package aplicacion;

public interface Movable {

	
	/**
	 * Mueve el objeto a una posicion determinada.
	 * @param xCoor coordenada de la posicion horizontal.
	 * @param yCoor coordenada de la posicion vertical.
	 */
	void moveTo(int xCoor, int yCoor);
	
	/**
	 * Mueve el objeto una distancia de su ubicacion actual.
	 * @param xDistance distancia en el eje x.
	 * @param yDistance distancia en el eje y.
	 */
	void move(int xDistance, int yDistance);
	
}
