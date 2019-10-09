
/**
 * Clase Trap tipo Radical.
 *
 * @author Eduard Arias, Juan Diaz
 * @version 1.0 (08-10-2019)
 */
public class RadicalTrap extends Trap{
    
    public RadicalTrap(int[] lowerEnd, int[] higherEnd){
        super(lowerEnd, higherEnd);
    }
    
    @Override
    public void makePuncture(int x){
        // por el momento hace lo mismo que la normal.
        super.makePuncture(x);
    }
}
