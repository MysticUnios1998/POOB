package aplicacion;


/**
 * El jugador principal del simulador. Tiene como objetivo ser capaz de manejar la informacion de todo jugador controlado por usuario
 * @author Eduard Arias, Juan Diaz
 *
 */
public class Manual extends Jugador {

	
	/**
	 * Constructor principal de la clase
	 * @param posX  posicion en el eje horizontal
	 * @param posY posicion en el eje vertical
	 */
	public Manual(int posX, int posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(int xDistance, int yDistance) {
		super.move(xDistance, yDistance);
	}

	@Override
	public void destruir() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveTo() {
		
	}

}
