import java.util.*;

public class stringAgain
{
  public static void main (String[] args)
  {
    
    
    Scanner console = new Scanner (System.in);
    System.out.println("Enter the first string");
    
    String first = console.nextLine();
    String next = ""; // priming the loop
    
    while (!first.equals(next))
    {
      System.out.println("Enter next String");
      next = console.nextLine();
    }
  }
}