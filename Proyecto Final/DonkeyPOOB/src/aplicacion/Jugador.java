package aplicacion;

public class Jugador extends Personaje {
	
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

	@Override
	public void moveTo(int xCoor, int yCoor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(int xDistance, int yDistance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destruir() {
		// TODO Auto-generated method stub
		
	}

}
