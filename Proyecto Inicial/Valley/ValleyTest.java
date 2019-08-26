import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

/**
 * The test class ValleyTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
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
}
