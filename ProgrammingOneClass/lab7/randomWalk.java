// imports
import java.awt.*;
import java.util.*;



public class randomWalk
{
  public static void main (String[] args)
  {
    Scanner console = new Scanner(System.in);
    DrawingPanel panel = new DrawingPanel(1000,1000);
    Graphics g = panel.getGraphics();
    String choiceBlue = "blue";
    String choiceRed = "red";
    
    
    
    
    
    System.out.println("Lab 7 written by IVAN CAPISTRAN");
    System.out.print("Enter the radius of the circle must be between 50 and 400 ");
    int inputRadius = console.nextInt();
    while (inputRadius < 50 || inputRadius > 400)
    {
      inputRadius = console.nextInt();
    }
    System.out.print("Next enter the color of the circle either blue or red ");
    String inputColor = console.nextLine();
   
    
    Boolean test1 = matchesChoice(inputColor, choiceBlue);
    Boolean test2 = matchesChoice(inputColor, choiceRed);
    Boolean testResult;
    if (test1 == false && test2 == false )
    {
      testResult = false;
    while (testResult == false)
    {
      inputColor = console.nextLine();
      test1 = matchesChoice(inputColor, choiceBlue);
      test2 = matchesChoice(inputColor, choiceRed);
      if (test1 == true || test2 == true)
      {
        testResult = true;
      }
    }
   
    
   }
    
    g.drawOval(500,500,inputRadius/2,inputRadius/2);
    
   
   
    
    
    
     
    
    
    
    
  
  }

public static boolean matchesChoice (String answer, String choice)
{
  
  answer.toUpperCase();
  choice.toUpperCase();
  
  if (answer.length() == choice.length())
  {
    return true;
  }
  else
  {
    return false;
  }
  

}

public static void drawCircles(Graphics g, int r)
{
  



}
    
    
    