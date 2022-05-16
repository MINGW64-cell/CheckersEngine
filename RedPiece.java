package checkers_engine;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class RedPiece extends Piece{
	
	@Override
	public void move(int x1, int y1, int x2, int y2) {
		
		int a = 1;
		
		//move front left
		
		if(Driver.board[x1][y1] == Driver.P) {
	    	
    		//move forward left
    		if(x2 == x1 - 1 && y2 == y1 - 1 && Driver.board[x2][y2] == 0)
    	    		isLegalMove = true;
    		
    		//move forward right
    		if(x2 == x1 + 1 && y2 == y1 - 1 && Driver.board[x2][y2] == 0)
    	    		isLegalMove = true;
    		
    		//capture forward left
    		if(x2 == x1 - 2 && y2 == y1 - 2 && Driver.board[x1 - 1][y1 - 1] < 0) {
	    			isLegalMove = true;
	    			Driver.board[x1 - 1][y1 - 1] = 0;	//Piece is killed
    	    }
    		
    		//capture forward right
    		if(x2 == x1 + 2 && y2 == y1 - 2 && Driver.board[x1 + 1][y1 - 1] < 0) {
	    			isLegalMove = true;
	    			Driver.board[x1 + 1][y1 - 1] = 0;
    	    }
    	}
		
		if(isLegalMove)	{
			Driver.board[x2][y2] = Driver.board[x1][y1];
			Driver.board[x1][y1] = 0;
			
		}
		
		isLegalMove = false;
		
	}	//end of move() override
	
}
