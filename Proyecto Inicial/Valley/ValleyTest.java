import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

/**
 * The test class ValleyTest.
 *
 * @author  Eduard Arias
 * @version 1.2 (2019-08-25)
 */
public class ValleyTest{
    
    private Valley v1,v2,v3,v4;
    private Random randomGenerator;
    private final int xSize, ySize;
    
    public ValleyTest(){
        xSize = 1000;
        ySize = 1000;
    }
    
    @Before
    public void setUp(){
        randomGenerator = new Random();
    }
    
    @Test
    public void shouldCreate(){
        try{
            v1 = new Valley(randomGenerator.nextInt(xSize), randomGenerator.nextInt(ySize));
            v2 = new Valley(100, 100);
            assertTrue(v2.ok());
            v2 = new Valley(0, 100);
            v3 = new Valley(randomGenerator.nextInt(xSize), randomGenerator.nextInt(ySize));
            assertTrue(v1.ok());
            assertTrue(v2.ok());
            assertTrue(v3.ok());
        }catch(Exception e){
            fail();
        }
        
    }
    
    @Test
    public void shouldNotCreate(){
        try{
            v1 = new Valley(-100, 0);
            v2 = new Valley(0, -200);
            v3 = new Valley(-10, -30);
            fail();
        }catch(Exception e){
            //normal behavior
        }
    }
    
    @Test
    public void shouldOpenVineyard(){
        try{
            v1 = new Valley(200, 200);
            v1.openYard("green", 20, 30);
            assertTrue(v1.ok());
            v1.openYard("blue", 89, 90);
            assertTrue(v1.ok());
        }catch(Exception e){
            fail();
        }
    }
    
    @Test
    public void shouldNotOpenVineyard(){
        try{
            v1 = new Valley(200, 200);
            v1.openYard("green", 20, 30);
            v1.openYard("green", 50, 60);
            assertFalse(v1.ok());
            v1.openYard("yellow", 25, 55);
            assertFalse(v1.ok());
            v1.openYard("blue", 124895, 123454);
            assertFalse(v1.ok());
            v2 = new Valley(0, 0);
            v2.openYard("yellow", 30, -90);
            assertFalse(v2.ok());
            v2.openYard("yellow", -20, 0);
            assertFalse(v2.ok()); 
        }catch(Exception e){}
    }
    
    @Test
    public void shouldCloseVineyard(){
        try{
            v1 = new Valley(200, 200);
            v2 = v1;
            v1.openYard("green", 20, 50);
            v1.openYard("blue", 60, 120);
            assertTrue(v1.ok());
            v1.closeYard("blue");
            assertTrue(v1.ok());
            v1.openYard("blue", 150, 160);
            assertEquals(v1.ok(), v2.ok());
            v2.openYard("red", 100, 101);
            assertTrue(v2.ok());
        }catch(Exception e){
            fail();
        }
    }
    
    @Test
    public void shouldNotCloseVineyard(){
        v3 = new Valley(200, 200);
        v3.closeYard("green");
        assertFalse(v3.ok());
        v3.openYard("blue", 20, 30);
        v3.closeYard("blue");
        assertTrue(v3.ok());
        v3.closeYard("blue");
        assertFalse(v3.ok());
    }
}
