package aplicacion;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReplicateTest {

	private Replicate rep;

	@Test
	public void shouldCreateTheSimulator() {
		try {
			rep = new Replicate(10,10);
			rep = new Replicate(100,200);
			rep = new Replicate(0,0);
			fail("Should have terminated");
		}catch(ReplicateException e) {
			try {
				rep = new Replicate(-1, 0);
				fail("Should have terminated");
			}catch(ReplicateException r) {}
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void shouldChangeSingleCell() {
		try {
			rep = new Replicate(4,4);
			for (int i=0; i<4; i++) {
				if (!rep.llenar(i,i)) fail("Did not change cell:"+i+" "+i );
			}
			assertEquals(
					rep.consulte(),
					new boolean[][] {{true, false, false, false}, {false, true, false, false},
						{false, false, true, false},{false, false, false, true}}
			);
			try {
				rep.llenar(-1, -2);
				fail("Negative coordinates not managed");
			}catch (ReplicateException e2) {}
		}catch (ReplicateException e) {
			fail("Could not change single cell");
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void shouldQueryGameState() {
		boolean[][] game = new boolean[5][5];
		try {
			rep = new Replicate(5,5);
			assertEquals(rep.consulte(), game);
			for (int i=0; i<5; i++) {
				try{
					rep.llenar(i, i);
					game[i][i] = true;
					assertEquals(rep.consulte(), game);
				}catch(ReplicateException e) {
					fail("Could not change game state");
				}
			}
			try{
				rep.llenar(0,2);
				rep.llenar(1,4);
				assertNotEquals(rep.consulte(), game);
				game[0][4] = true;
				assertNotEquals(rep.consulte(), game);
			}catch(ReplicateException e) {
				fail("Could not change game state");
			}
		}catch(ReplicateException e) {
			fail("Cannot create game");
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void shouldReplicate() {
		boolean[][] game = new boolean[5][5];
		try {
			rep = new Replicate(5,5);
			rep.llenar(0, 0);
			game[0][0] = true;
			rep.llenar(2, 0);
			game[2][0] = true;
			assertEquals(rep.consulte(), game);
			if (!rep.replicar()) fail("Game did not change"); 
			game[0][1] = true;
			game[2][1] = true;
			game[3][0] = true;
			game[3][1] = true;
			assertEquals(rep.consulte(), game);
			if (!rep.replicar()) fail("Game did not change");
			game = new boolean[5][5];
			game[0][2] = true;
			game[4][2] = true;
			assertEquals(rep.consulte(), game);
			if (!rep.replicar()) fail("Game should not change");
		}catch(ReplicateException e) {
			fail("Something wrong happend");
		}
	}

}
