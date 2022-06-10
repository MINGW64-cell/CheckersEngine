package checkers_engine2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class CheckersEngine extends JPanel implements MouseListener, MouseMotionListener{
	
	public static int mouseX1, mouseY1, mouseX2, mouseY2;
    public static int squareSize = 80;
    public static Color lightSquareColor = new Color(230, 230, 230);
    public static Color darkSquareColor = new Color(150, 150, 150);
    
    public static Color redPieceColor = new Color(200, 0, 0);
    public static Color blackPieceColor = Color.BLACK;
    public static Color redKingColor = Color.WHITE;
    public static Color blackKingColor = Color.WHITE;

    public static boolean lastMoveRed = true; //Red is true, Black is false
    public static boolean gameOver = false;
    public static boolean bool = true;
    
    public static int[] bestMove = {0, 0, 0, 0};
    public static int bestX1 = 0;
    public static int bestY1 = 0;
    public static int bestX2 = 0;
    public static int bestY2 = 0;
    
    @Override
    public void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        this.setBackground(Color.LIGHT_GRAY);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
        for (int i = 0; i < 64; i += 2) {
            g.setColor(lightSquareColor);
            g.fillRect((i % 8 + (i / 8) % 2) * squareSize, (i / 8) * squareSize, squareSize, squareSize);
            g.setColor(darkSquareColor);
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
    
    public static void move(int x1, int y1, int x2, int y2) {
    	
    	int deleteX = 0;
    	int deleteY = 0;
    	
    	boolean isLegalMove = false;
    	
    	/*
    	 * FR_2|____|____|____|FL_2
    	 * ____|FR_1|____|FL_1|____
    	 * ____|____|ORIG|____|____
    	 * ____|BL_1|____|BR_1|____
    	 * BL_2|____|____|____|BR_2
    	 */
    	
	    //preconditions met?
    
	    	//Red Piece
	    	if(Driver.board[x1][y1] == Driver.P) {
	    	
	    		//move forward left
	    		if(x2 == x1 - 1 && y2 == y1 - 1) {
	    	    	if(Driver.board[x2][y2] == 0) {
	    	    		isLegalMove = true;
	    	    	}
	    	    }
	    		
	    		//move forward right
	    		if(x2 == x1 + 1 && y2 == y1 - 1) {
	    			if(Driver.board[x2][y2] == 0) {
	    	    		isLegalMove = true;
	    	    	}
	    	    }
	    		
	    		//capture forward left
	    		if(x2 == x1 - 2 && y2 == y1 - 2) {
		    		if(Driver.board[x1 - 1][y1 - 1] < 0) {
		    			isLegalMove = true;
		    			deleteX = x1 - 1;
		    			deleteY = y1 - 1;
		    		}
	    	    }
	    		
	    		//capture forward right
	    		if(x2 == x1 + 2 && y2 == y1 - 2) {
	    			if(Driver.board[x1 + 1][y1 - 1] < 0) {
		    			isLegalMove = true;
		    			deleteX = x1 + 1;
		    			deleteY = y1 - 1;
		    		}
	    	    }
	    	}
	    	
	    	//Red King
	    	if(Driver.board[x1][y1] == Driver.K) {
	    		
	    		//move forward left
	    		if(x2 == x1 - 1 && y2 == y1 - 1) {
	    	    	if(Driver.board[x2][y2] == 0) {
	    	    		isLegalMove = true;
	    	    	}
	    	    }
	    		
	    		//move forward right
	    		if(x2 == x1 + 1 && y2 == y1 - 1) {
	    			if(Driver.board[x2][y2] == 0) {
	    	    		isLegalMove = true;
	    	    	}
	    	    }
	    		
	    		//capture forward left
	    		if(x2 == x1 - 2 && y2 == y1 - 2) {
		    		if(Driver.board[x1 - 1][y1 - 1] < 0) {
		    			isLegalMove = true;
		    			deleteX = x1 - 1;
		    			deleteY = y1 - 1;
		    		}
	    	    }
	    		
	    		//capture forward right
	    		if(x2 == x1 + 2 && y2 == y1 - 2) {
	    			if(Driver.board[x1 + 1][y1 - 1] < 0) {
		    			isLegalMove = true;
		    			deleteX = x1 + 1;
		    			deleteY = y1 - 1;
		    		}
	    	    }
	    		
	    		//move backwards left
	    		if(x2 == x1 - 1 && y2 == y1 + 1) {
		    		if(Driver.board[x2][y2] == 0) {
		    			isLegalMove = true;
		    		}
	    	    }
	    		
	    		//move backwards right
	    		if(x2 == x1 + 1 && y2 == y1 + 1) {
	    			if(Driver.board[x2][y2] == 0) {
		    			isLegalMove = true;
		    		}	
	    	    }
	    		
	    		//capture backwards left
	    		if(x2 == x1 - 2 && y2 == y1 + 2) {
	    			if(Driver.board[x1 - 1][y1 + 1] < 0) {
		    			isLegalMove = true;
		    			deleteX = x1 - 1;
		    			deleteY = y1 + 1;
		    		}
	    	    }
	    		
	    		//capture backwards right
	    		if(x2 == x1 + 2 && y2 == y1 + 2) {
	    			if(Driver.board[x1 + 1][y1 + 1] < 0) {
		    			isLegalMove = true;
		    			deleteX = x1 + 1;
		    			deleteY = y1 + 1;
		    		}
	    	    }
	    		
	    	}
    	
    	
    	
    	
    
    		
	    	//Black Piece
	    	if(Driver.board[x1][y1] == Driver.p) {
	        	
	    		//move backwards left
	    		if(x2 == x1 - 1 && y2 == y1 + 1) {
		    		if(Driver.board[x2][y2] == 0) {
		    			isLegalMove = true;
		    		}
	    	    }
	    		
	    		//move backwards right
	    		if(x2 == x1 + 1 && y2 == y1 + 1) {
	    			if(Driver.board[x2][y2] == 0) {
		    			isLegalMove = true;
		    		}	
	    	    }
	    		
	    		//capture backwards left
	    		if(x2 == x1 - 2 && y2 == y1 + 2) {
	    			if(Driver.board[x1 - 1][y1 + 1] > 0) {
		    			isLegalMove = true;
		    			deleteX = x1 - 1;
		    			deleteY = y1 + 1;
		    		}
	    	    }
	    		
	    		//capture backwards right
	    		if(x2 == x1 + 2 && y2 == y1 + 2) {
	    			if(Driver.board[x1 + 1][y1 + 1] > 0) {
		    			isLegalMove = true;
		    			deleteX = x1 + 1;
		    			deleteY = y1 + 1;
		    		}
	    	    }	
	    	}
	    	
	    	//Black King
	    	if(Driver.board[x1][y1] == Driver.k) {
	        	
	    		//move forward left
	    		if(x2 == x1 - 1 && y2 == y1 - 1) {
	    	    	if(Driver.board[x2][y2] == 0) {
	    	    		isLegalMove = true;
	    	    	}
	    	    }
	    		
	    		//move forward right
	    		if(x2 == x1 + 1 && y2 == y1 - 1) {
	    			if(Driver.board[x2][y2] == 0) {
	    	    		isLegalMove = true;
	    	    	}
	    	    }
	    		
	    		//capture forward left
	    		if(x2 == x1 - 2 && y2 == y1 - 2) {
		    		if(Driver.board[x1 - 1][y1 - 1] > 0) {
		    			isLegalMove = true;
		    			deleteX = x1 - 1;
		    			deleteY = y1 - 1;
		    		}
	    	    }
	    		
	    		//capture forward right
	    		if(x2 == x1 + 2 && y2 == y1 - 2) {
	    			if(Driver.board[x1 + 1][y1 - 1] > 0) {
		    			isLegalMove = true;
		    			deleteX = x1 + 1;
		    			deleteY = y1 - 1;
		    		}
	    	    }
	    		
	    		//move backwards left
	    		if(x2 == x1 - 1 && y2 == y1 + 1) {
		    		if(Driver.board[x2][y2] == 0) {
		    			isLegalMove = true;
		    		}
	    	    }
	    		
	    		//move backwards right
	    		if(x2 == x1 + 1 && y2 == y1 + 1) {
	    			if(Driver.board[x2][y2] == 0) {
		    			isLegalMove = true;
		    		}	
	    	    }
	    		
	    		//capture backwards left
	    		if(x2 == x1 - 2 && y2 == y1 + 2) {
	    			if(Driver.board[x1 - 1][y1 + 1] > 0) {
		    			isLegalMove = true;
		    			deleteX = x1 - 1;
		    			deleteY = y1 + 1;
		    		}
	    	    }
	    		
	    		//capture backwards right
	    		if(x2 == x1 + 2 && y2 == y1 + 2) {
	    			if(Driver.board[x1 + 1][y1 + 1] > 0) {
		    			isLegalMove = true;
		    			deleteX = x1 + 1;
		    			deleteY = y1 + 1;
		    		}
	    	    }	
	    	}

//    	deleteX = 0;
//    	deleleY = 0;
    	
	    if(isLegalMove) {
	    	
	    	/* 
	    	 * if (isRedMove && the piece that's moving is red
	    	 * or if isBlackMove && the piece that's moving is black)
	    	 */
	    	
	    	//moving
	    	if(lastMoveRed == (Driver.board[x1][y1] > 0)) {
	    		
//	    	if(lastMoveRed == true && Driver.board[x1][y1] > 0)	{
		    	if(Driver.board[x1][y1] != 0) {
		    		Driver.board[x2][y2] = Driver.board[x1][y1]; //swap
		    		Driver.board[x1][y1] = 0;
		    		
		    		Driver.board[deleteX][deleteY] = 0;
		    		
		    		lastMoveRed = !lastMoveRed;
		    		
		        	String moveList = AI.possibleMoves(Driver.board);
		        	
		        	if(!gameOver && moveList.length() == 0) {
		        		JOptionPane.showMessageDialog(null, "The Winner Is: RED");
		        		gameOver = true;
		        		return;
		        	}
		        	
		    	    AI.makeBestMove(moveList);       	
		    		Driver.board[bestMove[2]][bestMove[3]] = Driver.board[bestMove[0]][bestMove[1]];
		    		Driver.board[bestMove[0]][bestMove[1]] = 0;
		    	    lastMoveRed = !lastMoveRed;
		    		
//		    	    thisBetterWork(moveList);
//		    		lastMoveRed = !lastMoveRed;
		    	    
//		    	    Driver.board[bestX2][bestY2] = Driver.board[bestX1][bestY1];
//		    		Driver.board[bestX1][bestY1] = 0;
		    	    

		    		if(bestMove[0] + 2 == bestMove[2] && bestMove[1] + 2 == bestMove[3]) {
		    			Driver.board[bestMove[0] + 1][bestMove[1] + 1] = 0;
		    		}
		    		if(bestMove[0] + 2 == bestMove[2] && bestMove[1] - 2 == bestMove[3]) {
		    			Driver.board[bestMove[0] + 1][bestMove[1] - 1] = 0;
		    		}
		    		if(bestMove[0] - 2 == bestMove[2] && bestMove[1] + 2 == bestMove[3]) {
		    			Driver.board[bestMove[0] - 1][bestMove[1] + 1] = 0;
		    		}
		    		if(bestMove[0] - 2 == bestMove[2] && bestMove[1] - 2 == bestMove[3]) {
		    			Driver.board[bestMove[0] - 1][bestMove[1] - 1] = 0;
		    		}
		    	    

		    		
		    	}
	    	}
	    }
	    	
    	//promotion
    	for(int i = 0; i < 8; i++) {
    		if(Driver.board[i][0] == Driver.P) {
    			Driver.board[i][0] = Driver.K;
    		}
    		if(Driver.board[i][7] == Driver.p) {
    			Driver.board[i][7] = Driver.k;
    		}
    	}
    	
    	
    	
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
    	
    	
    	boolean aaaa = true;
    	
    	if(aaaa) {
//    		String moveList = AI.possibleMoves(Driver.board);
    	
//    		AI.makeBestMove(moveList); 	
//    		lastMoveRed = !lastMoveRed;
    	
    		aaaa = false;
    	}
    	
    }
    
    
/*    
    public static void move(int x1, int y1, int x2, int y2) {
    	
    	if(Driver.board[y1][x1] != 0) {
    		Driver.board[y2][x2] = Driver.board[y1][x1];
    		Driver.board[y1][x1] = 0;
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
		int[][] visBoard = board;
		System.out.println("POSSIBLE MOVES: " + AI.possibleMoves(Driver.board));
		System.out.println("EVALUATION: " + AI.evaluate2(Driver.board));
		System.out.println("BEST MOVE: " + bestMove[0] + bestMove[1] + bestMove[2] + bestMove[3]);
		System.out.println();
	}
    
    
//    public static void thisBetterWork() {
//    	String moveList = AI.possibleMoves(Driver.board);
//    	
//    }
    
    public static void thisBetterWork(String moveList) {
    	
		int X1 = 0, Y1 = 0, X2 = 0, Y2 = 0;
		int besttX1 = 0, besttY1 = 0, besttX2 = 0, besttY2 = 0;
		int bestEval = Integer.MAX_VALUE;
		
		/*
		 * pls work im desperate
		 */
		
		for(int i = 0; i < moveList.length(); i += 4) {
			
			int deleteX = 0;
			int deleteY = 0;
			
			int[][] testBoard = Driver.board;
			
			X1 = AI.getNum(moveList, i);
			Y1 = AI.getNum(moveList, i + 1);
			X2 = AI.getNum(moveList, i + 2);
			Y2 = AI.getNum(moveList, i + 3);
			
//			testBoard[X2][Y2] = testBoard[X1][Y1];
//			testBoard[X1][Y1] = 0;
			try {
				
				if(X2 - 2 == X1 && Y2 - 2 == Y1) {
					deleteX = X2 - 1;
					deleteY = Y2 - 1;
				}
				else if(X2 + 2 == X1 && Y2 - 2 == Y1) {
					deleteX = X2 + 1;
					deleteY = Y2 - 1;			
				}
				else if(X2 - 2 == X1 && Y2 + 2 == Y1) {
					deleteX = X2 - 1;
					deleteY = Y2 + 1;
				}
				else if(X2 + 2 == X1 && Y2 + 2 == Y1) {
					deleteX = X2 + 1;
					deleteY = Y2 + 1;
				}
				
				testBoard[deleteX][deleteY] = 0;
				
				deleteX = 0;
				deleteY = 0;
				
				if(AI.evaluate2(testBoard) < bestEval) {
					besttX1 = X1;
					besttY1 = Y1;
					besttX2 = X2;
					besttY2 = Y2;
				}	
			
			}
			catch(Exception e) {
				
			}
		}
		
		bestX1 = besttX1;
		bestY1 = besttY1;
		bestX2 = besttX2;
		bestY2 = besttY2;
		
		
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
            
            int[][] visBoard = Driver.board;
            
//            try {
//	    		if(bestMove[0] + 2 == bestMove[2] && bestMove[1] + 2 == bestMove[3]) {
//				Driver.board[bestMove[0] + 1][bestMove[0] + 1] = 0;
//				}
//				if(bestMove[0] + 2 == bestMove[2] && bestMove[1] - 2 == bestMove[3]) {
//					Driver.board[bestMove[0] + 1][bestMove[0] - 1] = 0;
//				}
//				if(bestMove[0] - 2 == bestMove[2] && bestMove[1] + 2 == bestMove[3]) {
//					Driver.board[bestMove[0] - 1][bestMove[0] + 1] = 0;
//				}
//				if(bestMove[0] - 2 == bestMove[2] && bestMove[1] - 2 == bestMove[3]) {
//					Driver.board[bestMove[0] - 1][bestMove[0] - 1] = 0;
//				}
//            	}
//            catch(Exception exception) {
//            	
//            }
            
            printBoard(Driver.flipXY(visBoard));
            
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



