import java.awt.*;

public class Hyperbola {

  // The width and height of the DrawingPanel.
  public static final int PANEL_SIZE = 512;

  // Right now this draws an X, but should draw two hyperbolas.
  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel(PANEL_SIZE, PANEL_SIZE);
    Graphics g = panel.getGraphics();
      int x1a = 0;
      int y1a = 0;
      int x2a = 0;
      int y2a = 512;
      
      int x1 = 512;
      int y1 = 512;
      int x2 = 512;
      int y2 = 0;
      int factor = 0;
      
      
    
    for (int i = 512; i>=0; i-=32)
    {
      g.drawLine(x1a,y1a,x2a,y2a);
      y1a+=32;
      x2a+=32;
    }
    
    for (int x = 0; x<=512; x+=8);
         {
           
           g.drawLine((x1-factor),(y1-factor),(x2-factor),y2);
          factor += -8;
         }
         
       
    
  }
}

