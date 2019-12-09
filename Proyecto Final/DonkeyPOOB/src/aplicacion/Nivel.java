 package aplicacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	
	
	public int getDificultad() {
		return this.dificultad;
	}
	
	public int[][][] getPlataformas(){
		int[][][] plats = new int[plataformas.size()][][];
		for (int i=0; i<plataformas.size(); i++) {
			Plataforma pl = plataformas.get(i);
			plats[i] = new int[][] {{pl.getInicio().getCoorX(), pl.getInicio().getCoorY()}, 
				{pl.getFinal().getCoorX(), pl.getFinal().getCoorY()}};
		}
		return plats;
	}
	
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
	
}
