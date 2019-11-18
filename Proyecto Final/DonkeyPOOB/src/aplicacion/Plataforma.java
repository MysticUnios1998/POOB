package aplicacion;

public class Plataforma {
	
	private Ubicacion[] ubicacion;

	public Plataforma(int[] ini, int[] fin) {
		ubicacion[0] = new Ubicacion(ini);
		ubicacion[1] = new Ubicacion(fin);
	}
	
	public boolean ingresar(Personaje intruso) {
		return false;
	}
	
}
