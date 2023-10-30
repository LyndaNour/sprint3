import java.awt.BorderLayout;
import java.util.Scanner;

import Board.Cell;

public class Board {
	Scanner scan = new Scanner(System.in);
	
	public enum Cell{
		EMPTY, S_PLACEMENT ,O_PLACEMENT
		}
	
	public enum GameState {
		PLAYING, DRAW, BLUE_WON, RED_WON
	}
	
	public enum ScoreState{
		DRAW_SCORE, BLUE_SCORE, RED_SCORE
	}
	
	
	private ScoreState currentScoreState;
	
	private Board.GameState currentGameState;
	
	protected int TOTALROWS = 6; // total rows 
	protected int TOTALCOLUMNS = 6; // total columns
	protected Cell[][] grid;

	private String turn = "Blue player";
	private int mode;
	char symbol ='S';
	int bpScore =0;
	int rpScore =0;
	
	public Board() { //constructor	
		grid = new Cell [TOTALROWS][TOTALCOLUMNS]; //initialization
		initBoard();
	}
	
	//initialize the game
	public void initBoard() {
		for(int row =0;row<TOTALROWS;row++) {
			for(int column=0;column<TOTALCOLUMNS;column++) {
				grid[row][column] = Cell.EMPTY;
			}
		}
		currentGameState = GameState.PLAYING;
		currentScoreState = ScoreState.DRAW_SCORE;
		symbol='S';
		mode = 0;
		turn = "Blue player";
	}
	
	public void setRows( int NEWTOTALROWS) {
		TOTALROWS = NEWTOTALROWS;
	}
	public void setColumns(int NEWTOTALCOLUMNS) {
		this.TOTALCOLUMNS = NEWTOTALCOLUMNS;
	}
	
	public int getTotalRows() {
		return TOTALROWS;
	}
	
	public int getTotalColumns() {
		return TOTALCOLUMNS;
	}
	
	// return the content of that cell
	public Cell getCell(int row, int column) {
		if(row>=0 && row<TOTALROWS && column>=0 && column<TOTALCOLUMNS) {
			return grid[row][column];		
		}else {
			return null;
		}
	}


	public String changeTurn() {
		return turn;
	}
	
	// choose s or o 
	public char getSymbol() {
		Scanner obj = new Scanner(System.in);
		System.out.println("choose to place S or O: ");
		symbol = obj.next().charAt(0);
		if(symbol != 'S' && symbol !='O') {
			System.out.println(symbol + " is an invalid token: ");
		}
		return symbol;
	}
		
	public void setGameMode(int newMode) {
		mode = newMode;
		
	}
	// getGameMode function returns the gameMode 
	public int getGameMode() {
		return mode;
	}

	// make A VALID move 
	public void makeMove(int row, int column) {
		if(row>=0 && row<TOTALROWS && column>=0 && column< TOTALCOLUMNS && grid[row][column]== Cell.EMPTY) {	
			
			 symbol = getSymbol();
			if(symbol == 'S') {
				grid[row][column]= Cell.S_PLACEMENT;
			}
			else if (symbol =='O') {
				grid[row][column]=Cell.O_PLACEMENT;
			}
			
			turn = (turn =="Blue player")? "Red player" : "Blue player";
		}
	}
	
	public int getBpScore() {
		return bpScore;
	}
	public int setBpScore(int points) {
		 bpScore = bpScore+1;
		 return bpScore;
	}
	public int getRpScore() {
		return rpScore;
	}
	public int setRpScore(int points) {
		rpScore = rpScore+1;
		return rpScore;
	}
	
	// no winner 
	public boolean isDraw() {
		for (int row = 0; row < TOTALROWS; ++row) {
			for (int col = 0; col < TOTALCOLUMNS; ++col) {
				if (grid[row][col] == Cell.EMPTY) {
					return false; // an empty cell found, not draw
				}
			}
		}
		currentGameState = GameState.DRAW;
		return true;
	}
	
	// check horizontalCheck
	/*
	 * S O S
	 */

