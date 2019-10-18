import java.util.Random;
/**
 * Clase Trap tipo Flexible. Solo permite un agujero a la vez en su superficie (se "autoparchea").
 *
 * @author Eduard Arias
 * @version 1.0 (08-10-2019)
 */
public class FlexibleTrap extends Trap{
    
    /**
     * Devuelve un punto al azar dentro de las fronteras del simulador.
     * @param simHeight altura del simulador.
     * @param simWidth largo del simulador.
     * @return array con las coordenadas.
     */
    public static final int[] getFlexiblePoint(int simHeight, int simWidth){
        int xCoord, yCoord;
        Random r = new Random();
        do{
            xCoord = r.nextInt(simWidth);
            yCoord = r.nextInt(simHeight);
        }while (0==xCoord || 0==yCoord);
        return new int[]{xCoord, yCoord};
    }
    
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
