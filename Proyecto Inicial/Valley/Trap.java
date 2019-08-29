import java.awt.*;
import java.awt.geom.*;
/**
 * Clase que encapsulará la información relacionada con las lonas en el 
 * simulador. Ofrecerá los servicios de estructura básica y dibujado en Canvas. 
 *
 * @author Eduard Arias
 * @version 2.0 (2019-08-28)
 */
public class Trap extends Line2D.Double implements Showable{
    
    private Point2D.Double initialPoint;
    private Point2D.Double finalPoint;
    private boolean isVisible;
    
    /**
     * Constructor principal de la clase. Crea una línea a partir de 
     * coordenadas tipo (x,y).
     * @param start array con las coordenadas del punto inicial.
     * @param end array con las coordenadas del punto final.
     */
    public Trap(int[] start, int[] end){
        super(--start[0], --start[1], --end[0], --end[1]);
        initialPoint = new Point2D.Double(start[0], start[1]);
        finalPoint = new Point2D.Double(end[0], end[1]);
        isVisible = false;
    }
    
    /**
     * Dibuja este objeto en pantalla
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * Quita el objeto de pantalla
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    
    /**
     * Retorna la ubicación de este objeto.
     * @return array con las coordenadas en forma de puntos. 
     */
    public final Point2D.Double[] getLocation(){
        return new Point2D.Double[]{initialPoint, finalPoint};
    }
    
    protected void draw(){
        if(isVisible){
            Canvas c = Canvas.getCanvas();
            c.draw(this, "black", this);//No importa que Shape sea, ya que dibuja una línea
            c.wait(10);
        }
    }
    
    protected void erase(){
        if (isVisible){
            Canvas.getCanvas().erase(this);
        }
    }
}