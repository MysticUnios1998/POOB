import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author   ECI, Eduard Arias, Juan Díaz
 * @version 2.0 (2019-09-04)
 */
public class MatrizTest{
    
    @Test    
    public void deberiaPasar(){
        assertTrue(1==1);
    }
    
    @Test
    public void deberiaFallar(){
        fail();   
    }

    @Test    
    public void deberiaErrar(){
        int a = 1/0;
    }

    
    @Test
    public void deberiaCrearMatricesDadosLosElementos(){
        int [][] dA={{1,2,3},{4,5,6},{7,8,9}};
        int [][] dB={{1,2,3},{4,5,6},{7,8,9}};        
        Matriz A=new Matriz(dA);
        Matriz B=new Matriz(dB);
        assertEquals(A,B);
    }
    
    
    @Test
    public void deberiaProtegerLosDatos(){
        int [][] dA={{1,2,3},{4,5,6},{7,8,9}};
        int [][] dB={{1,2,3},{4,5,6},{7,8,9}};        
        Matriz A=new Matriz(dA);
        Matriz B=new Matriz(dB);
        dA[0][0]=-1;
        assertEquals(A,B);
    }


    @Test
    public void deberiaCrearMatricesDadoValor(){
        int [][] dA={{0,0,0},{0,0,0},{0,0,0}};
        Matriz A=new Matriz(dA);
        Matriz B=new Matriz(0,3,3);
        assertEquals(A,B);
    }
    
    @Test
    public void deberiaCrearMatricesDiagonales(){
        int [] d={1,2,3,4};
        int [][] dD={{1,0,0,0},{0,2,0,0},{0,0,3,0},{0,0,0,4}};
        Matriz A=new Matriz(d);
        Matriz B=new Matriz(dD);
        assertEquals(A,B);
    }    
    
    
    @Test
    public void deberiaCrearMatricesIdentidad(){
        int [][] dI={{1,0,0},{0,1,0},{0,0,1}};     
        Matriz A=new Matriz(3);
        Matriz I=new Matriz(dI);
        assertEquals(A,I);
    }
    
    @Test
    public void noDeberiaCrearMatricesInValidas(){
        
        int [][] dA={{1,2,3},{4,5},{7,8,9}};
        int [][] dB={{1,2,3},{4,5,6},{7,8,9,7}};
        assertEquals(new Matriz(dA),Matriz.UNCERO);
        assertEquals(new Matriz(dB),Matriz.UNCERO);
        
        int [] d={};
        assertEquals(new Matriz(d),Matriz.UNCERO);


        assertEquals(new Matriz(10,-1,2),Matriz.UNCERO);
        assertEquals(new Matriz(10,1,-2),Matriz.UNCERO);  
        
        assertEquals(new Matriz(0),Matriz.UNCERO);
        assertEquals(new Matriz(-1),Matriz.UNCERO);       

    }   
    
    @Test
    public void shouldQuery(){
        Matriz m;
        int[][] d1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] d2 = {1,2,3,4};
        m = new Matriz(d1);
        assertEquals(m.toString(), "1 2 3 \n4 5 6 \n7 8 9 \n");
        m = new Matriz(d2);
        assertEquals(m.toString(), "1 0 0 0 \n0 2 0 0 \n0 0 3 0 \n0 0 0 4 \n");
        m = new Matriz(3, 3, 4);
        assertEquals(m.toString(), "3 3 3 3 \n3 3 3 3 \n3 3 3 3 \n");
        m = new Matriz(4);
        assertEquals(m.toString(), "1 0 0 0 \n0 1 0 0 \n0 0 1 0 \n0 0 0 1 \n");
    }
    
    @Test
    public void shouldSum(){
        Matriz m1,m2,m3;
        Matriz r1, r2, r3;
        int[][] d1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] d2 = {1,2,3,4,5,6,7,8,9};
        int[] d3 = {-1,2-3,4,-5,6,-7,8,-9};
        m1 = new Matriz(d1);
        m2 = new Matriz(d2);
        m3 = new Matriz(d3);
        r1 = m1.sume();
        r2 = m2.sume();
        r3 = m3.sume();
        assertEquals(r1.toString(), "45 \n");
        assertEquals(r2.toString(), "45 \n");
        assertEquals(r1.toString(), r2.toString());
        assertTrue(r3.get(0,0) == -5);
    }
    
    @Test
    public void shouldCalculateAverage(){
        Matriz m1,m2,m3;
        Matriz r1, r2, r3;
        int[][] d1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] d2 = {1,2,3,4,5,6,7,8,9};
        int[] d3 = {-1,2-3,4,-5,6,-7,8,-9};
        m1 = new Matriz(d1);
        m2 = new Matriz(d2);
        m3 = new Matriz(d3);
        r1 = m1.promedio();
        r2 = m2.promedio();
        r3 = m3.promedio();
        assertEquals(r1.toString(), "5 \n");
        assertEquals(r2.toString(), "0 \n");
        assertEquals(r3.toString(), "0 \n");
    }
    
    @Test
    public void shouldCalculateMaximum(){
        Matriz m1,m2,m3;
        Matriz r1, r2, r3;
        int[][] d1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] d2 = {1,2,3,4,5,6,7,8,9};
        int[] d3 = {-1,2-3,4,-5,6,-7,8,-9};
        m1 = new Matriz(d1);
        m2 = new Matriz(d2);
        m3 = new Matriz(d3);
        r1 = m1.maximo();
        r2 = m2.maximo();
        r3 = m3.maximo();
        assertEquals(r1.toString(), "9 \n");
        assertEquals(r2.toString(), "9 \n");
        assertTrue(r1.get(0,0) == r2.get(0,0));
        assertEquals(r3.toString(), "8 \n");
    }
    
    @Test
    public void shouldCalculateMinimum(){
        Matriz m1,m2,m3;
        Matriz r1, r2, r3;
        int[][] d1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] d2 = {1,2,3,4,5,6,7,8,9};
        int[] d3 = {-1,2-3,4,-5,6,-7,8,-9};
        m1 = new Matriz(d1);
        m2 = new Matriz(d2);
        m3 = new Matriz(d3);
        r1 = m1.minimo();
        r2 = m2.minimo();
        r3 = m3.minimo();
        assertEquals(r1.toString(), "1 \n");
        assertEquals(r2.toString(), "0 \n");
        assertEquals(r3.toString(), "-9 \n");
    }
}
