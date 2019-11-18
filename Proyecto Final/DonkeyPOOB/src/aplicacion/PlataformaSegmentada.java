package aplicacion;

public class PlataformaSegmentada extends Plataforma {

	
	
	public PlataformaSegmentada(int[] ini, int[] fin) {
		super(ini, fin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ingresar(Personaje intruso) {
		return false;
	}

}
