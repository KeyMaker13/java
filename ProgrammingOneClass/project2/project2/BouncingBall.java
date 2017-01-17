// imports
import java.awt.*;
import java.util.*;
import java.util.Random;


public class BouncingBall 
{
  // simulate a ball bouncing off the walls
  public static void main(String[] args) 
  {
    Scanner console = new Scanner(System.in);
    // Draw panel
    DrawingPanel panel = new DrawingPanel(500,500);
    Graphics g = panel.getGraphics();
    System.out.println("Project 2 by Ivan Capistran\n");
    // Prompt user for information on ball color and size
    Color c = Color.WHITE;
    System.out.print("Enter a color for the ball....blue or black");
    String colorOfBall = console.nextLine();
    colorOfBall = colorOfBall.toUpperCase();
    // to test user input to be of correct choices given
    if ((colorOfBall.equals("BLUE")) || (colorOfBall.equals("BLACK"))) 
        {
          if (colorOfBall.equals("BLUE"))
          {
           c = Color.BLUE;
          }
          else
          {
           c = Color.BLACK;
          }
         }
    else
    {
      System.out.println("Wrong choice of color");
      System.out.print("Enter a color for the ball....blue or black");
      colorOfBall = console.nextLine();
       colorOfBall = colorOfBall.toUpperCase();
      {
       if ((colorOfBall.equals("BLUE")) || (colorOfBall.equals("BLACK"))) 
           {
             if (colorOfBall.equals("BLUE"))
               {
                c = Color.BLUE;
               }
              else
               {
                c = Color.BLACK;
               }
           }
       else
           {
            System.exit(0);
           }
      }
    }

    System.out.print("Enter the size of the ball (3 to 200)");
    int sizeOfBall = console.nextInt();
    
    if ((sizeOfBall>=3) && (sizeOfBall<=200))
    {
    }
    else
    {
      System.out.println("Wrong size for ball");
      System.out.print("Enter size of ball");
      sizeOfBall = console.nextInt(); 
      {
        if ((sizeOfBall>=3) && (sizeOfBall<=200))
          {
           
          }
        else
        {
          System.exit(0);
        }
      } 
     }

    // loop that generates the ball movement several times
    for (int i =0; i<=13; i++)
    {
      
      // dy and dx are always different
      int dx = changeDirection();
      int dy = changeDirection();
      
      bounceLoop(panel, g, c, sizeOfBall, 250, 250, dx, dy);
    }
    
  
  }
// method with equation that will make ball bounce when it hits the wall
 public static void bounceLoop(DrawingPanel panel, Graphics g, Color c, int r, int x, int y, int dx, int dy)
 {
   
         int width=500;
         int height =500;
         
         int x1 = x;
         int y1 = y;
         
        for (int i = 0; i <= 600; i++) 
        {
          if ((x1 - r + dx < 0) || (x1 + r + dx > width))
          {
            dx = -dx;
          }
          if ((y1 - r + dy < 0) || (y1 + r + dy > height))
          {
            dy = -dy;
          }
          
            panel.sleep(10);
            g.setColor(Color.WHITE); 
           
            g.fillOval(x1-r, y1-r, 2*r, 2*r);
             g.setColor(c);
             x1= x1+dx ;
             y1= y1+dy ;
            
             g.fillOval(x1-r, y1-r, 2*r, 2*r); 
          }
        g.setColor(Color.WHITE);
        g.fillRect(0,0,500,500);
 }
// method that generates random number for dx and dy
public static int changeDirection()
{
 Random rand = new Random();
 int n = rand.nextInt(10) + -10;
 return n; 
}
  
}

