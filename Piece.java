package checkers_engine;

import javax.swing.*;

public class Piece {

	protected JFrame f;
	protected boolean isLegalMove = false;
	protected static int a = 1; //Will only be used if board switching sides is implemented
	
	/*
	 * Use polymorphism so that certain pieces have exclusive movements
	 */
	
	protected void prompt()	{
		f = new JFrame("Move again or Pass?");
		
	}
	
   public void move(int x1, int y1, int x2, int y2) {	//Will never be used due to always being overridden
		   
	    	/*
	    	 * FR_2|____|____|____|FL_2
	    	 * ____|FR_1|____|FL_1|____
	    	 * ____|____|ORIG|____|____
	    	 * ____|BL_1|____|BR_1|____
	    	 * BL_2|____|____|____|BR_2
	    	 */
	    	
	    	int a = 0;
	    	boolean isLegalMove = false;
	    	
	    	if(Driver.lastMoveRed || Driver.turns == -1)	{
	    		a++;
	    		
	    		Driver.lastMoveRed = false;
	    	}	else	{
	    		a--;
	    		
	    		Driver.lastMoveRed = true;
	    	}
	    	
	    	
	    	
	    	
		    //preconditions met?
	    	if(!Driver.lastMoveRed) {
		    	//Red Piece
		    	if(Driver.board[x1][y1] == Driver.P) {
		    	
		    		//move forward left
		    		if(x2 == x1 - 1 && y2 == y1 - 1) {
		    	    	if(Driver.board[x2][y2] == 0) {
		    	    		isLegalMove = true;
		    	    	}
		    	    }
		    		
		    		//move forward right
		    		if(x2 == x1 + 1 && y2 == y1 - 1) {
		    			if(Driver.board[x2][y2] == 0) {
		    	    		isLegalMove = true;
		    	    	}
		    	    }
		    		
		    		//capture forward left
		    		if(x2 == x1 - 2 && y2 == y1 - 2) {
			    		if(Driver.board[x1 - 1][y1 - 1] < 0) {
			    			isLegalMove = true;
			    			Driver.board[x1 - 1][y1 - 1] = 0;
			    		}
		    	    }
		    		
		    		//capture forward right
		    		if(x2 == x1 + 2 && y2 == y1 - 2) {
		    			if(Driver.board[x1 + 1][y1 - 1] < 0) {
			    			isLegalMove = true;
			    			Driver.board[x1 + 1][y1 - 1] = 0;
			    		}
		    	    }
		    	}
		    	
		    	//Red King
		    	if(Driver.board[x1][y1] == Driver.K) {
		    		
		    		//move forward left
		    		if(x2 == x1 - 1 && y2 == y1 - 1) {
		    	    	if(Driver.board[x2][y2] == 0) {
		    	    		isLegalMove = true;
		    	    	}
		    	    }
		    		
		    		//move forward right
		    		if(x2 == x1 + 1 && y2 == y1 - 1) {
		    			if(Driver.board[x2][y2] == 0) {
		    	    		isLegalMove = true;
		    	    	}
		    	    }
		    		
		    		//capture forward left
		    		if(x2 == x1 - 2 && y2 == y1 - 2) {
			    		if(Driver.board[x1 - 1][y1 - 1] < 0) {
			    			isLegalMove = true;
			    			Driver.board[x1 - 1][y1 - 1] = 0;
			    		}
		    	    }
		    		
		    		//capture forward right
		    		if(x2 == x1 + 2 && y2 == y1 - 2) {
		    			if(Driver.board[x1 + 1][y1 - 1] < 0) {
			    			isLegalMove = true;
			    			Driver.board[x1 + 1][y1 - 1] = 0;
			    		}
		    	    }
		    		
		    		//move backwards left
		    		if(x2 == x1 - 1 && y2 == y1 + 1) {
			    		if(Driver.board[x2][y2] == 0) {
			    			isLegalMove = true;
			    		}
		    	    }
		    		
		    		//move backwards right
		    		if(x2 == x1 + 1 && y2 == y1 + 1) {
		    			if(Driver.board[x2][y2] == 0) {
			    			isLegalMove = true;
			    		}	
		    	    }
		    		
		    		//capture backwards left
		    		if(x2 == x1 - 2 && y2 == y1 + 2) {
		    			if(Driver.board[x1 - 1][y1 + 1] < 0) {
			    			isLegalMove = true;
			    			Driver.board[x1 - 1][y1 + 1] = 0;
			    		}
		    	    }
		    		
		    		//capture backwards right
		    		if(x2 == x1 + 2 && y2 == y1 + 2) {
		    			if(Driver.board[x1 + 1][y1 + 1] < 0) {
			    			isLegalMove = true;
			    			Driver.board[x1 + 1][y1 + 1] = 0;
			    		}
		    	    }
		    		
		    	}
	    	
	    	Driver.lastMoveRed = true;
	    	
	    	}
	    	
	    	
	    	if(Driver.lastMoveRed) {
	    		
		    	//Black Piece
		    	if(Driver.board[x1][y1] == Driver.p) {
		        	
		    		//move backwards left
		    		if(x2 == x1 - 1 && y2 == y1 + 1) {
			    		if(Driver.board[x2][y2] == 0) {
			    			isLegalMove = true;
			    		}
		    	    }
		    		
		    		//move backwards right
		    		if(x2 == x1 + 1 && y2 == y1 + 1) {
		    			if(Driver.board[x2][y2] == 0) {
			    			isLegalMove = true;
			    		}	
		    	    }
		    		
		    		//capture backwards left
		    		if(x2 == x1 - 2 && y2 == y1 + 2) {
		    			if(Driver.board[x1 - 1][y1 + 1] > 0) {
			    			isLegalMove = true;
			    			Driver.board[x1 - 1][y1 + 1] = 0;
			    		}
		    	    }
		    		
		    		//capture backwards right
		    		if(x2 == x1 + 2 && y2 == y1 + 2) {
		    			if(Driver.board[x1 + 1][y1 + 1] > 0) {
			    			isLegalMove = true;
			    			Driver.board[x1 + 1][y1 + 1] = 0;
			    		}
		    	    }	
		    	}
		    	
		    	//Black King
		    	if(Driver.board[x1][y1] == Driver.k) {
		        	
		    		//move forward left
		    		if(x2 == x1 - 1 && y2 == y1 - 1) {
		    	    	if(Driver.board[x2][y2] == 0) {
		    	    		isLegalMove = true;
		    	    	}
		    	    }
		    		
		    		//move forward right
		    		if(x2 == x1 + 1 && y2 == y1 - 1) {
		    			if(Driver.board[x2][y2] == 0) {
		    	    		isLegalMove = true;
		    	    	}
		    	    }
		    		
		    		//capture forward left
		    		if(x2 == x1 - 2 && y2 == y1 - 2) {
			    		if(Driver.board[x1 - 1][y1 - 1] > 0) {
			    			isLegalMove = true;
			    			Driver.board[x1 - 1][y1 - 1] = 0;
			    		}
		    	    }
		    		
		    		//capture forward right
		    		if(x2 == x1 + 2 && y2 == y1 - 2) {
		    			if(Driver.board[x1 + 1][y1 - 1] > 0) {
			    			isLegalMove = true;
			    			Driver.board[x1 + 1][y1 - 1] = 0;
			    		}
		    	    }
		    		
		    		//move backwards left
		    		if(x2 == x1 - 1 && y2 == y1 + 1) {
			    		if(Driver.board[x2][y2] == 0) {
			    			isLegalMove = true;
			    		}
		    	    }
		    		
		    		//move backwards right
		    		if(x2 == x1 + 1 && y2 == y1 + 1) {
		    			if(Driver.board[x2][y2] == 0) {
			    			isLegalMove = true;
			    		}	
		    	    }
		    		
		    		//capture backwards left
		    		if(x2 == x1 - 2 && y2 == y1 + 2) {
		    			if(Driver.board[x1 - 1][y1 + 1] > 0) {
			    			isLegalMove = true;
			    			Driver.board[x1 - 1][y1 + 1] = 0;
			    		}
		    	    }
		    		
		    		//capture backwards right
		    		if(x2 == x1 + 2 && y2 == y1 + 2) {
		    			if(Driver.board[x1 + 1][y1 + 1] > 0) {
			    			isLegalMove = true;
			    			Driver.board[x1 + 1][y1 + 1] = 0;
			    		}
		    	    }	
		    	}
	    	
		    Driver.lastMoveRed = false;
		    	
	    	}
	    	
		    if(isLegalMove) {	
		    	//moving
		    	if(Driver.board[x1][y1] != 0) {
		    		Driver.board[x2][y2] = Driver.board[x1][y1];
		    		Driver.board[x1][y1] = 0;
		    	}
		    }
		    	
		    	//promotion
		    	for(int i = 0; i < 8; i++) {
		    		if(Driver.board[i][0] == 1) {
		    			Driver.board[i][0] = 3;
		    		}
		    		if(Driver.board[i][7] == -1) {
		    			Driver.board[i][7] = -3;
		    		}
		    	}
	    }

	
}
