import java.awt.*;

/**
 * A rectangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes (Modified)
 * @author  Eduard Arias
 * @version 2.0 (2019-08-24)
 */
public class Rectangle extends LinearFigure{

    /**
     * Create a new rectangle at default position with default color.
     */
    public Rectangle(){
        this(30, 40, "magenta", 70, 15);
    }
    
    /**
     * Crea un nuevo rectángulo con las especificaciones requeridas.
     * @param height altura del rectángulo.
     * @param width largo del rectángulo.
     * @param color color del rectángulo.
     * @param xPos posición del rectángulo en el eje horizontal.
     * @param yPos posición del rectángulo en el eje vertical.
     */
    public Rectangle(int height, int width, String color, int xPos, int yPos){
        this.height = height;
        this.width = width;
        this.color = color;
        xPosition = xPos;
        yPosition = yPos;
        isVisible = false;
    }

    protected void draw() {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,
                new java.awt.Rectangle(xPosition, yPosition, width, height));
            canvas.wait(10);
        }
    }
}

