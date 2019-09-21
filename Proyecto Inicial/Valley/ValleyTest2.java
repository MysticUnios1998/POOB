import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ValleyTest2.
 *
 * @author  Eduard Arias, Juan Díaz
 * @version 1.0 (21-09-2019)
 */
public class ValleyTest2{
    private Valley v1,v2;
    
    @Test 
    public void shouldZoom(){
        v1 = new Valley(300,300);
        v1.zoom('+');
        assertTrue(v1.ok());
        v1.makeVisible();
        v1.zoom('+');
        assertTrue(v1.ok());
        v1.zoom('-');
        assertTrue(v1.ok());
        v1.makeInvisible();
        v1.zoom('-');
        assertTrue(v1.ok());
    }
    
    @Test
    public void shouldQueryVineyards(){
        v2 = new Valley(400,400);
        assertEquals(v2.vineyards(), new int[][]{});
        v2.openYard("green", 10, 40);
        assertEquals(v2.vineyards(), new int[][]{{10,40}});
        v2.openYard("blue", 100, 150);
        assertEquals(v2.vineyards(), new int[][]{{10,40}, {100,150}});
        v2.openYard("yellow", 60, 70);
        assertEquals(v2.vineyards(), new int[][]{{10,40}, {100,150}, {60,70}});
        v2.closeYard("blue");
        assertEquals(v2.vineyards(), new int[][]{{10,40}, {60,70}});
    }
    
    @Test
    public void shouldQueryTraps(){
        v1 = new Valley(300,300);
        assertNull(v1.traps());
        v1.addTrap(new int[]{10,10}, new int[]{30,30});
        assertEquals(v1.traps(), new int[][][]{{{10,10}, {30,30}, {-1}}});
        v1.addTrap(new int[]{50, 120}, new int[]{120, 240});
        assertEquals(v1.traps(), new int[][][]{{{10,10}, {30,30}, {-1}}, {{50,120}, {120,240}, {-1}}});
        v1.makePuncture(1, 10);
        assertEquals(v1.traps(), new int[][][]{{{10,10}, {30,30}, {20}}, {{50,120}, {120,240}, {-1}}});
    }
    
    @Test
    public void shouldUndoRedo(){
        v2 = new Valley(400,400);
        v2.openYard("green", 10,10);
        v2.openYard("blue", 100, 130);
        System.out.println(v2.vineyards().length);
        assertEquals(v2.vineyards(), new int[][]{{10,10}, {100,130}});
        v2.doAction('U');
        assertTrue(v2.ok());
        assertEquals(v2.vineyards(), new int[][]{{10,10}});
    }
}
