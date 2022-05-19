package checkers_engine;

public class BlackKing extends BlackPiece {

	@Override
	public void move(int x1, int y1, int x2, int y2)	{
		
	if(Driver.board[x1][y1] == Driver.P) {
    	
		//move back left
		if(x2 == x1 - 1 && y2 == y1 - 1 && Driver.board[x2][y2] == 0)
	    		isLegalMove = true;
		
		//move back right
		if(x2 == x1 + 1 && y2 == y1 - 1 && Driver.board[x2][y2] == 0)
	    		isLegalMove = true;
		
		//capture back left
		if(x2 == x1 - 2 && y2 == y1 - 2 && Driver.board[x1 - 1][y1 - 1] < 0) {
    			isLegalMove = true;
    			Driver.board[x1 - 1][y1 - 1] = 0;	//Piece is killed
	    }
		
		//capture back right
		if(x2 == x1 + 2 && y2 == y1 - 2 && Driver.board[x1 + 1][y1 - 1] < 0) {
    			isLegalMove = true;
    			Driver.board[x1 + 1][y1 - 1] = 0;
	    }
	}
	
	super.move(x1, y1, x2, y2);
	
	}
	
	
}
