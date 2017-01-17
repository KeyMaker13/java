import java.awt.*;

public class ShiftedStraightLineMove {
  public static void main(String[] args) {
    // initialize DrawingPanel and Graphics objects
    DrawingPanel panel = new DrawingPanel(500,500);
    Graphics g = panel.getGraphics(); 
    
    // draw green ball on lower left and pause
    g.setColor(Color.GREEN);
    g.fillOval(0,300,100,100);
    panel.sleep(1000);
    
    // move ball to (100,300) and pause
    g.setColor(Color.WHITE);
    g.fillOval(0,300,100,100);
    panel.sleep(1000);
    g.setColor(Color.GREEN);
    g.fillOval(100,200,100,100);
    panel.sleep(1000);
    
    // move ball to (200,200) and pause
    g.setColor(Color.WHITE);
    g.fillOval(100,200,100,100);
    g.setColor(Color.GREEN);
     g.fillOval(200,100,100,100);
    panel.sleep(1000);
    
    // move ball to (300,100) and pause
    g.setColor(Color.WHITE);
    g.fillOval(200,100,100,100);
    g.setColor(Color.GREEN);
     g.fillOval(300,0,100,100);
    panel.sleep(1000);
    
       // move ball to (400,100) and pause
    g.setColor(Color.WHITE);
    g.fillOval(300,0,100,100);
   
    g.setColor(Color.GREEN);
     g.fillOval(400,100,100,100);
    panel.sleep(1000);
    g.setColor(Color.WHITE);
    g.fillOval(400,100,100,100);
   
    g.setColor(Color.GREEN);
     g.fillOval(300,200,100,100);
    panel.sleep(1000);
    g.setColor(Color.WHITE);
    g.fillOval(300,200,100,100);
   
    g.setColor(Color.GREEN);
     g.fillOval(200,300,100,100);
    panel.sleep(1000);
    g.setColor(Color.WHITE);
    g.fillOval(200,300,100,100);
   
    g.setColor(Color.GREEN);
     g.fillOval(100,400,100,100);
    panel.sleep(1000);
    
    
 
    
  }
}
    
    