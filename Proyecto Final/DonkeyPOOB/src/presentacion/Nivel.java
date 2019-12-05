package presentacion;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

@SuppressWarnings("serial")
public class Nivel extends JDialog{

	private DonkeyPOOBGUI mainFrame;
	private JPanel screen;
	
	public Nivel(DonkeyPOOBGUI d) {
		super();
		mainFrame = d;
		prepareElementos();
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
			ArrayList<Estructura> toDraw = mainFrame.getEstructurasToDraw();
			for (Estructura es: toDraw) es.draw(g);
		}
		
		private void drawPersonajes(Graphics g) {
			ArrayList<Sprite> toDraw = mainFrame.getSpritesToDraw();
			for (Sprite sp: toDraw) sp.draw(g);
		}
		
	}

}
