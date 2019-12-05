package aplicacion;


public class Plataforma implements Comparable{
	
	private Ubicacion[] ubicacion;

	public Plataforma(int[] ini, int[] fin) {
		ubicacion = new Ubicacion[] {new Ubicacion(ini), new Ubicacion(fin)};
	}
	
	public Ubicacion getInicio() {
		return ubicacion[0];
	}
	
	public Ubicacion getFinal() {
		return ubicacion[1];
	}

	@Override
	public int compareTo(Object o) {
		return this.compareTo((Plataforma)o);
	}
	
	public int compareTo(Plataforma p) {
		int result = 0;
		if (this.getInicio().compareTo(p.getInicio()) == -1 && this.getFinal().compareTo(p.getFinal()) == -1) result = -1;
		else if (this.getInicio().compareTo(p.getInicio()) == 1 && this.getFinal().compareTo(p.getFinal()) == 1) result = 1;
		return result;
	}
	
}
