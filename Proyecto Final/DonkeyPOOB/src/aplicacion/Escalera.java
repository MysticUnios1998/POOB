package aplicacion;


/**
 * Clase escalera que proporciona la informacion de las escaleras del simulador. Esta solo se permite vertical.
 * @author Eduard Arias, Juan Diaz
 *
 */
public class Escalera {
	
	private Ubicacion[] ubicacion;

	/**
	 * Constructor pricipal de la clase
	 * @param coorX posicion en el eje horizontal
	 * @param coorY posicion en el eje vertical
	 * @param largo longitud de la escalera
	 */
	public Escalera(int coorX, int coorY, int largo) {
		ubicacion = new Ubicacion[] {new Ubicacion(new int[] {coorX, coorY}), new Ubicacion(new int[] {coorX, coorY+largo})};
	}
	
	/**
	 * Retorna el inicio de la escalera.
	 * @return posicion en el eje y mas arriba de la escalera.
	 */
	public Ubicacion getInicio() {
		return ubicacion[0];
	}
	
	/**
	 * Retorna el final de la escalera.
	 * @return posicion en el eje y mas abajo de la escalera.
	 */
	public Ubicacion getFinal() {
		return ubicacion[1];
	}
	
	/**
	 * Verifica si un personaje del jugador tiene acceso o tiene permitido desplazarse por la escalera
	 * @param intruso personaje del simulador
	 * @return si el intruso tiene acceso o no
	 */
	public boolean ingresar(Personaje intruso) {
		return true;
	}
	
	/**
	 * Retorna el tipo de la escalera
	 * @return entero con la informacion requerida
	 */
	public int getTipo() {
		return 0;
	}

}
