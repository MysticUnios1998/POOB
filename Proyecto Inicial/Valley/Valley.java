import java.util.*;
import java.awt.geom.Point2D;

/**
 * Clase principal del proyecto Valley. Su objetivo es resonder a los 
 * servicios requeridos para realizar el simulador del problema F de ICPC 2019.
 *
 * @author Eduard Arias
 * @version 1.0 (2019-08-24)
 */
public class Valley implements Showable{
    
    private final Canvas canvasReference;
    private int height;
    private int width;
    private boolean lastActionOK;
    private boolean isVisible;
    private Stack<State> undo;
    private Stack<State> redo;
    private HashMap<String, Vineyard> vineyards;
    private ArrayList<Trap> traps;
    private ArrayList<Rain> rains;
    
    /**
     * Constructor principal para la clase valley.
     * @param width ancho del simulador. Debe ser un entero mayor a 0.
     * @param height altura del simulador. Debe ser un entero mayor a 0.
     */
    public Valley(int width, int height){
        if (width < 0 || height < 0) throw new ArithmeticException("Valores menores a 0.");
        canvasReference = Canvas.getCanvas(width, height);
        this.height = height;
        this.width = width;
        undo = new Stack<State>();
        redo = new Stack<State>();
        vineyards = new HashMap<String, Vineyard>();
        traps = new ArrayList<Trap>();
        rains = new ArrayList<Rain>();
        lastActionOK = true;
        isVisible = false;
    }
    
    /**
     * Coloca un nuevo viñedo en el valle. Este debe estar "bien planteado"
     * (que su inicio no sea mayor a su final) y no salirse del simulador.
     * @param name color identificador del viñedo. Colores válidos: "red", "yellow", "blue", "green",
     * "magenta", "orange" and "black".
     * @param xi coordenada de inicio del viñedo.
     * @param xf coordenada de final del viñedo.
     */
    public void openYard(String name, int xi, int xf){
        lastActionOK = false;
        xi--; xf--;
        if (xi >= 0 && xf < width && xi < xf){
            Vineyard newVineyard = new Vineyard(xf-xi, name, xi, height-Vineyard.fixedHeight);
            if (!vineyards.containsKey(name)){
                boolean sePuedeColocar = true;
                for (Vineyard vy: vineyards.values()){
                    if (newVineyard.intersect(vy)) sePuedeColocar = false;
                }
                if (sePuedeColocar){
                    prevState();
                    vineyards.put(name, newVineyard);
                    lastActionOK = true;
                    if (isVisible) newVineyard.makeVisible();
                }
            }
        }
    }
    
    /**
     * Remueve un viñedo del valle. De no existir, no hace nada.
     * @param name color identificador del viñedo a remover.
     */
    public void closeYard(String name){
        lastActionOK = false;
        if (vineyards.containsKey(name)){
            prevState();
            vineyards.get(name).makeInvisible();
            vineyards.remove(name);
            lastActionOK = true;
        }
    }
    
    /**
     * Coloca una nueva trampa (techo) en el simulador. Si las posiciones requeridas
     * se salen de las dimensiones del simulador, no hace nada.
     * @param lowerEnd array con las posiciones iniciales.
     * @param higherEnd array con las posiciones finales.
     */
    public void addTrap(int[] lowerEnd, int[] higherEnd){
        lastActionOK = false;
        if (1<=lowerEnd[0] && lowerEnd[0]<=width && 1<=lowerEnd[1] && lowerEnd[1]<=height
        && 1<=higherEnd[0] && higherEnd[0]<=width && 1<=higherEnd[1] && higherEnd[1]<=height){
            Trap t = new Trap(lowerEnd, higherEnd);
            boolean seChoca = false;
            int i = 0;
            while(i<traps.size() && !seChoca) seChoca = t.intersectsLine(traps.get(i++));
            if (!seChoca){
                prevState();
                traps.add(t);
                lastActionOK = true;
                for (Rain r: rains) r.calculatePath(traps, height, width);
                if (isVisible) t.makeVisible();
            }
        }
    }
    
