import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
/**
 * Clase que encapsulará la información relacionada con las lonas en el 
 * simulador. Ofrecerá los servicios de estructura básica y dibujado en Canvas. 
 *
 * @author Eduard Arias, Juan Díaz
 * @version 2.0 (2019-08-28)
 */
public class Trap extends Line2D.Double implements Showable{
    
    private Point2D.Double initialPoint;
    private Point2D.Double finalPoint;
    private boolean isVisible;
    private ArrayList<Circle> punctures;
    
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
        punctures = new ArrayList<Circle>();
        isVisible = false;
    }
    
    @Override
    public void makeVisible(){
        isVisible = true;
        draw();
        for (Circle c: punctures) c.makeVisible();
    }
    
    @Override
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    
    /**
     * Crea un nuevo agujero en esta trampa. 
     * @param x posición del agujero a lo largo de la trampa. Debe ser un 
     * entero mayor a 0.
     */
    public void makePuncture(int x){
        int xPos, yPos;
        double l = getLength();
        xPos = (int)Math.round((finalPoint.getX()*x + initialPoint.getX()*(l-x))/l);
        yPos = (int)Math.round(Math.sqrt(Math.pow(x,2) - Math.pow(xPos- initialPoint.getX(), 2))+initialPoint.getY());
        Circle c = new Circle(14, "white", xPos-7, yPos-7);
        punctures.add(c);
        if (isVisible) c.makeVisible();
    }
    
    /**
     * Repara un agujero que tenga la trampa.
     * @param la posición del agujero.
     */
    public void patchPuncture(int pos){
        int xPos, yPos;
        double l = getLength();
        xPos = (int)Math.round((finalPoint.getX()*pos + initialPoint.getX()*(l-pos))/l);
        yPos = (int)Math.round(Math.sqrt(Math.pow(pos,2) - Math.pow(xPos- initialPoint.getX(), 2))+initialPoint.getY());
        Point2D.Double pt;
        Circle c;
        ArrayList<Integer> removeCandidates = new ArrayList<Integer>();
        for (int i=0; i<punctures.size(); i++){
            c = punctures.get(i);
            pt = c.getLocation();
            if (pt.distance(xPos-7, yPos-7) <= 7){
                c.makeInvisible();
                removeCandidates.add(i);
            }
        }
        for (int j=0; j<removeCandidates.size(); j++) punctures.remove(removeCandidates.get(j));
    }
    
    /**
     * Retorna la ubicación de este objeto.
     * @return array con las coordenadas en forma de puntos. 
     */
    public final Point2D.Double[] getLocation(){
        return new Point2D.Double[]{initialPoint, finalPoint};
    }
    
    /**
     * Retorna la longitud de la trampa.
     * @return la longitud calculada como distancia pitagótica entre los puntos
     */
    public double getLength(){
        return Math.sqrt(Math.pow(initialPoint.getX()-finalPoint.getX(), 2)+
        Math.pow(initialPoint.getY()-finalPoint.getY(), 2));
    }
    
    /**
     * Devuelve las coordenadas horizontales de los huecos.
     * @return array con las coordenadas.
     */
    public int[] getPuncturesCoordinate(){
        int[] ans = new int[punctures.size()];
        for(int i=0; i<punctures.size(); i++) ans[i] = punctures.get(i).xPosition;        
        return (punctures.size() != 0) ? ans: new int[]{-1};
    }
    
    /**
     * Retorna el primer agujero que esté en unas coordenadas. Si no hay 
     * tal agujero, se retorna el punto con yMax.
     * @param x coordenada horizontal.
     * @param y coordenada vertical.
     * @return punto 2D con el agujero dado las coordenadas.
     */
    public Point2D.Double holeNextTo(int x, int y){
        Point2D.Double result = null;
        Point2D.Double punct = null;
        int i=0;
        double minDistance = getLength();
        for (Circle p: punctures){
            punct = p.getLocation();
            if (punct.getY() >= y && punct.distance(x,y) < minDistance){
                result = punct;
                minDistance = punct.distance(x,y);
            }
        }
        if (result == null){
            int xTranslation = 0;
            Point2D.Double[] p = getLocation();
            if (p[0].getY() >= p[1].getY()){
                xTranslation = (p[0].getX() <= p[1].getX()) ? -4: +4;
                result = new Point2D.Double(p[0].getX()+xTranslation, p[0].getY());
            }else{
                xTranslation = (p[1].getX() <= p[0].getX()) ? -4: +4;
                result = new Point2D.Double(p[1].getX()+xTranslation, p[1].getY());
            }
        }else{
            double xf, yf;
            xf = result.getX();
            yf = result.getX();
            result = new Point2D.Double(xf+7, yf+7);
        }
        return result;
    }
    
    protected void draw(){
        if(isVisible){
            Canvas c = Canvas.getCanvas();
            c.draw(this, "black", this);
            c.wait(10);
        }
    }
    
    protected void erase(){
        if (isVisible) Canvas.getCanvas().erase(this);
    }
}