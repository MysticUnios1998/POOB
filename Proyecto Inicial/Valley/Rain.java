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
     * Calcula el camino del agua definido por las trampas en el simulador.
     * @param tr arrayList con las trampas.
     */
    public void calculatePath(ArrayList<Trap> tr, int height, int width){
        erase();
        path.clear();
        path.add(new Point2D.Double(start, 0));
        int x=start, y=0;
        while (y < height){
            for (Trap t: tr){
                if (t.intersectsLine(x, y, x, y+4)){
                    path.add(new Point2D.Double(x, y-4));
                    Point2D.Double nextPoint = t.holeNextTo(x,y);
                    path.add(new Point2D.Double(nextPoint.getX()+7, nextPoint.getY()+2));
                    x = (int)nextPoint.getX();
                    y = (int)nextPoint.getY();
                }
            }
            y+=2;
        }
        path.add(new Point2D.Double(x, height));
        draw();
    }
    
    /**
     * Devuelve la coordenada de inicio de la lluvia.
     * @return posicion de inicio.
     */
    public int getStart(){
        return start;
    }
    
    /**
     * Devuelve la coordenada del final de la lluvia.
     * @return posicion del final.
     */
    public int getEndPosition(){
        return (int)path.get(path.size()-1).getX();
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
