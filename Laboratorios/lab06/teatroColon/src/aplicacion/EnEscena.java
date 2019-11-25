package aplicacion;
import java.io.Serializable;
import java.util.Random;


/**
 * Generaliza el comportamiento de qcualquier objeto que aparezca en escena (en el canvas).
 * 
 * @author Eduard Arias, ECI 2019-2
 * @version 2.1
 */
public interface EnEscena extends Serializable{
    String[] FORMAS = new String[]{"Persona", "Circulo", "Cuadrado"};
    
    Random r = new Random(1);
    
    int getPosicionX();
    int getPosicionY();
    String getColor();

    void actue();
    void corte();
    
    /**
     * Es una persona
     * @return La representacion de la forma de cada elemento en escena. Puede ser humano, rectangulo o circulo.
     */
    default String forma(){
       return FORMAS[0];
    }
    
    /**
     * El mensaje es la representación cadena del objeto
     * @return String con el mensaje de cada objeto
     */
    default String mensaje(){
       return toString();
    }
    
    /**
     * Decide aleatoriamente la acción a tomar
     */
    default void decida(){
        if (r.nextBoolean()){
            actue();
        }else{
            corte();
        }
    }
    
    String getName();
}
