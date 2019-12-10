package aplicacion;


/**
 * Clase que contiene la informacion de las plataformas en el simulador. Esta controla las colisiones hacia ellas con otros objets del simulador.
 * @author Eduard Arias, Juan Diaz
 *
 */
public class Plataforma implements Comparable<Plataforma>{
	
	private Ubicacion[] ubicacion;

	/**
	 * Constructor principal de la clase.
	 * @param ini coordenadas de inicio de la plataforma
	 * @param fin coordenadas de fin de la plataforma
	 */
	public Plataforma(int[] ini, int[] fin) {
		ubicacion = new Ubicacion[] {new Ubicacion(ini), new Ubicacion(fin)};
	}
	
	/**
	 * Retorna las coordenadas de inicio de la plataforma
	 * @return
	 */
	public Ubicacion getInicio() {
		return ubicacion[0];
	}
	
	/**
	 * Retorna las coordenadas del final de la plataforma
	 * @return
	 */
	public Ubicacion getFinal() {
		return ubicacion[1];
	}
	
	/**
	 * Compara una plataforma con otra. Se considera que es "menor" a otra cuando la supera completamente y viceversa
	 * @return indicador de comparacion. -1- Menor, 0- Igual, 1- Mayor
	 */
	public int compareTo(Plataforma p) {
		int result = 0;
		if (this.getInicio().compareTo(p.getInicio()) == -1 && this.getFinal().compareTo(p.getFinal()) == -1) result = -1;
		else if (this.getInicio().compareTo(p.getInicio()) == 1 && this.getFinal().compareTo(p.getFinal()) == 1) result = 1;
		return result;
	}
	
}
