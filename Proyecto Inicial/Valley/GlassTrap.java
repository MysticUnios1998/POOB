
/**
 * Clase Trap tipo Glass. Este tipo especial de trampa es transparente al usuario (siempre es invisible) y se "rompe"
 * cuando le hacen un agujero.
 *
 * @author Eduard Arias, Juan Diaz
 * @version 1.0(14-10-2019)
 */
public class GlassTrap extends Trap{
    
    public GlassTrap(int[] lowerEnd, int[] higherEnd){
        super(lowerEnd, higherEnd);
    }
    
    @Override
    public void makeVisible(){
        isVisible = false;
    }
    
    @Override
    public void makePuncture(int x){
        super.makePuncture(x);
        makeInvisible();
        if (getLength() >= 5){
            Circle c = punctures.get(0);
            finalPoint.setLocation(c.getLocation());
            c.makeInvisible();
        }
        punctures.clear();
    }
}
