//This is the inheritance version of the OG CheckersEngine by Jouan

package checkers_engine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class CheckersEngine extends JPanel implements MouseListener, MouseMotionListener	{
	
	public static int mouseX1, mouseY1, mouseX2, mouseY2;
    public static int squareSize = 80;
    public static Color redPieceColor = Color.RED;
    public static Color blackPieceColor = Color.BLACK;
    public static Color redKingColor = Color.WHITE;
    public static Color blackKingColor = Color.WHITE;
    private static Piece p;

    public static boolean lastMoveRed = true; //Red is true, Black is false
    public static boolean gameOver = false;
    
    @Override
    public void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        this.setBackground(Color.LIGHT_GRAY);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
        for (int i = 0; i < 64; i += 2) {
            g.setColor(new Color(230, 230, 230));
            g.fillRect((i % 8 + (i / 8) % 2) * squareSize, (i / 8) * squareSize, squareSize, squareSize);
            g.setColor(new Color(150, 150, 150));
            g.fillRect(((i + 1) % 8 - ((i + 1) / 8) % 2) * squareSize, ((i + 1) / 8) * squareSize, squareSize, squareSize);
        }
    	        
/*    	        
        for(int i = 0; i < 64; i++) {
        	
        	if(Driver.board[i / 8][i % 8] > 0) {
        		g.setColor(Color.RED);
        		g.fillOval((i % 8) * squareSize, (i / 8) * squareSize, squareSize, squareSize);
        		
        		if(Driver.board[i / 8][i % 8] == Driver.redKingValue) {
        			g.setColor(Color.BLACK);
	        		
	        		int offSetX = squareSize * (i % 8);
	        		int offSetY = squareSize * (i / 8);   	        
	        
	        		g.fillPolygon(new int[] {offSetX + squareSize / 5, offSetX + squareSize / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 13 / 20, offSetX + squareSize / 2, offSetX + squareSize * 7 / 20}, 
	        		new int[] {offSetY + squareSize / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize / 5, offSetY + squareSize / 2, offSetY + squareSize / 5, offSetY + squareSize / 2}, 7);
	        	
        		}
        	}
        	
        	if(Driver.board[i / 8][i % 8] < 0) {
        		g.setColor(Color.BLACK);
        		g.fillOval((i % 8) * squareSize, (i / 8) * squareSize, squareSize, squareSize);
        		
        		if(Driver.board[i / 8][i % 8] == Driver.blackKingValue) {
        			g.setColor(Color.WHITE);
	        		
	        		int offSetX = squareSize * (i % 8);
	        		int offSetY = squareSize * (i / 8);   	        
	        
	        		g.fillPolygon(new int[] {offSetX + squareSize / 5, offSetX + squareSize / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 13 / 20, offSetX + squareSize / 2, offSetX + squareSize * 7 / 20}, 
	        		new int[] {offSetY + squareSize / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize / 5, offSetY + squareSize / 2, offSetY + squareSize / 5, offSetY + squareSize / 2}, 7);
	        	
        		}
        		
        		
        	}
        	
        }
*/
    	        
        for(int x = 0; x < 8; x++) {
        	
        	for(int y = 0; y < 8; y++) {
        	
	        	if(Driver.board[x][y] > 0) {
	        		g.setColor(redPieceColor);
	        		g.fillOval(x * squareSize, y * squareSize, squareSize, squareSize);
	        		
	        		if(Driver.board[x][y] == Driver.redKingValue) {
	        			g.setColor(redKingColor);
    	        		
    	        		int offSetX = squareSize * x;
    	        		int offSetY = squareSize * y;   	        
    	        
    	        		g.fillPolygon(new int[] {offSetX + squareSize / 5, offSetX + squareSize / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 13 / 20, offSetX + squareSize / 2, offSetX + squareSize * 7 / 20}, 
    	        		new int[] {offSetY + squareSize / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize / 5, offSetY + squareSize / 2, offSetY + squareSize / 5, offSetY + squareSize / 2}, 7);
    	        	
	        		}
	        		
	        		}
        	
	        	if(Driver.board[x][y] < 0) {
	        		g.setColor(blackPieceColor);
	        		g.fillOval(x * squareSize, y * squareSize, squareSize, squareSize);
	        		
	        		if(Driver.board[x][y] == Driver.blackKingValue) {
	        			g.setColor(blackKingColor);
    	        		
    	        		int offSetX = squareSize * x;
    	        		int offSetY = squareSize * y;   	        
    	        
    	        		g.fillPolygon(new int[] {offSetX + squareSize / 5, offSetX + squareSize / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 13 / 20, offSetX + squareSize / 2, offSetX + squareSize * 7 / 20}, 
    	        		new int[] {offSetY + squareSize / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize / 5, offSetY + squareSize / 2, offSetY + squareSize / 5, offSetY + squareSize / 2}, 7);
	        		}		
	        	}
        	}
        }	
    }
    
    public static void move(int x1, int y1, int x2, int y2)	{
    	
    	int a = Driver.board[x1][y1];
    	
    	if(a == 1 || a == -1)
    		p = new Pawn();
    	else if(a == 3 || a == -3)
    		p = new King();
    	    	
    	p.move(x1, y1, x2, y2);
    	
    	//promotion
    	for(int i = 0; i < 8; i++) {
    		if(Driver.board[i][0] == 1) {
    			Driver.board[i][0] = 3;
    		}
    		if(Driver.board[i][7] == -1) {
    			Driver.board[i][7] = -3;
    		}
    	}
    	
    }	//End of move method
    	
    
    public void winner()	{
    	//do this if no more of the color left
    	String winner;
    	boolean noRed = true;
    	boolean noBlack = true;
    	for(int i = 0; i < Driver.board.length; i++) {
    		for(int j = 0; j < Driver.board[0].length; j++) {
    			if(Driver.board[i][j] > 0) {
    				noRed = false;
    			}
    			if(Driver.board[i][j] < 0) {
    				noBlack = false;
    			}
    		}
    	}
    	if(noRed && !gameOver) {
    		JOptionPane.showMessageDialog(null, "The Winner Is: BLACK");
    		gameOver = true;
    	}
    	else if(noBlack && !gameOver) {
    		JOptionPane.showMessageDialog(null, "The Winner Is: RED");
    		gameOver = true;
    	}
    	
    }
    
    public static void printBoard(int[][] board) {
		for(int i = 0; i < board.length; i++) {
			
			System.out.print("|");
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(board[i][j] + "|");
			}
			System.out.println();
		}
		System.out.println();
	}
    
    public void update() {
    	
    }
    
    
//ignore all code below (Special methods one shouldn't mess with [unless the person in question is Jouan])
    
    
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getX() < 8 * squareSize && e.getY() < 8 * squareSize) {
         
            mouseX1 = e.getX();
            mouseY1 = e.getY();
            repaint();
            System.out.println("(mouseX1, mouseY1): (" + mouseX1 + ", " + mouseY1 + ")");
            
        }
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getX() < 8 * squareSize && e.getY() < 8 * squareSize) { 
           
            mouseX2 = e.getX();
            mouseY2 = e.getY();
            System.out.println("(mouseX2, mouseY2): (" + mouseX2 + ", " + mouseY2 + ")");
            
            move(mouseX1/squareSize, mouseY1/squareSize, mouseX2/squareSize, mouseY2/squareSize);
            
            System.out.println(lastMoveRed);
            printBoard(Driver.flipXY(Driver.board));
            
            repaint();
            
            return;
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}



