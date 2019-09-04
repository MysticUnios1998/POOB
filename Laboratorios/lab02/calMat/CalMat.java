import java.util.*;

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
        lastActionOK = false;
        if (operandos.size() >= 2){
            Matriz m1, m2, result, d1, d2;
            m1 = operandos.pop();
            m2 = operandos.pop();
            d1 = m1.dimension();
            d2 = m2.dimension();
            if (operacion == '*'){
                result = multiplicacionMatricial(m1,m2);
                if (!result.equals(Matriz.UNCERO)) lastActionOK = true;
            }else if(d1.equals(d2)){
                int[][] newMatrix = new int[d1.get(0,0)][d2.get(0,1)];
                int c;
                for (int i=0; i<d1.get(0,0); i++){
                    for (int j=0; j<d2.get(0,1); j++){
                        c = m2.get(i,j);
                        if (operacion == '+') c += m1.get(i,j);
                        else if (operacion == '-') c -= m1.get(i,j);
                        else if (operacion == '.') c *= m1.get(i,j);
                        newMatrix[i][j] = c;
                    }
                }
                result = new Matriz(newMatrix);
                lastActionOK = true;
            }else result = Matriz.UNCERO;
            if (!ok()){
                operandos.push(m2);
                operandos.push(m1);
            }else operandos.push(result);
        }
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
    
    private Matriz multiplicacionMatricial(Matriz m1, Matriz m2){
        lastActionOK = false;
        Matriz result, d1, d2;
        d1 = m1.dimension();
        d2 = m2.dimension();
        System.out.println(d1);
        System.out.println(d2);
        if (d1.get(0,1) != d2.get(0,0)){
            result = Matriz.UNCERO;
        }else{
            int[][] newMatrix = new int[d1.get(0,0)][d2.get(0,1)];
            int c;
            for (int i=0; i<d1.get(0,0); i++){
                for (int j=0; j<d2.get(0,1); j++){
                    c = 0;
                    for (int x=0; x<d1.get(0,1); x++) c += m1.get(i,x)*m2.get(x,j);
                    newMatrix[i][j] = c;
                }
            }
            result = new Matriz(newMatrix);
            lastActionOK = true;
        }
        return result;
    }
}
    



