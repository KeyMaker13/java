import java.util.*;

public class stringAgainTwo
{
  public static void main (String[] args)
  {
    Scanner console = new Scanner (System.in);
    
    System.out.println("Enter first string");
    String first = console.nextLine();
    String next = first;
    
    while (next.equals(first))
    {
      System.out.println("Enter a different string");
      next = console.nextLine();
    }
  }
}