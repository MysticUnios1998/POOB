package presentacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Configuracion extends JDialog {

	private DonkeyPOOBGUI mainFrame;
	
	private JPanel background;
	private JButton jugador;
	private JButton jugadores;
	private JButton volver;
	
	public Configuracion(DonkeyPOOBGUI d) {
		// TODO Auto-generated constructor stub
		super();
		mainFrame = d;
		prepareElementos();
		prepareAcciones();
	}

	private void prepareElementos() {	
		prepareBotones();
		prepareBackground();
		prepareVentana();
	}
	
	private void prepareVentana() {
		this.setSize(300,500);
		this.setLayout(new BorderLayout());
		this.add(background, BorderLayout.CENTER);
	}
	
	private void prepareBackground() {
		background = new JPanel();
		background.setBackground(Color.DARK_GRAY);
		background.add(jugador);
		background.add(jugadores);
		background.add(volver);
	}
	
	private void prepareBotones() {
		jugador = new JButton("1 Jugador");
		jugadores = new JButton("2 Jugadores");
		volver = new JButton("Volver");
	}
	
	private void prepareAcciones() {
		prepareAccionesVentana();
		prepareAccionesBotones();
	}
	
	private void prepareAccionesVentana(){
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void prepareAccionesBotones() {
		prepareAccionVolver();
	}
	
	private void prepareAccionVolver() {
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
	}

}
