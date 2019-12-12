package aplicacion;

/**
 * La clase jugador tiene el objetivo de manejar la informacion de cualquier jugador del simulador.
 * @author Eduard Arias, Juan Diaz
 *
 */
public abstract class Jugador extends Personaje{
	
	private int puntos;
	private int vidas;
	
	private boolean onAir;

	/**
	 * Constructor principal de la clase Jugador
	 * @param posX posicion del jugador en el eje horizontal.
	 * @param posY posicion del jugador en el eje vertical.
	 */
	public Jugador(int posX, int posY) {
		super(posX, posY);
		puntos = 0;
		vidas = 3;
	}
	
	/**
	 * Realiza la accion de "muerte" del jugador
	 */
	public void morir() {
		vidas -= 1;
	}
	
	/**
	 * Retorna la cantidad de vidas restantes del jugador
	 * @return entero con la informacion requerida
	 */
	public int getVidas() {
		return this.vidas;
	}

	/**
	 * Realiza la accion de "salto" del jugador. Es un movimiento semi-parabolico y mientras está activo no puede recibir otras acciones
	 */
	public void saltar() {
		if (!onAir) {
			onAir = true;
			move(getVelocidad()[0], -3);
			move();
		}
	}
	
	@Override
	public void move() {
		super.move();
	}
	
	@Override
	public void move(int dx, int dy) {
		if (!onAir) super.move(dx,  dy);
		onAir = false;
	}

}
