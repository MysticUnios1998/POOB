package presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class EscaleraSegmentada extends Escalera {

	public EscaleraSegmentada(int[] posicionInicial, int largo) {
		super(posicionInicial, largo);
	}
	
	@Override
	public void draw(Graphics gr) {
		super.draw(gr);
		Graphics2D g = (Graphics2D)gr;
		g.setColor(Color.BLACK);
		g.fillRect(posIni[0]-5, posIni[1]+Math.abs(posIni[1]-posFin[1])/2, 30, 40);	
		g.setColor(Color.LIGHT_GRAY);
	}

}
