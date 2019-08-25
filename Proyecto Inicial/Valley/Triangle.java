import java.awt.*;

/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @author  Eduard Arias
 * @version 2.0 (2019-08-24)
 */

public class Triangle extends LinearFigure{

    /**
     * Create a new triangle at default position with default color.
     */
    public Triangle(){
        this(30, 40, "green", 140, 15);
    }
    
    /**
     * Crea un nuevo triángulo con las especificaciones requeridas.
     * @param height altura del triángulo.
     * @param width largo del triángulo.
     * @param color color del triángulo.
     * @param xPos posicion del triángulo en el eje horizontal.
     * @param yPos posicion del triángulo en el eje vertical.
     */
    public Triangle(int height, int width, String color, int xPos, int yPos){
        this.height = height;
        this.width = width;
        this.color = color;
        xPosition = xPos;
        yPosition = yPos;
        isVisible = false;
    }

    protected void draw(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { xPosition, xPosition + (width/2), xPosition - (width/2) };
            int[] ypoints = { yPosition, yPosition + height, yPosition + height };
            canvas.draw(this, color, new Polygon(xpoints, ypoints, 3));
            canvas.wait(10);
        }
    }
}
