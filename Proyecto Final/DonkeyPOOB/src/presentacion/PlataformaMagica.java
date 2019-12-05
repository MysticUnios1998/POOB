package presentacion;

import java.awt.Graphics;

@SuppressWarnings("serial")
public class PlataformaMagica extends Plataforma {

	public PlataformaMagica(int[] posIni, int[] posFinal) {
		super(posIni, posFinal);
	}
	
	@Override
	public void draw(Graphics gr) {
		super.draw(gr); // por el momento es asi
	}

}
