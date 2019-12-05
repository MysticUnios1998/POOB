package presentacion;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

@SuppressWarnings("serial")
public class Plataforma extends Estructura {
	
	public Plataforma(int[] posIni, int[] posFinal) {
		super(posIni, posFinal);
	}

	@Override
	public void draw(Graphics gr) {
		Graphics2D g = (Graphics2D)gr;
		g.setColor(Color.RED);
		g.setStroke(new BasicStroke(20));
		g.draw(new Line2D.Double(posIni[0], posIni[1], posFin[0], posFin[1]));
	}
}
