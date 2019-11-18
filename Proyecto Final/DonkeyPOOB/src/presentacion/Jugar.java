package presentacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
//import aplicacion.*;
import java.io.*;

public class Jugar extends JFrame implements ActionListener{

	//Ventanas
	private static Principal menuPrincipal;
	private static Jugar jugarVent;

	//Elementos visibles de la interfaz
	private JLabel titulo = new JLabel();
	private ImageIcon onePlayer = new ImageIcon("res/play/onePlayer.png");
	private ImageIcon twoPlayer = new ImageIcon("res/play/twoPlayer.png");
	private ImageIcon volverImg = new ImageIcon("res/play/volver.png");
	private JPanel background = new JPanel();
	private JButton botonVolver = new JButton(volverImg);
	private JButton unJugador = new JButton(onePlayer);
	private JButton dosJugadores = new JButton(twoPlayer);	
  	private JLabel aviso = new JLabel();

	private JPanel tituloLayout = new JPanel(new FlowLayout());
	private JPanel inferior = new JPanel(new FlowLayout());

	//Un mensaje que describa alguna accion si es necesario
  	JLabel texto = new JLabel("");

  	//Define los elementos que aparecerán en el menú de la ventana
  	MenuBar menu = new MenuBar();
  	Menu menuJuego = new Menu("Menu");
  	MenuItem volver = new MenuItem("Volver");  	
  	MenuItem salir = new MenuItem("Salir");  	

	public Jugar(Principal menuPrincipal){
		super("Donkey POOB - Jugar");
		this.menuPrincipal = menuPrincipal;
		jugarVent = this;		
		prepareElementos();		
    	prepareAcciones();
	}	

	public void prepareAcciones(){
        this.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent evt){ exitAccion();}});
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        salir.addActionListener(this);
        volver.addActionListener(this); 
        botonVolver.addActionListener(this);
        unJugador.addActionListener(this);
        dosJugadores.addActionListener(this);      

    }

	public void prepareElementos(){      
      	int ancho = 600;
      	int alto = 500;
      	this.setSize(ancho,alto);
      	//Centra la ventana
      	this.setLocationRelativeTo(null);
      	//Pone un texto descriptivo en la ventana    
    	this.setLayout(new FlowLayout());
    	this.add(texto);
    	//Prepara los elementos visibles del juego
    	setResizable(false); 
    	setLayout(new BorderLayout());
    	add(tituloLayout,BorderLayout.NORTH);    	
    	add(inferior,BorderLayout.SOUTH);   	
    	add(background,JLabel.CENTER);
    	//Prepara otros elementos
    	prepareElementosMenu();
    	prepareElementosMenuJugar();
    	//Otras ventanas    	   

    }

    public void prepareElementosMenu(){
    	//Añade los elementos al menú desplegable
    	this.setMenuBar(menu);
    	this.menu.add(menuJuego);
    	this.menuJuego.add(volver);
    	this.menuJuego.add(salir);
    }

    public void prepareElementosMenuJugar(){
    	titulo.setText("JUGAR");
    	titulo.setFont(new Font("OCRB",Font.BOLD,42));
    	titulo.setForeground(Color.white);
      	aviso.setText("Dos jugadores es una partida de Jugador vs Jugador");
      	aviso.setFont(new Font("OCRB",Font.BOLD,12));
      	aviso.setForeground(Color.white);
    	tituloLayout.add(titulo);
    	tituloLayout.setBackground(Color.black);
    	inferior.setBackground(Color.black);
    	background.setBackground(Color.black);
    	background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS)); 
      	background.add(Box.createRigidArea(new Dimension(0,30)));   	
    	background.add(unJugador); unJugador.setAlignmentX(CENTER_ALIGNMENT); unJugador.setBorder(BorderFactory.createEmptyBorder());
      	background.add(Box.createRigidArea(new Dimension(0,40)));
    	background.add(dosJugadores); dosJugadores.setAlignmentX(CENTER_ALIGNMENT); dosJugadores.setBorder(BorderFactory.createEmptyBorder());
      	background.add(Box.createRigidArea(new Dimension(0,40))); 
      	background.add(botonVolver); botonVolver.setAlignmentX(CENTER_ALIGNMENT); botonVolver.setBorder(BorderFactory.createEmptyBorder());
      	background.add(Box.createRigidArea(new Dimension(0,40)));   	
     	inferior.setLayout(new BoxLayout(inferior, BoxLayout.Y_AXIS));           
      	inferior.add(aviso); aviso.setAlignmentX(CENTER_ALIGNMENT);
    	     
    }

    private static void unJugadorAccion(){
    	/**
    	partidaVent.setVisible(true);
    	jugarVent.setVisible(false); 
    	*/  
    }	

    private static void dosJugadoresAccion(){
    	/**
      	partida2J.setVisible(true);
      	jugarVent.setVisible(false);
      	*/   
    }

    private static void volverAccion(){		
    	menuPrincipal.setVisible(true);    	
    	jugarVent.dispose();
    }

    private static void exitAccion(){
   		if (JOptionPane.showConfirmDialog(null,"Esta seguro que desea cerrar el juego? ", "Salir de la aplicacion",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);
		else{

		}
	}

	public void actionPerformed(ActionEvent evento){
		if (evento.getSource()==salir){this.exitAccion();}
		if (evento.getSource()==volver){this.volverAccion();}
		if (evento.getSource()==botonVolver){this.volverAccion();}
		if (evento.getSource()==unJugador){this.unJugadorAccion();}
    	if (evento.getSource()==dosJugadores){this.dosJugadoresAccion();};
	}

}

