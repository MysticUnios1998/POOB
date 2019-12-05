package aplicacion;

public abstract class Personaje implements Movable {

	private Ubicacion posicion;
	
	public Personaje(int posX, int posY) {
		posicion = new Ubicacion(new int[] {posX, posY});
	}
	
	public int[] getPos() {
		return new int[] {posicion.getCoorX(), posicion.getCoorY()};
	}
	
	public abstract void destruir();
	
}
