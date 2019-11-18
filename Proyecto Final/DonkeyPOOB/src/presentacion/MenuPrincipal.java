package presentacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame{
	
	private DonkeyPOOBGUI mainFrame;
	
	private JPanel background;
	private JButton nuevoJuego;
	private JButton cargarJuego;
	private JButton ajustesJuego;
	private JButton salir;

	public MenuPrincipal(DonkeyPOOBGUI d) {
		super("DonkeyPOOB");
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
		this.setSize(600,500);
		this.setLayout(new BorderLayout());
		this.add(background, BorderLayout.CENTER);
	}
	
	private void prepareBackground() {
		background = new JPanel();
		background.setBackground(Color.BLACK);
		background.add(nuevoJuego);
		background.add(cargarJuego);
		background.add(ajustesJuego);
		background.add(salir);
	}
	
	private void prepareBotones(){
		nuevoJuego = new JButton("Nuevo Juego");
		cargarJuego = new JButton("Cargar Juego");
		ajustesJuego = new JButton("Configuracion");
		salir = new JButton("Salir");
	}
	
	private void prepareAcciones() {
		prepareAccionesBotones();
		prepareAccionesVentana();
	}
	
	private void prepareAccionesVentana(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void prepareAccionesBotones() {
		prepareAccionNuevo();
		prepareAccionSalir();
	}
	
	private void prepareAccionNuevo() {
		nuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mainFrame.nuevoJuego();
			}
		});
	}
	
	private void prepareAccionSalir() {
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro?", null, JOptionPane.YES_NO_OPTION);
				if (opcion == 0) System.exit(0);
			}
		});
	}

}
