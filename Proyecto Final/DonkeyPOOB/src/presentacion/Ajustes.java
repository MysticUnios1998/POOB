package presentacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
//import aplicacion.*;
import java.io.*;

public class Ajustes extends JFrame implements ActionListener{

	//Ventanas
	private static Principal menuPrincipal;
	private static Ajustes ajustesVent;

	//Elementos visibles de la interfaz
	private ImageIcon volverImg = new ImageIcon("res/config/volver.png");
	private ImageIcon green = new ImageIcon("res/config/green.png");
	private ImageIcon blue = new ImageIcon("res/config/blue.png");
	private ImageIcon red = new ImageIcon("res/config/red.png");
	private ImageIcon yellow = new ImageIcon("res/config/yellow.png");
	private ImageIcon brown = new ImageIcon("res/config/brown.png");
	private ImageIcon si = new ImageIcon("res/config/si.png");
	private ImageIcon no = new ImageIcon("res/config/no.png");
	private JLabel titulo = new JLabel();
	private JLabel configJugador = new JLabel();
	private JLabel configJugador2 = new JLabel();
	private JLabel configTablero = new JLabel();
	private JPanel background = new JPanel();	
	private JButton botonVolver = new JButton(volverImg);
	//Jugador 1
	private JButton color1J1 = new JButton(green);
	private JButton color2J1 = new JButton(blue);
	private JButton color3J1 = new JButton(red);
	private JButton color4J1 = new JButton(yellow);
	private JButton color5J1 = new JButton(brown);	
	//Jugador 2
	private JButton color1J2 = new JButton(green);
	private JButton color2J2 = new JButton(blue);
	private JButton color3J2 = new JButton(red);
	private JButton color4J2 = new JButton(yellow);
	private JButton color5J2 = new JButton(brown);	
	//Sorpresas
	private JLabel configSorpresa = new JLabel();
	private JButton sorSi = new JButton(si);
	private JButton sorNo = new JButton(no);
	//Un mensaje que describe alguna accion si es necesario
  	private static JLabel texto = new JLabel("Seleccione una opcion");

	private JPanel tituloLayout = new JPanel(new FlowLayout());
	private JPanel botones = new JPanel();	

	public Ajustes(Principal menuPrincipal){
        super("Donkey POOB - Ajustes");
        ajustesVent = this; 
        this.menuPrincipal = menuPrincipal;        
        prepareAcciones();
        prepareElementos();
	}

