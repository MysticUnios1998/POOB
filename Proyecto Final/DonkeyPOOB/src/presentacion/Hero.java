package presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Hero extends Sprite {
	
	public Hero(String name, Nivel nivel) {
		super(name, nivel);
		prepareAcciones();
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
		g.fillOval(pos[0]+5, pos[1]-15, 10, 10);
	}
	
	private void prepareAcciones() {
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
		});
	}

}
