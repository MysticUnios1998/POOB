import java.util.*;

/**
 * Clase principal del proyecto Valley. Su objetivo es resonder a los 
 * servicios requeridos para realizar el simulador del problema F de ICPC 2019.
 *
 * @author Eduard Arias
 * @version 1.0 (2019-08-24)
 */
public class Valley{
    
    private final Canvas canvasReference;
    private int height;
    private int width;
    private boolean lastActionOK;
    
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
        lastActionOK = true;
    }
    
    /**
     * @param name
     * @param xi
     * @param xf
     */
    public void openYard(String name, int xi, int xf){}
    
    /**
     * @param name
     */
    public void closeYard(String name){}
    
    /**
     * @param lowerEnd
     * @param higherEnd
     */
    public void addTrap(int[] lowerEnd, int[] higherEnd){}
    
    /**
     * @param position
     */
    public void removeTrap(int position){}
    
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
    public void makeVisible(){}
    
    /**
     * Hace invisible al simulador. Si ya es invisible, no hace nada.
     */
    public void makeInvisible(){}
    
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
