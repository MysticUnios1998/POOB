package presentacion;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import aplicacion.DonkeyPOOB;
import aplicacion.DonkeyPOOBException;

public class DonkeyPOOBGUI{
	
	private DonkeyPOOB logicaJuego;
	
	private MenuPrincipal menuP;
	private Configuracion ajustesJuego;
	private Nivel juego;
	
	private DonkeyPOOBGUI() {
		menuP = new MenuPrincipal(this);
		logicaJuego = DonkeyPOOB.getDonkeyPOOB();
	}
	
	public static void main(String[] args) {
		new DonkeyPOOBGUI();
	}
	
	public void nuevoJuego(int[][][] plataformas, int[][] escaleras, String[][] personajes, boolean sorpresas) throws DonkeyPOOBException {
		juego = new Nivel(this);
		logicaJuego.nuevoJuego(plataformas, escaleras, personajes, sorpresas);
		juego.agregarPersonajes(personajes);
		juego.agregarEstructuras(plataformas);
		juego.agregarEstructuras(escaleras);
	}
	
	public void nuevoJuego() throws DonkeyPOOBException {
		this.nuevoJuego(
				new int[][][] {{{20,120}, {300, 120}}, {{100, 300}, {400, 300}}, {{120, 40}, {450, 100}}, {{10,	450}, {450, 430}}},
				new int[][] {{100, 120, 180, 0}, {380, 90, 210, 0}, {200, 120, 180, 1}, {300, 300, 140, 0}},
				new String[][] {{"Mario", "Manual"}},
				false
		);
	}
	
	public Dimension getGameSize() {
		return new Dimension(DonkeyPOOB.MAX_ANCHO, DonkeyPOOB.MAX_ALTURA);
	}
	
	public int[][][] getPlataformaInfo(){
		return logicaJuego.getPlataformas();
	}
	
	public int[][][] getEscalerasInfo(){
		return logicaJuego.getEscaleras();
	}
	
	public int[] getPos(String name) throws DonkeyPOOBException{
		try{
			return logicaJuego.getPos(name);
		}catch (DonkeyPOOBException e) {
			JOptionPane.showMessageDialog(null, String.format("%s: %s", e.getMessage(), name));
			throw e;
		}
	}
	
}