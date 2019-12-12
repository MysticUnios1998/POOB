package presentacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Color;


@SuppressWarnings("serial")
public class DonkeyKong extends Sprite {

	public DonkeyKong(String name, Nivel nivel) {
		super(name, nivel);
	}

	@Override
	public void draw(Graphics gr) {
		int[] pos = getPos();
		Graphics2D g = (Graphics2D)gr;
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(pos[0], pos[1], 20, 20);
	}

	@Override
	public void mover(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detener(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
