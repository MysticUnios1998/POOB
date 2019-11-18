package aplicacion;

public class DonkeyPOOB {

	private int alturaSim;
	private int anchoSim;
	
	public DonkeyPOOB(int height, int width) throws DonkeyPOOBException{
		if (height<=0 || width<=0) throw new DonkeyPOOBException(DonkeyPOOBException.ALTURA_ANCHO_INVALIDO);
		alturaSim = height;
		anchoSim = width;
	}
	
}
