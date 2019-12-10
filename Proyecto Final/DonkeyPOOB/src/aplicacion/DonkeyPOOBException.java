package aplicacion;


/**
 * Clase Support que mantiene las Excepciones del simulador
 * @author Eduard Arias, Juan Diaz
 *
 */
public class DonkeyPOOBException extends Exception {
	
	public static final String NO_PERSONAJE = "No se puede crear el personaje";
	public static final String PLAYER_UNKNOWN = "No existe el personaje";
	
	
	/**
	 * Constructor principal de la clase
	 * @param mensaje mensaje que se le va aindicar al usuario
	 */
	public DonkeyPOOBException(String mensaje) {
		super(mensaje);
	}
	
}
