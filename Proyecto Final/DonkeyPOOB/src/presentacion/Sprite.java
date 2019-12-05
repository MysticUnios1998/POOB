package presentacion;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public abstract class Sprite extends JComponent implements Drawable{
	
	protected int[] pos;
	
	public Sprite(int[] pos) {
		this.pos = pos;
	}
	
}
