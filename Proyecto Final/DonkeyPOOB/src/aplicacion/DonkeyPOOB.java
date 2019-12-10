package aplicacion;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Clase Backend del simulador
 * @author Eduard Arias, Juan Diaz
 *
 */
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
			nuevoPersonaje = (Personaje)Class.forName(String.format("aplicacion.%s", personaje[1])).
					getDeclaredConstructor(int.class, int.class).newInstance(0, 0);
		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException |
				InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new DonkeyPOOBException(DonkeyPOOBException.NO_PERSONAJE);
		}
		posicionInicial(nuevoPersonaje);
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
	
	
	/**
	 * Retorna la posicion de un personaje.
	 * @param name nombre del personaje.
	 * @return array con la posición del personaje.
	 * @throws DonkeyPOOBException si el nombre no pertenece a ningun personaje existente.
	 */
	public int[] getPos(String name) throws DonkeyPOOBException{
		if (!personajes.containsKey(name)) throw new DonkeyPOOBException(DonkeyPOOBException.PLAYER_UNKNOWN);
		return personajes.get(name).getPos();
	}
	
	
	/**
	 * Cambia la velocidad del personaje en un direccion
	 * @param name nombre identificador del personaje
	 * @param dir direccion deseada. 1- Derecha, 2- Izquierda, 3- Arriba, 4- Abajo, 5- Salto
	 */
	public void mover(String name, int dir) {
		int x = 0, y = 0;
		switch (dir) {
			case 1:
				x = 1;
				break;
			case 2:
				x = -1;
				break;
			case 3:
				y = -1;
				break;
			case 4:
				y = 1;
				break;
			case 5:
				((Jugador)personajes.get(name)).saltar();
				break;
		}
		personajes.get(name).move(x,y);
	}
	
	
	/**
	 * Mueve al personaje segun sus caracteristicas.
	 * @param name nombre identificador del personaje
	 */
	public void mover(String name) {
		personajes.get(name).move();
	}
	
	
	/**
	 * Detiene el movimiento del personaje
	 * @param name nombre identificador del personaje
	 * @param key direccion deseada. 1- Derecha, 2- Izquierda, 3- Arriba, 4- Abajo, 5- Salto
	 */
	public void detener(String name, int key) {
		int[] pos = personajes.get(name).getVelocidad();
		if (key <= 2) {
			pos[0] = 0;
		}else if(key <= 4) {
			pos[1] = 0;
		}else if(key <= 5) {
			//falta aqui detener salto
		}
		personajes.get(name).move(pos[0], pos[1]);
	}
	
	private void posicionInicial(Personaje p) {
		int x, y;
		int[][] plataforma = null;
		if (p instanceof Enemigo) {
			plataforma = nivel.getPlataformas()[0];
			x = (plataforma[0][1] <= plataforma[1][1]) ? plataforma[0][0]: plataforma[1][0];
			y = Math.min(plataforma[0][1], plataforma[1][1])-35;
		}
		else if (p instanceof Jugador) {
			plataforma = nivel.getPlataformas()[nivel.getTotalPlataformas()-1];
			x = (plataforma[0][1] >= plataforma[1][1]) ? plataforma[0][0]: plataforma[1][0];
			y = Math.max(plataforma[0][1], plataforma[1][1])-35;
		}else {
			x = 0;
			y = 0;
		}
		p.moveTo(x, y);
	}
	
}
