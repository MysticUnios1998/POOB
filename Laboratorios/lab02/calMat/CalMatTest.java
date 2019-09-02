import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CalMatTest.
 *
 * @author  Eduard Arias, Juan Díaz
 * @version 1.0 (2019-08-31)
 */
public class CalMatTest
{
    private CalMat calculator;
    
    @Test
    public void shouldCreate(){
        try{
            calculator = new CalMat();
            assertTrue(calculator.ok());
        }catch(Exception e){
            fail();
        }
    }
    
    @Test
    public void shouldStack(){
        try{
            calculator = new CalMat();
            int[][] d1 = {{1,2,3}, {4,5,6}, {7,8,9}};
            int[][] d2 = {{0}};
            int[] d3 = {1,2,3,4,5};
            Matriz m1 = new Matriz(d1);
            Matriz m2 = new Matriz(d2);
            Matriz m3 = new Matriz(d3);
            Matriz m4 = new Matriz(3,4,5);
            Matriz m5 = new Matriz(8);
            calculator.empile(d1);
            assertTrue(calculator.ok());
            assertEquals(calculator.consulte(), m1.toString());
            calculator.empile(d2);
            assertTrue(calculator.ok());
            assertEquals(calculator.consulte(), m2.toString());
            calculator.empile(d3);
            assertTrue(calculator.ok());
            assertEquals(calculator.consulte(), m3.toString());
            calculator.empile(3,4,5);
            assertTrue(calculator.ok());
            assertEquals(calculator.consulte(), m4.toString());
            calculator.empile(8);
            assertTrue(calculator.ok());
            assertEquals(calculator.consulte(), m5.toString());
        }catch(Exception e){
            fail();
        }
    }
    
    @Test
    public void shouldNotStack(){
        calculator = new CalMat();
        int[][] d1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] d2 = {1,2,3,4,5,6,7,8,9};
        Matriz m1 = new Matriz(d1);
        Matriz m2 = new Matriz(d2);
        Matriz m3 = new Matriz(1,3,3);
        calculator.empile(d1);
        assertNotEquals(calculator.consulte(), m2.toString());
        assertNotEquals(calculator.consulte(), Matriz.UNCERO.toString());
        assertNotEquals(calculator.consulte(), m3.toString());
        calculator.empile(d2);
        assertNotEquals(calculator.consulte(), m1.toString());
        assertNotEquals(calculator.consulte(), new Matriz(9));
    }
    
    @Test
    public void shouldUnstack(){
        try{
            calculator = new CalMat();
            calculator.empile(new int[][]{{1,2,3}, {4,5,6}});
            calculator.desempile();
            assertTrue(calculator.ok());
            assertEquals(calculator.consulte(), "");
        }catch(Exception e){
            fail();
        }
    }
    
    @Test
    public void shouldNotUnstack(){
        calculator = new CalMat();
        calculator.desempile();
        assertFalse(calculator.ok());
        calculator.empile(new int[][]{{1}, {2}});
        calculator.desempile();
        assertTrue(calculator.ok());
        calculator.desempile();
        assertFalse(calculator.ok());
    }
    
    @Test 
    public void shouldQuery(){
        try{
            calculator = new CalMat();
            int[][] d1 = {{1,2,3}, {4,5,6}, {7,8,9}};
            int[] d2 = {1,2,3,4,5};
            int e = 2,f = 3,c = 4;
            int n = 5;
            Matriz m1 = new Matriz(d1);
            Matriz m2 = new Matriz(d2);
            Matriz m3 = new Matriz(e,f,c);
            Matriz m4 = new Matriz(n);
            calculator.empile(d1);
            assertEquals(calculator.consulte(), m1.toString());
            calculator.empile(d2);
            assertEquals(calculator.consulte(), m2.toString());
            calculator.empile(e,f,c);
            assertEquals(calculator.consulte(), m3.toString());
            calculator.empile(n);
            assertEquals(calculator.consulte(), m4.toString());
        }catch(Exception e){
            fail();
        }
    }
    
    @Test
    public void shouldNotQuery(){
        calculator = new CalMat();
        int[][] d1 = {{1,2,3}, {4,5,6}};
        int[][] d2 = {{9,8,7}, {6,5,4}, {3,2,1}};
        Matriz m1 = new Matriz(d1);
        Matriz m2 = new Matriz(d2);
        assertEquals(calculator.consulte(), "");
        calculator.empile(new int[][]{{1,2,3}, {}});
        assertFalse(calculator.consulte().equals(m1.toString()));
        assertEquals(Matriz.UNCERO.toString(), calculator.consulte());
        calculator.empile(d2);
        assertFalse(calculator.consulte().equals(m1.toString()));
        calculator.desempile();
        assertNotEquals(calculator.consulte(), m2.toString());
    }
}
