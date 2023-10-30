import Board.Cell;

public class GeneralGame extends Board{
	
	Board board = new Board();
	
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
	    		  "/nblue player score: "+ bpScore);
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
}
