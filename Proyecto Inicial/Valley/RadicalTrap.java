import java.util.ArrayList;

/**
 * Clase Trap tipo Radical. Este tipo especial de trampa desaparece si es agujereada.
 *
 * @author Eduard Arias, Juan Diaz
 * @version 1.0 (08-10-2019)
 */
public class RadicalTrap extends Trap{
    
    private final ArrayList<Trap> tr;
    
    public RadicalTrap(int[] lowerEnd, int[] higherEnd, ArrayList<Trap> tr){
        super(lowerEnd, higherEnd);
        this.tr = tr;
    }
    
    @Override
    public void makePuncture(int x){
        makeInvisible();
        tr.remove(this);
    }
}
