import java.awt.*;
import java.util.*;

public class Circles
  {
  public static final Scanner console = new Scanner(System.in); 
  
  public static void main (String[] args)
  {
    
    DrawingPanel panel = new DrawingPanel(400, 300);
    Graphics g = panel.getGraphics();
    // tell user how to input data for the circles
    System.out.println("LAB 5 BY IVAN CAPISTRAN\n");
    System.out.println("You will enter the values for the location of a circle in terms of x and y\n then you will enter the size of the radius");
    System.out.println("You will give Values for 3 Circles");
    System.out.println("The grid is 400 by 300");
    System.out.println("Values for first circle.\nEnter x then y then radius");
    int xCircleOne = console.nextInt();
    int yCircleOne = console.nextInt();
    int rCircleOne = console.nextInt();
    System.out.println("Values for second circle.\nEnter x then y then radius");
    int xCircleTwo = console.nextInt();
    int yCircleTwo = console.nextInt();
    int rCircleTwo = console.nextInt();
    System.out.println("Values for third circle.\nEnter x then y then radius");
    int xCircleThree = console.nextInt();
    int yCircleThree = console.nextInt();
    int rCircleThree = console.nextInt();
    System.out.println();
    // draw circles with data from user
    g.fillOval(xCircleOne,yCircleOne,rCircleOne,rCircleOne);
    g.setColor(Color.RED);
    
    g.fillOval(xCircleTwo,yCircleTwo,rCircleTwo,rCircleTwo);
    g.setColor(Color.BLUE);
    
    g.fillOval(xCircleThree,yCircleThree,rCircleThree,rCircleThree);
    g.setColor(Color.BLACK);
    // compare circles
    int circleOneVsCircleTwo = compareCircleSize(rCircleOne,rCircleTwo);
    
    if (circleOneVsCircleTwo == -1)
    {
      System.out.println("The Red Circle is smaller than the Blue circle");
    }
    if (circleOneVsCircleTwo == 0)
    {
      System.out.println("The Red Circle is the same size as than the Blue circle");
    }
    if (circleOneVsCircleTwo == 1)
    {
      System.out.println("The Red Circle is bigger than the Blue circle");
    }
    
    
    int circleOneVsCircleThree = compareCircleSize(rCircleOne,rCircleThree);
    
    if (circleOneVsCircleThree == -1)
    {
      System.out.println("The Red Circle is smaller than the Black circle");
    }
    if (circleOneVsCircleThree == 0)
    {
      System.out.println("The Red Circle is the same size as than the Black circle");
    }
    if (circleOneVsCircleThree == 1)
    {
      System.out.println("The Red Circle is bigger than the Black circle");
    }
    
    int circleTwoVsCircleThree = compareCircleSize(rCircleTwo,rCircleThree);
    
    if (circleTwoVsCircleThree == -1)
    {
      System.out.println("The Blue Circle is smaller than the Black circle");
    }
    if (circleTwoVsCircleThree == 0)
    {
      System.out.println("The Blue Circle is the same size as than the Black circle");
    }
    if (circleTwoVsCircleThree == 1)
    {
      System.out.println("The Blue Circle is bigger than the Black circle");
    }
    
    // see what circles intersect
    if ( intersection(xCircleOne,yCircleOne,rCircleOne,xCircleTwo,yCircleTwo,rCircleTwo) == 1)
    {
      System.out.println("The Red and Blue circle intersect");
    }
    if ( intersection(xCircleOne,yCircleOne,rCircleOne,xCircleThree,yCircleThree,rCircleThree) == 1)
    {
      System.out.println("The Red and Black circle intersect");
    }
    if ( intersection(xCircleTwo,yCircleTwo,rCircleTwo,xCircleThree,yCircleThree,rCircleThree) == 1)
    {
      System.out.println("The Blue and Black circle intersect");
    }
     
  }
  
  //method for comparing the circles in size in radius
 public static int compareCircleSize(int r1, int r2)
 {
   int value=0;
   
   if (r1<r2)
   {
    value = -1;
   }
   
   if (r1==r2)
   {
     value = 0;
   }
   if (r1>r2)
   {
     value = 1;
   }       
     
  return value;
 }
 
 // method for intersection
 public static double intersection(int x1, int y1, int r1, int x2, int y2, int r2)
 {
   double returnValue = 0;
   
   double value = Math.sqrt(Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2));
   
   if (value <= (r1+r2))
   {
     returnValue = 1;
   }
   else
   {
     returnValue = 0;
   }
 
   return returnValue;
 }
 
}