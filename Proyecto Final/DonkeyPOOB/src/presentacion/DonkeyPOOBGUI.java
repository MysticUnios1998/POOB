package presentacion;

import javax.swing.JOptionPane;

import aplicacion.DonkeyPOOB;
import aplicacion.DonkeyPOOBException;

public class DonkeyPOOBGUI{
	
	private static int gameHeight = 1000;
	private static int gameWidth = 500;
	
	// Logica del juego
	private DonkeyPOOB logicaJuego;
	
	// Interfaz gráfica del juego
	private MenuPrincipal menuP;
	private Configuracion ajustesJuego;
	private Nivel juego;
	
	private DonkeyPOOBGUI() {
		menuP = new MenuPrincipal(this);
		try {
			logicaJuego = new DonkeyPOOB(gameWidth, gameHeight);
		}catch (DonkeyPOOBException dke) {
			JOptionPane.showConfirmDialog(null, dke.getStackTrace(), null, JOptionPane.OK_OPTION);
		}
	}
	
	public boolean nuevoJuego() {
		ajustesJuego = new Configuracion(this);
		//logicaJuego.nuevoJuego();
		return true;
	}
	
	public static void main(String[] args) {
		new DonkeyPOOBGUI();
	}
	
	
}