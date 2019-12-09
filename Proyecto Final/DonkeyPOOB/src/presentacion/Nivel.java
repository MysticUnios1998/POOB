package presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;

import aplicacion.DonkeyPOOBException;

@SuppressWarnings("serial")
public class Nivel extends JDialog{

	private DonkeyPOOBGUI mainFrame;
	private JPanel screen;
	
	private ArrayList<Sprite> sprites;
	private ArrayList<Estructura> estructuras;
	
	public Nivel(DonkeyPOOBGUI d) {
		super();
		mainFrame = d;
		sprites = new ArrayList<Sprite>();
		estructuras = new ArrayList<Estructura>();
		prepareElementos();
	}
	
	public void agregarPersonajes(String[][] personajes) throws DonkeyPOOBException {
		for (String[] personaje: personajes)
			try {
				sprites.add(
							(Sprite)Class.forName(String.format("presentacion.%s", Sprite.traducir(personaje[1]))).
							getDeclaredConstructor(String.class, Nivel.class).newInstance(personaje[0], this)
							);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				throw new DonkeyPOOBException(DonkeyPOOBException.PLAYER_UNKNOWN);
			}
	}
	
	public void agregarEstructuras(int[][][] plataformas) {
		for (int[][] plataforma: plataformas) estructuras.add(new Plataforma(plataforma[0], plataforma[1]));
	}
	
	public void agregarEstructuras(int[][] escaleras) {
		for (int[] escalera: escaleras) estructuras.add(
				(escalera[3] == 0) ? new Escalera(new int[] {escalera[0], escalera[1]}, escalera[2]) : 
					new EscaleraSegmentada(new int[] {escalera[0], escalera[1]}, escalera[2])
				);
	}
	
	public int[] getPos(String name) throws DonkeyPOOBException{
		return mainFrame.getPos(name);
	}
	
	private void prepareElementos() {
		preparePantalla();
		prepareVentana();
	}
	
	private void prepareVentana() {
		this.setSize(mainFrame.getGameSize());
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		this.setTitle("DonkeyPOOB");
		this.setResizable(false);
		this.requestFocus();
		this.setVisible(true);
	}
	
	private void preparePantalla() {
		screen = new PantallaNivel();
		this.getContentPane().add(screen);
	}
	
	class PantallaNivel extends JPanel{
		
		public PantallaNivel() {
			this.setBackground(Color.BLACK);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawEstructuras(g);
			drawPersonajes(g);
		}
		
		private void drawEstructuras(Graphics g) {
			for (Estructura es: estructuras) es.draw(g);
		}
		
		private void drawPersonajes(Graphics g) {
			for (Sprite sp: sprites) sp.draw(g);
		}
		
	}

}
