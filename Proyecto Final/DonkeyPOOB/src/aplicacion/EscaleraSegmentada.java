package aplicacion;

public class EscaleraSegmentada extends Escalera {

	public EscaleraSegmentada(int coorX, int coorY, int largo) {
		super(coorX, coorY, largo);
	}
	
	@Override
	public boolean ingresar(Personaje intruso) {
		return !(intruso instanceof Jugador);
	}
	
	@Override
	public int getTipo() {
		return 1;
	}

}
