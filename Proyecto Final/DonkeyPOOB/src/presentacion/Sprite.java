package presentacion;

import java.awt.Graphics;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public abstract class Sprite extends JComponent{
	
	protected int[] pos;
	
	public Sprite(int[] pos) {
		this.pos = pos;
	}
	
	public abstract void draw(Graphics gr);
	
}
