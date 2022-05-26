package checkers_engine;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Piece extends Frame	{

	protected JFrame f;
	
	protected boolean isLegalMove = false, again;
	
	protected int a = 1, 
			b = 1, 
			x, 
			y, 
			opp, 
			oppK;
	
	/*
	 * Use polymorphism so that certain pieces have exclusive movements
	 */
	
	/**
	 * Creates an option pane that asks the user if they want to make a second move
	 * 
	 * @return
	 */
	
	protected boolean prompt()	{
		
		boolean b = false;
		
		f = new JFrame();
		
		f.setVisible(true);
		
		int a = JOptionPane.OK_OPTION;

		if(JOptionPane.OK_OPTION == a)	{
			b = true;
		}
		
		return b;
	}
	
    public void move(int x1, int y1, int x2, int y2) {	//Will never be used due to always being overridden
    	//nothing lol
    }

	
}
