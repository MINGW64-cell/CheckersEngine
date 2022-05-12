package checkers_engine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckersEngine extends JPanel implements MouseListener, MouseMotionListener{
	
	public static int x1, y1, x2, y2;
    public static int squareSize = 80;
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
	        		g.setColor(Color.RED);
	        		g.fillOval(x * squareSize, y * squareSize, squareSize, squareSize);
	        		
	        		if(Driver.board[x][y] == Driver.redKingValue) {
	        			g.setColor(Color.ORANGE);
    	        		
    	        		int offSetX = squareSize * x;
    	        		int offSetY = squareSize * y;   	        
    	        
    	        		g.fillPolygon(new int[] {offSetX + squareSize / 5, offSetX + squareSize / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 13 / 20, offSetX + squareSize / 2, offSetX + squareSize * 7 / 20}, 
    	        		new int[] {offSetY + squareSize / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize / 5, offSetY + squareSize / 2, offSetY + squareSize / 5, offSetY + squareSize / 2}, 7);
    	        	
	        		}
	        		
	        		}
        	
	        	if(Driver.board[x][y] < 0) {
	        		g.setColor(Color.BLACK);
	        		g.fillOval(x * squareSize, y * squareSize, squareSize, squareSize);
	        		
	        		if(Driver.board[x][y] == Driver.blackKingValue) {
	        			g.setColor(Color.WHITE);
    	        		
    	        		int offSetX = squareSize * x;
    	        		int offSetY = squareSize * y;   	        
    	        
    	        		g.fillPolygon(new int[] {offSetX + squareSize / 5, offSetX + squareSize / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 13 / 20, offSetX + squareSize / 2, offSetX + squareSize * 7 / 20}, 
    	        		new int[] {offSetY + squareSize / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize / 5, offSetY + squareSize / 2, offSetY + squareSize / 5, offSetY + squareSize / 2}, 7);
    	        	
	        		}		
	        		
	        	}
        	}
        	
        }
    		
    	        	
    	        	
    	        
/*    	        
        for(int i = 0; i < Driver.redPieces.size(); i++) {
        	g.setColor(Color.RED);
        	g.fillOval(Driver.redPieces.get(i)/10 * squareSize, (7 - Driver.redPieces.get(i) % 10) * squareSize, squareSize, squareSize); // X right, Y down, Diameter, Diameter
        	if(Driver.redPieces.get(i)/100 > -1) {
        		g.setColor(Color.BLACK);
        		
        		int offSetX = squareSize * (int)((Driver.redPieces.get(i)) / 10);
        		int offSetY = squareSize * (int)(7 - Driver.redPieces.get(i) % 10);    	        
        
        		g.fillPolygon(new int[] {offSetX + squareSize / 5, offSetX + squareSize / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 13 / 20, offSetX + squareSize / 2, offSetX + squareSize * 7 / 20}, 
        		new int[] {offSetY + squareSize / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize / 5, offSetY + squareSize / 2, offSetY + squareSize / 5, offSetY + squareSize / 2}, 7);
        	}

        }
        
        
        for(int i = 0; i < Driver.blackPieces.size(); i++) {
        	g.setColor(Color.BLACK);
        	g.fillOval(Driver.blackPieces.get(i)/10 * squareSize, (7 - Driver.blackPieces.get(i) % 10) * squareSize, squareSize, squareSize); // X right, Y down, Diameter, Diameter
        	if(Driver.blackPieces.get(i)/100 > -1) {
        		g.setColor(Color.WHITE);
        		
        		int offSetX = squareSize * (int)((Driver.blackPieces.get(i)) / 10);
        		int offSetY = squareSize * (int)(7 - Driver.blackPieces.get(i) % 10);    	        
        
        		g.fillPolygon(new int[] {offSetX + squareSize / 5, offSetX + squareSize / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 13 / 20, offSetX + squareSize / 2, offSetX + squareSize * 7 / 20}, 
        		new int[] {offSetY + squareSize / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize / 5, offSetY + squareSize / 2, offSetY + squareSize / 5, offSetY + squareSize / 2}, 7);
        	}
        }	
*/
	        
