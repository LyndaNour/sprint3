import java.util.Scanner;

import Board.Cell;
import Board.GameState;

public class console2 {
	private Board board;
	private GeneralGame general;

	public console2(Board board) {
		this.board = board;
	}
	
	public void displayBoard() {
		for(int row=0;row<board.getTotalRows();row++) {
			for(int col =0; col<board.getTotalColumns(); col++) {
				System.out.print( "    " + symbol(board.getCell(row, col)) );
			}
			System.out.println();	
		}
	}
	
	private static char symbol(Board.Cell cell) {
		if(cell == Board.Cell.S_PLACEMENT) {
			return 'S';
		}
		else
			if(cell == Board.Cell.O_PLACEMENT) {
				return 'O';
			}else
				return '-';
	}
	
	public boolean isOver(String turn) {//String turn
		boolean done = false;
		String winner;
		if(board.getGameState()== Board.GameState.PLAYING) {
			done = false;
		}
		if(board.isDraw()) {
			done =true;
		}
		if(board.getGameMode()==0) {
		
		if(board.simpleCheck(turn) && board.getGameState()==Board.GameState.BLUE_WON) {
		done =true;
		}
		else if(board.simpleCheck(turn) && board.getGameState()==Board.GameState.RED_WON) {
			done =true;
		}
		else if(board.getGameMode()==1) {	
			System.out.println("winner "+board.generalCheck(turn));
			
			done =true;
		}
		}
		System.out.println("Current game state: " + board.getGameState() + "!");
		return done;
		
	}
	public void play()
	{
		Scanner obj =new Scanner(System.in);
		System.out.println("Welcome to SOS Game !");
		System.out.println("enter the total number of rows: ");
		int totalRows = obj.nextInt();
		board.setRows(totalRows);
		
		System.out.println("enter the total number of columns: ");
		int totalColumns = obj.nextInt();
		board.setColumns(totalColumns);
		
		System.out.println("Enter the game mode, enter 0 for simple game and 1 for general game  ");
		int gameMode = obj.nextInt();
		board.setGameMode(gameMode);
		
		while(totalRows <3 ||totalRows >6 || totalColumns<3 || totalColumns >6 )
		{
			System.out.println("invalid size, choose a board size between 3 and 6");
			System.out.println("enter number of rows: ");
			totalRows = obj.nextInt();
			board.setRows(totalRows);
			System.out.println("enter number of columns: ");
			 totalColumns = obj.nextInt();
			board.setColumns(totalColumns);
		}
	
		displayBoard();
		

		boolean done = false;
		board.getGameMode();
		String currentPlayer;
		boolean winner;

		while(!done) {
		
			currentPlayer = board.changeTurn();
		System.out.println("Current player: " + currentPlayer);
		
		System.out.print("choose row to make a move: ");
		int row = obj.nextInt();
		System.out.print("choose column to make a move: ");
		int column =obj.nextInt();
		
		// check invalid move 
		if (row < 0 || row >= board.getTotalRows() || column < 0 || column >= board.getTotalColumns() || symbol(board.getCell(row,column)) != '-') {
			System.out.println("Invalid move at (" + row + "," + column + ")");
		}
		else {
				board.makeMove(row, column);
				displayBoard();
				System.out.println(board.generalCheck(currentPlayer));
				done = isOver(currentPlayer);
		}
		}
	}
	
	public static void main(String[] args) {
		new console2(new Board()).play();
	}
}