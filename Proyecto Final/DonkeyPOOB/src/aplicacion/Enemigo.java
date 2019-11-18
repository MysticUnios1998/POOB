package aplicacion;

public abstract class Enemigo extends Personaje{

	public Enemigo(int posX, int posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}
	
	public abstract boolean atacar(Jugador objetivo);
	
}
