package aplicacion;

public class Escalera {
	
	private Ubicacion[] ubicacion;

	public Escalera(int coorX, int coorY, int largo) {
		ubicacion = new Ubicacion[] {new Ubicacion(new int[] {coorX, coorY}), new Ubicacion(new int[] {coorX, coorY+largo})};
	}
	
	public Ubicacion getInicio() {
		return ubicacion[0];
	}
	
	public Ubicacion getFinal() {
		return ubicacion[1];
	}
	
	public boolean ingresar(Personaje intruso) {
		return true;
	}
	
	public int getTipo() {
		return 0;
	}

}
