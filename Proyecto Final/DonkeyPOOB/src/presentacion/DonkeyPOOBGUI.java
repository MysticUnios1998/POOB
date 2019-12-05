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
	private ArrayList<Sprite> sprites;
	
	private DonkeyPOOBGUI() {
		menuP = new MenuPrincipal(this);
		logicaJuego = DonkeyPOOB.getDonkeyPOOB();
		sprites = new ArrayList<Sprite>();
	}
	
	public static void main(String[] args) {
		new DonkeyPOOBGUI();
	}
	
	public void nuevoJuego() {
		logicaJuego.nuevoJuego();
		juego = new Nivel(this);
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
	
	public int[] getMainEnemyInfo() {
		return logicaJuego.getDonkeyKong();
	} 
	
	public ArrayList<Sprite> getSpritesToDraw(){
		return sprites;
	}
	
}