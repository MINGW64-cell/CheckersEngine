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

	
	/*
	 * Use polymorphism so that certain pieces have exclusive movements
	 */
	
	/**
	 * Creates an option pane that asks the user if they want to make a second move
	 * 
	 * @return
	 */
	
	protected boolean prompt()	{	//Work on this (Done on 6/6/2022)
		
		f = new JFrame("Capture Again?");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setSize(500,500);
		
		JPanel p = new JPanel();		//Button work started
		
		JButton y = new JButton("Yes"), n = new JButton("No");	
		f.add(y);
		f.add(n);
		
		p.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		f.add(p, BorderLayout.SOUTH);
			
		f.setVisible(true);
		
		y.addActionListener(new ActionListener()	{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				bool = true;
			}	
		});	
		
		n.addActionListener(new ActionListener()	{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				bool = false;
			}	
		});	//End of addActionListener for button y
		
		return bool;
	}	//End of prompt()
	
	
	
    public void move(int x1, int y1, int x2, int y2) {	//Will never be used due to always being overridden
    	//nothing lol
    }

	
}
