package checkers_engine;

public class King extends Pawn	{

	public King()	{
		reverseAB();
	}
	
	@Override
	public void move(int x1, int y1, int x2, int y2) {
		//move up right
		if(Driver.board[x1][y1] == Driver.P) {
			//move backwards left
    		if(x2 == x1 - a && y2 == y1 + b) {
	    		if(Driver.board[x2][y2] == 0) {
	    			isLegalMove = true;
	    		}
    	    }
    		
    		//move backwards right
    		if(x2 == x1 + a && y2 == y1 + b) {
    			if(Driver.board[x2][y2] == 0) {
	    			isLegalMove = true;
	    		}	
    	    }
    		
    		//capture backwards left
    		if(x2 == x1 - a && y2 == y1 + b) {
    			if(Driver.board[x1 - a][y1 + b] < 0) {
	    			isLegalMove = true;
	    			Driver.board[x1 - a][y1 + b] = 0;
	    		}
    	    }
    		
    		//capture backwards right
    		if(x2 == x1 + a && y2 == y1 + b) {
    			if(Driver.board[x1 + a][y1 + b] < 0) {
	    			isLegalMove = true;
	    			Driver.board[x1 + a][y1 + b] = 0;
	    		}
    	    }
		}
		super.move(x1,y1,x2,y2);
	}
}
