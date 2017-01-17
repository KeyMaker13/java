package craps;
import java.awt.*;

/**
 * <P>Draws a 6-sided dice with left corner at (0, 0)</p>
 *
 */
public class DiceDrawer {
     private static final double DEFAULT_PIP_RADIUS = 10;
     private static final double DEFAULT_PIP_OFFSET = 10;
     private static final Color DEFAULT_DICE_COLOR = Color.yellow;
     private static final Color DEFAULT_PIP_COLOR = Color.blue;
     private static final int DEFAULT_DICE_SIZE = 100;

     private double radius;
     private double offset;
     private Color diceColor;
     private Color pipColor;
     private int diceSize;
     
    private  DiceDrawer draw ;
     

     public DiceDrawer( ) {
        this(DEFAULT_DICE_SIZE, DEFAULT_PIP_RADIUS, DEFAULT_PIP_OFFSET,
             DEFAULT_DICE_COLOR, DEFAULT_PIP_COLOR);
        
     }

     public DiceDrawer(int size) {
        this(size, DEFAULT_PIP_RADIUS, DEFAULT_PIP_OFFSET,
             DEFAULT_DICE_COLOR, DEFAULT_PIP_COLOR);
        
    }

     public DiceDrawer(int size, double radius, double offset, Color dice,
                       Color pip) {
        diceSize = size;
        this.radius = radius;
        this.offset = offset;
        diceColor = dice;
        pipColor = pip;
      //  draw = this;
     }
    
     // usual accessors (get methods) and modifiers (set methods)

   /**
    * Draws a die at (0, 0) with a face value of value. If value is not in
    * the range (1-6), a blank dice is drawn.
    *
    * @param g Graphics object to perform the drawing
    * @param value face value of the dice to be drawn (1 to 6)
    */
   public void drawDiceFace(Graphics g, int value) {
	   System.out.println("drawDiceFace() is invoked");
	   g.setColor(this.diceColor);
	   g.fillRect(0, 0, this.diceSize, this.diceSize);
	   drawFacePips(g, value);
	   
    
    
   }

   /**
    * Draws the pips corresponding to value by calling drawPip with appropriate
    * row and col values. For example the pip in the upper left corner is in row
    * 0, col 0.
    *
    * @param g Graphics object to perform the drawing
    * @param value face value of pips to be drawn
    */
   private void drawFacePips(Graphics g, int value) {
	   double x;
	   double y;
	   double r;
	   System.out.println("we are drawing the pip 1 now");
      if (value == 1){
//    	  x= 0.5 * this.diceSize;
//    	  x= x - this.radius;
//    	  y= 0.5 * this.diceSize;
//    	  y= y - this.radius;
//    	  
    	 drawPip(g,(this.diceSize/2) -10 ,this.diceSize/2 -10);
      }
      if (value == 2){
    	  drawPip(g,10 ,10);
    	  drawPip(g,this.diceSize - 30  ,this.diceSize - 30);
    	 
      }
      if (value == 3){
    	  drawPip(g,10 ,10);
    	  drawPip(g,(this.diceSize/2) -10 ,this.diceSize/2 -10);
    	  drawPip(g,this.diceSize - 30  ,this.diceSize - 30);
      }
      if (value == 4){
    	  drawPip(g,10 ,10);
    	 drawPip(g,10, this.diceSize -30 );
    	 drawPip(g,this.diceSize - 30  ,10);
    	 drawPip(g,this.diceSize - 30  ,this.diceSize - 30);
      }
      if (value == 5){
    	  drawPip(g,10 ,10);
     	 drawPip(g,10, this.diceSize -30 );
     	 drawPip(g,this.diceSize - 30  ,10);
     	 drawPip(g,this.diceSize - 30  ,this.diceSize - 30);
     	 drawPip(g,(this.diceSize/2) -10 ,this.diceSize/2 -10);
      }
      if (value == 6){
    	  drawPip(g,10 ,10);
    	  drawPip(g,this.diceSize/2 - 10 , 10 );
    	  drawPip(g,this.diceSize -30, 10 );
    	  
    	  drawPip(g,10, this.diceSize - 30);
    	  drawPip(g,this.diceSize/2 - 10 ,this.diceSize - 30 );
    	  drawPip(g,this.diceSize -30, this.diceSize - 30 );
    	  
      }
     
   }

   /**
    * Draws a single pip in the appropriate row and colum as indicated by the
    * parameters of the dice. (Remember x corresponds to columns, y to rows)
    *
    * @param g Graphics object to perform the drawing
    * @param row row number of the pip to be drawn (0 to 2)
    * @param col column number of the pip to be drawn
    */
   private void drawPip(Graphics g, int row, int col) {
   g.setColor(DEFAULT_PIP_COLOR);
	   g.fillOval(col, row,20,20);
   }
   
   
   
   
}