    /**
     * Coloca un tipo especial de trampa en el simulador.Si las posiciones requeridas
     * se salen de las dimensiones del simulador, no hace nada.
     * El tipo puede ser: "flexible", "hard", "radical".
     * @param type tipo de trampa.  Si el tipo no coincide con
     * los anteriores, se crea una trampa normal.
     * @param lowerEnd array con las posiciones iniciales.
     * @param higherEnd array con las posiciones finales.
     */
    public void addTrap(String type, int[] lowerEnd, int[] higherEnd){
        addTrap(lowerEnd, higherEnd);
        if (ok()){
            if (type.equals("hard")){
                traps.set(traps.size()-1, new HardTrap(lowerEnd, higherEnd));
            }else if(type.equals("flexible")){
                traps.set(traps.size()-1, new FlexibleTrap(lowerEnd, higherEnd));
            }else if(type.equals("radical")){
                traps.set(traps.size()-1, new RadicalTrap(lowerEnd, higherEnd));
            }
        }
    }
    
    /**
     * Remueve una lona del simulador. Funciona por orden de llegada.
     * @param position número de la lona a eliminar. Debe ser un entero mayor a 0.
     */
    public void removeTrap(int position){
        lastActionOK = false;
        position--;
        if (position >= 0 && position < traps.size()){
            prevState();
            if (traps.get(position).delete()){
                traps.remove(position);
                lastActionOK = true;
                for (Rain r: rains) r.calculatePath(traps, height, width);
            }
        }
    }
    
    /**
     * Realiza una rotura en una trampa. De no existir la trampa no hace nada.
     * @param trap posición en orden de llegada de la trampa requerida.
     * Debe ser un entero mayor a 0.
     * @param x posición sobre la trampa en donde se va a hacer el agujero.
     */
    public void makePuncture(int trap, int x){
        lastActionOK = false;
        trap--;
        if (0<=trap && trap<traps.size()){
            Trap t = traps.get(trap);
            if (x <= t.getLength()){
                prevState();
                t.makePuncture(x);
                lastActionOK = true;
                for (Rain r: rains) r.calculatePath(traps, height, width);
            }
        }
    }
    
    /**
     * Repara un agujero de una trampa requerida. La trampa está por orden de llegada.
     * Si en la posición solicitada no hay agujero, se considera un éxito.
     * @param trap posición en orden de llegada de la trampa requerida.
     * @param position ubicación del agujero en la trampa.
     */
    public void patchPuncture(int trap, int position){
        lastActionOK = false;
        trap--;
        if (0<=trap && trap<traps.size()){
            prevState();
            traps.get(trap).patchPuncture(position);
            lastActionOK = true;
            for (Rain r: rains) r.calculatePath(traps, height, width);
        }
    }
    
    /**
     * Crea lluvia en el simulador, iniciando desde un punto específico.
     * @param x posicion horizontal del inicio de la lluvia.
     */
    public void startRain(int x){
        lastActionOK = false;
        if (1<=x && x<=width){
            prevState();
            Rain r = new Rain(x);
            rains.add(r);
            r.calculatePath(traps, width, height);
            if (isVisible) r.makeVisible();
            lastActionOK = true;
        }
    }
    
    /**
     * Para la lluvia del simulador.
     * @param position coordenada horizontal de la lluvia. Se toma un margen de 5 pixeles.
     */
    public void stopRain(int position){
        lastActionOK = false;
        ArrayList<Rain> eliminationCandidates = new ArrayList<Rain>();
        for (Rain r: rains){
            if (Math.abs(r.getStart()-position) <= 4){
                r.makeInvisible();
                eliminationCandidates.add(r);
            }
        }
        if (eliminationCandidates.size() > 0){
            prevState();
            for (Rain r: eliminationCandidates) rains.remove(r);
            lastActionOK = true;
        }
    }
    
    /**
     * Devuelve los viñedos que están recibiendo cualquier lluvia.
     * @return array con los nombres identificadores de los viñedos que
     * cumplen la condición.
     */
    public String[] rainFalls(){
        ArrayList<String> vineyardsUnderRain = new ArrayList<String>();
        boolean isWeathy;
        for (Vineyard vy: vineyards.values()){
            int[] vyPosition = vy.getPosition();
            isWeathy = false;
            for (int i=0; i<rains.size() && !isWeathy; i++){
                int pos = rains.get(i).getEndPosition();
                if (vyPosition[0] <= pos && pos <= vyPosition[1]){
                    isWeathy = true;
                    vineyardsUnderRain.add(vy.getName());
                }
                
            }
        }
        return vineyardsUnderRain.toArray(new String[vineyardsUnderRain.size()]);
    }
    
