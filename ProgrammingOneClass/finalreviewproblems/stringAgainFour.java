import java.util.*;

public class stringAgainFour
{
  public static void main (String[] args)
  {
  Scanner console = new Scanner (System.in);
  
    System.out.println("Enter a string, then i will stop asking for more strings\nuntill you enter the same string twice");
  
  String first = console.next();
  
  String nextFirst = "";
  String nextSecond = "";
  boolean stop = false;
  
  while(!stop)
  {
    nextFirst = console.next();
    nextSecond = console.next();
    if (nextFirst.equals(nextSecond))
    {
     stop = true;
    }
    
  }
}
}
