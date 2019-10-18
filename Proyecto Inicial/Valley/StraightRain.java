import java.util.ArrayList;

/**
 * Clase Rain tipo Straight. Tipo especial de lluvia que se mantiene recta siempre que sea posible.
 *
 * @author Eduard Arias, Juan Diaz
 * @version 1.0(15-10-2019)
 */
public class StraightRain extends Rain{
    
    /**
     * Constructor principal de la clase StraightRain
     * @param x posicion horizontal del inicio de la lluvia.
     */
    public StraightRain(int x){
        super(x);
    }
    
    @Override
    public void calculatePath(ArrayList<Trap> tr, int height, int width){
        super.calculatePath(tr, height, width);
    }
    
}
