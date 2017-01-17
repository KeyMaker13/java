import java.awt.*; // so the program can use Graphics and Color

public class OutlineExample2 {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(300, 300);
        Graphics g = panel.getGraphics(); 

        // black outline
       // g.setColor(Color.BLACK); 
       // g.fillRect(120, 10, 100, 150);

        // inner red fill
       // g.setColor(Color.RED);
       // g.fillRect(121, 11, 98, 148);
    
   // g.drawLine(10, 10, 10, 290);
   // g.drawLine(10, 10, 290, 10);
   // g.drawLine(10, 10, 290, 290);
   // g.drawLine(10, 290, 290, 10);
    g.drawLine(10, 290, 290, 290);
    //g.drawLine(290, 10, 290, 290);
    
    
    }
}

