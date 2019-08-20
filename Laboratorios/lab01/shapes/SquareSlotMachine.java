import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * Esta clase realizará una simulación de una tragamonedas cuadrada. Podrá jugar
 * en una o todas las filas y avisarle al usuario de errores y mensajes ganadores.
 * Se utilizarán elementos básicos del proyecto shapes.
 *
 * @author (Eduard Arias)
 * @version (2.0, 2019-08-19)
 */
public class SquareSlotMachine{
    
    public static final String[] colors = {"blue","red","yellow","green", "orange", "magenta"};
    
    private ArrayList<ArrayList<Circle>> elements;
    private Rectangle background;
    private int size;
    private int[] juegos;
    
    /**
     * Constructor de la clase SquareSlotMachine
     * @param n tamaño de la máquina. Debe ser un entero entre 2 y 5.
     */
    public SquareSlotMachine(int n){
        size = (2 <= n && n <= 5) ? n: 2;
        if (size != n) JOptionPane.showMessageDialog(null, 
            "El valor será cambiado automáticamente.",
            "Valor incorrecto",
            JOptionPane.INFORMATION_MESSAGE);
        juegos = new int[]{0,0};
        ArrayList<Circle> row;
        elements = new ArrayList<ArrayList<Circle>>();
        background = new Rectangle();
        background.moveHorizontal(-52);
        for (int i=0; i<size; i++){
            row = new ArrayList<Circle>();
            for (int j=0; j<size; j++){
                Circle c = new Circle();
                c.moveHorizontal(30*j);
                c.moveVertical(30*i);
                row.add(c);
            }
            elements.add(row);
        }
        makePretty();
    }
    
    /**
     * Reinicia el estado de la máquina
     */
    public void reset(){
        for (ArrayList<Circle> arr: elements){
            for (Circle c: arr) c.changeColor("white");
        }
        juegos[0] = 0;
        juegos[1] = 0;
    }
    
    /**
     * Realiza una jugada de la máquina.
     */
    public void pull(){
        int randomIndex;
        for (ArrayList<Circle> arr: elements){
            for (Circle c: arr){
                randomIndex = (int)(Math.random()*10) % (size+1);
                c.changeColor(colors[randomIndex]);
            }
        }
        if (isWinningState()){
            JOptionPane.showMessageDialog(null, "¡¡GANASTE!!");
            juegos[0]++;
        }
        juegos[1]++;
    }
    
    /**
     * Realiza una jugada en una fila específica de la máquina.
     * @param row fila en donde se desea jugar. Debe ser un entero mayor a 0.
     */
    public void pull(int row){
        int randomIndex;
        if (1 > row || row > 5) JOptionPane.showMessageDialog(null,
            "El valor ha pasado los límites.",
            "Parámetro incorrecto",
            JOptionPane.ERROR_MESSAGE);
        else{
            for (Circle c: elements.get(row-1)){
                randomIndex = (int)(Math.random()*10) % (size+1);
                c.changeColor(colors[randomIndex]);
            }
            if (isWinningState()){
                JOptionPane.showMessageDialog(null, "¡¡GANASTE!!");
                juegos[0]++;
            }
            juegos[1]++;
        }
    }
    
    /**
     * Verifica si el estado actual de la máquina es ganador por columnas,
     * filas o diagonales (principales).
     * @return si es o no un estado ganador.
     */
    public boolean isWinningState(){
        return checkRows() || checkCols() || checkDiags();
    }
    
    /**
     * Calcula el porcentaje de victorias desde la última vez que se reinició
     * o inició la máquina.
     * @return el porcentaje de victorias.
     */
    public double percentageOfWinning(){
        return juegos[0]*100.0/juegos[1];
    }
    
