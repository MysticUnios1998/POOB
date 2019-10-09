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
    
    protected Point2D.Double initialPoint;
    protected Point2D.Double finalPoint;
    protected boolean isVisible;
    protected ArrayList<Circle> punctures;
    
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
    
    /**
     * Constructor por defecto de la clase. Crea una trampa en la posición (1,1) a la (1,2);
     */
    public Trap(){
        this(new int[]{1,1}, new int[]{1,2});
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
        int len = punctures.size();
        int[] ans = new int[(len > 0) ? len: 1];
        if (len == 0) ans[0] = -1;
        else{
            for (int i=0; i<len;i++) ans[i] = (int)punctures.get(i).getLocation().getX()+1;
        }
        return ans;
    }
    
    /**
     * Retorna los puntos de los agujeros.
     * @return ArrayList con los agujeros de la trampa.
     */
    public ArrayList<Circle> getPunctures(){
        return punctures;
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
        Point2D.Double punct;
        for (Circle c: punctures){
            punct = c.getLocation();
            if (punct.getY()+7 >= y){
                if (result == null || punct.distance(x,y) <=7) result = punct;
            }
        }
        if (result == null) result = (initialPoint.getY() >= finalPoint.getY()) ? initialPoint: finalPoint;
        return result;
    }
    
    /**
     * Crea una copia de una trampa anterior.
     * @param t trampa a clonar.
     */
    public void copyState(Trap t){
        Point2D.Double[] location = t.getLocation();
        initialPoint.setLocation(location[0]);
        finalPoint.setLocation(location[1]);
        for (Circle c: t.getPunctures()) punctures.add(new Circle(14, "white", c.xPosition, c.yPosition));
    }
    
    /**
     * Elimina la trampa de pantalla
     * @return si se pudo eliminar o no
     */
    public boolean delete(){
        makeInvisible();
        return true;
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