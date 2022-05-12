package checkers_engine;

import java.util.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Driver {
	

//	public static ArrayList<Integer> redPieces = new ArrayList<Integer>();
//	public static ArrayList<Integer> blackPieces = new ArrayList<Integer>();
	
	public static int kingValue = 3;
	public static int pawnValue = 1;
	
	public static int P = pawnValue;
	public static int p = pawnValue * -1;
	public static int K = kingValue;
	public static int k = kingValue * -1;
	
	public static int redKingValue = K;
	public static int blackKingValue = k;
	
    public static boolean lastMoveRed = true; //Red is true, Black is false
	
	public static int[][] board = new int[][]{
		{0, p, 0, 0, 0, P, 0, P},
		{p, 0, p, 0, 0, 0, P, 0},
		{0, p, 0, 0, 0, P, 0, P},
		{p, 0, p, 0, 0, 0, P, 0},
		{0, p, 0, 0, 0, P, 0, P},
		{p, 0, p, 0, 0, 0, P, 0},
		{0, p, 0, 0, 0, P, 0, P},
		{p, 0, p, 0, 0, 0, P, 0},		
	};

	//probably useless
	public static int[][] flipXY(int[][] board) {
		int[][] newBoard = new int[8][8];
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				newBoard[i][j] = board[j][i];
		return newBoard;
	}
	
	public static void main(String[] args) {

		/*
		for(int i = 0; i < 4; i++) {
			redPieces.add(i * 20);
			redPieces.add(i * 20 + 2);
			redPieces.add(i * 20 + 11);
			blackPieces.add(i * 20 + 6);
			blackPieces.add(i * 20 + 15);
			blackPieces.add(i * 20 + 17);
		}
		*/
		
		JFrame f = new JFrame("checkers_engine");
		
		f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
		
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    CheckersEngine ui = new CheckersEngine();
	    f.add(ui);
	    f.setSize(CheckersEngine.squareSize * 8, CheckersEngine.squareSize * 8 + 30);
	    f.setVisible(true);
	    
/*	    while(true){
            PointerInfo a = MouseInfo.getPointerInfo();
            Point b = a.getLocation();
            int x = (int) b.getX();
            int y = (int) b.getY();

            System.out.println(x);
            System.out.println(y);
        }
*/
	    
	
	    
	    
	}
	
	public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked");  
        }
	
	public void pawn(boolean isRed, int x, int y) {
    	
    }
}


