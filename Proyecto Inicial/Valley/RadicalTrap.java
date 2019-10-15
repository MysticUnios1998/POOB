
/**
 * Clase Trap tipo Radical. Este tipo especial de trampa desaparece si es agujereada.
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
        makeInvisible(); // todavia no funciona eliminando la trampa
    }
}
