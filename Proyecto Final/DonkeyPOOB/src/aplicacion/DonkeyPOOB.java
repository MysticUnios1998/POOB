package aplicacion;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class DonkeyPOOB {

	/**
	 * Altura maxima del simulador
	 */
	public static final int MAX_ALTURA = 500;
	
	/**
	 * Ancho maximo del simulador
	 */
	public static final int MAX_ANCHO = 500;
	
	private static DonkeyPOOB app;
	
	/**
	 * Regresa la instancia de la lógica dell simulador. Si no se ha creado, se crea una.
	 * @return la instancia usada del simulador
	 */
	public static DonkeyPOOB getDonkeyPOOB() {
		if (app == null) app = new DonkeyPOOB();
		return app;
	}
	
	private Nivel nivel;
	private HashMap<String, Personaje> personajes;
	
	private DonkeyPOOB(){
		nivel = null;
		personajes = new HashMap<String, Personaje>();
	}
	
	
	/**
	 * Crea un nuevo juego con las características deseadas.
	 * @param plataformas arrayCube con las posiciones de las plataformas.
	 * @param escaleras arrayMatrix con las posiciones de las escaleras.
	 * @param personajes arrayMatrix con el personaje deseado. Deben ser de la forma {nombre, tipoDePersonaje}.
	 * @param sorpesas si se desea incluir sorpresas en el nivel o no.
	 * @throws DonkeyPOOBException si no se pudo crear el nivel.
	 */
	public void nuevoJuego(int[][][] plataformas, int[][] escaleras, String[][] personajes, boolean sorpresas) throws DonkeyPOOBException {
		nivel = new Nivel(plataformas, escaleras, sorpresas);
		for (String[] s: personajes) crearPersonaje(s);
	}
	
	
	/**
	 * Crea un nuevo personaje en el simulador. 
	 * @param personaje array con el personaje deseado. Debe ser de la forma {nombre, tipoDePersonaje}.
	 * Tipos permitidos: Manual, Protector, Temeroso, Mimo, DonkeyKong, BarrilAzul, BarrilRojo, BarrilVerde, BarrilAmarillo
	 * @throws DonkeyPOOBException si no se pudo crear el personaje.
	 */
	public void crearPersonaje(String[] personaje) throws DonkeyPOOBException{
		Personaje nuevoPersonaje = null;
		try {
			nuevoPersonaje = (Jugador)Class.forName(String.format("aplicacion.%s", personaje[1])).
					getDeclaredConstructor(int.class, int.class).newInstance(0, 0);
		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException |
				InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new DonkeyPOOBException(DonkeyPOOBException.NO_PERSONAJE);
		}
		nuevoPersonaje.moveTo();
		personajes.put(personaje[0], nuevoPersonaje);
	}
	
	
	/**
	 * Retorna la informacion de las plataformas del nivel.
	 * @return arrayCube con las posiciones de cada plataforma.
	 */
	public int[][][] getPlataformas(){
		return nivel.getPlataformas();
	}
	
	
	/**
	 * Retorna la informacion de las escaleras del nivel.
	 * @return arrayCube con las posiciones de cada escalera.
	 */
	public int[][][] getEscaleras(){
		return nivel.getEscaleras();
	}
	
	public int[] getPos(String name) throws DonkeyPOOBException{
		if (!personajes.containsKey(name)) throw new DonkeyPOOBException(DonkeyPOOBException.PLAYER_UNKNOWN);
		return personajes.get(name).getPos();
	}
	
}
