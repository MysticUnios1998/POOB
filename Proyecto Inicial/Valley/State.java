import java.util.ArrayList;
import java.util.HashMap;
import java.awt.geom.Point2D;
/**
 * La clase State se utiliará como nodo de estado en el tiempo del simulador.
 *
 * @author Eduard Arias, Juan Díaz
 * @version 2.0 (03-10-2019)
 */
public class State{
    
    private ArrayList<Trap> traps;
    private ArrayList<Rain> rains;
    private HashMap<String, Vineyard> vineyards;
    private boolean visibility;
    
    public State(){
        traps = new ArrayList<Trap>();
        rains = new ArrayList<Rain>();
        vineyards = new HashMap<String, Vineyard>();
        visibility = false;
    }
    
    public void saveState(ArrayList<Trap> traps, ArrayList<Rain> rains, HashMap<String, Vineyard> vineyards, boolean isVisible, int height, int width){
        Trap tr;
        Rain r;
        int i;
        for (i=0; i<traps.size();i++){
            Point2D.Double[] loc = traps.get(i).getLocation();
            tr = new Trap();
            tr.copyState(traps.get(i));
            this.traps.add(tr);
        }
        for (i=0; i<rains.size(); i++){
            r = new Rain(rains.get(i).getStart());
            r.calculatePath(traps, height, width);
            this.rains.add(r);
        }
        for (Vineyard vy: vineyards.values()){
            int[] location = vy.getPosition();
            this.vineyards.put(vy.getName(), new Vineyard(location[1]-location[0], vy.getName(), location[0], height-Vineyard.fixedHeight));
        } 
        visibility = isVisible;
    }
    
    public void copyState(State s){
        traps = s.getTraps();
        rains = s.getRains();
        vineyards = s.getVineyards();
        visibility = s.getVisibility();
    }
    
    public boolean getVisibility(){
        return visibility;
    }
    
    public ArrayList<Trap> getTraps(){
        return traps;
    }
    
    public ArrayList<Rain> getRains(){
        return rains;
    }
    
    public HashMap<String, Vineyard> getVineyards(){
        return vineyards;
    }
    
    private void reset(){
        traps.clear();
        rains.clear();
        vineyards.clear();
        visibility = false;
    }
}
        