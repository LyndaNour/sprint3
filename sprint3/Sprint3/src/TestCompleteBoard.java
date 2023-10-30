import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCompleteBoard {

	private Board game;
	
	@Before
	public void setUp() throws Exception {
		game = new Board();
	}

	@After
	public void tearDown() throws Exception {
	}

	// acceptance criterion 4.1
	@Test
	public void testBlueWon() {
		game.makeMove(0, 0);
		game.makeMove(1, 1);		
		game.makeMove(2, 2);
		assertEquals("", game.getGameState(), Board.GameState.BLUE_WON); 
	}

	// acceptance criterion 4.3
	@Test
	public void testRedWon() {
		game.makeMove(1, 0);		
		game.makeMove(1, 1);
		game.makeMove(1, 2);		
	
		assertEquals("", game.getGameState(), Board.GameState.RED_WON); 
	
	}

	// acceptance criterion 4.5
	@Test
	public void testDraw() {
		game.makeMove(0, 1);		
		game.makeMove(0, 0);
		game.makeMove(0, 2);		
		game.makeMove(1, 2);
		game.makeMove(1, 0);		
		game.makeMove(1, 1);
		game.makeMove(2, 2);		
		game.makeMove(2, 0);
		game.makeMove(2, 1);
		assertEquals("", game.getGameState(), Board.GameState.DRAW); 
		new Board(); 

	
	}
	


}
