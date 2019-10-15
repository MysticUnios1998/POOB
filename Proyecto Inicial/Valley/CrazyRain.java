import java.util.ArrayList;
import java.util.Random;

/**
 * Calse Rain tipo Crazy. Tipo especial de lluvia que cambia su posicion inicial cada vez que es invisible.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CrazyRain extends Rain{
    
    private Random r;
    private final ArrayList<Trap> simulatorTraps;
    private final int simHeight;
    private final int simWidth;

    /**
     * Constructor principal de la clase Rebel Rain
     * @param x posicion horizontal del inicio de la lluvia.
     */
    public CrazyRain(int x, ArrayList<Trap> tr, int h, int w){
        super(x);
        simulatorTraps = tr;
        simHeight = h;
        simWidth = w;
        r = new Random();
        do{
            start = r.nextInt(simWidth);
        }while(Math.abs(start-x)<5 && start<=0);
    }
    
    @Override
    public void makeInvisible(){
        super.makeInvisible();
        r = new Random();
        int x;
        do{
            x = r.nextInt(simWidth);
        }while(Math.abs(start-x)<5 && x<=0);
        start = x;
        calculatePath(simulatorTraps, simHeight, simWidth);
    }
}
