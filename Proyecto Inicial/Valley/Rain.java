import java.util.ArrayList;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
/**
 * Clase Rain que hace referencia a la lluvia que debe caer en los VineYards
 * 
 * @author Eduard Arias, Juan Diaz
 * @version 2.0 (12-09-2019)
 */
public class Rain extends Line2D.Double implements Showable{
    
    public final static String RAIN_COLOR = "cyan";
    
    private int start;
    private ArrayList<Point2D.Double> path;
    private boolean isVisible;
    
    
    /**
     * Constructor principal de la clase Rain con valor fijos
     * @param x Posicion en el eje horzontal de la lluvia
     */
    public Rain(int x){
        start = x;
        path = new ArrayList<Point2D.Double>();
        isVisible = false;
    }
    
    /**
     * Retorna el camino que ha hecho la lluvia.
     * @return Point2D[] con los pountos individuales del camino.
     */
    public Point2D.Double[] getPath(){
        return path.toArray(new Point2D.Double[path.size()]);
    }
    
    /**
     * Verifica si una trampa se ubica en el camino de la lluvia.
     * @param trap trampa contra la que se verifica la ubicación.
     */
    public void intersects(Trap trap){
        
    }
    
    @Override
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    @Override
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    
    private void addPoint(int x, int y){
        Point2D.Double newPoint = new Point2D.Double(x,y);
        int i=0;
        while (i<path.size() && path.get(i).getY() < y) i++;
        path.add(i, newPoint);
        if (isVisible) makeVisible();
    }
    
    private void draw(){
        if(isVisible){
            Canvas c = Canvas.getCanvas();
            c.draw(this, Rain.RAIN_COLOR, this);
            c.wait(10);
        }
    }
    
    private void erase(){
        if (isVisible) Canvas.getCanvas().erase(this);
    }
    
}
