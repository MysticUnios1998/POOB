package presentacion;

import javax.swing.JOptionPane;

import aplicacion.DonkeyPOOB;
import aplicacion.DonkeyPOOBException;

public class DonkeyPOOBGUI{
	
	private int height;
	private int width;
	
	// Logica del juego
	private DonkeyPOOB logicaJuego;
	
	// Interfaz gráfica del juego
	private MenuPrincipal menuP;
	
	private DonkeyPOOBGUI() {
		menuP = new MenuPrincipal(this);
		try {
			logicaJuego = new DonkeyPOOB(500, 1000);
		}catch (DonkeyPOOBException dke) {
			JOptionPane.showConfirmDialog(null, dke.getStackTrace(), null, JOptionPane.OK_OPTION);
		}
	}
	
	public static void main(String[] args) {
		new DonkeyPOOBGUI();
	}
	
	
}