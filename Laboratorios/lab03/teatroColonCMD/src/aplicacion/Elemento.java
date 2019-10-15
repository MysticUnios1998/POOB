package aplicacion;
import java.awt.Color;

public class Elemento {
    
    private String nombre;      
    protected Color color;
    private int posicionx,posiciony;
    
    /**Crea un nuevo elemento en la posicion (posicionx, posiciony)
    @param nombre nombre del elemento
    @param posicionx coordenada x de la posicion 
    @param posiciony coordenada y de la posicion
    */
    public Elemento(String nombre, int posicionx, int posiciony){
        this.posicionx=posicionx;
        this.posiciony=posiciony;
        this.nombre=nombre;        
        color=Color.BLACK;
    }

    /**Retorna el color del elemento*/
    public Color getColor(){
        return color;
    }
    
    /**Cambia el color del elemento. Puede ser rojo, azul, naranja, amarillo, verde*/
    public void setColor(String color){
        if(color.equals("rojo")) this.color=Color.RED;
        else if(color.equals("azul")) this.color=Color.BLUE; 
        else if(color.equals("naranja")) this.color=Color.ORANGE; 
        else if(color.equals("amarillo")) this.color=Color.YELLOW; 
        else if(color.equals("verde")) this.color=Color.GREEN; 
        else this.color=Color.BLACK;
    }
    
     /**Retorna la coordenada x de la posicion*/
    public final int getPosicionX(){
        return posicionx;
    }

    /**Retorna la coordenada y de la posicion*/
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
}
