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
        height = 30;
        width = 40;
        xPosition = 140;
        yPosition = 15;
        color = "green";
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
