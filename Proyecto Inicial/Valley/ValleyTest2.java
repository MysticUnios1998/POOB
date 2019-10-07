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
        assertEquals(v1.traps(), new int[][][]{});
        v1.addTrap(new int[]{10,10}, new int[]{30,30});
        assertEquals(v1.traps(), new int[][][]{{{10,10}, {30,30}, {-1}}});
        v1.addTrap(new int[]{50, 120}, new int[]{120, 240});
        assertEquals(v1.traps(), new int[][][]{{{10,10}, {30,30}, {-1}}, {{50,120}, {120,240}, {-1}}});
        v1.makePuncture(1, 10);
        assertEquals(v1.traps(), new int[][][]{{{10,10}, {30,30}, {10}}, {{50,120}, {120,240}, {-1}}});
        v1.addTrap(new int[]{30,0}, new int[]{0, 40});
        assertEquals(v1.traps(), new int[][][]{{{10,10}, {30,30}, {10}}, {{50,120}, {120,240}, {-1}}});
        v1.addTrap(new int[]{30,1}, new int[]{100, 1});
        v1.makePuncture(3, 50);
        assertEquals(v1.traps(), new int[][][]{{{10,10}, {30,30}, {10}}, {{50,120}, {120,240}, {-1}}, {{30, 1}, {100, 1}, {73}}});
    }
    
    @Test
    public void shouldQueryRains(){
        v1 = new Valley(400,400);
        assertEquals(v1.rains(), new int[][][]{});
        v1.startRain(15);
        assertEquals(v1.rains(), new int[][][]{{{15, 1}, {15, 401}}});
        v1.startRain(150);
        assertEquals(v1.rains(), new int[][][]{{{15, 1}, {15, 401}}, {{150, 1}, {150, 401}}});
        v1.startRain(149);
        assertEquals(v1.rains(), new int[][][]{{{15, 1}, {15, 401}}, {{150, 1}, {150, 401}}, {{149, 1}, {149, 401}}});
        v1.addTrap(new int[]{10,10}, new int[]{30,30});
        assertEquals(v1.rains(), new int[][][]{{{15, 1}, {15, 9}, {36, 32}, {36, 401}}, {{150, 1}, {150, 401}}, {{149, 1}, {149, 401}}});
        v1.startRain(100);
        v1.addTrap(new int[]{80, 20}, new int[]{120, 20});
        assertEquals(v1.rains(), new int[][][]{{{15, 1}, {15, 9}, {36, 32}, {36, 401}}, {{150, 1}, {150, 401}}, 
            {{149, 1}, {149, 401}}, {{100,1}, {100, 13}, {72, 22}, {72, 401}}});
        v1.makePuncture(2, 20);
        assertEquals(v1.rains(), new int[][][]{{{15, 1}, {15, 9}, {36, 32}, {36, 401}}, {{150, 1}, {150, 401}}, 
            {{149, 1}, {149, 401}}, {{100,1}, {100, 13}, {99, 15}, {99, 401}}});
    }
    
    @Test
    public void shouldUndoRedo(){
        v1 = new Valley(400,400);
        v1.addTrap(new int[]{10,10}, new int[]{50,50});
        v1.addTrap(new int[]{20,10}, new int[]{150,50});
        v1.doAction('U');
        assertTrue(v1.ok());
        assertEquals(v1.traps(), new int[][][]{{{10,10}, {50,50}, {-1}}});
        v1.doAction('R');
        assertTrue(v1.ok());
        assertEquals(v1.traps(), new int[][][]{{{10,10}, {50,50}, {-1}}, {{20,10}, {150,50}, {-1}}});
        v1.makePuncture(1, 20);
        v1.makePuncture(1, 10);
        v1.doAction('U');
        assertTrue(v1.ok());
        v1.doAction('U');
        assertTrue(v1.ok());
        assertEquals(v1.traps(), new int[][][]{{{10,10}, {50,50}, {-1}}, {{20,10}, {150,50}, {-1}}});
    }
}
