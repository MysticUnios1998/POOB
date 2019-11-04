package aplicacion;

public abstract class Personaje implements Movable {

	private Ubicacion posicion;
	
	public Personaje(int posX, int posY) {
		posicion = new Ubicacion(posX, posY);
	}
	
}