    /**
     * Juega un numero al azar para trucar el estado ganador. Si llega a haber un error
     * el juego se cierra (Hack Failed).
     * @param guess numero para jugar un pull trucado. Debe ser estar entre 0 y 9.
     */
    public void hackedPull(int guess){
        int randomNumber = (int)(Math.random()*10) % (10);
        if (guess != randomNumber){
            JOptionPane.showMessageDialog(null,
            "Hacked Failed: EXIT_FAILURE status",
            "#$%&/%&(=_=)_",
            JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }else{
            JOptionPane.showMessageDialog(null, "¡¡GANASTE!!");
            reset();
        }
    }
    
    /**
     * Calcula los movimientos mínimos para ganar. El número calculado no será
     * mayor a el tamaño de las filas/columnas de la  máquina.
     * @return la cantidad de movimientos.
     */
    public int minimumMoves(){
        int minimum = size;
        int rowMin = size, colMin = size;
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                rowMin = 0;
                colMin = 0;
                for (int x=0; x<size; x++){
                    if (j!=x && !elements.get(i).get(j).getColor().equals(elements.get(i).get(x).getColor())) colMin++;
                    if (i!=x &&!elements.get(i).get(j).getColor().equals(elements.get(x).get(j).getColor())) rowMin++;
                }
                minimum = Math.min(minimum, Math.min(rowMin, colMin));
            }
        }
        return minimum;
    }
    
    /**
     * Reliza una jugada alterada mínima.
     */
    public void minimumMovesPull(){
        int minimum = size;
        int[] arr = new int[3];
        int rowMin = size, colMin = size;
        int cellMin = size;
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                rowMin = 0;
                colMin = 0;
                for (int x=0; x<size; x++){
                    if (j!=x && !elements.get(i).get(j).getColor().equals(elements.get(i).get(x).getColor())) colMin++;
                    if (i!=x &&!elements.get(i).get(j).getColor().equals(elements.get(x).get(j).getColor())) rowMin++;
                }
                cellMin = Math.min(rowMin, colMin);
                if (cellMin < minimum){
                    minimum = cellMin;
                    arr[0] = i;
                    arr[1] = j;
                    arr[2] = (cellMin == rowMin) ? 1: 0;
                }
            }
        }
        String minColor = elements.get(arr[0]).get(arr[1]).getColor();
        for (int i=0; i<size; i++){
            if (arr[2] == 1) elements.get(i).get(arr[1]).changeColor(minColor);
            else elements.get(arr[0]).get(i).changeColor(minColor);
        }
        JOptionPane.showMessageDialog(null, "¡¡GANASTE!!");
    }
    
    private void makePretty(){
        background.changeColor("black");
        background.changeSize(30*size+1, 30*size+4);
        background.makeVisible();
        for (ArrayList<Circle> arr: elements){
            for (Circle c: arr){
                c.changeColor("white");
                c.makeVisible();
            }
        }
    }
    
    private boolean checkRows(){
        boolean rowWinner = false;
        String rowColor;
        for (int i=0; i<size && !rowWinner; i++){
            rowWinner = true;
            rowColor = elements.get(i).get(0).getColor();
            for (int j=1; j<size && rowWinner; j++){
                if (!rowColor.equals(elements.get(i).get(j).getColor())) rowWinner = false;
            }
        }
        return rowWinner;
    }
    
    private boolean checkCols(){
        boolean colWinner = false;
        String colColor;
        for (int j=0; j<size && !colWinner; j++){
            colWinner = true;
            colColor = elements.get(0).get(j).getColor();
            for (int i=1; i<size && colWinner; i++){
                if (!colColor.equals(elements.get(i).get(j).getColor())) colWinner = false;
            }
        }
        return colWinner;
    }
    
    private boolean checkDiags(){
        boolean d1 = true;
        boolean d2 = true;
        String d1Color = elements.get(0).get(0).getColor();
        String d2Color = elements.get(0).get(size-1).getColor();
        for (int i=1; i<size && (d1 || d2); i++){
            if (d1 && !d1Color.equals(elements.get(i).get(i))) d1 = false;
            if (d2 && !d2Color.equals(elements.get(i).get(size-i-1).getColor())) d2 = false;
        }
        return d1 || d2;
    }
}
