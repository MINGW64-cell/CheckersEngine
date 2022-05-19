package checkers_engine;

public class AI {
	
	public static int evaluate(int board[][]) {	//Task for 5/17/2022
		
		int sum = 0;
		int[] rowSum = new int[board.length]; 
		
		for(int i = 0; i < 8; i++) {
		
			sum += rowSum(board[i]);
			
		}
			
		return sum;
		
	}	//end of evaluate()
	
//calculates the sum of a row.

    public static int rowSum(int[] row){
    	int rowSum = 0;
          	for(int col = 0; col<row.length; col++){
              rowSum += row[col];
          	}
        return rowSum;
    }

	public static void makeBestMove(String moveList) {
	
		int X1 = 0, Y1 = 0, X2 = 0, Y2 = 0;
		int bestX1 = 0, bestY1 = 0, bestX2 = 0, bestY2 = 0;
		
		/*
		 * A bunch of code to determine the best X1, Y1, X2, Y2 using Driver.board
		 * At the end, call this method in CheckersEngine.move to implement the AI
		 */
		
		for(int i = 0; i < moveList.length(); i += 4) {
			int testBoard[][] = Driver.board;
			
			X1 = get(moveList, i);
			Y1 = get(moveList, i + 1);
			X2 = get(moveList, i + 2);
			Y2 = get(moveList, i + 3);
			
		}
		
		
		CheckersEngine.move(X1, Y1, X2, Y2);
		
	}
	
	/**
	 * 
	 * @param board
	 * @return String of possible moves "toString(int x1, int y1, int x2, int y2)"
	 * 
	 * |  |  |EIGHTH RANK|  |  |
	 * |L |  |  |  |  |  |  | R|
	 * |  |  |  |  |  |  |  |  |
	 * |E |  |  |  |  |  |  | E|
	 * |D |  |  |  |  |  |  | D|
	 * |G |  |  |  |  |  |  | G|
	 * |E |  |  |  |  |  |  | E|
	 * |  |  |FIRST  RANK|  |  |
	 */
	
	public static String possibleMoves(int[][] board) {
		String moveList = "";
		
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				
				// str(x1, y1, x2, y2)
				if(board[y][x] == Driver.p) { 		/*  
													* No clue why this works 
													* But it does(?) 
													* And that's good enough
													*/
					
					// possible move back right
					moveList += (str(x) + str(y) + str(x + 1) + str(y + 1));
					
					// possible move back left
					moveList += (str(x) + str(y) + str(x - 1) + str(y + 1));

					// possible capture back right
					moveList += (str(x) + str(y) + str(x + 2) + str(y + 2));
					
					// possible capture back left
					moveList += (str(x) + str(y) + str(x - 2) + str(y + 2));
					
				}
				
				if(board[x][y] == Driver.k) {
					
					// possible move back right
					moveList += (str(x) + str(y) + str(x + 1) + str(y + 1));
					
					// possible move back left
					moveList += (str(x) + str(y) + str(x - 1) + str(y + 1));
					
					// possible move forward right
					moveList += (str(x) + str(y) + str(x + 1) + str(y - 1));
					
					// possible move forward left
					moveList += (str(x) + str(y) + str(x - 1) + str(y - 1));
					
					// possible capture back right
					moveList += (str(x) + str(y) + str(x + 2) + str(y + 2));
					
					// possible capture back left
					moveList += (str(x) + str(y) + str(x - 2) + str(y + 2));
					
					// possible capture forward right
					moveList += (str(x) + str(y) + str(x + 2) + str(y - 2));
					
					// possible capture forward left
					moveList += (str(x) + str(y) + str(x - 2) + str(y - 2));
					
				}
				
			}
		}
		
		/*
		 * Delete illegal moves
		 */
		
		
//		for(int i = 0; i < moveList.length(); i += 4) {
//			if(moveList.substring(i, i + 4).contains("8")) {
//				moveList = moveList.substring(0, i) + moveList.substring(i + 4);
//				i -= 4;
//			}
//		}
		
		return removeOutOfBounds(moveList);
		
	}
	
	/** Lmao it's like Python */
	public static String str(int x) {
		if(x < 0 || x > 7) {
			return "8";
		}
		return Integer.toString(x);
	}
	
	public static int get(String testString, int index) {
		return Integer.parseInt(testString.substring(index, index + 1));
	}



// Checks for moves that are out of bounds and removes them from the ‘moveList’ String
// I tested the method but further testing might be needed

	public static String removeOutOfBounds(String moveList	/*Error suppresser*/)	{
		String checkSubString = "";
	    
		for(int i = 0; i < moveList.length(); i+=4){

			checkSubString = moveList.substring(i,i+4);
	       
			for(int j = 0; j < checkSubString.length(); j++){
	        
				if(checkSubString.substring(j,j+1).indexOf("8")>-1){
	               moveList = moveList.substring(0,i) + moveList.substring(i+4, moveList.length());
	               i-=4;
	           }
	       }
	    }
		
		return moveList;

	}

}