	  public boolean simpleCheck(String turn) {
		  String winner = null;
	       for (int i = 0; i < TOTALROWS ; i++) {
	            for (int j = 0; j < TOTALCOLUMNS-2 ; j++) {
	                if (grid[i][j].equals(Cell.S_PLACEMENT) && grid[i][j + 1].equals(Cell.O_PLACEMENT) && grid[i][j + 2].equals(Cell.S_PLACEMENT)) {
	                	winner =turn;
	                	if(winner =="Blue player") {
	                		currentGameState = GameState.BLUE_WON;
	                	}else {
	                		currentGameState = GameState.RED_WON;
	                	}
	                	return true;
	                }
	            }     
	        }
	           // check vertical 
	        /*
	         * S
	         * O
	         * S
	         */
            for (int i = 0; i < TOTALROWS-2; i++) {
	            for (int j = 0; j < TOTALCOLUMNS; j++) {
	                if (grid[i][j].equals(Cell.S_PLACEMENT) && grid[i + 1][j].equals(Cell.O_PLACEMENT) && grid[i + 2][j].equals(Cell.S_PLACEMENT)) {
	                    winner = turn;
	                    if(winner == "Blue player") {
	                    	currentGameState = GameState.BLUE_WON;
	                    }
	                    else {
	                    	currentGameState = GameState.RED_WON;
	                    }
	                    return true;
	                }
	            }
	        }
            // check diagonals 
            /* S
             * 	  O
             * 		S
             */
                for (int i = 0; i < TOTALROWS- 2; i++) {
                    for (int j = 0; j < TOTALCOLUMNS- 2; j++) {
                        if (grid[i][j].equals(Cell.S_PLACEMENT) && grid[i + 1][j + 1].equals(Cell.O_PLACEMENT) && grid[i + 2][j + 2].equals(Cell.S_PLACEMENT)) {
                            winner = turn;
                            if(winner == "Blue player") {
    	                    	currentGameState = GameState.BLUE_WON;
    	                    }
    	                    else {
    	                    	currentGameState = GameState.RED_WON;
    	                    }
    	                    return true;
                        }
                    }
                }
                
                // check anti diagonal 
                /*
                 * 			S
                 * 		O
                 * 	S
                 */
                
                for (int i = 0; i < TOTALROWS - 2; i++) {
                    for (int j = 2; j < TOTALCOLUMNS; j++) {
                        if (grid[i][j].equals(Cell.S_PLACEMENT) && grid[i + 1][j - 1].equals(Cell.O_PLACEMENT) && grid[i + 2][j - 2].equals(Cell.S_PLACEMENT)) {
                        	winner = turn;
                        	if(winner == "Blue player") {
       	                    	currentGameState = GameState.BLUE_WON;
       	                    }
       	                    else {
       	                    	currentGameState = GameState.RED_WON;
       	                    }
       	                    return true;
                        }
                    }
                }
                // check the first above diagonal 
                /*
                 *  -	S	-	-
                 *  -	-	O	-
                 *  -	-	-	S
                 *  -	-	-	-
                 */ 
                for(int i =0; i<TOTALROWS-3; i++) {
                	  if (grid[i][i+1].equals(Cell.S_PLACEMENT) && grid[i+1][i+2].equals(Cell.O_PLACEMENT) && grid[i+2][i+3].equals(Cell.S_PLACEMENT)) {
                		  winner = turn;
                      	if(winner == "Blue player") {
     	                    	currentGameState = GameState.BLUE_WON;
     	                    }
     	                    else {
     	                    	currentGameState = GameState.RED_WON;
     	                    }
     	                    return true;
                	  }
                }
                
                // check the first below diagonal 
                /*
                 *  	-	-	-	-
                 *  	S	-	-	-
                 *  	-	O	-	-
                 *  	-	-	S	-
                 */
            	   for(int i =0; i<TOTALROWS-3; i++) {
                  	  if (grid[i+1][i].equals(Cell.S_PLACEMENT) && grid[i+2][i+1].equals(Cell.O_PLACEMENT) && grid[i+3][i+2].equals(Cell.S_PLACEMENT)) {
                  		  winner = turn;
                        	if(winner == "Blue player") {
       	                    	currentGameState = GameState.BLUE_WON;
       	                    }
       	                    else {
       	                    	currentGameState = GameState.RED_WON;
       	                    }
       	                    return true;
                  	  }
            	   }
            	   
         	      // check the second above diagonal 
                /*
                 *  	-	-	S	-	-
                 *  	-	-	-	O	-
                 *  	-	-	-	-	S
                 *  	-	-	-	-	-
                 *  	-	-	-	-	-
                 */
            	   for(int i =0; i<TOTALROWS-4; i++) {
                  	  if (grid[i][i+2].equals(Cell.S_PLACEMENT) && grid[i+1][i+3].equals(Cell.O_PLACEMENT) && grid[i+2][i+4].equals(Cell.S_PLACEMENT)) {
                  		  winner = turn;
                        	if(winner == "Blue player") {
       	                    	currentGameState = GameState.BLUE_WON;
       	                    }
       	                    else {
       	                    	currentGameState = GameState.RED_WON;
       	                    }
       	                    return true;
                  	  }
            	   }
        
               	   
         	      // check the second below diagonal 
                /*
                 *  	-	-	-	-	-
                 *  	-	-	-	-	-
                 *  	S	-	-	-	-
                 *  	-	O	-	-	-
                 *  	-	-	S	-	-
                 */
            	   for(int i =0; i<TOTALROWS-4; i++) {
                  	  if (grid[i+2][i].equals(Cell.S_PLACEMENT) && grid[i+3][i+1].equals(Cell.O_PLACEMENT) && grid[i+4][i+2].equals(Cell.S_PLACEMENT)) {
                  		  winner = turn;
                  		  
                        	if(winner == "Blue player") {
       	                    	currentGameState = GameState.BLUE_WON;
       	                    }
       	                    else {
       	                    	currentGameState = GameState.RED_WON;
       	                    }
       	                    return true;
                  	  }
            	   }
            	      // check the third above diagonal 
                   /*
                    *  	-	-	-	S	-	-
                    *  	-	-	-	-	O	-
                    *  	-	-	-	-	-	S
                    *  	-	-	-	-	-	-
                    *  	-	-	-	-	-	-
                    *  	-	-	-	-	-	-
                    */
               	   for(int i =0; i<TOTALROWS-5; i++) {
                     	  if (grid[i][i+3].equals(Cell.S_PLACEMENT) && grid[i+1][i+4].equals(Cell.O_PLACEMENT) && grid[i+2][i+5].equals(Cell.S_PLACEMENT)) {
                     		  winner = turn;
                           	if(winner == "Blue player") {
          	                    	currentGameState = GameState.BLUE_WON;
          	                    }
          	                    else {
          	                    	currentGameState = GameState.RED_WON;
          	                    }
          	                    return true;
                     	  }
               	   }
                   // check the third below diagonal 
                   /*
                    *  	-	-	-	-	-	-
                    *  	-	-	-	-	-	-
                    *  	-	-	-	-	-	-
                    *  	-	-	-	-	-	-
                    *  	S	-	-	-	-	-
                    *  	- 	O	-	-	-	-
                    *  	-	-	S	-	-	-
                    */
               	   for(int i =0; i<TOTALROWS-5; i++) {
                     	  if (grid[i+3][i].equals(Cell.S_PLACEMENT) && grid[i+4][i+1].equals(Cell.O_PLACEMENT) && grid[i+5][i+2].equals(Cell.S_PLACEMENT)) {
                     		  winner = turn;
                           	if(winner == "Blue player") {
          	                    	currentGameState = GameState.BLUE_WON;
          	                    }
          	                    else {
          	                    	currentGameState = GameState.RED_WON;
          	                    }
          	                    return true;
                     	  }
               	   }
                  
	        return false; 
	    }