	public void prepareAcciones(){
        this.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent evt){exitAccion();}});
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);        
        botonVolver.addActionListener(this);
        //Cambios de color de jugador 1
        color1J1.addActionListener(
        	new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		try{greenJ1();} 
        		catch(IOException ex){}
        	}
        });
        color2J1.addActionListener(
        	new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		try{blueJ1();} 
        		catch(IOException ex){}
        	}
        });         
         color3J1.addActionListener(
        	new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		try{redJ1();} 
        		catch(IOException ex){}
        	}
        });
         color4J1.addActionListener(
        	new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		try{yellowJ1();} 
        		catch(IOException ex){}
        	}
        });
         color5J1.addActionListener(
        	new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		try{brownJ1();} 
        		catch(IOException ex){}
        	}
        });        
        //Cambios de color de jugador 2
        color1J2.addActionListener(
        	new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		try{greenJ2();} 
        		catch(IOException ex){}
        	}
        });
        color2J2.addActionListener(
        	new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		try{blueJ2();} 
        		catch(IOException ex){}
        	}
        });         
        color3J2.addActionListener(
        	new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		try{redJ2();} 
        		catch(IOException ex){}
        	}
        });
        color4J2.addActionListener(
        	new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		try{yellowJ2();} 
        		catch(IOException ex){}
        	}
        });
        color5J2.addActionListener(
        	new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		try{brownJ2();} 
        		catch(IOException ex){}
        	}
        });        
        //Cambios de sorpresas
        sorSi.addActionListener(
        	new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		try{activarSorpresa();} 
        		catch(IOException ex){}
        	}
        });

        sorNo.addActionListener(
        	new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		try{desactivarSorpresa();} 
        		catch(IOException ex){}
        	}
        });      
	
    }

    public void prepareElementos(){     	
      	int ancho = 600;
      	int alto = 500;
      	this.setSize(ancho,alto);
      	//Centra la ventana
      	this.setLocationRelativeTo(null);
      	//Pone un texto descriptivo en la ventana    
    	this.setLayout(new FlowLayout());    	
    	//Prepara los elementos visibles del juego
    	setResizable(false); 
    	setLayout(new BorderLayout());
    	add(tituloLayout,BorderLayout.NORTH);    	
    	add(botones,BorderLayout.SOUTH);   	
    	add(background,JLabel.CENTER);    	
    	//Prepara otros elementos    	
    	prepareElementosMenuAjustes();
    }

    public void prepareElementosMenuAjustes(){
		titulo.setText("AJUSTES");
    	titulo.setFont(new Font("OCRB",Font.BOLD,42));
    	titulo.setForeground(Color.white);
    	tituloLayout.add(titulo);
    	tituloLayout.setBackground(Color.black);
    	botones.setBackground(Color.black);		
		configJugador.setText("Color Mario");
    	configJugador.setFont(new Font("OCRB",Font.BOLD,24));
    	configJugador.setForeground(Color.white);
    	configJugador2.setText("Color Luigi");
    	configJugador2.setFont(new Font("OCRB",Font.BOLD,24));
    	configJugador2.setForeground(Color.white);    	
    	configTablero.setText("PARTIDA");
    	configTablero.setFont(new Font("OCRB",Font.BOLD,24));
    	configTablero.setForeground(Color.cyan);
    	configSorpresa.setText("Activar sorpresas ");
    	configSorpresa.setFont(new Font("OCRB",Font.BOLD,24));
    	configSorpresa.setForeground(Color.white);    	
    	texto.setFont(new Font("OCRB",Font.BOLD,15));
    	texto.setForeground(Color.white);    	
    	background.setBackground(Color.black);
    	background.setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();    	    	
    	//Contenido de los ajustes    		
		c.fill = GridBagConstraints.HORIZONTAL; c.gridx=0; c.gridy=0; background.add(configJugador,c);	
		c.fill = GridBagConstraints.HORIZONTAL; c.gridx=1; c.gridy=0; background.add(color1J1,c); color1J1.setBorder(BorderFactory.createEmptyBorder());
		c.fill = GridBagConstraints.HORIZONTAL; c.gridx=2; c.gridy=0; background.add(color2J1,c); color2J1.setBorder(BorderFactory.createEmptyBorder());
		c.fill = GridBagConstraints.HORIZONTAL; c.gridx=3; c.gridy=0; background.add(color3J1,c); color3J1.setBorder(BorderFactory.createEmptyBorder());
		c.fill = GridBagConstraints.HORIZONTAL; c.gridx=4; c.gridy=0; background.add(color4J1,c); color4J1.setBorder(BorderFactory.createEmptyBorder());
		c.fill = GridBagConstraints.HORIZONTAL; c.gridx=5; c.gridy=0; background.add(color5J1,c); color5J1.setBorder(BorderFactory.createEmptyBorder());						
		c.fill = GridBagConstraints.HORIZONTAL; c.gridx=0; c.gridy=1; background.add(configJugador2,c);  	
		c.fill = GridBagConstraints.HORIZONTAL; c.gridx=1; c.gridy=1; background.add(color1J2,c); color1J2.setBorder(BorderFactory.createEmptyBorder());
		c.fill = GridBagConstraints.HORIZONTAL; c.gridx=2; c.gridy=1; background.add(color2J2,c); color2J2.setBorder(BorderFactory.createEmptyBorder());
		c.fill = GridBagConstraints.HORIZONTAL; c.gridx=3; c.gridy=1; background.add(color3J2,c); color3J2.setBorder(BorderFactory.createEmptyBorder());
		c.fill = GridBagConstraints.HORIZONTAL; c.gridx=4; c.gridy=1; background.add(color4J2,c); color4J2.setBorder(BorderFactory.createEmptyBorder());
		c.fill = GridBagConstraints.HORIZONTAL; c.gridx=5; c.gridy=1; background.add(color5J2,c); color5J2.setBorder(BorderFactory.createEmptyBorder());		 		
		c.fill = GridBagConstraints.HORIZONTAL; c.gridx=0; c.gridy=2; background.add(configTablero,c);
		c.fill = GridBagConstraints.HORIZONTAL; c.gridx=0; c.gridy=3; background.add(configSorpresa,c); 
		c.fill = GridBagConstraints.HORIZONTAL; c.gridx=1; c.gridy=3; background.add(sorSi,c); sorSi.setBorder(BorderFactory.createEmptyBorder());
		c.fill = GridBagConstraints.HORIZONTAL; c.gridx=2; c.gridy=3; background.add(sorNo,c); sorNo.setBorder(BorderFactory.createEmptyBorder());
		botones.setLayout(new BoxLayout(botones, BoxLayout.Y_AXIS));
		botones.add(texto); texto.setAlignmentX(CENTER_ALIGNMENT);			
		botones.add(botonVolver); botonVolver.setAlignmentX(CENTER_ALIGNMENT); botonVolver.setBorder(BorderFactory.createEmptyBorder());
	}

	private static void volverAccion(){		
    	menuPrincipal.setVisible(true);    	
    	ajustesVent.dispose();
    }

    private static void exitAccion(){
   		if (JOptionPane.showConfirmDialog(null,"Esta seguro que desea cerrar el juego? ", "Salir de la aplicacion",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);
		else{

		}
	}

	//Metodos de persistencia
	//Jugador 1
	private static void greenJ1() throws IOException{
		FileWriter config = new FileWriter("docs/Config.txt");
		config.write("res/green.png");
		config.close();
		texto.setText("Color del jugador 1 cambiado a verde");		
	}

	private static void blueJ1() throws IOException{
		FileWriter config = new FileWriter("docs/Config.txt");
		config.write("res/blue.png");
		config.close();
		texto.setText("Color del jugador 1 cambiado a azul");		
	}

	private static void redJ1() throws IOException{
		FileWriter config = new FileWriter("docs/Config.txt");
		config.write("res/red.png");
		config.close();
		texto.setText("Color del jugador 1 cambiado a rojo");		
	}

	private static void yellowJ1() throws IOException{
		FileWriter config = new FileWriter("docs/Config.txt");
		config.write("res/yellow.png");
		config.close();
		texto.setText("Color del jugador 1 cambiado a amarillo");		
	}

	private static void brownJ1() throws IOException{
		FileWriter config = new FileWriter("docs/Config.txt");
		config.write("res/brown.png");
		config.close();
		texto.setText("Color del jugador 1 cambiado a cafe");		
	}	

	//Jugador 2
	private static void greenJ2() throws IOException{
		FileWriter config = new FileWriter("docs/Config2.txt");
		config.write("res/green.png");
		config.close();
		texto.setText("Color del jugador 2 cambiado a verde");		
	}

	private static void blueJ2() throws IOException{
		FileWriter config = new FileWriter("docs/Config2.txt");
		config.write("res/blue.png");
		config.close();
		texto.setText("Color del jugador 2 cambiado a azul");		
	}

	private static void redJ2() throws IOException{
		FileWriter config = new FileWriter("docs/Config2.txt");
		config.write("res/red.png");
		config.close();
		texto.setText("Color del jugador 2 cambiado a rojo");		
	}

	private static void yellowJ2() throws IOException{
		FileWriter config = new FileWriter("docs/Config2.txt");
		config.write("res/yellow.png");
		config.close();
		texto.setText("Color del jugador 2 cambiado a amarillo");		
	}

	private static void brownJ2() throws IOException{
		FileWriter config = new FileWriter("docs/Config2.txt");
		config.write("res/brown.png");
		config.close();
		texto.setText("Color del jugador 2 cambiado a cafe");		
	}	

	//Sorpresas
	private static void activarSorpresa() throws IOException{
		FileWriter config = new FileWriter("docs/Sorpresas.txt");
		config.write("si");
		config.close();
		texto.setText("Sorpresas activadas");		
	}

	private static void desactivarSorpresa() throws IOException{
		FileWriter config = new FileWriter("docs/Sorpresas.txt");
		config.write("no");
		config.close();
		texto.setText("Sorpresas desactivadas");		
	}

	public void actionPerformed(ActionEvent evento){		
		if (evento.getSource()==botonVolver){this.volverAccion();};		
	}   

}