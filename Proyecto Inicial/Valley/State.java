import java.util.ArrayList;
import java.util.HashMap;
/**
 * La clase State se utiliará como nodo de estado en el tiempo del simulador.
 *
 * @author Eduard Arias, Juan Díaz
 * @version 1.0 (27-09-2019)
 */
public class State{
    private ArrayList<Trap> traps;
    private ArrayList<Rain> rains;
    private HashMap<String, Vineyard> vineyards;
    private boolean visibility;
        
    public void saveState(ArrayList<Trap> trs, ArrayList<Rain> rns, HashMap<String, Vineyard> vys, boolean vis){
        traps = new ArrayList<Trap>(trs);
        rains = new ArrayList<Rain>(rns);
        vineyards = new HashMap<String, Vineyard>(vys);
        visibility = vis;
    }
    
    public void readState(ArrayList<Trap> trs, ArrayList<Rain> rns, HashMap<String, Vineyard> vys){
        trs = traps;
        rns = rains;
        vys = vineyards;
    }
    
    public void copyState(State s){
        s.readState(traps, rains, vineyards);
        visibility = s.getVisibility();
    }
    
    public void reset(){
        traps.clear();
        rains.clear();
        vineyards.clear();
        visibility = false;
    }
    
    public boolean getVisibility(){
        return visibility;
    }
}
        