package presentacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

import aplicacion.Replicate;

public class ReplicateGUI extends JFrame implements ActionListener{
	//Ventana
	private static ReplicateGUI gui;

	//Define los elementos que aparecerán en el menú de la ventana
	private MenuBar menu = new MenuBar();
	private Menu juego = new Menu("Menu");
	private MenuItem guardar = new MenuItem("Guardar");
	private MenuItem guardarComo = new MenuItem("Guardar como...");
	private MenuItem nuevo = new MenuItem("Nuevo");
	private MenuItem cargar = new MenuItem("Abrir");
	private MenuItem salir = new MenuItem("Salir");
	
	//Administrador de archivos
	private JFileChooser fc = new JFileChooser();
	
	//Elementos del tablero	
	private JButton[][] tablero = new JButton[9][9];
	private JLabel titulo = new JLabel();
	private JPanel tituloLayout = new JPanel(new FlowLayout());
	private JPanel centroLayout = new JPanel(new GridLayout(10,10));
	private JPanel botones = new JPanel(new FlowLayout());
	private JPanel espacio = new JPanel(new FlowLayout());
	private JPanel espacios = new JPanel(new BorderLayout());

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
		//Prepara los elementos visibles
		setLayout(new BorderLayout());
    	add(tituloLayout,BorderLayout.NORTH);
    	add(centroLayout,BorderLayout.CENTER);
    	add(botones,BorderLayout.SOUTH);
    	add(cambioColor,BorderLayout.SOUTH);
    	add(espacio,BorderLayout.WEST);
    	add(espacios,BorderLayout.EAST);		
		//Prepara otros elementos
		prepareElementosMenu();
		prepareElementosTablero();
	}

	public void prepareElementosMenu(){
       	//Añade los elementos al menú desplegable
    	this.setMenuBar(menu);
    	this.menu.add(juego);     	
    	this.juego.add(nuevo);
    	this.juego.add(cargar);
		this.juego.add(guardar);
		this.juego.add(guardarComo);
		this.juego.add(salir);		
    }

	public void prepareElementosTablero(){
		titulo.setText("Replicate");
    	titulo.setFont(new Font("Bradley Hand ITC",Font.BOLD,32));
    	tituloLayout.add(titulo);
    	for (int i = 0; i < tablero.length; i++){
      		for (int j = 0; j < tablero[0].length; j++) {
        		tablero[i][j] = new JButton();
        		centroLayout.add(tablero[i][j]);
			tablero[i][j].setEnabled(false);        
      		}
    	}
    	demo();		
	}
	private void refresque(){
		for (int i = 0; i < tablero.length; i++){
      		for (int j = 0; j < tablero[0].length; j++) {        
        		demo();        
        		tablero[i][j].setVisible(false);
        		tablero[i][j].setVisible(true);
      		}
   		}
	}

	private void demo(){
		for (int i = 0; i < tablero.length; i++){
			for (int j = 0; j < tablero[0].length; j++) {
		        if (i==4 && j==4)
		          tablero[i][j].setBackground(color1);
		        else{
		          tablero[i][j].setBackground(color2);
		        }        
		    tablero[i][j].setEnabled(false);
			}
		}
	}



	public void prepareAcciones(){
		this.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent evt){ exitAccion();}});
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		salir.addActionListener(this);
		guardar.addActionListener(this);
		cargar.addActionListener(this);
		cambioColor.addActionListener(this);
		
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
		color2 = panelColor.showDialog(null, "Escoger un color para las fichas", color2);
    	if(color2==null) color2=(Color.blue);
    	refresque();	
 	}


	public void actionPerformed(ActionEvent evento){
		if (evento.getSource()==salir){this.exitAccion();}
		if (evento.getSource()==cargar){this.abrirAccion();}
		if (evento.getSource()==guardar){this.guardarAccion();}
		if (evento.getSource()==cambioColor){this.cambiarColorAccion();};
	}
	
}


