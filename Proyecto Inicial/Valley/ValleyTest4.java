

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ValleyTest4.
 *
 * @author  Eduard Arias, Juan Diaz
 * @version 1.0(14-10-2019)
 */
public class ValleyTest4{
    
    private Valley v;
    
    @Before
    public void setUp(){
        v = new Valley(400,400);
    }
    
    @Test
    public void shouldManageHardTraps(){
        v.addTrap("hard", new int[]{10,10}, new int[]{40,40});
        assertTrue(v.ok());
        assertEquals(v.traps(), new int[][][]{{{10,10}, {40,40}, {-1}}});
        v.makePuncture(1, 10);
        assertEquals(v.traps(), new int[][][]{{{10,10}, {40,40}, {-1}}});
        v.makePuncture(1, 20);
        assertEquals(v.traps(), new int[][][]{{{10,10}, {40,40}, {-1}}});
        v.patchPuncture(1, 20);
        assertEquals(v.traps(), new int[][][]{{{10,10}, {40,40}, {-1}}});
        v.removeTrap(1);
        assertFalse(v.ok());
        assertEquals(v.traps(), new int[][][]{{{10,10}, {40,40}, {-1}}});
    }
    
    @Test
    public void shouldManageFlexibleTraps(){
        v.addTrap("flexible", new int[]{10,10}, new int[]{40, 40});
        assertTrue(v.ok());
        assertEquals(v.traps(), new int[][][]{{{10,10}, {40,40}, {-1}}});
        v.makePuncture(1, 20);
        assertEquals(v.traps(), new int[][][]{{{10,10}, {40,40}, {17}}});
        v.makePuncture(1, 25);
        assertEquals(v.traps(), new int[][][]{{{10,10}, {40,40}, {21}}});
        v.patchPuncture(1,20);
        assertEquals(v.traps(), new int[][][]{{{10,10}, {40,40}, {-1}}});
    }
    
    @Test
    public void shouldManageRadicalTraps(){
        
    }
    
    @Test
    public void shouldManageGlassTraps(){
        v.addTrap("glass", new int[]{10,10}, new int[]{40,40});
        assertTrue(v.ok());
        assertEquals(v.traps(), new int[][][]{{{10,10}, {40,40}, {-1}}});
        v.makePuncture(1, 25);
        assertEquals(v.traps(), new int[][][]{{{10,10}, {21,20}, {-1}}});
        v.makePuncture(1, 10);
        assertEquals(v.traps(), new int[][][]{{{10,10}, {10, 10}, {-1}}});
        v.makePuncture(1, 1);
        assertEquals(v.traps(), new int[][][]{{{10,10}, {10, 10}, {-1}}});
    }
}
