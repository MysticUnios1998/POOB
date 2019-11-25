package aplicacion;

public class TeatroColonException extends Exception {

	public static final String FILE_NOT_FOUND = "El archivo seleccionado no existe";
	public static final String ERROR_WRITING_TO_FILE = "Problema al escribir al archivo";
	public static final String ERROR_READING_FILE = "Problema al leer el archivo";
	
	public TeatroColonException() {
		super("Opcion ... en construccion");
	}

	public TeatroColonException(String message) {
		super(message);
	}

}
