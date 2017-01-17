import java.util.*;
import java.awt.*;

public class TicTacToe {
  public static final Scanner CONSOLE = new Scanner(System.in);
  public static final Random RAND = new Random();
  public static final int EMPTY = 0;
  public static final int CROSS = 1;
  public static final int NAUGHT = 2;
  
  // This main method allows the user to play Tic-Tac-Toe vs.
  // the computer.  Method calls to static methods in
  // ReplaceThis.class should be replaced with your own methods
  // in this program.
  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel(600,600);
    Graphics g = panel.getGraphics();
    
    // This draws the lines and the small numbers on the panel
    drawBoard(g);
    
    // createBoard returns an int array of length 9
    //int[] board = ReplaceThis.createBoard();
    int[] board = createBoard();
    
    // font for drawing big Xs and Os
    g.setFont(new Font("SansSerif", Font.BOLD, 150));
    
    // The computer is X and moves first.
    int turn = CROSS;
    
    // gameOver is true if X or O wins or the board is filled
    while ( ! ReplaceThis.gameOver(board) ) {
      if (turn == CROSS) {
        
        // computerMove selects a random move to an empty square.
        int move = ReplaceThis.computerMove(board);
        
        // Record the computer's move.
        board[move] = CROSS;
        
        // drawX draws an X in the appropriate square.
        ReplaceThis.drawX(g, move);
        
        // Now it will be the user's turn.
        turn = NAUGHT;
      } else {
        
        // userMove inputs a move from the user.
        int move = ReplaceThis.userMove(board);
        
        // Record the user's move.
        board[move] = NAUGHT;
        
        // drawO draws an O in the appropriate square.
        ReplaceThis.drawO(g, move);
        
        // Now it will be the computer's turn.
        turn = CROSS;
      }
    }
    
    // The game is over, so print the winner.
    ReplaceThis.printWinner(board);
  }
  
  // draw board method
  public static void drawBoard(Graphics g)
  {
    // draw lines for tic tac toe
    g.drawLine(200,0,200,600);
    g.drawLine(400,0,400,600);
    g.drawLine(0,200,600,200);
    g.drawLine(0,400,600,400);
    // draw numbers 0-2
    g.drawString("0",5,15);
    g.drawString("1",205,15);
    g.drawString("2",405,15);
    // draw numbers 3-5
    g.drawString("3",5,215);
    g.drawString("4",205,215);
    g.drawString("5",405,215);
    // draw numbers 6-8
    g.drawString("6",5,415);
    g.drawString("7",205,415);
    g.drawString("8",405,415);
  }
  // creat board method with an array value of 9
  public static int[] createBoard()
  {
    int[] array = {0,0,0,0,0,0,0,0,0};
    
    return array;
  }
 
  
  
  
  
  
  
  
  
  
}