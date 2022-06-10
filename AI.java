package checkers_engine2;

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
    
    public static int[][] heatmap = new int[][]{
		{0, 100, 0, 110, 0, 125, 0, 120},
		{100, 0, 100, 0, 120, 0, 120, 0},
		{0, 100, 0, 110, 0, 120, 0, 120},
		{100, 0, 100, 0, 120, 0, 120, 0},
		{0, 100, 0, 110, 0, 120, 0, 120},
		{100, 0, 100, 0, 120, 0, 120, 0},
		{0, 100, 0, 110, 0, 120, 0, 120},
		{100, 0, 100, 0, 125, 0, 125, 0},		
	};
	
	public static int evaluate2(int[][] board) {
		int sum = 0;
		for(int i = 1; i < 64; i++) {
			sum += board[i/8][i%8] * heatmap[i/8][i%8];
		}
		return sum;
	}

	public static void makeBestMove(String moveList) {
	
		int X1 = 0, Y1 = 0, X2 = 0, Y2 = 0;
		int bestX1 = 0, bestY1 = 0, bestX2 = 0, bestY2 = 0;
		int bestEval = Integer.MAX_VALUE;
		
		/*
		 * A bunch of code to determine the best X1, Y1, X2, Y2 using Driver.board
		 * At the end, call this method in CheckersEngine.move to implement the AI
		 */
		
		for(int i = 0; i < moveList.length(); i += 4) {
			
			int deleteX = 0;
			int deleteY = 0;
			
			int[][] testBoard = new int[8][8];
			for(int x = 0; x < 8; x++) {
				for(int y = 0; y < 8; y++) {
					testBoard[x][y] = Driver.board[x][y];
				}
			}
			
			X1 = getNum(moveList, i);
			Y1 = getNum(moveList, i + 1);
			X2 = getNum(moveList, i + 2);
			Y2 = getNum(moveList, i + 3);
			
//			testBoard[X2][Y2] = testBoard[X1][Y1];
//			testBoard[X1][Y1] = 0;
			try {
				
				if(X2 - 2 == X1 && Y2 - 2 == Y1) {
					deleteX = X2 - 1;
					deleteY = Y2 - 1;
				}
				else if(X2 + 2 == X1 && Y2 - 2 == Y1) {
					deleteX = X2 + 1;
					deleteY = Y2 - 1;			
				}
				else if(X2 - 2 == X1 && Y2 + 2 == Y1) {
					deleteX = X2 - 1;
					deleteY = Y2 + 1;
				}
				else if(X2 + 2 == X1 && Y2 + 2 == Y1) {
					deleteX = X2 + 1;
					deleteY = Y2 + 1;
				}
				
				testBoard[deleteX][deleteY] = 0; /*issue*/
				
				deleteX = 0;
				deleteY = 0;
				
				if(evaluate2(testBoard) < bestEval) {
					bestX1 = X1;
					bestY1 = Y1;
					bestX2 = X2;
					bestY2 = Y2;
				}	
			
			}
			catch(Exception e) {
				
			}
		}
		

//		CheckersEngine.move(X1, Y1, X2, Y2);
		
		
		CheckersEngine.bestMove[0] = X1;
		CheckersEngine.bestMove[1] = Y1;
		CheckersEngine.bestMove[2] = X2;
		CheckersEngine.bestMove[3] = Y2;
		
		
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
				if(board[x][y] == Driver.p) { 		/*  
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

		
		for(int i = 0; i < moveList.length(); i += 4) {
			try {
				if(moveList.substring(i, i + 4).contains("8")) {
					moveList = moveList.substring(0, i) + moveList.substring(i + 4);
					i -= 4;
				}	
			}
			catch(Exception e) {
				
			}
		}
		
		for(int i = 0; i < moveList.length(); i += 4) {
			try {
				if(board[getNum(moveList, i + 2)][getNum(moveList, i + 3)] != 0) {
					moveList = moveList.substring(0, i) + moveList.substring(i + 4);
					i -= 4;
				}
			}
			catch(Exception e) {
				
			}
		}
		
		for(int i = 0; i < moveList.length(); i += 4) {
			if(getNum(moveList, i + 2) == getNum(moveList, i) + 2) {
				try {
					if(board[getNum(moveList, i) + 1][getNum(moveList, i + 1) + 1] <= 0) {
						moveList = moveList.substring(0, i) + moveList.substring(i + 4);
						i -= 4;
					}
				}
				catch(Exception e) {
					
				}
			}
			else if(getNum(moveList, i + 2) == getNum(moveList, i) - 2) {
				try {
					if(board[getNum(moveList, i) - 1][getNum(moveList, i + 1) + 1] <= 0) {
						moveList = moveList.substring(0, i) + moveList.substring(i + 4);
						i -= 4;
					}
				}
				catch(Exception e) {
					
				}
			}
		}
		
		return moveList;
		
	}
	
	/** Lmao it's like Python */
	public static String str(int x) {
		if(x < 0 || x > 7) {
			return "8";
		}
		return Integer.toString(x);
	}
	
	public static int getNum(String testString, int index) {
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
	
	public int[][] makeMove(int[][] board, int x1, int y1, int x2, int y2){
		return board;
	}

}






