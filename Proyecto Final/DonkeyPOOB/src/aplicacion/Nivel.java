 package aplicacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * La clase que contiene toda la informacion del nivel del simulador. Puede incluir sorpresas, el enemigo principal, los jugadores y cualquier otro enemigo
 * @author Eduard Arias, Juan Diaz
 *
 */
public class Nivel {
	
	private int dificultad;
	private boolean sorpresas;
	private ArrayList<Plataforma> plataformas;
	private ArrayList<Escalera> escaleras;
	
	private Nivel(int dificultad) {
		this.dificultad = dificultad;
		plataformas = new ArrayList<Plataforma>();
		escaleras = new ArrayList<Escalera>();
	}
	
	/**
	 * Contructor principal de la clase
	 * @param plataformas arrayCube con la informacion de las plataformas deseadas en el nivel.
	 * @param escaleras arrayMatrix con las posiciones de las escaleras en el nivel
	 * @param sorpresas si se desea incluir sorpresas o no. Aparecen aleatoriamente en el nivel
	 */
	public Nivel(int[][][] plataformas, int[][] escaleras, boolean sorpresas) {
		this(1);
		this.sorpresas = sorpresas;
		for (int[][] plataforma: plataformas) this.plataformas.add(new Plataforma(plataforma[0], plataforma[1]));
		agregarEscaleras(escaleras);
	}
	
	private void agregarEscaleras(int[][] escaleras) {
		this.ordenarPlataformas();
		Escalera e = null;
		for (int[] stair: escaleras) {
			switch (stair[3]) {
				case 0:
					e = new Escalera(stair[0], stair[1], stair[2]);
					break;
				case 1:
					e = new EscaleraSegmentada(stair[0], stair[1], stair[2]);
					break;
			}
			this.escaleras.add(e);
		}
	}
	
	
	/**
	 * Retorna la dificultad del nivel
	 * @return entero con la dificultad. Esta es aleatoria entre 1 y 3
	 */
	public int getDificultad() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Retorna la informacion de las plataformas del nivel
	 * @return arrayCube con las posiciones de cada plataforma
	 */
	public int[][][] getPlataformas(){
		int[][][] plats = new int[plataformas.size()][][];
		for (int i=0; i<plataformas.size(); i++) {
			Plataforma pl = plataformas.get(i);
			plats[i] = new int[][] {{pl.getInicio().getCoorX(), pl.getInicio().getCoorY()}, 
				{pl.getFinal().getCoorX(), pl.getFinal().getCoorY()}};
		}
		return plats;
	}
	
	
	/**
	 * Retorna la informacion de las escaleras en el nivel
	 * @return arrayCube con las posiciones de cada escalera
	 */
	public int[][][] getEscaleras(){
		int[][][] stairs = new int[escaleras.size()][][];
		for (int i=0; i<escaleras.size(); i++) {
			Escalera e = escaleras.get(i);
			stairs[i] =  new int[][] {{e.getInicio().getCoorX(), e.getInicio().getCoorY()}, 
				{e.getFinal().getCoorX(), e.getFinal().getCoorY()},
			{e.getTipo()}};
		}
		return stairs;
	}
	
	private void ordenarPlataformas() {
		Collections.sort(plataformas,
			new Comparator<Plataforma>() {
				@Override
				public int compare(Plataforma o1, Plataforma o2) {
					return o1.compareTo(o2);
				}
				
			}
		);
	}

	/**
	 * Retorna la cantidad de plataformas en el nivel
	 * @return entero con la informacion requerida
	 */
	public int getTotalPlataformas() {
		return plataformas.size();
	}
	
}
