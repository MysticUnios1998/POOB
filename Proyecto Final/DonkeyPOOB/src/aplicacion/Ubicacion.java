package aplicacion;

public class Ubicacion {

	private int xPos;
	private int yPos;
	
	/**
	 * Retorna la coordenada en el eje horizontal.
	 * @return la posicion "x" de la ubicacion.
	 */
	public int getCoorX() {
		return xPos;
	}

	/**
	 * Retorna la coordenada en el eje vertical.
	 * @return la posicion "y" de la ubicacion.
	 */
	public int getCoorY() {
		return yPos;
	}

	/**
	 * Cambia la coordenada del eje horizontal.
	 * @param xPos nueva coordenada "x".
	 */
	public void cambiarCoorX(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * Cambia la coordenada del eje vertical.
	 * @param xPos nueva coordenada "y".
	 */
	public void cambiarCoorY(int yPos) {
		this.yPos = yPos;
	}

	/**
	 * Constructor principal de la clase Ubicacion.
	 * @param xPos posicion en el eje horizontal.
	 * @param yPos posicion en el eje vertical.
	 */
	public Ubicacion(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	
	
}
