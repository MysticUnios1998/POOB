package aplicacion;

import java.util.ArrayList;
import java.util.HashMap;

public class DonkeyPOOB {

	public static final int MAX_ALTURA = 500;
	public static final int MAX_ANCHO = 500;
	
	private static DonkeyPOOB app;
	
	public static DonkeyPOOB getDonkeyPOOB() {
		if (app == null) app = new DonkeyPOOB();
		return app;
	}
	
	private Nivel nivel;
	private HashMap<String, Personaje> personajes;
	
	private DonkeyPOOB(){
		nivel = null;
		personajes = new HashMap<String, Personaje>();
	}
	
	public void nuevoJuego() {
		this.nuevoJuego(
				new int[][][] {{{20,120}, {300, 120}}, {{100, 300}, {400, 300}}, {{120, 40}, {450, 100}}, {{10,	450}, {450, 430}}},
				new int[][] {{100, 120, 180, 0}, {380, 90, 210, 0}, {200, 120, 180, 1}, {300, 300, 140, 0}},
				new String[][] {{"Mario", "Normal"}},
				false
		);
	}
	
	public void nuevoJuego(int[][][] plataformas, int[][] escaleras, String[][] personajes, boolean sorpesas) {
		nivel = new Nivel(plataformas, escaleras);
		for (String[] s: personajes) crearPersonaje(s);
	}
	
	public int[][][] getPlataformas(){
		return nivel.getPlataformas();
	}
	
	public int[][][] getEscaleras(){
		return nivel.getEscaleras();
	}
	
	public int[] getDonkeyKong() {
		//return personajes.get("DonkeyKong").getPos();
		return null;
	}
	
	public int[] getMario(){
		return personajes.get("Mario").getPos();
	}
	
	private void crearPersonaje(String[] personaje) {
		Jugador nuevoJugador = null;
		int[] pos = posicionValidaInicio();
		switch (personaje[1]) {
			case "Normal":
				nuevoJugador = new Jugador(pos[0], pos[1]);
				break;
			case "Mimo":
				nuevoJugador = new Mimo(pos[0], pos[1]);
				break;
			case "Temeroso":
				nuevoJugador = new Temeroso(pos[0], pos[1]);
				break;
			case "Protector":
				nuevoJugador = new Protector(pos[0], pos[1]);
				break;
		}
		personajes.put(personaje[0], nuevoJugador);
	}
	
	private int[] posicionValidaInicio() {
		int[][][] posPlats = getPlataformas();
		int[][] plat = posPlats[posPlats.length-1];
		plat[0][1] -= 30;
		return plat[0];
	}
	
}
