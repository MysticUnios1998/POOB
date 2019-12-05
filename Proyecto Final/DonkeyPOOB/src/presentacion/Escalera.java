package presentacion;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

@SuppressWarnings("serial")
public class Escalera extends Estructura {
	
	public Escalera(int[] posicionInicial, int largo) {
		super(posicionInicial, new int [] {posicionInicial[0], posicionInicial[1]+largo});
	}

	@Override
	public void draw(Graphics gr) {
		int largo;
		Graphics2D g = (Graphics2D)gr;
		g.setColor(Color.LIGHT_GRAY);
		g.setStroke(new BasicStroke(10));
		largo = Math.abs(posIni[1]-posFin[1]);
		g.draw(new Line2D.Double(
				posIni[0], posIni[1], posFin[0],posFin[1]));
		g.draw(new Line2D.Double(
				posIni[0]+20, posIni[1], posFin[0]+20, posFin[1]));
		for (int i=0; i<largo; i+=20) {
			g.drawLine(posIni[0],posIni[1]+i,posIni[0]+20,posIni[1]+i);
		}
	}

}
