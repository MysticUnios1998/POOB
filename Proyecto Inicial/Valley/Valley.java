import java.util.*;

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
    private HashMap<String, Vineyard> vineyards;
    private ArrayList<Trap> traps;
    
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
        vineyards = new HashMap<String, Vineyard>();
        traps = new ArrayList<Trap>();
        lastActionOK = true;
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
                    vineyards.put(name, newVineyard);
                    lastActionOK = true;
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
                traps.add(t);
                lastActionOK = true;
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
            traps.get(position).makeInvisible();
            traps.remove(position);
            lastActionOK = true;
        }
    }
    
    /**
     * @param trap
     * @param x
     */
    public void makePuncture(int trap, int x){}
    
    /**
     * @param trap
     * @param position
     */
    public void patchPunture(int trap, int position){}
    
    /**
     * @param x
     */
    public void startRain(int x){}
    
    /**
     * @param position
     */
    public void stopRain(int position){}
    
    /**
     * 
     */
    public String[] rainFalls(){
        return new String[]{"Helo"};
    }
    
    /**
     * Hace visible al simulador. Si ya es visible, no hace nada.
     */
    public void makeVisible(){
        for (Vineyard vy: vineyards.values()) vy.makeVisible();
        for (Trap t: traps) t.makeVisible();
        lastActionOK = true;
    }
    
    /**
     * Hace invisible al simulador. Si ya es invisible, no hace nada.
     */
    public void makeInvisible(){
        for (Vineyard vy: vineyards.values()) vy.makeInvisible();
        for (Trap t: traps) t.makeInvisible();
        lastActionOK = true;
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
}
