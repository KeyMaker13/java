import java.util.*;

public class stringAgainThree
{
  public static void main (String[] args)
  {
    Scanner console = new Scanner (System.in);
    
    System.out.println("Enter a string, and i will stop asking untill the next string has a z");
    
    String first = console.next();
    
    String next = first;
    boolean stop = false;
    int stop1 = 0;
    
    
   while (!stop)
   {
     
    for (int i = 0; i < next.length(); i++)
    {
      if ( next.charAt(i) == 'z')
      {
        stop1++;
      }
    }
    if (stop1 == 1)
    {
      stop = true;
    }
    else
    { 
      next = console.next(); // must use else statement or after the z is found it will still ask the user to input a string
    }
    
   }
  }
}