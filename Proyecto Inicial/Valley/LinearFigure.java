
/**
 * Esta clase manejará los estados y comportamientos de las dos figuras 
 * "lineales" del proyecto shapes. Simplifica el código y permitirá extenderr
 * los comportamientos de estas dos subclases.
 *
 * @author (Eduard Arias)
 * @version 1.0 (2019-08-24)
 */
public abstract class LinearFigure extends Figure{
    
    protected int height;
    protected int width;
    
    /**
     * Change the size to the new size
     * @param newHeight the new height in pixels. newHeight must be >=0.
     * @param newWidht the new width in pixels. newWidth must be >=0.
     */
    public void changeSize(int newHeight, int newWidth) {
        erase();
        height = newHeight;
        width = newWidth;
        draw();
    }
}
