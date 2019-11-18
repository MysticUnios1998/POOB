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
	 * @param posArray array con las coordenadas de la ubicacion.
	 */
	public Ubicacion(int[] posArray) {
		this.cambiarCoorX(posArray[0]);
		this.cambiarCoorY(posArray[1]);
	}
	
	
	
}
