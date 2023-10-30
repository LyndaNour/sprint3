import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import Board.Cell;
import junit.framework.TestCase;

public class TestBlueplayerMoves extends TestCase {
	
	private Board board;
	
	@Before
	public void setUp() throws Exception{
		board = new Board();
	}
	
/*	@After
	public void tearDows() throws Exception{
		
	}*/
	// acceptance criterion 4.1
	@Test
	public void testBlueplayerTurnMoveVacantCell() {
		board.makeMove(0, 0);
		assertEquals("", board.getCell(0, 0), Board.Cell.S_PLACEMENT);
		assertEquals("", board.changeTurn(), "Red player");
	}
	
	// acceptance criterion 4.2 illegal move
	@Test
	public void testBlueplayerTurnMoveNonVacantCell() {
		board.makeMove(0, 0);
		board.makeMove(1, 0);
		assertEquals("", board.getCell(1,0),Board.Cell.O_PLACEMENT);
		assertEquals("", board.changeTurn(), "Blue player");
		board.makeMove(0, 0);
		assertEquals("", board.changeTurn(), "Blue player");
	}
	
	//acceptance criterion 4.3 move outside the board, invalid row
	@Test
	public void testBlueplayerTurnInvalidRowMove() {
		board.makeMove(9, 0);
		assertEquals("", board.changeTurn(), "Blue player");	
	}
	
	//acceptance criterion 4.3 move outside the board, invalid column
		@Test
		public void testBlueplayerTurnInvalidColumnMove() {
			board.makeMove(0, 9);
			assertEquals("", board.changeTurn(), "Blue player");	
		}
	
	

}
