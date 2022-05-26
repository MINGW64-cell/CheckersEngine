package checkers_engine;

@SuppressWarnings("serial")
public class Pawn extends Piece	{	//Original Name Red Piece
	
	protected int x1, y1, x2, y2, d;
	
	public Pawn()	{
		
		if(Driver.isBlackTurn())	{
			b = -1;
			opp = Driver.P;		//Figure out logical implications of opp
			oppK = Driver.K;
		}	else	{
			b = Math.abs(b);
			opp = Driver.p;
			oppK = Driver.k;
		}	
	}	//end of Pawn() constructor	
	
	@Override
	public void move(int x1, int y1, int x2, int y2) {
		
		//random variables
		int c = Driver.board[x1][y1];
		
		//midpoints
		x = (x1 + x2)/2;			//meant for multicapture method bc x2 & y2 are local
		y = (y1 + y2)/2;			//also meant for multicapture method for same reason
		
		//Facilitates multiCapture()
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
		//move front left

		//a = 1 b = 1, x pairs with a and y pairs with b
		
//		if(c == Driver.P || c == Driver.p) {	//P and positives are red, p and negatives are black
	    	
    		//move forward left
    		if(x2 == x1 - a && y2 == y1 - b && Driver.board[x2][y2] == 0)
    	    		isLegalMove = true;
    		
    		//move forward right
    		if(x2 == x1 + a && y2 == y1 - b && Driver.board[x2][y2] == 0)
    	    		isLegalMove = true;
    		
    		
    	//Capture methods should work properly, so there shouldn't be a need to check it. -Steven
    		
    		//capture forward left
    		if(x2 == x1 - 2*a && y2 == y1 - 2*b && (Driver.board[x1 - a][y1 - b] == opp || Driver.board[x1 - a][y1 - b] == oppK)) {
	    			isLegalMove = true;
	    			Driver.board[x1 - a][y1 - b] = 0;	//Piece is killed
    	    }
    		
    		//capture forward right
    		if(x2 == x1 + 2*a && y2 == y1 - 2*b && (Driver.board[x1 + a][y1 - b] == opp || Driver.board[x1 - a][y1 - b] == opp)) {
	    			isLegalMove = true;
	    			Driver.board[x1 + a][y1 - b] = 0;
    	    }
//    	}
		
		if(isLegalMove)	{
			Driver.board[x2][y2] = c;
			Driver.board[x1][y1] = 0;
//			d = Driver.board[x2][y2];		Forgot the point of this thing? (probably obselete now)
		}
			
		multiCapture();
		
		
		isLegalMove = false;
		Driver.turn++;	
		
	}	//end of move() override

	/**
	 * Do not recall move method (too many unneeded possible runtime errors)
	 * 
	 * > Scan the surroundings of x2 and y2
	 * > If something is valid auto-take the piece.
	 * > If more than one possible move is valid let the player choose
	 */
	public void multiCapture()	{
		
			if(super.prompt())	{
				
				
				
			}
		
	}	//end of multiCapture
	
}

