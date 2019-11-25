package presentacion;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


import aplicacion.*;


/**
 * Clase que maneja la interfaz gráfica de la aplicacion Teatro Colon. Permite abrir y guardar estados de los elementos
 * de diferentes maneras.
 * 
 * @author Eduard Arias
 * @version 2.1
 */
public class TeatroColonGUI extends JFrame{
    
    private Teatro teatro=null;
    
    private JFileChooser fileManager;
    
    private JPanel botones;
    private JScrollPane contenedor;
    private JButton botonAccion;
    private JButton botonCorten;
    private JButton botonDecision; 
    
    private JMenuBar menuP;
    private JMenu archivo;
    private JMenu juego;
    private JMenuItem iniciar;
    private JMenuItem salir;
    private JMenuItem abrir;
    private JMenuItem salvar;
    private JMenuItem importar;
    private JMenuItem exportar;
    
   
    private FotoTeatro foto;
    
    
    private TeatroColonGUI() {
        super("Teatro Colón");
        try {
            teatro=Teatro.demeTeatro();     
            teatro.algunosEnEscena();
            elementos();
            acciones();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private void elementos() throws Exception {
        setLayout(new BorderLayout());    
        contenedor = new JScrollPane();
        foto= new FotoTeatro();
        contenedor.getViewport().add(foto);
        botones=new JPanel(new GridLayout(1,3));
        botonAccion=new JButton("Actuen");
        botonCorten=new JButton("Corten");
        botonDecision=new JButton("Decidan"); 
        botones.add(botonAccion);
        botones.add(botonCorten);
        botones.add(botonDecision); 
        add(contenedor,BorderLayout.CENTER);
        add(botones,BorderLayout.SOUTH);
        fileManager = new JFileChooser();
        fileManager.setCurrentDirectory(new File("./docs"));
        prepareElementosMenu();
        pack();
        setSize(Teatro.MAXIMO+100,Teatro.MAXIMO+135);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    private void prepareElementosMenu() {
    	menuP = new JMenuBar();
    	archivo = new JMenu("Archivo");
    	juego = new JMenu("Juego");
    	iniciar = new JMenuItem("Iniciar");
    	salir = new JMenuItem("Salir");
    	abrir = new JMenuItem("Abrir");
    	salvar = new JMenuItem("Salvar");
    	importar = new JMenuItem("Importar");
    	exportar = new JMenuItem("Exportar");
    	juego.add(iniciar);
    	juego.add(salir);
    	archivo.add(abrir);
    	archivo.add(salvar);
    	archivo.add(importar);
    	archivo.add(exportar);
    	menuP.add(archivo);
    	menuP.add(juego);
    	setJMenuBar(menuP);
    }
    
    
    private void acciones(){
        ActionListener oyenteBotonAccion=new ActionListener(){
            public void actionPerformed(ActionEvent e){
                accion();
            }   
        };  
        botonAccion.addActionListener(oyenteBotonAccion);
        
        ActionListener oyenteBotonCorten=new ActionListener(){
            public void actionPerformed(ActionEvent e){
                corten();
            }   
        };  
        botonCorten.addActionListener(oyenteBotonCorten);
        
        ActionListener oyenteBotonDecision=new ActionListener(){
            public void actionPerformed(ActionEvent e){
                decidan();
            }   
        }; 
        
        botonDecision.addActionListener(oyenteBotonDecision);
        
        WindowListener w = new WindowAdapter() { 
            public void windowClosing(WindowEvent e) {
                salir();
            }
        };  
        
        prepareAccionesMenu();
        
        this.addWindowListener(w);
        
    }   
    
    private void prepareAccionesMenu() {
    	prepareAccionIniciar();
    	prepareAccionSalir();
    	prepareAccionSalvar();
    	prepareAccionAbrir();
    	prepareAccionImportar();
    	prepareAccionExportar();
    }
    
    private void prepareAccionIniciar() {
    	iniciar.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
    				teatro.iniciar();
    				actualice();
    			}catch(TeatroColonException tcE) {
    				JOptionPane.showConfirmDialog(null, tcE.getMessage(), "Iniciar", JOptionPane.OK_OPTION);
    			}
    		}
    	});
    }
    
    private void prepareAccionSalir(){
    	salir.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			salir();
    		}
    	});
    }
    
    private void prepareAccionSalvar() {
    	salvar.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
    				fileManager.setFileFilter(new FileNameExtensionFilter("Archivo DAT", ".dat"));
    				if (fileManager.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
    					teatro.salvar(new File(fileManager.getSelectedFile().getAbsolutePath()+".dat")); 
    					JOptionPane.showConfirmDialog(null, "Guardado con éxito", null, JOptionPane.OK_OPTION);
    				}
    			}catch(TeatroColonException tcE) {
    				JOptionPane.showConfirmDialog(null, tcE.getMessage(), "Salvar", JOptionPane.OK_OPTION);
    			}
    		}
    	});
    }
    
    private void prepareAccionAbrir() {
    	abrir.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
    				fileManager.setFileFilter(new FileNameExtensionFilter("Archivo DAT", ".dat"));
    				if (fileManager.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
    					teatro.abrir(new File(fileManager.getSelectedFile().getAbsolutePath()+".dat"));
    					JOptionPane.showConfirmDialog(null, "Apertura con éxito", null, JOptionPane.OK_OPTION);
    					actualice();
    				}
    			}catch(TeatroColonException tcE) {
    				JOptionPane.showConfirmDialog(null, tcE.getMessage(), "Abrir", JOptionPane.OK_OPTION);
    			}
    		}
    	});
    }
    
    private void prepareAccionImportar() {
    	importar.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
    				fileManager.setFileFilter(new FileNameExtensionFilter("Documento de Texto", ".txt"));
    				if (fileManager.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
    					teatro.importar(new File(fileManager.getSelectedFile().getAbsolutePath()+".txt"));
    					JOptionPane.showConfirmDialog(null, "Apertura con éxito", null, JOptionPane.OK_OPTION);
    					actualice();
    				}
    			}catch(TeatroColonException tcE) {
    				JOptionPane.showConfirmDialog(null, tcE.getMessage(), "Importar", JOptionPane.OK_OPTION);
    			}
    		}
    	});
    }
    
    private void prepareAccionExportar() {
    	exportar.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
    				fileManager.setFileFilter(new FileNameExtensionFilter("Documento de Texto", ".txt"));
    				if (fileManager.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
    					teatro.exportar(new File(fileManager.getSelectedFile().getAbsolutePath()+".txt"));
    					JOptionPane.showConfirmDialog(null, "Guardado con éxito", null, JOptionPane.OK_OPTION);
    				}
    			}catch(TeatroColonException tcE) {
    				JOptionPane.showConfirmDialog(null, tcE.getMessage(), "Exportar", JOptionPane.OK_OPTION);
    			}
    		}
    	});
    }
    
    private void accion(){
         teatro.accion();
         actualice();
    }
    
    
    private void corten(){       
        teatro.corten();
        actualice();
    }       
    
    private void decidan(){       
        teatro.decidan();
        actualice();
    }   
    
    private void actualice(){
        foto.actualice();
    }
    
    private void salir(){
        dispose();
        System.exit(0);
    }   
    
    
    /**
     * Método inicial de la aplicación. Inicia un Teatro Colon con caracteristicas por defecto.
     * @param args argumentos del sistema
     */
    public static void main(String[] args) {
        TeatroColonGUI gui=new TeatroColonGUI();
        gui.setVisible(true);
    }   
    
    /**
     * Clase interna que maneja los componentes visuales del canvas.
     * 
     * @author Eduard Arias, ECI 2019-2
     */
    class FotoTeatro extends JComponent {
        private int x,y;
        
        private static final int MAX=Teatro.MAXIMO;
        
        /**
         * Devuelve el color correspondiente de un String 
         * @param e elemento EnEscena
         * @return Clase Color con el elemento que corresponde
         */
        public Color getColor(EnEscena e) {
        	Color ans;
        	String eColor = e.getColor();
        	if(eColor.equals("rojo")) ans = Color.red;
            else if(eColor.equals("azul")) ans = Color.blue;
            else if(eColor.equals("naranja")) ans = Color.orange; 
            else if(eColor.equals("amarillo")) ans = Color.yellow; 
            else if(eColor.equals("verde")) ans = Color.green; 
            else ans = Color.black;
        	return ans;
        }
        
        /**
         * Devuelve el color correspondiente de un String 
         * @param e elemento Persona
         * @return Clase Color con el elemento que corresponde
         */
        public Color getColor(Persona e) {
        	Color ans;
        	String eColor = e.getColor();
        	if(eColor.equals("rojo")) ans = Color.red;
            else if(eColor.equals("azul")) ans = Color.blue;
            else if(eColor.equals("naranja")) ans = Color.orange; 
            else if(eColor.equals("amarillo")) ans = Color.yellow; 
            else if(eColor.equals("verde")) ans = Color.green; 
            else ans = Color.black;
        	return ans;
        }
        
        /**
         * Refresca los elementos en el canvas
         */
        public void actualice(){
            teatro=Teatro.demeTeatro();
            repaint();
        }
        
        /**
         * Dibuja los elementos en el canvas. Para cada elemento EnEscena tiene una manera de dibujarlo 
         * @param g graficos del sistema
         */
        public void paintComponent(Graphics g){
            g.setFont(new Font("TimesRoman", Font.PLAIN, 8)); 
            
            for (int i=1; i<=teatro.numeroEnEscena(); i++) {
                
                EnEscena e=teatro.demeEnEscena(i);
                int x=e.getPosicionX();
                int y=MAX-e.getPosicionY();  
                
                g.setColor(getColor(e)); 
                g.drawString(e.mensaje(),x+20,y+10);   
                
                if (e.forma().equals("Persona")){
                    humano(g,(Persona)e,x,y);
                } else  if (e.forma().equals("Circulo")){
                    g.fillOval(x+10,y+0,20,20);
                } else  if (e.forma().equals("Cuadrado")){
                    g.fillRect(x,y,20,20);
                }
            }
            super.paintComponent(g);
        }        
        
        
        /**
         * Dibuja la figura de un elemento Persona
         * @param g graficos del sistema
         * @param e elemento Persona a dibujar
         * @param x posicion en el eje horizontal del elemento
         * @param y posicion en el eje vertical del elemento
         */
        public void humano(Graphics g, Persona e,int x, int y){
            int pos;
            g.setColor(Color.PINK);
            g.fillOval(x+10,y+0,10,10);/*cabeza*/
            g.setColor(getColor(e)); 
            g.drawLine(x+10+5,y+10,x+10+5,y+10+20);
            
            pos=e.getPosicionBrazo('I');
            if (pos==Persona.ARRIBA){
                g.drawLine(x+10+5,y+10+5,x+10+15,y+10);/*brazo izq arriba*/
            } else if (pos==Persona.FRENTE){
                g.drawLine(x+10+5,y+10+5,x+10+15,y+10+5);/*brazo izq al frente*/
            } else {
                g.drawLine(x+10+5,y+10+5,x+10+15,y+10+10);/*brazo izq abajo*/
            }
            
            pos=e.getPosicionBrazo('D');
            if (pos==Persona.ARRIBA){
                g.drawLine(x+10+5,y+10+5,x+5,y+10);/*brazo der arriba*/
            } else if  (pos==Persona.FRENTE){
                g.drawLine(x+10+5,y+10+5,x+5,y+10+5);/*brazo der al frente*/
            } else{
                g.drawLine(x+10+5,y+10+5,x+5,y+10+10);/*brazo der abajo*/
            }
            
            g.drawLine(x+10+5,(y+15)+10+5,x+10+15,(y+15)+10+15);
            g.drawLine(x+10+5,(y+15)+10+5,x+5,(y+15)+10+15);
            
           pos=e.getPosicionPierna('D');
            if (pos==Persona.ARRIBA){
                g.drawLine(x+5,(y+15)+10+15,x+5+10,(y+15)+10+15);/*pierna der arriba*/
            } else if  (pos==Persona.FRENTE){
                g.drawLine(x+5,(y+15)+10+15,x+5-10,(y+15)+10+15+5);/*pierna der al frente*/
            } else{
                g.drawLine(x+5,(y+15)+10+15,x+5,(y+15)+10+15+10);/*pierna der abajo*/
            }
            
            pos=e.getPosicionPierna('I');
            if (pos==Persona.ARRIBA){
                g.drawLine(x+10+15,(y+15)+10+15,x+10+15-10,(y+15)+10+15);/*pierna izq arriba*/
            } else if  (pos==Persona.FRENTE){
                g.drawLine(x+10+15,(y+15)+10+15,x+10+15+10,(y+15)+10+15+5);/*pierna izq al frente*/
            }else {
                g.drawLine(x+10+15,(y+15)+10+15,x+10+15,(y+15)+10+15+10);/*piernaizqabajo*/
            }
        }
    }
}