	  public String generalCheck(String turn) {
			String currentWinner = null;
			int bpScore =0;
			int rpScore=0;
			
			  // general game check winner
			// check horizontalCheck
			/*
			 * S O S
			 */
		      for (int i = 0; i < TOTALROWS ; i++) {
		            for (int j = 0; j < TOTALCOLUMNS-2 ; j++) {
		                if (grid[i][j].equals(Cell.S_PLACEMENT) && grid[i][j + 1].equals(Cell.O_PLACEMENT) && grid[i][j + 2].equals(Cell.S_PLACEMENT)) {
		                	currentWinner =turn;
		                	if(currentWinner == "Red player") {
		                		rpScore++;	
		                	}else if(currentWinner =="Blue player") {
		                		
								bpScore++;
		                	}
		                }
		            }
		      	}
		      // check vertical 
		        /*
		         * S
		         * O
		         * S
		         */
	          for (int i = 0; i < TOTALROWS-2; i++) {
		            for (int j = 0; j < TOTALCOLUMNS; j++) {
		                if (grid[i][j].equals(Cell.S_PLACEMENT) && grid[i + 1][j].equals(Cell.O_PLACEMENT) && grid[i + 2][j].equals(Cell.S_PLACEMENT)) {
		                    currentWinner = turn;
		                    if(currentWinner == "Red player") {
		                    	rpScore++;
		                    }else if(currentWinner =="Blue player") {
		                		
								bpScore++;
		                	}
		                }
		            }
		        }
	          
	          // check diagonals 
	          /* S
	           * 	  O
	           * 		S
	           */
	              for (int i = 0; i < TOTALROWS- 2; i++) {
	                  for (int j = 0; j < TOTALCOLUMNS- 2; j++) {
	                      if (grid[i][j].equals(Cell.S_PLACEMENT) && grid[i + 1][j + 1].equals(Cell.O_PLACEMENT) && grid[i + 2][j + 2].equals(Cell.S_PLACEMENT)) {
	                          currentWinner = turn;
	                          if(currentWinner == "Red player") {
	                          	rpScore++;

	                      	}else if(currentWinner =="Blue player") {
			                		
									bpScore++;
			                	}
	  	                   
	                      }
	                  }
	              }
	              
	              // check anti diagonal 
	              /*
	               * 			S
	               * 		O
	               * 	S
	               */
	              
	              for (int i = 0; i < TOTALROWS - 2; i++) {
	                  for (int j = 2; j < TOTALCOLUMNS; j++) {
	                      if (grid[i][j].equals(Cell.S_PLACEMENT) && grid[i + 1][j - 1].equals(Cell.O_PLACEMENT) && grid[i + 2][j - 2].equals(Cell.S_PLACEMENT)) {
	                      	currentWinner = turn;
	                      	if(currentWinner == "Red player") {
	     	                    	rpScore++;
	                      	}else if(currentWinner =="Blue player") {
			                		
									bpScore++;
			                	}	       	                 
	                      }
	                  }
	              }
	              // check the first above diagonal 
	              /*
	               *  -	S	-	-
	               *  -	-	O	-
	               *  -	-	-	S
	               *  -	-	-	-
	               */ 
	              for(int i =0; i<TOTALROWS-3; i++) {
	              	  if (grid[i][i+1].equals(Cell.S_PLACEMENT) && grid[i+1][i+2].equals(Cell.O_PLACEMENT) && grid[i+2][i+3].equals(Cell.S_PLACEMENT)) {
	              		  currentWinner = turn;
	                    	if(currentWinner == "Red player") {
	   	                    	rpScore++;
	                    	}else if(currentWinner =="Blue player") {
		                		
								bpScore++;
		                	}     	                  
	              	  }
	              }
	              
	              // check the first below diagonal 
	              /*
	               *  	-	-	-	-
	               *  	S	-	-	-
	               *  	-	O	-	-
	               *  	-	-	S	-
	               */
	          	   for(int i =0; i<TOTALROWS-3; i++) {
	                	  if (grid[i+1][i].equals(Cell.S_PLACEMENT) && grid[i+2][i+1].equals(Cell.O_PLACEMENT) && grid[i+3][i+2].equals(Cell.S_PLACEMENT)) {
	                		  currentWinner = turn;
	                      	if(currentWinner == "Red player") {
	     	                    	rpScore++;
	                      	}else if(currentWinner =="Blue player") {
			                		
									bpScore++;
			                	}       	                  
	                	  }
	          	   }
	          	   
	       	      // check the second above diagonal 
	              /*
	               *  	-	-	S	-	-
	               *  	-	-	-	O	-
	               *  	-	-	-	-	S
	               *  	-	-	-	-	-
	               *  	-	-	-	-	-
	               */
	          	   for(int i =0; i<TOTALROWS-4; i++) {
	                	  if (grid[i][i+2].equals(Cell.S_PLACEMENT) && grid[i+1][i+3].equals(Cell.O_PLACEMENT) && grid[i+2][i+4].equals(Cell.S_PLACEMENT)) {
	                		  currentWinner = turn;
	                      	if(currentWinner == "Red player") {
	     	                    	rpScore++;
	                      	}else if(currentWinner =="Blue player") {
			                		
									bpScore++;
			                	}	       	                
	                	  }                  	  
	          	   }
	      
	             	   
	       	      // check the second below diagonal 
	              /*
	               *  	-	-	-	-	-
	               *  	-	-	-	-	-
	               *  	S	-	-	-	-
	               *  	-	O	-	-	-
	               *  	-	-	S	-	-
	               */
	          	   for(int i =0; i<TOTALROWS-4; i++) {
	                	  if (grid[i+2][i].equals(Cell.S_PLACEMENT) && grid[i+3][i+1].equals(Cell.O_PLACEMENT) && grid[i+4][i+2].equals(Cell.S_PLACEMENT)) {
	                		  currentWinner = turn;
	                		  
	                      	if(currentWinner == "Red player") {
	     	                    	rpScore++;
	                      	}else if(currentWinner =="Blue player") {
			                		
									bpScore++;
			                	}	       	                  
	                	  }
	          	   }
	          	      // check the third above diagonal 
	                 /*
	                  *  	-	-	-	S	-	-
	                  *  	-	-	-	-	O	-
	                  *  	-	-	-	-	-	S
	                  *  	-	-	-	-	-	-
	                  *  	-	-	-	-	-	-
	                  *  	-	-	-	-	-	-
	                  */
	             	   for(int i =0; i<TOTALROWS-5; i++) {
	                   	  if (grid[i][i+3].equals(Cell.S_PLACEMENT) && grid[i+1][i+4].equals(Cell.O_PLACEMENT) && grid[i+2][i+5].equals(Cell.S_PLACEMENT)) {
	                   		  currentWinner = turn;
	                         	if(currentWinner == "Red player") {
	        	                    	rpScore++;
	                      	}else if(currentWinner =="Blue player") {
			                		
									bpScore++;
			                	}
	        	                   
	                   	  }
	             	   }
	                 // check the third below diagonal 
	                 /*
	                  *  	-	-	-	-	-	-
	                  *  	-	-	-	-	-	-
	                  *  	-	-	-	-	-	-
	                  *  	-	-	-	-	-	-
	                  *  	S	-	-	-	-	-
	                  *  	- 	O	-	-	-	-
	                  *  	-	-	S	-	-	-
	                  */
	             	   for(int i =0; i<TOTALROWS-5; i++) {
	                   	  if (grid[i+3][i].equals(Cell.S_PLACEMENT) && grid[i+4][i+1].equals(Cell.O_PLACEMENT) && grid[i+5][i+2].equals(Cell.S_PLACEMENT)) {
	                   		  currentWinner = turn;
	                         	if(currentWinner == "Red player") {
	        	                    	rpScore++;
	                      	}else if(currentWinner =="Blue player") {
			                		
									bpScore++;
			                	}	          	                  
	                   	  }
	             	   }
	             	   
		      System.out.println(" red player score:" + rpScore + 
		    		  "\nblue player score: "+ bpScore);
		      if(rpScore>bpScore) {
		    	  
		    	  currentWinner ="Red player";
		      }else if(rpScore<bpScore) {
		    	  currentWinner = "Blue player";
		      }else if(rpScore == bpScore) {
		    	  currentWinner =null;
		      }
		      System.out.println("winner is: "+ currentWinner);
		      
		      	return currentWinner;	
		  }
		  
	  

	public GameState getGameState() {
		return currentGameState;
	}
	
	public ScoreState getScoreState() {
		return currentScoreState;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


