package aplicacion;
import java.util.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;


/**
 * Clase principal de la lógica de la aplicación. Responde por los datos contenidos en la aplicación 
 * así como de su cambio e integridad. Corresponde al patrón "Singleton"
 * 
 * @author Eduard Arias, ECI 2019-2
 * @version 2.4
 */
public class Teatro{
    public static final int MAXIMO = 500;
    private static Teatro teatro = null;
    
    public static Teatro demeTeatro() {
        if (teatro==null) Teatro.nuevoTeatro();
        return teatro;
    }
    
    private static void nuevoTeatro() {
        teatro=new Teatro();
    }   
    
    public static void cambieTeatro(Teatro d) {
        teatro=d;
    }       


    private ArrayList<EnEscena> elementos;
    
    private Teatro() {
        elementos= new ArrayList<EnEscena>();
    }
    
    
    /**
     * Coloca algunos elementos por defecto en el canvas.
     */
    public void algunosEnEscena(){ 
        Actor romeo = new Actor(Teatro.demeTeatro(),"romeo", 10, 10); 
        Actor julieta = new Actor(Teatro.demeTeatro(),"julieta", 100, 10);
        adicione(romeo);
        adicione(julieta);
        ActorNecio homer = new ActorNecio(Teatro.demeTeatro(), "homer", 190, 10);
        ActorNecio bard = new ActorNecio(Teatro.demeTeatro(), "bard", 280, 10);
        adicione(homer);
        adicione(bard);
        Luz centralDerecha = new Luz(Teatro.demeTeatro(), "centralDerecha", 220, 250);
        Luz centralIzquierda = new Luz(Teatro.demeTeatro(), "centralIzquierda", 280, 250);
        adicione(centralDerecha);
        adicione(centralIzquierda);
        ActorPerezoso bella = new ActorPerezoso(Teatro.demeTeatro(), "bella", 390, 10);
        ActorPerezoso edward = new ActorPerezoso(Teatro.demeTeatro(), "edward", 480, 10);
        adicione(bella);
        adicione(edward);
        ActorTimido juan = new ActorTimido(Teatro.demeTeatro(), "juan", 390, 80);
        ActorTimido eduard = new ActorTimido(Teatro.demeTeatro(), "eduard", 480, 80);
        adicione(juan);
        adicione(eduard);
        Pantalla izquierda = new Pantalla(Teatro.demeTeatro(), "izquierda", 100, 450);
        Pantalla derecha = new Pantalla(Teatro.demeTeatro(), "derecha", 400, 450);
        adicione(izquierda);
        adicione(derecha);
    }  
    
    
    /**
     * Consulta el elemento en la n-ésima posicion de los elementos en escena.
     * @param n la posicion del elemento requerido
     * @return El elemento en escena.
     */
    public EnEscena demeEnEscena(int n){
        EnEscena h=null;
        if (1<=n && n<=elementos.size()){
            h=elementos.get(n-1);
        }    
        return h; 
    }
    
    /**
     * Agrega un nuevo elemento en escena al canvas.
     * @param e elemento en escena requerido
     */
    public void adicione(EnEscena e){
	    elementos.add(e);
    }
	
    /**
     * Consulta la cantidad de elementos en escena en la actualidad del canvas 
     * @return la cantidad de elementos
     */
    public int numeroEnEscena(){
        return elementos.size();
    }  
    
    /**
     * Ejecuta la orden de "actuar" a todos los elementos en escena
     */
    public void accion(){
        for (EnEscena e: elementos) e.actue();
    }

    /**
     * Ejecuta la orden de "cortar" a todos los elementos en escena
     */
    public void corten(){
        for (EnEscena e: elementos) e.corte();
    }    

    /**
     * Ejecuta la orden de "decidan" a todos los elementos en escena
     */
    public void decidan(){
        for (EnEscena e: elementos) e.decida();
    }
    
    /**
     * Inicia los elementos por defecto de la aplicacion.
     * @exception TeatroColonException
     */
    public void iniciar() throws TeatroColonException{
    	elementos.clear();
    	algunosEnEscena();
    }
    
    /**
     * Realiza la apertura de un archivo con la información de los elementos en escena de un teatro particular. 
     * El archivo debe tener la información en forma de "objeto". 
     * @param archivo objeto File con la ubicación del archivo a abrir. Debe ser ".dat".
     * @exception TeatroColonException si el archivo no existe o si sucede un error al leerlo o abrirlo.
     */
    @SuppressWarnings("resource")
	public void abrir(File archivo) throws TeatroColonException{
    	if (archivo == null) throw new TeatroColonException(TeatroColonException.FILE_NOT_FOUND);
    	ObjectInputStream in = null;
    	try {
    		in = new ObjectInputStream(new FileInputStream(archivo));
    		elementos.clear();
    		boolean finished = false;
    		while (!finished) {
    			try {
					elementos.add((EnEscena)in.readObject());
				} catch (ClassNotFoundException e) {
					iniciar();
					in.close();
					throw new TeatroColonException(String.format("%s: %s",TeatroColonException.ERROR_READING_FILE, e.getMessage()));
				}catch (EOFException eof) {
					finished = true;
				}
    		}
    		in.close();
    	}catch(IOException ioE) {
    		throw new TeatroColonException(String.format("%s: %s\n%s", TeatroColonException.ERROR_READING_FILE, archivo.getName(), ioE.getMessage()));
    	}
    }
    
