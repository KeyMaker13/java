import java.awt.*;

public class Hyperbola {

  // The width and height of the DrawingPanel.
  public static final int PANEL_SIZE = 512;

  // Right now this draws an X, but should draw two hyperbolas.
  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel(PANEL_SIZE, PANEL_SIZE);
    Graphics g = panel.getGraphics();
      //constants for first hyperbola
      int x1a = 0;
      int y1a = 0;
      int x2a = 0;
      int y2a = 512;
      // constants for second hyperbola
      int x1b = 512;
      int y1b = 0;
      int x2b = 512;
      int y2b = 512;
      //loop for first hyperbola
      for (int i = 512; i>=0; i-=32)
      {
      g.drawLine(x1a,y1a,x2a,y2a);
      y1a+=32;
      x2a+=32;
      }
     // loop for second hyperbola
     for (int x = 0; x<=512; x+=8)
         {
          g.drawLine(x1b,y1b,x2b,y2b);
          x1b += -8;
          y2b += -8;
         }
  }
}

