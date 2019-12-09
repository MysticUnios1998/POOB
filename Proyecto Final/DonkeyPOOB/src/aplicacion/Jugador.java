package aplicacion;

public abstract class Jugador extends Personaje {
	
	private int puntos;
	private int vidas;

	/**
	 * Constructor principal de la clase Jugador
	 * @param posX posicion del jugador en el eje horizontal.
	 * @param posY posicion del jugador en el eje vertical.
	 */
	public Jugador(int posX, int posY) {
		super(posX, posY);
		puntos = 0;
		vidas = 3;
	}
	
	public void morir() {
		vidas -= 1;
	}
	
	public int getVidas() {
		return this.vidas;
	}

}