    /**
     * Realiza la apertura de un archivo con la información de los elementos en escena de un teatro particular. 
     * El archivo debe tener la información en forma de "objeto". 
     * @param archivo objeto File con la ubicación del archivo a abrir. Debe ser ".dat".
     * @exception TeatroColonException si el archivo no existe o si sucede un error al leerlo o abrirlo.
     */
    public void abrir01(File archivo) throws TeatroColonException{
    	if (archivo == null) throw new TeatroColonException(TeatroColonException.FILE_NOT_FOUND);
    	ObjectInputStream in = null;
    	try {
    		in = new ObjectInputStream(new FileInputStream(archivo));
    		elementos.clear();
    		boolean finished = false;
    		while (!finished) {
    			try {
					elementos.add((EnEscena)in.readObject());
				} catch (ClassNotFoundException e) {
					iniciar();
					in.close();
					throw new TeatroColonException(String.format("%s: %s",TeatroColonException.ERROR_READING_FILE, e.getMessage()));
				}catch (EOFException eof) {
					finished = true;
				}
    		}
    		if (in != null) in.close();
    	}catch(IOException ioE) {
    		ioE.printStackTrace();
    		throw new TeatroColonException(String.format("%s: %s", TeatroColonException.ERROR_READING_FILE, archivo.getName()));
    	}
    }
    
    /**
     * Guarda la informacion de los elementos en escena de un teatro particular en forma de Stream de objetos.
     * @param archivo objeto File con la ubicación del archivo a guardar. Debe ser ".dat"
     * @exception TeatroColonException si el archivo no se creó correctamente o si sucede un error al leerlo o abrirlo.
     */
    public void salvar(File archivo) throws TeatroColonException{
    	if (archivo == null) throw new TeatroColonException(TeatroColonException.FILE_NOT_FOUND);
    	ObjectOutputStream out = null;
    	try {
    		out = new ObjectOutputStream(new FileOutputStream(archivo));
    		for (EnEscena obj: elementos) out.writeObject(obj);
    		out.close();
    	}catch(IOException ioE) {
    		throw new TeatroColonException(String.format("%s: %s\n%s", TeatroColonException.ERROR_WRITING_TO_FILE, archivo.getName(), ioE.getMessage()));
    	}
    }
    
    /**
     * Guarda la informacion de los elementos en escena de un teatro particular en forma de Stream de objetos.
     * @param archivo objeto File con la ubicación del archivo a guardar. Debe ser ".dat"
     * @exception TeatroColonException si el archivo no se creó correctamente o si sucede un error al leerlo o abrirlo.
     */
    public void salvar01(File archivo) throws TeatroColonException{
    	if (archivo == null) throw new TeatroColonException(TeatroColonException.FILE_NOT_FOUND);
    	ObjectOutputStream out = null;
    	try {
    		out = new ObjectOutputStream(new FileOutputStream(archivo));
    		for (EnEscena obj: elementos) out.writeObject(obj);
    		out.close();
    	}catch(IOException ioE) {
    		throw new TeatroColonException(String.format("%s: %s", TeatroColonException.ERROR_WRITING_TO_FILE, archivo.getName()));
    	}
    }
    
    /**
     * Realiza la apertura de un archivo con la información de los elementos en escena de un teatro particular. Envia la informacion en forma de 
     * texto para ser compatible con otros recursos. 
     * @param archivo objeto File con la ubicación del archivo a abrir. Debe ser ".txt"
     * @exception TeatroColonException si el archivo no existe o si sucede un error al leerlo o abrirlo.
     */
    @SuppressWarnings("resource")
	public void importar(File archivo) throws TeatroColonException{
    	if (archivo == null) throw new TeatroColonException(TeatroColonException.FILE_NOT_FOUND);
    	Scanner in = null;
    	try {
    		in = new Scanner(archivo);
    		in.useDelimiter("\n");
    		String[] line;
    		elementos.clear();
    		while (in.hasNext()) {
    			line = in.next().split(" ");
    			try {
					elementos.add((EnEscena) Class.forName(String.format("aplicacion.%s", line[0])).
							getDeclaredConstructor(Teatro.class, String.class, int.class, int.class).
							newInstance(null, line[3], Integer.parseInt(line[1]), Integer.parseInt(line[2])));
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
					throw new IOException(e.getMessage());
				}
    		}
    	}catch(IOException ioE) {
    		throw new TeatroColonException(String.format("%s: %s\n%s", TeatroColonException.ERROR_WRITING_TO_FILE, archivo.getName(), ioE.getMessage()));
		}
    }
    
    
    /**
     * Guarda la información de los elementos en escena de un teatro particular. Extrae la informacion en forma de 
     * texto para ser compatible con otros recursos. 
     * @param archivo objeto File con la ubicación del archivo a abrir. Debe ser ".txt"
     * @exception TeatroColonException si el archivo no se creó correctamente o si sucede un error al leerlo o abrirlo.
     */
    public void exportar(File archivo) throws TeatroColonException{
    	if (archivo == null) throw new TeatroColonException(TeatroColonException.FILE_NOT_FOUND);
    	BufferedWriter out = null;
    	try {
    		out = new BufferedWriter(new FileWriter(archivo));
    		for (EnEscena elemento: elementos) {
    			out.write(String.format("%s %d %d %s\n", 
    					elemento.getClass().getSimpleName(), 
    					elemento.getPosicionX(),
    					elemento.getPosicionY(),
    					elemento.getName()
    			));
    		}
    		out.close();
    	}catch (IOException ioE) {
    		throw new TeatroColonException(String.format("%s: %s", TeatroColonException.ERROR_WRITING_TO_FILE, archivo.getName()));
    	}
    }
    
}
