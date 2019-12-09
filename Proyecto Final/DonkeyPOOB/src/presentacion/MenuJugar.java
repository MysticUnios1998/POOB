package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuJugar extends JDialog {

	private DonkeyPOOBGUI mainFrame;
	
	private JPanel background;
	private JButton jugador;
	private JButton jugadores;
	private JButton volver;

	private ImageIcon unJugador = new ImageIcon("images/play/unJugador.PNG");
	private ImageIcon dosJugadores = new ImageIcon("images/play/dosJugador.PNG");
	private ImageIcon volverBoton = new ImageIcon("images/play/volver.PNG");

	private JLabel titulo = new JLabel("NUEVO JUEGO");
	private JPanel tituloLayout = new JPanel();	
	
	public MenuJugar(DonkeyPOOBGUI d) {		
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
		this.setSize(400,500);
		this.setLayout(new BorderLayout());
		this.add(background, BorderLayout.CENTER);
		this.add(tituloLayout, BorderLayout.NORTH);
	}
	
	private void prepareBackground() {
		//Fondo
		background = new JPanel();
		background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
		background.setBackground(Color.DARK_GRAY);
		background.add(Box.createRigidArea(new Dimension(0,65)));
		background.add(jugador);
		background.add(Box.createRigidArea(new Dimension(0,40)));
		background.add(jugadores);
		background.add(Box.createRigidArea(new Dimension(0,40)));
		background.add(volver);
		//Parte superior
		titulo.setFont(new Font("OCRB",Font.BOLD,42));
    	titulo.setForeground(Color.white);
    	tituloLayout.add(titulo);
    	tituloLayout.setBackground(Color.DARK_GRAY);
	}
	
	private void prepareBotones() {
		jugador = new JButton(unJugador); jugador.setBorder(BorderFactory.createEmptyBorder()); jugador.setAlignmentX(CENTER_ALIGNMENT);
		jugadores = new JButton(dosJugadores); jugadores.setBorder(BorderFactory.createEmptyBorder()); jugadores.setAlignmentX(CENTER_ALIGNMENT);
		volver = new JButton(volverBoton); volver.setBorder(BorderFactory.createEmptyBorder()); volver.setAlignmentX(CENTER_ALIGNMENT);
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
		volver.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e) {				
				setVisible(false);
				dispose();
			}
		});
	}

}
