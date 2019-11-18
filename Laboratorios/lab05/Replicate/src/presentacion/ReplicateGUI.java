package presentacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

import aplicacion.Replicate;
import aplicacion.ReplicateException;

public class ReplicateGUI extends JFrame implements ActionListener{
	//Ventana
	private static ReplicateGUI gui;
	
	//Logica de Aplicacion
	private Replicate rep;
	private JButton replicar;
	private JButton llenar; 
	private JButton cambiarTam;

	//Define los elementos que aparecerán en el menú de la ventana
	private MenuBar menu;
	private Menu juego;
	private MenuItem guardar;
	private MenuItem guardarComo;
	private MenuItem nuevo;
	private MenuItem cargar;
	private MenuItem salir;
	
	//Administrador de archivos
	private JFileChooser fc = new JFileChooser();
	
	//Elementos del tablero	
	private JButton[][] tablero;
	private JLabel titulo;
	private JPanel tituloLayout;
	private JPanel centroLayout;
	private JPanel botones;
	private JPanel espacio;
	private JPanel espacios;

	//Elementos para el cambio de color
  	private JButton cambioColor = new JButton("Cambiar colores del tablero");
  	private JColorChooser panelColor = new JColorChooser(); 
	private Color color1 = Color.black;
  	private Color color2 = Color.white; 

  	public ReplicateGUI(){
		super("Replicate");
		prepareElementos();		
		prepareAcciones();		
	}
	
	public static void main(String args[]){
      	gui = new ReplicateGUI();	 
      	gui.setVisible(true);       
    }

	public void prepareElementos(){
		//Ajusta la ventana a 1/4 de la pantalla
      	this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
      	int ancho = (int)(Toolkit.getDefaultToolkit().getScreenSize().width/2);
      	int alto = (int)(Toolkit.getDefaultToolkit().getScreenSize().height/2);
      	this.setSize(ancho,alto);
      	//Centra la ventana      	
		this.setLocationRelativeTo(null);
		setResizable(false);
		//Prepara otros elementos
    	prepareReplicate();
		prepareElementosMenu();
		prepareElementosTablero();
	}
	
	private void prepareReplicate() {
		JTextField alt = new JTextField();
		JTextField anch = new JTextField();
		Object[] message = {
		    "Altura:", alt,
		    "Anchura:", anch
		};
		JOptionPane.showConfirmDialog(null, message, "Creacion de Tablero", JOptionPane.DEFAULT_OPTION);
		try{
			rep = new Replicate(
				Integer.parseInt(alt.getText()),
				Integer.parseInt(anch.getText())
				);
			replicar = new JButton("Replicar");
			llenar = new JButton("Llenar");
			cambiarTam = new JButton("Cambiar Tama�o");
		}catch(ReplicateException e) {
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Ingreso Fallido", JOptionPane.DEFAULT_OPTION);
			System.exit(1);
		}
	}

	private void prepareElementosMenu(){
       	//Añade los elementos al menú desplegable
		menu = new MenuBar();
		juego = new Menu("Menu");
		guardar = new MenuItem("Guardar");
		guardarComo = new MenuItem("Guardar como...");
		nuevo = new MenuItem("Nuevo");
		cargar = new MenuItem("Abrir");
		salir = new MenuItem("Salir");
    	this.setMenuBar(menu);
    	this.menu.add(juego);     	
    	this.juego.add(nuevo);
    	this.juego.add(cargar);
		this.juego.add(guardar);
		this.juego.add(guardarComo);
		this.juego.add(salir);		
    }

	private void prepareElementosTablero(){
		int a = rep.consulte().length;
		int b = rep.consulte()[0].length;
		tablero = new JButton[a][b];
		titulo = new JLabel();
		tituloLayout = new JPanel(new FlowLayout());
		centroLayout = new JPanel(new GridLayout(a+1,b+1));
		botones = new JPanel(new FlowLayout());
		espacio = new JPanel(new FlowLayout());
		espacios = new JPanel(new BorderLayout());
		titulo.setText("Replicate");
    	titulo.setFont(new Font("Bradley Hand ITC",Font.BOLD,32));
    	tituloLayout.add(titulo);
    	setLayout(new BorderLayout());
    	add(tituloLayout,BorderLayout.NORTH);
    	add(centroLayout,BorderLayout.CENTER);
    	botones.add(cambioColor);
    	botones.add(replicar);
    	botones.add(llenar);
    	botones.add(cambiarTam);
    	add(botones,BorderLayout.SOUTH);
    	add(espacio,BorderLayout.WEST);
    	add(espacios,BorderLayout.EAST);
    	for (int i = 0; i < tablero.length; i++){
      		for (int j = 0; j < tablero[0].length; j++) {
        		tablero[i][j] = new JButton();
        		centroLayout.add(tablero[i][j]);     
      		}
    	}
    	refresque();		
	}
	
