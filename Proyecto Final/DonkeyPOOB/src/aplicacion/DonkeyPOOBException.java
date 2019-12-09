package aplicacion;

public class DonkeyPOOBException extends Exception {
	
	public static final String NO_PERSONAJE = "No se puede crear el personaje";
	public static final String PLAYER_UNKNOWN = "No existe el personaje";
	
	public DonkeyPOOBException(String mensaje) {
		super(mensaje);
	}
	
}