    /**
     * Realiza la accion de intercambio de estados del simulador.
     * @param d undo ('U') o redo ('R').
     */
    public void doAction(char d){
        lastActionOK = false;
        if (d=='U' || d=='R'){
            State newState = new State();
            newState.saveState(traps, rains, vineyards, isVisible, height, width);
            makeInvisible();
            if (d == 'U' && undo.size() > 0){
                redo.add(newState);
                readState(undo.pop());
                lastActionOK = true;
            }else if(d == 'R' && redo.size() > 0){
                undo.add(newState);
                readState(redo.pop());
                lastActionOK = true;
            }else{
                if (lastActionOK) makeVisible(); // este es porque el makeInvisible de arriba cambia la visibilidad y el lastActionOK
                lastActionOK = false;
            }
        }
    }
    
    @Override
    public void makeVisible(){
        lastActionOK = false;
        if (!isVisible){
            prevState();
            for (Vineyard vy: vineyards.values()) vy.makeVisible();
            for (Trap t: traps) t.makeVisible();
            for (Rain r: rains) r.makeVisible();
            lastActionOK = true;
            isVisible = true;
        }
    }
    
    @Override
    public void makeInvisible(){
        lastActionOK = false;
        if (isVisible){
            prevState();
            for (Vineyard vy: vineyards.values()) vy.makeInvisible();
            for (Trap t: traps) t.makeInvisible();
            for (Rain r: rains) r.makeInvisible();
            lastActionOK = true;
            isVisible = false;
        }
    }
    
    /**
     * Realiza el zoom del simulador.
     * @param z caracter que indica si es zoomIn (+) o zoomOut (-).
     */
    public void zoom(char z){
        lastActionOK = false;
        if(z == '+' || z == '-'){
            canvasReference.zoom(z);
            lastActionOK = true;
        }
    }
    
    /**
     * Devuelve la información de los viñedos.
     * @return arrayMatrix con las coordenadas de inicio y final de cada viñedo.
     */
    public int[][] vineyards(){
        int[][] vys = new int[vineyards.size()][2];
        int i = 0;
        for (Vineyard vy : vineyards.values()){
            vys[i][0] = vy.xPosition+1;
            vys[i][1] = vy.xPosition+vy.width+1;
            i++;
        }        
        return vys;
    }
    
    /**
     * Devuelve la información de las trampas.
     * @return arrayCube con las coordenadas de inicio y final de 
     * cada trampa, junto con las coordenadas horizontales de sus huecos.
     */
    public int[][][] traps(){
        int[][][] trapsResume = new int[traps.size()][][];
        int[][] trapInfo;
        int x;
        for (int i=0; i<traps.size(); i++){
            Point2D.Double[] tr = traps.get(i).getLocation();
            trapInfo = new int[3][];
            for (x=0; x<2; x++) trapInfo[x] = new int[]{(int)tr[x].getX()+1,(int)tr[x].getY()+1};
            trapInfo[x] = traps.get(i).getPuncturesCoordinate();
            trapsResume[i] = trapInfo;
        }
        return trapsResume;
    }
    
    /**
     * Devuelve la información de las lluvias.
     * @return arrayCube con las coordenadas de los puntos de recorrido de cada lluvia.
     */
    public int[][][] rains(){
        int[][][] rainsResume = new int[rains.size()][][];
        int[][] rainInfo;
        Point2D.Double[] rainPath;
        for (int i=0; i<rains.size();i++){ 
            rainPath = rains.get(i).getPath();
            rainInfo = new int[rainPath.length][2];
            for (int j=0; j<rainPath.length; j++) rainInfo[j] = new int[]{(int)rainPath[j].getX(), (int)rainPath[j].getY()+1};
            rainsResume[i] = rainInfo;
        }
        return rainsResume;
    }
    
    /**
     * Finaliza el proceso y sale del simulador.
     */
    public void finish(){
        System.exit(0);
    }
    
    /**
     * Verifica si se pudo realizar la última acción solicitada.
     * @return si l última acción se realizó con éxito o no.
     */
    public boolean ok(){
        return lastActionOK;
    }
    
    private void prevState(){
        State prev = new State();
        prev.saveState(traps, rains, vineyards, isVisible, height, width);
        undo.add(prev);
        redo.clear();
    }
    
    private void readState(State s){
        traps = s.getTraps();
        rains = s.getRains();
        vineyards = s.getVineyards();
        if (s.getVisibility()) makeVisible();
    }
}

