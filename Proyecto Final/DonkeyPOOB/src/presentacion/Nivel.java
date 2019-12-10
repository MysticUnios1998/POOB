package presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.Timer;

import aplicacion.DonkeyPOOBException;

@SuppressWarnings("serial")
public class Nivel extends JDialog{

	private DonkeyPOOBGUI mainFrame;
	private JPanel screen;
	private Timer t;
	
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
					| InvocationTargetException | NoSuchMethodException | SecurityException| ClassNotFoundException e) {
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
	
	public void mover(String name, int dir) {
		mainFrame.mover(name, dir);
	}
	
	public void mover(String name) {
		mainFrame.mover(name);
	}
	
	public void detener(String name, int key) {
		mainFrame.detener(name, key);
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
		this.setVisible(true);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				for (Sprite s: sprites) s.mover(e);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				for (Sprite s: sprites) s.detener(e);
			}
		});
		t = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		t.start();
	}
	
	private void preparePantalla() {
		screen = new PantallaNivel();
		this.getContentPane().add(screen);
	}
	
	private void update() {
		for (Sprite s: sprites) s.mover();
		screen.repaint();
	}
	
	class PantallaNivel extends JPanel{
		
		public PantallaNivel() {
			this.setBackground(Color.BLACK);
			this.setLayout(null);
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
