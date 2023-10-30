import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Board.Cell;
import junit.framework.TestCase;

public class RedPlayerTest extends TestCase{
	private Board board;
	
	@Before
	public void setUp() throws Exception{
		board = new Board();
		board.makeMove(1, 1);// s move then o move	
	}
	
	
	// AC 4.5
	@Test
	public void testRedplayerTurnVacantCell() {
		board.makeMove(0, 0); // o player move
		assertEquals("", board.getCell(0, 0),Board.Cell.O_PLACEMENT);
		assertEquals("", board.changeTurn(),"Blue player");
	}
	
	// acceptance criterion 4.6
		@Test
		public void testRedplayerTurnMoveNonVacantCell() {
			board.makeMove(0, 0); // O player move
			board.makeMove(1, 0); // s player move
			assertEquals("", board.changeTurn(), "Red player");
			board.makeMove(1, 0); // invalid o player move
			assertEquals("", board. changeTurn(), "Red player");
		}
	
		// acceptance criterion 4.7
		@Test
		public void testRedplayerTurnInvalidRowMove() {
			board.makeMove(9, 0); 
			assertEquals("", board.changeTurn(), "Red player");
		}
		
		// acceptance criterion 4.7
		@Test
		public void testRedplayerTurnInvalidColumnMove() {
			board.makeMove(0, 9); 
			assertEquals("", board.changeTurn(), "Red player");
		}
}
