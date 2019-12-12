package presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Hero extends Sprite {
	
	public Hero(String name, Nivel nivel) {
		super(name, nivel);
	}

	@Override
	public void draw(Graphics gr) {
		int[] pos = getPos();
		Graphics2D g = (Graphics2D)gr;
		g.setColor(Color.RED);
		g.fillOval(pos[0], pos[1], 20, 20);
		g.setColor(Color.BLUE);
		g.fillOval(pos[0]+4, pos[1]+4, 13, 13);
		g.setColor(Color.PINK);
		g.fillOval(pos[0]+5, pos[1]-8, 10, 10);
	}

	public void mover(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_D) mover(1);
		else if (e.getKeyCode() == KeyEvent.VK_A) mover(2);
		else if (e.getKeyCode() == KeyEvent.VK_W) mover(3);
		else if (e.getKeyCode() == KeyEvent.VK_S) mover(4);
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) mover(5);
	}

	@Override
	public void detener(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_D) detener(1);
		else if (e.getKeyCode() == KeyEvent.VK_A) detener(2);
		else if (e.getKeyCode() == KeyEvent.VK_W) detener(3);
		else if (e.getKeyCode() == KeyEvent.VK_S) detener(4);
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) detener(5);
	}

}
