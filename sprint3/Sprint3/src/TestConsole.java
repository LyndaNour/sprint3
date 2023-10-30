import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


public class TestConsole {
	private Board board;
	@Before
	public void setUp() throws Exception {
		board = new Board();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testEmptyBoard() {	
		new console2(board).displayBoard();
	}
	
	@Test
	public void testNonEmptyBoard() {
		board.makeMove(0, 0);
		board.makeMove(1, 1);		
		new console2(board).displayBoard();
	}
	
	@Test
	public void testWinner() {
		board.makeMove(0, 0);
		board.makeMove(0, 1);
		board.makeMove(0, 2);
		assertTrue("", board.simpleCheck("Blue player"));

	}
	@Test 
	public void testGetSymbol() {
		assertEquals(board.getSymbol(), 'S');
	}

}