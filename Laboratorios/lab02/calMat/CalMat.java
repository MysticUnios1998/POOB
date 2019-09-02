import java.util.Stack;

/**
 * Representa una calculadora de matrices
 * @author ESCUELA 2019-02, Eduard Arias, Juan Díaz
 */
    
public class CalMat{

    private Stack<Matriz> operandos;
    private boolean lastActionOK;
    
    /**
     * Contructor principal de la clase CalMat
     */
    public CalMat(){
        operandos = new Stack<Matriz>();
        lastActionOK = true;
    }

    /**
     * Coloca una nueva matriz, definida por elementos, en la cima de la pila de operandos.
     * @param matriz arrayMatrix con la configuracion de la matriz.
     */
    public void empile(int[][] matriz){ 
        operandos.push(new Matriz(matriz));
        lastActionOK = true;
    }
    
    /**
     * Coloca una nueva matriz, definida por su diagonal, en la cima de la pila de operandos.
     * @param diagonal array con la configuración de los elementos de la diagonal.
     */
    public void empile(int[] diagonal){
        operandos.push(new Matriz(diagonal));
        lastActionOK = true;
    }
    
    /**
     * Coloca una nueva matriz, definida por un único elemento de la matriz
     * en la cima de la pila de operandos.
     * @param e elemento único que va en la matriz.
     * @param filas numero de filas de la matriz.
     * @param columnas numero de columnas de la matriz.
     */
    public void empile(int e, int filas, int columnas){ 
        operandos.push(new Matriz(e,filas,columnas));
        lastActionOK = true;
    }

    /**
     * Coloca la matriz identidad de tamaño definido.
     * @param d dimensión de la matriz.
     */
    public void empile(int d){
        operandos.push(new Matriz(d));
    }
    
    /**
     * Remueve el elemento de la cima de la pial de operandos. Si no hay
     * elementos, no realiza acción.
     */
    public void desempile(){
        lastActionOK = false;
        if (!operandos.empty()){
            operandos.pop();
            lastActionOK = true;
        }
    }

    /**
     * Retorna la configuración de la última matriz de la pila de
     * operandos en forma de cadena.
     * @return la cadena con la información de la matriz.
     */
    public String consulte(){
        return (!operandos.empty()) ? operandos.peek().toString(): "";
    }
    

    // Los operadores binarios : + (suma), - (resta), . (multiplique elemento a elemento), * (multiplique matricial)
    public void opereMatrices(char operacion){
    }
    
    //Los operadores son: + (suma),  - (promedio), m (minimo), M (maximo), d(dimensones)
    //Los operadores consideran todos los elementos de la matriz
    public void opereMatriz(char operacion){
    }
    
    
    //Los operadores son: + (suma),  - (promedio), m (minimo), M (maximo)
    //Las operaciones se realizan por filas    
    public void opereFilas(char operacion){
    }
    
    //Los operadores son: + (suma),  - (promedio), m (minimo), M (maximo)
    //Las operaciones se realizan por columnas
    public void opereColumnas(char operacion){
    }    
    
    /**
     * Indica si se logro realizar la ultima acción
     * @return si la ultima accion fue exitosa o no.
     */
    public boolean ok(){
        return lastActionOK;
    }
}
    



