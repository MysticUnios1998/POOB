package presentacion;

import java.util.HashMap;
import javax.swing.JComponent;

import aplicacion.DonkeyPOOBException;

@SuppressWarnings("serial")
public abstract class Sprite extends JComponent implements Drawable{
	
	private static HashMap<String, String> diccionarioTipos = null;
	
	private Nivel nivel;
	protected String name;
	
	public Sprite(String name, Nivel n) {
		this.nivel = n;
		this.name = name;
	}
	
	public int[] getPos() {
		try {
			return nivel.getPos(name);
		} catch (DonkeyPOOBException e) {
			return null;
		}
	}
	
	private static void iniciarTraductor() {
		diccionarioTipos = new HashMap<String,String>();
		String[] t1 = {"DonkeyKong","Manual","Protector","Temeroso","Mimo","BarrilAzul","BarrilVerde","BarrilRojo","BarrilAmarillo"};
		String[] t2= {"DonkeyKong","Hero","Hero","Hero","Hero","Barril","Barril","Barril","Barril"};
		for (int i=0; i<t1.length; i++) diccionarioTipos.put(t1[i], t2[i]);
	}
	
	public static String traducir(String name) {
		if (diccionarioTipos == null) iniciarTraductor();
		return diccionarioTipos.get(name);
	}
	
}
