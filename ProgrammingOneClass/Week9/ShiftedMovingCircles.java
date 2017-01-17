import java.awt.*;

public class ShiftedMovingCircles {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(300, 300);
        Graphics g = panel.getGraphics( );
        drawCircles(panel, g);
    }
    
    public static void drawCircles(DrawingPanel panel, Graphics g) {
         int x1=0,y1=0,dx=0,dy=0,x2=0,y2=0, x=0,y=0;
         dx=30;
         dy=-30;
         x1=0;
         y1=-30+270; 
         int width=300;
         int height =300;
         int r=30;
          x=x1;
          y=y1;
         
            
        for (int i = 0; i <= 100; i++) {
          
         
          System.out.println("x: " + x +"  y: " + y);
          if ((x - r + dx < 0) || (x + r + dx > width)){
            dx = -dx;}
          if ((y - r + dy < 0) || (y + r + dy > height)){
            dy = -dy;}
          
            panel.sleep(60);
            g.setColor(Color.WHITE); 
           
            g.fillOval(x-r, y-r, 2*r, 2*r);
             g.setColor(Color.RED);
             x= x+dx ;
             y=  y+dy ;
            
             g.fillOval(x-r, y-r, 2*r, 2*r);
         System.out.println("x: " + x +"  y: " + y);
        }
    
    }

}


