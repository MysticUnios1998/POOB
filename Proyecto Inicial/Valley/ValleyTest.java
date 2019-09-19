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
    
    @Test
    public void shouldAddTrap(){
        try{
            v2 = new Valley(300, 300);
            v2.addTrap(new int[]{20,20}, new int[]{100, 100});
            assertTrue(v2.ok());
            v2.addTrap(new int[]{21,20}, new int[]{150, 101});
            assertTrue(v2.ok());
            v2.addTrap(new int[]{100, 20}, new int[]{100, 20});
            assertTrue(v2.ok());
        }catch(Exception e){
            fail();
        }
    }
    
    @Test
    public void shouldNotAddTrap(){
        v2 = new Valley(300, 300);
        v3 = new Valley(300, 300);
        v2.addTrap(new int[]{1,1}, new int[]{300,300});
        assertTrue(v2.ok());
        v2.addTrap(new int[]{20,20}, new int[]{250, 100});
        assertFalse(v2.ok());
        v2.addTrap(new int[]{1, 1}, new int[]{100, 101});
        assertFalse(v2.ok());
        v2.addTrap(new int[]{1, 300}, new int[]{300, 1});
        assertFalse(v2.ok());
        v2.addTrap(new int[]{21,20}, new int[]{101, 100});
        assertTrue(v2.ok());
        v2.addTrap(new int[]{22,20}, new int[]{101, 100});
        assertFalse(v2.ok());
    }
    
    @Test
    public void shouldRemoveTrap(){
        try{
            v1 = new Valley(300, 300);
            v1.addTrap(new int[]{1,1}, new int[]{300,300});
            v1.removeTrap(1);
            assertTrue(v1.ok());
            v1.addTrap(new int[]{1,1}, new int[]{300,300});
            assertTrue(v1.ok());
            v1.addTrap(new int[]{22,20}, new int[]{101, 100});
            v1.removeTrap(2);
            assertTrue(v1.ok());
        }catch(Exception e){
            fail();
        }
    }
    
    @Test
    public void shouldNotRemoveTrap(){
        v1 = new Valley(300, 300);
        v1.removeTrap(1);
        assertFalse(v1.ok());
        v1.addTrap(new int[]{1,1}, new int[]{9,9});
        v1.addTrap(new int[]{10,1}, new int[]{9,90});
        v1.removeTrap(10);
        assertFalse(v1.ok());
        v1.removeTrap(1);
        assertTrue(v1.ok());
        v1.removeTrap(2);
        assertFalse(v1.ok());
    }
    
    @Test
    public void shouldMakePuncture(){
        try{
            v1 = new Valley(400, 400);
            v1.addTrap(new int[]{10,10}, new int[]{100, 100});
            v1.addTrap(new int[]{1,1}, new int[]{200, 1});
            assertTrue(v1.ok());
            v1.makePuncture(1, 40);
            assertTrue(v1.ok());
            v1.makePuncture(1, 80);
            assertTrue(v1.ok());
            v1.makePuncture(2, 20);
            assertTrue(v1.ok());
            v1.makePuncture(2, 40);
            assertTrue(v1.ok());
            v1.makePuncture(1, 1);
            assertTrue(v1.ok());
            v1.makePuncture(2, 199);
            assertTrue(v1.ok());
        }catch(Exception e){
            fail();
        }
    }
    
    @Test
    public void shouldPatchPuncture(){
        try{
            v4 = new Valley(300,300);
            v4.addTrap(new int[]{1,1}, new int[]{1,200});
            v4.addTrap(new int[]{30,30}, new int[]{70,70});
            assertTrue(v4.ok());
            v4.makePuncture(1, 30);
            v4.makePuncture(1, 100);
            v4.makePuncture(1, 150);
            v4.makePuncture(2, 30);
            v4.makePuncture(2, 34);
            assertTrue(v4.ok());
            v4.patchPuncture(1, 32);
            assertTrue(v4.ok());
            v4.patchPuncture(2, 32);
            assertTrue(v4.ok());
        }catch(Exception e){
            fail();
        }
    }
    
    @Test
    public void shouldNotPatchPunture(){
        v4 = new Valley(300,300);
        v4.addTrap(new int[]{1,1}, new int[]{200,200});
        v4.addTrap(new int[]{30,30}, new int[]{70,70});
        v4.patchPuncture(4, 30);
        assertFalse(v4.ok());
        v4.patchPuncture(3, 50);
        assertFalse(v4.ok());
        v4.makePuncture(1, 30);
        v4.makePuncture(1, 100);
        v4.patchPuncture(1, 30);
        assertTrue(v4.ok());
    }
    
    @Test
    public void shouldRain(){
        v1 = new Valley(400, 400);
        v1.startRain(100);
        assertTrue(v1.ok());
        v1.startRain(200);
        assertTrue(v1.ok());
        for (int i=0; i<10; i++){
            v1.startRain(100+i*2);
            assertTrue(v1.ok());
        }
    }
    @Test
    public void shouldNotRain(){
        v2 = new Valley(10,10);
        v2.startRain(0);
        assertFalse(v2.ok());
        v2.startRain(100);
        assertFalse(v2.ok());
        v2.startRain(-1100);
        assertFalse(v2.ok());
    }
    
    @Test
    public void shouldStopRain(){
        v1 = new Valley(300,300);
        v1.startRain(20);
        v1.stopRain(20);
        assertTrue(v1.ok());
        v1.startRain(12);
        v1.stopRain(10);
        assertTrue(v1.ok());
        v1.startRain(100);
        v1.stopRain(102);
        assertTrue(v1.ok());
    }
    @Test
    public void shouldNotStopRain(){
        v3 = new Valley(300, 300);
        v3.stopRain(30);
        assertFalse(v3.ok());
        v3.stopRain(0);
        assertFalse(v3.ok());
        v3.startRain(100);
        v3.stopRain(50);
        assertFalse(v3.ok());
        v3.stopRain(105);
        assertFalse(v3.ok());
    }
    
    @Test
    public void shouldRainFalls(){
        v1 = new Valley(200,200);
        v1.openYard("blue", 100, 120);
        v1.openYard("green", 1, 50);
        v1.startRain(40);
        assertEquals(v1.rainFalls(), new String[]{"green"});
        v1.startRain(110);
        assertEquals(v1.rainFalls(), new String[]{"green", "blue"});
        v1.addTrap(new int[]{30, 30}, new int[]{70, 100});
        assertEquals(v1.rainFalls(), new String[]{"blue"});
        v1.startRain(30);
        assertEquals(v1.rainFalls(), new String[]{"blue"});
        v1.removeTrap(1);
        assertEquals(v1.rainFalls(), new String[]{"green", "blue"});
    }
}
