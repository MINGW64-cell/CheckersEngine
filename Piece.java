package checkers_engine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class Piece extends JFrame	{

	protected JFrame f;
	
	protected boolean isLegalMove = false, again = true, bool = false;
	
	protected int a = 1, 
			b = 1, 
			x, 
			y, 
			opp, 
			oppK;
	
	private boolean pressed;

	
	/*
	 * Use polymorphism so that certain pieces have exclusive movements
	 */
	
	/**
	 * Creates an option pane that asks the user if they want to make a second move
	 * 
	 * @return
	 */
	
	protected boolean prompt() {
		
		JFrame a = new JFrame("Hiii");
		a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		a.setLocationRelativeTo(null);
		a.setVisible(true);
		a.setSize(300,300);
		
		JPanel b = new JPanel();
		b.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 110));
		b.setBackground(Color.darkGray);
		
		a.add(b);
		
		JButton y = new JButton("Yes");
		b.add(y);
		JButton n = new JButton("No");
		b.add(n);
		
		//The buttons below don't seem to block
		while(!pressed)	{
			y.addActionListener(new ActionListener()	{
	
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					bool = true;
					pressed = true;
				}
			});
	
			n.addActionListener(new ActionListener()	{
	
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					bool = false;
					pressed = true;
				}
			});
		}
	
		return bool;	
	}	//end of prompt()
	
	
	
    public void move(int x1, int y1, int x2, int y2) {	//Will never be used due to always being overridden
    	//nothing lol
    }

	
}

