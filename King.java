package checkers_engine;

@SuppressWarnings("serial")
public class King extends Pawn	{

	public King()	{
		
		if(Driver.isBlackTurn())	{
			b = -1;
//			opp = Driver.P;		//Figure out logical implications of opp
//			oppK = Driver.K;
		}	else	{
			b = Math.abs(b);
//			opp = Driver.p;
//			oppK = Driver.k;
		}	
	}	//end of King() constructor
	
	@Override
	public void move(int x1, int y1, int x2, int y2) {
		int c = Driver.board[x1][y1];
			
		//move up right
			
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
    		if(x2 == x1 - 2*a && y2 == y1 + 2*b && (Driver.board[x1 - a][y1 + b] == opp || Driver.board[x1 - a][y1 + b] == oppK)) {
    			if(Driver.board[x1 - a][y1 + b] == opp || Driver.board[x1 - a][y1 + b] == oppK) {
	    			isLegalMove = true;
	    			Driver.board[x1 - 2*a][y1 + 2*b] = 0;
	    		}
    	    }
    		
    		//capture backwards right
    		if(x2 == x1 + 2*a && y2 == y1 + 2*b && (Driver.board[x1 + a][y1 + b] == opp || Driver.board[x1 + a][y1 + b] == oppK)) {
    			if((Driver.board[x1 + a][y1 + b] == opp || Driver.board[x1 + a][y1 + b] == oppK)) {
	    			isLegalMove = true;
	    			Driver.board[x1 + 2*a][y1 + 2*b] = 0;
	    		}
    	    }
 
		super.move(x1,y1,x2,y2);
	}

	@Override
	public void multiCapture() {
		
		super.multiCapture();

	}
}
