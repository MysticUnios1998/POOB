import java.awt.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @author Eduard Arias
 * @version 2.0 (2019-08-24) 
 */

public class Circle extends Figure{

    public static double PI=3.1416;
    private int diameter;
    
    /**
     * Create a new circle at default position with default color.
     */
    public Circle(){
        this(30, "blue", 20, 15);
    }
    
    /**
     * Crea un nuevo círculo con las especificaciones requeridas.
     * @param diameter diametro del círculo.
     * @param color color del círculo.
     * @param xPos posición del círculo en el eje horizontal.
     * @param yPos posición del círculo en el eje vertical.
     */
    public Circle(int diameter, String color, int xPos, int yPos){
        this.diameter = diameter;
        this.color = color;
        xPosition = xPos;
        yPosition = yPos;
        isVisible = false;
    }

    /**
     * Change the size.
     * @param newDiameter the new size (in pixels). Size must be >=0.
     */
    public void changeSize(int newDiameter){
        erase();
        diameter = newDiameter;
        draw();
    }
    
    /**
     * Retorna la ubicación del círculo.
     * @return punto2D con las coordenadas del círculo.
     */
    public Point2D.Double getLocation(){
        return new Point2D.Double(xPosition, yPosition);
    }

    /*
     * Draw the circle with current specifications on screen.
     */
    protected void draw(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, 
                new Ellipse2D.Double(xPosition, yPosition, 
                diameter, diameter));
            canvas.wait(10);
        }
    }
}
