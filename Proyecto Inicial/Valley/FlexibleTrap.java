
/**
 * Clase Trap tipo Flexible. Solo permite un agujero a la vez en su superficie (se "autoparchea").
 *
 * @author Eduard Arias
 * @version 1.0 (08-10-2019)
 */
public class FlexibleTrap extends Trap{
    
    public FlexibleTrap(int[] lowerEnd, int[] higherEnd){
        super(lowerEnd, higherEnd);
    }
    
    @Override
    public void makePuncture(int x){
        if (punctures.size() > 0){
            punctures.get(0).makeInvisible();
            punctures.clear();
        }
        super.makePuncture(x);
    }
}
