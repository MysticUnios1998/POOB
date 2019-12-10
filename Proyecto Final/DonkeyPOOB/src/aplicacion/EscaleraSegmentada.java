package aplicacion;

/**
 * Clase especializada de Escalera que no permite el ingreso de jugadores.
 * @author Eduard Arias, Juan Diaz
 *
 */
public class EscaleraSegmentada extends Escalera {

	/**
	 * Constructor principal de la clase
	 * @param coorX posicion en el eje horizontal
	 * @param coorY posicion en el eje vertical
	 * @param largo longitud de la escalera
	 */
	public EscaleraSegmentada(int coorX, int coorY, int largo) {
		super(coorX, coorY, largo);
	}
	
	@Override
	public boolean ingresar(Personaje intruso) {
		return !(intruso instanceof Jugador);
	}
	
	@Override
	public int getTipo() {
		return 1;
	}

}
