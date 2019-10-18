
/**
 * Clase Trap tipo Hard. Este tipo especial de trampa no puede ser agujereado ni eliminado.
 *
 * @author Eduard Arias, Juan Diaz
 * @version 1.0 (08-10-2019) 
 */
public class HardTrap extends Trap{
    
    public HardTrap(int[] lowerEnd, int[] higherEnd){
        super(lowerEnd, higherEnd);
    }
    
    @Override
    public boolean delete(){
        return false;
    }
    
    @Override
    public void makePuncture(int x){}
}
