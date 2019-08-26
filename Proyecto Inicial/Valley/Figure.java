
/**
 * Esta clase tiene los aspectos básicos de toda figura en el programa.
 * Contiene los comportamientos para una figura se maneje en el canvas.
 *
 * @author (Eduard Arias)
 * @version 1.1 (2019-08-24)
 */
public abstract class Figure implements Movable{
    
    protected int xPosition;
    protected int yPosition;
    protected String color;
    protected boolean isVisible;
    
    /**
     * Make this figure visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * Make this figure invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    
    /**
     * Move the figure horizontally.
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance){
        erase();
        xPosition += distance;
        draw();
    }
    
    /**
     * Move the figure vertically.
     * @param distance the desired distance in pixels
     */
    public void moveVertical(int distance){
        erase();
        yPosition += distance;
        draw();
    }
    
    /**
     * Slowly move the figure horizontally.
     * @param distance the desired distance in pixels
     */
    public void slowMoveHorizontal(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            xPosition += delta;
            draw();
        }
    }
    
    /**
     * Slowly move the figure vertically.
     * @param distance the desired distance in pixels
     */
    public void slowMoveVertical(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        }else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            yPosition += delta;
            draw();
        }
    }
    
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta", "orange" and "black".
     */
    public void changeColor(String newColor){
        color = newColor;
        draw();
    }
    
    /*
     * Draw the figure with current specifications on screen.
     */
    protected abstract void draw();
    
    /*
     * Erase the rectangle on screen.
     */
    protected void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
