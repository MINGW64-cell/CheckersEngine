package checkers_engine;

public class Pawn extends Piece	{	//Original Name Red Piece
	
	public Pawn()	{
		reverseAB();
	}
	
	@Override
	public void move(int x1, int y1, int x2, int y2) {
		
		
		//move front left

		//a = 1 b = 1, x pairs with a and y pairs with b
		
		if(Driver.board[x1][y1] == Driver.P) {
	    	
    		//move forward left
    		if(x2 == x1 - a && y2 == y1 - b && Driver.board[x2][y2] == 0)
    	    		isLegalMove = true;
    		
    		//move forward right
    		if(x2 == x1 + a && y2 == y1 - b && Driver.board[x2][y2] == 0)
    	    		isLegalMove = true;
    		
    		//capture forward left
    		if(x2 == x1 - 2*a && y2 == y1 - 2*b && Driver.board[x1 - a][y1 - b] < 0) {
	    			isLegalMove = true;
	    			Driver.board[x1 - a][y1 - b] = 0;	//Piece is killed
    	    }
    		
    		//capture forward right
    		if(x2 == x1 + 2*a && y2 == y1 - 2*b && Driver.board[x1 + a][y1 - b] < 0) {
	    			isLegalMove = true;
	    			Driver.board[x1 + a][y1 - b] = 0;
    	    }
    	}
		
		if(isLegalMove)	{
			Driver.board[x2][y2] = Driver.board[x1][y1];
			Driver.board[x1][y1] = 0;
			
		}
		
		isLegalMove = false;
		
	}	//end of move() override
	
}
