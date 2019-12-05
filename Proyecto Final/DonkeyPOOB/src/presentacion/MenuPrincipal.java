package presentacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame{
	
	private DonkeyPOOBGUI mainFrame;
	
	private Configuracion opcionesJuego;
	
	private JPanel background;
	private JButton titulo;
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
		this.setLayout(new BorderLayout());
		this.add(background, BorderLayout.CENTER);
		this.pack();
	}
	
	private void prepareBackground() {		
		background = new JPanel();
		background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
		background.setBackground(Color.BLACK);
		background.add(titulo);
		background.add(Box.createRigidArea(new Dimension(0,20)));
		background.add(nuevoJuego); 
		background.add(Box.createRigidArea(new Dimension(0,20)));
		background.add(cargarJuego);
		background.add(Box.createRigidArea(new Dimension(0,20)));
		background.add(ajustesJuego);
		background.add(Box.createRigidArea(new Dimension(0,20)));
		background.add(salir);
	}
	
	private void prepareBotones(){
		prepareBotonTitulo(); 
		prepareBotonNuevoJuego(); 
		prepareBotonCargarJuego(); 
		prepareBotonAjustes(); 
		prepareBotonSalir(); 
	}
	
	private void prepareBotonTitulo() {
		titulo = new JButton(new ImageIcon("images/main/titulo.PNG"));
		titulo.setBorder(BorderFactory.createEmptyBorder());
		titulo.setAlignmentX(CENTER_ALIGNMENT);
	}
	
	private void prepareBotonNuevoJuego() {
		nuevoJuego = new JButton(new ImageIcon("images/main/nuevoJuego.PNG"));
		nuevoJuego.setBorder(BorderFactory.createEmptyBorder());
		nuevoJuego.setAlignmentX(CENTER_ALIGNMENT);
	}
	
	private void prepareBotonCargarJuego() {
		cargarJuego = new JButton(new ImageIcon("images/main/cargarJuego.PNG"));
		cargarJuego.setBorder(BorderFactory.createEmptyBorder());
		cargarJuego.setAlignmentX(CENTER_ALIGNMENT);
	}
	
	private void prepareBotonAjustes() {
		ajustesJuego = new JButton(new ImageIcon("images/main/configJuego.PNG"));
		ajustesJuego.setBorder(BorderFactory.createEmptyBorder());
		ajustesJuego.setAlignmentX(CENTER_ALIGNMENT);
	}
	
	private void prepareBotonSalir() {
		salir = new JButton(new ImageIcon("images/main/salirJuego.PNG")); 
		salir.setBorder(BorderFactory.createEmptyBorder());
		salir.setAlignmentX(CENTER_ALIGNMENT);
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
		prepareAccionAjustes();
	}
	
	private void prepareAccionNuevo() {
		nuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				opcionesJuego = new Configuracion(mainFrame);
				mainFrame.nuevoJuego();
			}
		});
	}

	private void prepareAccionAjustes() {
		ajustesJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mainFrame.abrirAjustes();
			}
		});
	}
	
	private void prepareAccionSalir() {
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro?", "Salir del juego", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) System.exit(0);
			}
		});
	}

}
