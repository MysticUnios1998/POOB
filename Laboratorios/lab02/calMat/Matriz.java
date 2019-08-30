import java.util.*;
/**
 * @author ECI, 2019
 * @author Eduard Arias, Juan Díaz
 * @version 2.0 (209-08-30)
 *
 */
public class Matriz{

    public static final Matriz UNCERO= new Matriz(new int[][]{{0}});
    private ArrayList<ArrayList<Integer>> matriz;
    
    /**
     * Constructor de la matriz dados sus elementos. Si hay error en datos, retorna la matriz [0]
     * @param elementos arrayMatrix con los números de la matriz.
     */
    public Matriz (int[][] elementos){
        boolean bienEstructurado = true;
        for (int i=0; i<elementos.length-1 && bienEstructurado; i++){
            if (elementos[i].length != elementos[i+1].length) bienEstructurado = false;
        }
        if(elementos.length <= 0 || !bienEstructurado) elementos = new int[][]{{0}};
        matriz = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> fila;
        for (int i=0; i<elementos.length; i++){
            fila = new ArrayList<Integer>();
            for (int j=0; j<elementos[0].length; j++) fila.add(elementos[i][j]);
            matriz.add(fila);
        }
    }
    
     /**
     * Constructor de la matriz diagonal. Si hay error en datos, retorna la matriz [0]
     * @param d array con los elementos de la diagonal.
     */    
    public Matriz (int[] d){
        matriz = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> fila;        
        if(d.length <= 0) d = new int[]{0};
        int x = d.length;
        for (int i=0; i<x; i++){
                fila = new ArrayList<Integer>();
                for (int j=0; j<x; j++) fila.add((i==j) ? d[i] : 0);
                matriz.add(fila);
        }                        
    }    

    /**
     * Constructor de la matriz con un numero repetido dada su dimension. Si hay error en datos, retorna la matriz [0]
     * @param e elemento de la matriz.
     * @param f cantidad de filas. Debe ser mayor a 0.
     * @param c cantidad de columnas. Debe ser mayor a 0.
     */
    public Matriz (int e, int f, int c) {
        matriz = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> fila;
        if(f <= 0 || c <= 0){
            fila = new ArrayList<Integer>();
            fila.add(0);
            matriz.add(fila);
        }else{
            for (int i=0; i<f; i++){
                fila = new ArrayList<Integer>();
                for (int j=0; j<c; j++) fila.add(e);
                matriz.add(fila);
            }
        }
    }
    
    /**
     * Constructor de la matriz identidad dada su dimension. Si hay error en datos, retorna la matriz [0]
     * @param n dimensión de la matriz. Debe ser entero no negativo.
     */
    public Matriz (int n){
        matriz = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> fila;        
        if(n <= 0){
            fila = new ArrayList<Integer>();
            fila.add(0);
            matriz.add(fila);
        }else{        
            for (int i=0; i<n; i++){
                fila = new ArrayList<Integer>();
                for (int j=0; j<n; j++) fila.add((i==j) ? 1 : 0);
                matriz.add(fila);
            }
        }        
    }
    
    /**
     * Retorna las dimensiones de la matriz en forma de matriz para garantizar
     * la propiedad de cerradura.
     * @return matriz de 1x2 con el numero de filas y columnas de la matriz.
     */
    public Matriz dimension(){
        return new Matriz(new int[][]{{matriz.size(), matriz.get(0).size()}});
    }
    
    /**
     * Devuelve un elemento de la matriz. Solo se opera si los numeros están dentro de
     * los parámetros de la matriz.
     * @param f fila objetivo.
     * @param c columna objetivo.
     * return elemento de la celda [f,c] de la matriz.
     */
    public int get(int f, int c){
        return matriz.get(f).get(c);
    }
    
    /**
     * Compara esta matriz con otra matriz.
     * @param otra matriz contrala que se hace la comparación
     * @return si son iguales o no.
     */
    public boolean equals (Matriz otra){
        Matriz d1 = dimension();
        Matriz d2 = otra.dimension();
        boolean eq = d1.get(0,0)==d2.get(0,0) && d1.get(0,1)==d2.get(0,1);
        if(eq){
            for(int i=0; i<matriz.size() && eq; i++){
                for(int j=0; j<matriz.get(0).size() && eq; j++){
                    if(get(i,j)!=otra.get(i,j))eq=false;
                }
            }
        }
        return eq;
    }

    /** 
     * Compara esta matriz con otro objeto. El objeto debe ser casteable a un tipo matriz.
     * @param otra objeto contra el que se hace la comparación.
     * @return si son iguales o no.
     */
    @Override
    public boolean equals(Object otra) {
        return equals((Matriz)otra);
    }
    
    
    /** 
     * Retorna una cadena con los datos de la matriz alineado por columna
     * @return una cadena con los elementos de la matriz en el formato especificado.
     */
    @Override
    public String toString () {
          String s = "";
          return s;
    }   
    
    //Retorna la matriz con el numero de filas o columnas
    public Matriz sume(Matriz m){
        return null;
    }
    
    //Retorna una matriz de un elemento
    public Matriz sume(){
           return null;
    }    

    //foc: indica si la suma es por filas('f') o por columnas('c')
    public Matriz sume(char foc){
        return null;
    }
    

    

    
 
}