//    	int offSetX = squareSize*4;
//    	int offSetY = squareSize*4;
	        
	        
//    	g.fillPolygon(new int[] {offSetX + squareSize / 5, offSetX + squareSize / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 4 / 5, offSetX + squareSize * 13 / 20, offSetX + squareSize / 2, offSetX + squareSize * 7 / 20}, 
//    	     new int[] {offSetY + squareSize / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize * 4 / 5, offSetY + squareSize / 5, offSetY + squareSize / 2, offSetY + squareSize / 5, offSetY + squareSize / 2}, 7);

	        
    
    }
    
    public static void move(int xx1, int yy1, int xx2, int yy2) {
    	
    	
    	boolean isLegalMove = false;
    	
    	/*
    	 * FR_2|____|____|____|FL_2
    	 * ____|FR_1|____|FL_1|____
    	 * ____|____|ORIG|____|____
    	 * ____|BL_1|____|BR_1|____
    	 * BL_2|____|____|____|BR_2
    	 */
    	
	    //preconditions met?
    	if(!Driver.lastMoveRed) {
	    	//Red Piece
	    	if(Driver.board[xx1][yy1] == Driver.P) {
	    	
	    		//move forward left
	    		if(xx2 == xx1 - 1 && yy2 == yy1 - 1) {
	    	    	if(Driver.board[xx2][yy2] == 0) {
	    	    		isLegalMove = true;
	    	    	}
	    	    }
	    		
	    		//move forward right
	    		if(xx2 == xx1 + 1 && yy2 == yy1 - 1) {
	    			if(Driver.board[xx2][yy2] == 0) {
	    	    		isLegalMove = true;
	    	    	}
	    	    }
	    		
	    		//capture forward left
	    		if(xx2 == xx1 - 2 && yy2 == yy1 - 2) {
		    		if(Driver.board[xx1 - 1][yy1 - 1] < 0) {
		    			isLegalMove = true;
		    			Driver.board[xx1 - 1][yy1 - 1] = 0;
		    		}
	    	    }
	    		
	    		//capture forward right
	    		if(xx2 == xx1 + 2 && yy2 == yy1 - 2) {
	    			if(Driver.board[xx1 + 1][yy1 - 1] < 0) {
		    			isLegalMove = true;
		    			Driver.board[xx1 + 1][yy1 - 1] = 0;
		    		}
	    	    }
	    	}
	    	
	    	//Red King
	    	if(Driver.board[xx1][yy1] == Driver.K) {
	    		
	    		//move forward left
	    		if(xx2 == xx1 - 1 && yy2 == yy1 - 1) {
	    	    	if(Driver.board[xx2][yy2] == 0) {
	    	    		isLegalMove = true;
	    	    	}
	    	    }
	    		
	    		//move forward right
	    		if(xx2 == xx1 + 1 && yy2 == yy1 - 1) {
	    			if(Driver.board[xx2][yy2] == 0) {
	    	    		isLegalMove = true;
	    	    	}
	    	    }
	    		
	    		//capture forward left
	    		if(xx2 == xx1 - 2 && yy2 == yy1 - 2) {
		    		if(Driver.board[xx1 - 1][yy1 - 1] < 0) {
		    			isLegalMove = true;
		    			Driver.board[xx1 - 1][yy1 - 1] = 0;
		    		}
	    	    }
	    		
	    		//capture forward right
	    		if(xx2 == xx1 + 2 && yy2 == yy1 - 2) {
	    			if(Driver.board[xx1 + 1][yy1 - 1] < 0) {
		    			isLegalMove = true;
		    			Driver.board[xx1 + 1][yy1 - 1] = 0;
		    		}
	    	    }
	    		
	    		//move backwards left
	    		if(xx2 == xx1 - 1 && yy2 == yy1 + 1) {
		    		if(Driver.board[xx2][yy2] == 0) {
		    			isLegalMove = true;
		    		}
	    	    }
	    		
	    		//move backwards right
	    		if(xx2 == xx1 + 1 && yy2 == yy1 + 1) {
	    			if(Driver.board[xx2][yy2] == 0) {
		    			isLegalMove = true;
		    		}	
	    	    }
	    		
	    		//capture backwards left
	    		if(xx2 == xx1 - 2 && yy2 == yy1 + 2) {
	    			if(Driver.board[xx1 - 1][yy1 + 1] < 0) {
		    			isLegalMove = true;
		    			Driver.board[xx1 - 1][yy1 + 1] = 0;
		    		}
	    	    }
	    		
	    		//capture backwards right
	    		if(xx2 == xx1 + 2 && yy2 == yy1 + 2) {
	    			if(Driver.board[xx1 + 1][yy1 + 1] < 0) {
		    			isLegalMove = true;
		    			Driver.board[xx1 + 1][yy1 + 1] = 0;
		    		}
	    	    }
	    		
	    	}
    	
    	Driver.lastMoveRed = true;
    	
    	}
    	
    	
    	if(Driver.lastMoveRed) {
    		
	    	//Black Piece
	    	if(Driver.board[xx1][yy1] == Driver.p) {
	        	
	    		//move backwards left
	    		if(xx2 == xx1 - 1 && yy2 == yy1 + 1) {
		    		if(Driver.board[xx2][yy2] == 0) {
		    			isLegalMove = true;
		    		}
	    	    }
	    		
	    		//move backwards right
	    		if(xx2 == xx1 + 1 && yy2 == yy1 + 1) {
	    			if(Driver.board[xx2][yy2] == 0) {
		    			isLegalMove = true;
		    		}	
	    	    }
	    		
	    		//capture backwards left
	    		if(xx2 == xx1 - 2 && yy2 == yy1 + 2) {
	    			if(Driver.board[xx1 - 1][yy1 + 1] > 0) {
		    			isLegalMove = true;
		    			Driver.board[xx1 - 1][yy1 + 1] = 0;
		    		}
	    	    }
	    		
	    		//capture backwards right
	    		if(xx2 == xx1 + 2 && yy2 == yy1 + 2) {
	    			if(Driver.board[xx1 + 1][yy1 + 1] > 0) {
		    			isLegalMove = true;
		    			Driver.board[xx1 + 1][yy1 + 1] = 0;
		    		}
	    	    }	
	    	}
	    	
	    	//Black King
	    	if(Driver.board[xx1][yy1] == Driver.k) {
	        	
	    		//move forward left
	    		if(xx2 == xx1 - 1 && yy2 == yy1 - 1) {
	    	    	if(Driver.board[xx2][yy2] == 0) {
	    	    		isLegalMove = true;
	    	    	}
	    	    }
	    		
	    		//move forward right
	    		if(xx2 == xx1 + 1 && yy2 == yy1 - 1) {
	    			if(Driver.board[xx2][yy2] == 0) {
	    	    		isLegalMove = true;
	    	    	}
	    	    }
	    		
	    		//capture forward left
	    		if(xx2 == xx1 - 2 && yy2 == yy1 - 2) {
		    		if(Driver.board[xx1 - 1][yy1 - 1] > 0) {
		    			isLegalMove = true;
		    			Driver.board[xx1 - 1][yy1 - 1] = 0;
		    		}
	    	    }
	    		
	    		//capture forward right
	    		if(xx2 == xx1 + 2 && yy2 == yy1 - 2) {
	    			if(Driver.board[xx1 + 1][yy1 - 1] > 0) {
		    			isLegalMove = true;
		    			Driver.board[xx1 + 1][yy1 - 1] = 0;
		    		}
	    	    }
	    		
	    		//move backwards left
	    		if(xx2 == xx1 - 1 && yy2 == yy1 + 1) {
		    		if(Driver.board[xx2][yy2] == 0) {
		    			isLegalMove = true;
		    		}
	    	    }
	    		
	    		//move backwards right
	    		if(xx2 == xx1 + 1 && yy2 == yy1 + 1) {
	    			if(Driver.board[xx2][yy2] == 0) {
		    			isLegalMove = true;
		    		}	
	    	    }
	    		
	    		//capture backwards left
	    		if(xx2 == xx1 - 2 && yy2 == yy1 + 2) {
	    			if(Driver.board[xx1 - 1][yy1 + 1] > 0) {
		    			isLegalMove = true;
		    			Driver.board[xx1 - 1][yy1 + 1] = 0;
		    		}
	    	    }
	    		
	    		//capture backwards right
	    		if(xx2 == xx1 + 2 && yy2 == yy1 + 2) {
	    			if(Driver.board[xx1 + 1][yy1 + 1] > 0) {
		    			isLegalMove = true;
		    			Driver.board[xx1 + 1][yy1 + 1] = 0;
		    		}
	    	    }	
	    	}
    	
	    Driver.lastMoveRed = false;
	    	
    	}
    	
	    if(isLegalMove) {	
	    	//moving
	    	if(Driver.board[xx1][yy1] != 0) {
	    		Driver.board[xx2][yy2] = Driver.board[xx1][yy1];
	    		Driver.board[xx1][yy1] = 0;
	    	}
	    }
	    	
	    	//promotion
	    	for(int i = 0; i < 8; i++) {
	    		if(Driver.board[i][0] == 1) {
	    			Driver.board[i][0] = 3;
	    		}
	    		if(Driver.board[i][7] == -1) {
	    			Driver.board[i][7] = -3;
	    		}
	    	}
    }
/*    
    public static void move(int xx1, int yy1, int xx2, int yy2) {
    	
    	if(Driver.board[yy1][xx1] != 0) {
    		Driver.board[yy2][xx2] = Driver.board[yy1][xx1];
    		Driver.board[yy1][xx1] = 0;
    	}
    }
*/
    
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
         
            x1 = e.getX();
            y1 = e.getY();
            repaint();
            System.out.println("(x1, y1): (" + x1 + ", " + y1 + ")");
            
        }
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getX() < 8 * squareSize && e.getY() < 8 * squareSize) { 
           
            x2 = e.getX();
            y2 = e.getY();
            System.out.println("(x2, y2): (" + x2 + ", " + y2 + ")");
            
            move(x1/squareSize, y1/squareSize, x2/squareSize, y2/squareSize);
            
            System.out.println(Driver.lastMoveRed);
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
