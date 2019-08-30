
import java.util.Stack;

/**
 * Representa una calculadora de matrices
 * @author ESCUELA 2019-02
 */
    
public class CalMat{

    private Stack<Matriz> operandos;
    //Consultar en el API Java la clase Stack
    
    public CalMat(){
    }

    
    public void empile(int[][] matriz){       
    }
    
    //
    public void empile(int[] diagonal){       
    }
    
    //Todos los elementos son e
    public void empile(int e, int filas, int columnas){       
    }

    //Identidad de dimension d
    public void empile(int d){       
    }
    

    public void desempile(){
    }

    public String consulte(){
        return null;
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
    
    //Indica si se logro realizar la ultima accion
    public boolean ok(){
        return false;
    }
}
    



