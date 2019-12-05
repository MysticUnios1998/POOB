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
			drawPlataformas(g);
			drawEscaleras(g);
			drawPersonajes(g);
		}
		
		private void drawPlataformas(Graphics gr) {
			int[][][] platsToDraw = mainFrame.getPlataformaInfo();
			Graphics2D g = (Graphics2D)gr;
			g.setColor(Color.RED);
			g.setStroke(new BasicStroke(20));
			for (int[][] pl: platsToDraw) {
				g.draw(new Line2D.Double(pl[0][0], pl[0][1], pl[1][0], pl[1][1]));
			}
		}
		
		private void drawEscaleras(Graphics gr) {
			int[][][] stairsToDraw = mainFrame.getEscalerasInfo();
			int largo;
			Graphics2D g = (Graphics2D)gr;
			g.setColor(Color.LIGHT_GRAY);
			g.setStroke(new BasicStroke(10));
			for (int[][] st: stairsToDraw) {
				largo = Math.abs(st[0][1]-st[1][1]);
				g.draw(new Line2D.Double(
						st[0][0], st[0][1], st[1][0], st[1][1]));
				g.draw(new Line2D.Double(
						st[0][0]+20, st[0][1], st[1][0]+20, st[1][1]));
				for (int i=0; i<largo; i+=20) {
					g.drawLine(st[0][0], st[0][1]+i, st[0][0]+20, st[0][1]+i);
				}
				if (st[2][0] == 1) {
					g.setColor(Color.BLACK);
					g.fillRect(st[0][0]-5, st[0][1]+largo/2, 30, 40);	
					g.setColor(Color.LIGHT_GRAY);
				}
			}
		}
		
		private void drawPersonajes(Graphics g) {
			ArrayList<Sprite> toDraw = mainFrame.getSpritesToDraw();
			for (Sprite sp: toDraw) sp.draw(g);
		}
		
	}

}
