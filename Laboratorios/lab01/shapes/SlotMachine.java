import java.util.ArrayList;

/**
 * Esta clase realizará la simulación de una maquina tragamonedas.
 * Utilizará elementos básicos de las figuras y permitirá al usuario conocer
 * el estado ganador de su juego y realizar varios juegos al mismo tiempo.
 *
 * @author (Eduard Arias)
 * @version (1.0, 2019-08-18)
 */
public class SlotMachine{
    
    public static final String[] colors = {"blue","red","yellow","green", "orange", "magenta"};
    
    private Rectangle background;
    private ArrayList<Circle> elements;
    private int size;
    private int[] juegos;
    
    /**
     * Constructor de la clase SlotMachine.
     * @param n la dimensión del tragamonedas. Debe ser un entero entre 2
     * y 5.
     */
    public SlotMachine(int n){
        size = (!(2<=n && n<=5)) ? 2: n;
        juegos = new int[]{0,0};
        background = new Rectangle();
        background.moveHorizontal(-52);
        background.changeSize(32, n*30+4);
        background.changeColor("dark");
        elements = new ArrayList<Circle>(n);
        for (int i=0; i<n; i++){
            Circle x = new Circle();
            x.changeColor("white");
            x.moveHorizontal(30*i);
            elements.add(x);
        }
        makeVisible();
    }
    
    /**
     * Resetea el estado del tragamonedas.
     */
    public void reset(){
        for  (Circle c: elements) c.changeColor("white");
        juegos[0] = 0;
        juegos[1] = 0;
    }
    
    /**
     * Realiza una jugada de la máquina.
     */
    public void pull(){
        int randomIndex;
        for (Circle c: elements){
            randomIndex = (int)(Math.random()*10) % (size+1);
            c.changeColor(colors[randomIndex]);
        }
        if (isWinningState()) juegos[0]++;
        juegos[1]++;
    }
    
    /**
     * Realiza varias jugadas de la máquina.
     * @param times cantidad de jugadas que se van a hacer. Debe ser un entero
     * mayor a 0.
     */
    public void pull(int times){
        if (times<=0) times = 1;
        for (int i=0; i<times; i++){
            pull();
            Canvas.getCanvas().wait(1000);
        } 
    }
    
    /**
     * Verifica si el estado actual de la máquina es ganador.
     * @return true si el estado es ganador, false en caso contrario.
     */
    public boolean isWinningState(){
        String winner = elements.get(0).getColor();
        boolean hasWon = true;
        for (int i=1; i<size && hasWon; i++){
            if (!elements.get(i).getColor().equals(winner)) hasWon = false;
        }
        return hasWon;
    }
    
    /**
     * Calcula el porcentaje de victorias
     * @return la parte entera del resultado de victorias contra juegos totales
     */
    public int percentageOfWinningStates(){
        return (int)(juegos[0]*100/juegos[1]);
    }
    
    /**
     * Vuelve visible al tragamonedas
     */
    public void makeVisible(){
        background.makeVisible();
        for (Circle c: elements) c.makeVisible();
    }
    
    /**
     * Vuelve invisible al tragamonedas
     */
    public void makeInvisible(){
        background.makeInvisible();
        for (Circle c: elements) c.makeInvisible();
    }
    
    /**
     * Mueve al tragamonedas a unas nuevas coordenadas
     * @param horizontal distancia a mover horizontalmente
     * @param vertical distancia a mover verticalmente
     */
    public void move(int horizontal, int vertical){
        makeInvisible();
        background.moveHorizontal(horizontal);
        background.moveVertical(vertical);
        for (Circle c: elements){
            c.moveHorizontal(horizontal);
            c.moveVertical(vertical);
        }
        makeVisible();
    }
}
