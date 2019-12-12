 package aplicacion;

 /**
  * Clase abstracta que encapsula la informacion de cualquier personaje del simulador. LLamese "personaje" a cualquier objeto capaz de desplazarse
  * por un nivel
  * @author Eduard Arias, Juan Diaz
  *
  */
public abstract class Personaje implements Movable {

	private Ubicacion posicion;
	/**
	 * Velocidad de movimiento. Contiene el cambio de posiciones de las cuatro direcciones estandar 
	 */
	protected int[] velocidad;
	
	/**
	 * Constructor principal de la clase
	 * @param posX coordenada de la posicion horizontal.
	 * @param posY coordenada de la posicion vertical.
	 */
	public Personaje(int posX, int posY) {
		posicion = new Ubicacion(new int[] {posX, posY});
		velocidad = new int[2];
	}
	
	@Override
	public void moveTo(int xCoor, int yCoor) {
		posicion.cambiarCoorX(xCoor);
		posicion.cambiarCoorY(yCoor);
	}
	
	@Override
	public void move(int xDist, int yDist) {
		velocidad[0] = xDist;
		velocidad[1] = yDist;
	}
	
	/**
	 * Mueve al personaje por el nivel
	 */
	public void move() {
		if (0<=posicion.getCoorX()+velocidad[0] && posicion.getCoorX()+velocidad[0]+25<=DonkeyPOOB.MAX_ANCHO) posicion.cambiarCoorX(posicion.getCoorX()+velocidad[0]);
		if (10<=posicion.getCoorY()+velocidad[1] && posicion.getCoorY()+velocidad[1]+50<=DonkeyPOOB.MAX_ALTURA) posicion.cambiarCoorY(posicion.getCoorY()+velocidad[1]);
	}
	
	/**
	 * Retorna la posicion del personaje en el nivel
	 * @return array con las coordenadas
	 */
	public int[] getPos() {
		return new int[] {posicion.getCoorX(), posicion.getCoorY()};
	}
	
	/**
	 * Retorna la velocidad de cambio de posicion del personaje
	 * @return array con la informacion deseada
	 */
	public int[] getVelocidad() {
		return new int[] {velocidad[0], velocidad[1]};
	}
	
	/**
	 * Realiza la accion de "destruir" del personaje. Destruye cuando un tipo de enemigo aparece o tiene una sorpresa especial activada
	 */
	public abstract void destruir();
	
	/**
	 * Realiza la accion de saltar del personaje. Para los enemigos, realiza una accion en contra del jugador
	 */
	public abstract void saltar();
	
}
