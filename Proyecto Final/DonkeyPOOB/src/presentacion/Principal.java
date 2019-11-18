package presentacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
//import aplicacion.*;
import java.io.*;

public class Principal extends JFrame implements ActionListener{

	//Ventanas
	private static Principal menuPrincipal;
	private static Jugar jugarVent;
	private static Ajustes ajustesVent;

	//Define los elementos visibles de la pantalla
	private ImageIcon titleButton = new ImageIcon("res/main/titleButton.png");	
	private ImageIcon playButton = new ImageIcon("res/main/playButton.png");
	private ImageIcon configButton = new ImageIcon("res/main/configButton.png");
	private ImageIcon exitButton = new ImageIcon("res/main/exitButton.png");	
	private JPanel background = new JPanel();
	private JButton titulo = new JButton(titleButton);
	private JButton botonJugar = new JButton(playButton);
	private JButton botonSalir = new JButton(exitButton);
	private JButton botonAjustes = new JButton(configButton);

	private JPanel tituloLayout = new JPanel();
	private JPanel inferior = new JPanel(new FlowLayout()); 

	//Define los elementos que aparecerán en el menú de la ventana
  	MenuBar menu = new MenuBar();
  	Menu juego = new Menu("Juego");  	
  	MenuItem nuevo = new MenuItem("Nuevo Juego");  	
  	MenuItem salir = new MenuItem("Salir");

  	Menu ajustes = new Menu("Ajustes");
  	MenuItem ajustesJugador = new MenuItem("Cambiar ajustes");  	


	//Un mensaje que describa alguna accion si es necesario
  	JLabel texto = new JLabel("Eduard Arias - Juan Diaz");

  	public Principal(){
		super("Donkey POOB");
		prepareElementos();		
    	prepareAcciones();			
	}

	public static void main(String args[]){
      menuPrincipal = new Principal();
      menuPrincipal.setVisible(true);       
    }

    public void prepareAcciones(){
      this.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent evt){ exitAccion();}});
      this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      salir.addActionListener(this);      
      nuevo.addActionListener(this);
      ajustesJugador.addActionListener(this);
      botonSalir.addActionListener(this);  
      botonJugar.addActionListener(this);
	  botonAjustes.addActionListener(this);	     	   
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
    	prepareElementosMenuPrincipal();
    	//Otras ventanas
    	jugarVent = new Jugar(this);
		ajustesVent = new Ajustes(this);
    }

    public void prepareElementosMenu(){
        //Añade los elementos al menú desplegable
    	this.setMenuBar(menu);
     	this.menu.add(juego);     	
     	this.juego.add(nuevo);
     	//this.juego.addSeparator();
     	//this.juego.add(guardar);
     	//this.juego.add(cargar);     	
     	//this.juego.addSeparator();
     	this.juego.add(salir);
     	this.menu.add(ajustes);
     	this.ajustes.add(ajustesJugador);     	
    }

    public void prepareElementosMenuPrincipal(){
    	tituloLayout.setLayout(new BoxLayout(tituloLayout, BoxLayout.Y_AXIS));    	
    	tituloLayout.add(titulo); titulo.setAlignmentX(CENTER_ALIGNMENT); titulo.setBorder(BorderFactory.createEmptyBorder());    	
    	tituloLayout.setBackground(Color.black);
    	inferior.setBackground(Color.black);
    	background.setBackground(Color.black);
    	background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
        background.add(Box.createRigidArea(new Dimension(0,40)));    	
    	background.add(botonJugar); botonJugar.setAlignmentX(CENTER_ALIGNMENT); botonJugar.setBorder(BorderFactory.createEmptyBorder());
    	background.add(Box.createRigidArea(new Dimension(0,40)));  	
    	background.add(botonAjustes); botonAjustes.setAlignmentX(CENTER_ALIGNMENT); botonAjustes.setBorder(BorderFactory.createEmptyBorder());
    	background.add(Box.createRigidArea(new Dimension(0,40)));
    	background.add(botonSalir); botonSalir.setAlignmentX(CENTER_ALIGNMENT); botonSalir.setBorder(BorderFactory.createEmptyBorder());
    	inferior.setLayout(new BoxLayout(inferior, BoxLayout.LINE_AXIS));
    	inferior.add(texto);
    	texto.setFont(new Font("OCRB",Font.BOLD,10));
    	texto.setForeground(Color.white); texto.setAlignmentX(LEFT_ALIGNMENT);    	   	  	
    }

    private static void jugarAccion(){    	
    	if (JOptionPane.showConfirmDialog(null,"Empezar juego con los ajustes aplicados?", "Comenzar partida",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION){		
			jugarVent.setVisible(true);
			menuPrincipal.setVisible(false);}
		else{
		}
    }
	
	private static void ajustesAccion(){		
		ajustesVent.setVisible(true);
		menuPrincipal.setVisible(false);
			
	}

    
    private static void exitAccion(){
   		if (JOptionPane.showConfirmDialog(null,"Esta seguro que desea cerrar el juego? ", "Salir de la aplicacion",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);
		else{
		}
	}

	public void actionPerformed(ActionEvent evento){
		if (evento.getSource()==salir){this.exitAccion();}
		if (evento.getSource()==nuevo){this.jugarAccion();}
		if (evento.getSource()==botonSalir){this.exitAccion();}
		if (evento.getSource()==botonJugar){this.jugarAccion();}
		if (evento.getSource()==botonAjustes){this.ajustesAccion();}
		if (evento.getSource()==ajustesJugador){this.ajustesAccion();};

	}



}