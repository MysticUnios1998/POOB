package aplicacion;

/**
 * Clase que mantendrá los datos que cualquier elemento que se considere "enemigo" el personaje principal.
 * @author Eduard Arias, Juan Diaz
 *
 */
public abstract class Enemigo extends Personaje{

	/**
	 * Constructor principal de la clase
	 * @param posX posicion en el eje horizontal
	 * @param posY posicion en el eje vertical
	 */
	public Enemigo(int posX, int posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Realiza la accion de "ataque" a un jugador del simulador.
	 * @param objetivo jugador que recibe el ataque
	 * @return si se puede atacar al objetivo o no
	 */
	public abstract boolean atacar(Jugador objetivo);
	
}