	private void refresque(){
		boolean[][] replicateState = rep.consulte();
		for (int i = 0; i < tablero.length; i++){
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j].setBackground((replicateState[i][j]) ? color1:color2);
				tablero[i][j].setEnabled(false);
			}
		}
	}



	public void prepareAcciones(){
		this.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent evt){ exitAccion();}});
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		salir.addActionListener(this);
		nuevo.addActionListener(this);
		guardar.addActionListener(this);
		cargar.addActionListener(this);
		cambioColor.addActionListener(this);
		replicar.addActionListener(this);
		llenar.addActionListener(this);
		cambiarTam.addActionListener(this);
	}

	private void exitAccion(){
   		if (JOptionPane.showConfirmDialog(null,"Esta seguro que desea cerrar el juego? ", "Salir de la aplicacion",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);		
	}
	
	private void abrirAccion(){
		int res = fc.showOpenDialog(this);
		if (res == JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null,"Funcion en construccion\nAbrir  archivo: " + fc.getSelectedFile().getName());
		}
	}
	
	private void guardarAccion(){
		int res = fc.showOpenDialog(this);
		if (res == JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null,"Funcion en construccion\nSalvar  archivo: " + fc.getSelectedFile().getName());
		}
	}

	private void cambiarColorAccion(){
		color2 = panelColor.showDialog(null, "Escoger un color para el tablero", color2);
    	if(color2==null) color2=(Color.blue);
    	refresque();	
 	}
	
	private void replicarAccion() {
		if (rep.replicar()) refresque();
	}
	
	private void llenarAccion() {
		JTextField coorX = new JTextField();
		JTextField coorY = new JTextField();
		Object[] message = {
		    "Coordenada X:", coorX,
		    "Coordenada Y:", coorY
		};
		JOptionPane.showConfirmDialog(null, message, "Ingresar coordenadas", JOptionPane.DEFAULT_OPTION);
		try {
			if (rep.llenar(Integer.parseInt(coorX.getText()), Integer.parseInt(coorY.getText()))) {
				tablero[Integer.parseInt(coorX.getText())][Integer.parseInt(coorY.getText())].setBackground(color1);
			}
		}catch (ReplicateException e) {
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Error en el Juego :c", JOptionPane.DEFAULT_OPTION);
		}catch (NumberFormatException ne) {
			JOptionPane.showConfirmDialog(null, ne.getMessage(), "Error en el Juego :c", JOptionPane.DEFAULT_OPTION);
		}
	}
	
	private void nuevoAccion() {
		boolean[][] b = rep.consulte();
		int height = b.length;
		int width = b[0].length;
		try {
			rep = new Replicate(height, width);
			refresque();
		}catch (ReplicateException e) {
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Error en el Juego :c", JOptionPane.DEFAULT_OPTION);
		}
	} 
	
	private void cambiarTamAccion() {
		JTextField alt = new JTextField();
		JTextField anch = new JTextField();
		Object[] message = {
		    "Nueva Altura:", alt,
		    "Nueva Anchura:", anch
		};
		JOptionPane.showConfirmDialog(null, message, "Creacion de Tablero", JOptionPane.DEFAULT_OPTION);
		try {
			Replicate auxRep = new Replicate(
					Integer.parseInt(alt.getText()),
					Integer.parseInt(anch.getText())
					);
			//rep = auxRep;
			JOptionPane.showConfirmDialog(this, "Funcion en desarrollo :)", "Error en el Juego :c", JOptionPane.DEFAULT_OPTION);
		}catch (ReplicateException e) {
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Error en el Juego :c", JOptionPane.DEFAULT_OPTION);
		}
	}


	public void actionPerformed(ActionEvent evento){
		if (evento.getSource()==salir){this.exitAccion();}
		else if (evento.getSource()==nuevo){this.nuevoAccion();}
		else if (evento.getSource()==cargar){this.abrirAccion();}
		else if (evento.getSource()==guardar){this.guardarAccion();}
		else if (evento.getSource()==cambioColor){this.cambiarColorAccion();}
		else if (evento.getSource()==replicar) {this.replicarAccion();}
		else if (evento.getSource()==llenar) {this.llenarAccion();}		
		else if (evento.getSource()==cambiarTam) {this.cambiarTamAccion();}
	}
	
}


