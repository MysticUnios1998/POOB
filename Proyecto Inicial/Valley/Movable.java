
/**
 * La clase Movable contendrá los métodos básicos para el movimiento de 
 * un objeto en la pantalla. Una clase que implemente esta interfaz 
 * deberá saber cómo desplazarse en dos dimensiones.
 *
 * @author Eduard Arias
 * @version 1.0 (2019-08-25)
 */
public interface Movable{
    
    /**
     * Controla el desplazamiento en el eje horizontal.
     * @param distance distancia a recorrer en pixeles.
     */
    public void moveHorizontal(int distance);
    
    /**
     * Controla el desplazamiento en el eje vertical.
     * @param distance distancia a recorrer en pixeles.
     */
    public void moveVertical(int distance);
}
