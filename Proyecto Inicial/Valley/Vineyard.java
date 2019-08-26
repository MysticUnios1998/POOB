/**
 * Write a description of class Vineyard here.
 *
 * @author Eduard Arias
 * @version 1.0 (2019-08-25)
 */
public class Vineyard extends Rectangle{
    
    public static final int fixedHeight = 10;
    
    /**
     * Constructor principal de la clase Vineyard
     * @param height altura del viñedo.
     * @param width extensión del viñedo.
     * @param color identificador del viñedo actual.
     * @param xPos posición del viñedo en el eje horizontal.
     * @param yPos posición del viñedo en el eje vertical.
     */
    public Vineyard(int height, int width, String color, int xPos, int yPos){
        super(height, width, color, xPos, yPos);
    }
    
    /**
     * Constructor principal sobrecargado de la clase Vineyard. Este crea un viñedo
     * con altura fija.
     * @param width extensión del viñedo.
     * @param color identificador del viñedo actual.
     * @param xPos posición del viñedo en el eje horizontal.
     * @param yPos posición del viñedo en el eje vertical.
     */
    public Vineyard(int width, String color, int xPos, int yPos){
        this(fixedHeight, width, color, xPos, yPos);
    }
    
    /**
     * Verifica si el viñedo se cruza con otro. Se cruzan si tienen un rango de valores
     * en común (teoría de conjuntos).
     * @param vineyard viñedo contra el que se hace la verificación.
     * @return si se cruzan o no.
     */
    public boolean intersect(Vineyard vineyard){
        return !(vineyard.xPosition+vineyard.width < xPosition ||
                xPosition+width < vineyard.xPosition);
    }
}
