package checkers_engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Piece {

	protected JFrame f;
	protected boolean isLegalMove = false;
	protected static int a = 1, b = 1;
	Scanner s = new Scanner(System.in);
	
	/*
	 * Use polymorphism so that certain pieces have exclusive movements
	 */
	
	protected void OtherPrompt()	{
		
		System.out.println("Move Again?");
		
		boolean b = s.nextBoolean();
		
		if(b)	{
			
		}
		
	}
	
	protected void prompt()	{
		f = new JFrame();
		
		f.setVisible(true);
	}
	
    public void move(int x1, int y1, int x2, int y2) {	//Will never be used due to always being overridden
    	
    	if(Driver.board[x2+a][y2-a] > 0 || Driver.board[x2-a][y2-a] > 0)	{
    		prompt();
    	}
    		
    	
    }
    
    protected static void reverseAB()	{
    	if(Driver.isBlackTurn())	{
    		a = -a;
	    	b = -b;
    	}
    }

	
}
