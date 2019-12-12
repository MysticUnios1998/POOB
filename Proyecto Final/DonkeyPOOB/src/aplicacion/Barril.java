package aplicacion;

public abstract class Barril extends Enemigo{
	
	private int puntos;
	
	/**
	 * Constructor principal de la calse Barril
	 * @param posX posicion en e eje horizontal
	 * @param posY posicion en el eje vertical
	 * @param puntos puntos concebidos por cada barril al actuar el evento de puntucacion
	 */
	public Barril(int posX, int posY, int puntos) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void saltar() {}

	

}
