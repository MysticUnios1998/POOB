package aplicacion;
import java.io.Serializable;


/**
 * Clase Elemento que reune las cualidades de cualquier elemento en la pantalla.
 * 
 * @author Eduard Arias
 * @version 2.0
 *
 */
public class Elemento implements Serializable{
    
    private String nombre;      
    protected String color;
    private int posicionx;
    private int posiciony;
    
    /**Crea un nuevo elemento en la posicion (posicionx, posiciony)
    @param nombre nombre del elemento
    @param posicionx coordenada x de la posicion 
    @param posiciony coordenada y de la posicion
    */
    public Elemento(String nombre, int posicionx, int posiciony){
        this.posicionx=posicionx;
        this.posiciony=posiciony;
        this.nombre=nombre;        
        color="black";
    }

    /**
     * Retorna el color del elemento
     * @return String con el color del elemento
     */
    public String getColor(){
        return color;
    }
    
    /**
     * Cambia el color del elemento. Puede ser rojo, azul, naranja, amarillo, verde. Por defecto es "black"
     * @param color nuevo color del objeto
     */
    public void setColor(String color){
    	if(color.equals("rojo")) this.color=color;
        else if(color.equals("azul")) this.color=color;
        else if(color.equals("naranja")) this.color=color; 
        else if(color.equals("amarillo")) this.color=color; 
        else if(color.equals("verde")) this.color=color; 
        else this.color="black";
    }
    
     /**
      * Retorna la coordenada x de la posicion
      * @return posicion en el eje horizontal
      */
    public final int getPosicionX(){
        return posicionx;
    }

    /**
     * Retorna la coordenada y de la posicion
     * @return posicion en el eje vertical
     */
    public final int getPosicionY(){
        return posiciony;
    }
    
    /**
     * Retorna el nombre del elemento
     * @return Cadena con la información requerida
     */
    public String toString(){
        return nombre;
    }
    
    /**
     * Consulta el nombre del elemento
     * @return String con la información requerida
     */
    public String getName() {
    	return toString();
    }
}
