package presentacion;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public abstract class Estructura extends JComponent implements Drawable {

	protected int[] posIni;
	protected int[] posFin;
	
	public Estructura(int[] posicionInicial, int[] posicionFinal) {
		posIni = posicionInicial;
		posFin = posicionFinal;
	}
	
}
