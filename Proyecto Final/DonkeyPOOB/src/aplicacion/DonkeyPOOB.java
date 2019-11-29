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
	
	private ArrayList<Nivel> niveles;
	private HashMap<String, Personaje> personajes;
	
	private DonkeyPOOB(){
		niveles = new ArrayList<Nivel>();
		personajes = new HashMap<String, Personaje>();
	}
	
}
