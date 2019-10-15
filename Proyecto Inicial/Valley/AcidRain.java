import java.util.ArrayList;
import java.awt.geom.Point2D;

/**
 * Clase Rain tipo Acid. Tipo especial de lluvia que agujerea las trampas que se encuentren en su camino.
 *
 * @author Eduard Arias, Juan Diaz
 * @version 1.0(15-10-2019)
 */
public class AcidRain extends Rain{
    
    /**
     * Constructor principal de la clase AcidRain
     * @param x posicion horiontal del inicio de la lluvia.
     */
    public AcidRain(int x){
        super(x);
    }
    
    @Override
    public void calculatePath(ArrayList<Trap> tr, int width, int height){
        erase();
        path.clear();
        path.add(new Point2D.Double(start, 0));
        path.add(new Point2D.Double(start, height));
        int x=start, y=0;
        Point2D.Double trapLoc;
        while (y < height){
            for (Trap t: tr){
                if (t.intersectsLine(x, y, x, y+4)){
                    trapLoc = t.getLocation()[0];
                    t.makePuncture((int)trapLoc.distance(x,y));
                    y+=4;
                }
            }
            y++;
        }
        draw();
    }
}
