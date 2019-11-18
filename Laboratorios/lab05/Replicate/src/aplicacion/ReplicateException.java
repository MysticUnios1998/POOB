package aplicacion;

public class ReplicateException extends Exception {
	
	public final static String INVALID_BOARD = "No se puede crear tablero con esas dimensiones";
	public final static String INVALID_COORDINATES = "Coordenadas ingresadas no validas";
	
	public ReplicateException(String message) {
		super(message);
	}
	
	
}
