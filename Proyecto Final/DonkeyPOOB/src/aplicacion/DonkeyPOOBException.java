package aplicacion;

public class DonkeyPOOBException extends Exception {
	
	public static final String ALTURA_ANCHO_INVALIDO = "La altura o el ancho son inválidos."; 
	
	public DonkeyPOOBException(String mensaje) {
		super(mensaje);
	}
	
}
