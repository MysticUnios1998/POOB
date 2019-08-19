

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Prueba las funcionalidades de la clase slotMachine. Suspruebas estan
 * basadas en la división por ciclos propuesta en el laboratorio.
 *
 * @author  (Eduard Arias)
 * @version (1.0, 2019-08-18)
 */
public class slotMachineTest
{
    private SlotMachine sm;
    /**
     * Default constructor for test class slotMachineTest
     */
    public slotMachineTest(){
        sm = new SlotMachine(3);
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        sm.reset();
    }
    
    @Test
    public void shouldPlayOK(){
        try{
            sm.pull();
            sm.pull(8);
            sm.pull();
        }catch(Exception e){
            fail("Something wrong happened");
        }
    }
    
    @Test
    public void shouldShowPercentageOK(){
        sm.pull();
        if (sm.isWinningState()){
            assert(sm.percentageOfWinningStates() == 100);
            assert(sm.isWinningState());
        }
        else assert(sm.percentageOfWinningStates() == 0);
        sm.reset();
        try{
            sm.percentageOfWinningStates();
            fail();
        }catch(ArithmeticException ae){
            
        }catch(Exception e){
            fail();
        }
    }
}
