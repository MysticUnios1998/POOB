package aplicacion;

import java.awt.Color;
import java.awt.color.*;

public class DonkeyPOOB {

	private int alturaSim;
	private int anchoSim;
	private Color background;
	
	public DonkeyPOOB(int height, int width) throws DonkeyPOOBException{
		if (height<=0 || width<=0) throw new DonkeyPOOBException(DonkeyPOOBException.ALTURA_ANCHO_INVALIDO);
		alturaSim = height;
		anchoSim = width;
		background = Color.BLACK;
	}
	
}
