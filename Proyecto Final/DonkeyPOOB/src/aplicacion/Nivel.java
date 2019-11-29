package aplicacion;

import java.util.ArrayList;

public class Nivel {
	
	private int dificultad;
	
	private ArrayList<Sorpresa> sorpresas;
	private ArrayList<Plataforma> plataformas;
	
	public Nivel() {
		this(1);
	}
	
	public Nivel(int dificultad) {
		this.dificultad = dificultad;
		plataformas = new ArrayList<Plataforma>();
		sorpresas = new ArrayList<Sorpresa>();
	}
	
	public int getDificultad() {
		return this.dificultad;
	}
	
}
