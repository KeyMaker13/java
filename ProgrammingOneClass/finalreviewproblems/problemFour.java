import java.util.*;

public class problemFour
{
  public static void main (String[] args)
  {
    Scanner console = new Scanner (System.in);
    
    System.out.println("Enter a number and I will tell you how many times it is divisable by two");
    int divide = console.nextInt();
    int count =0;
    
    while (divide%2==0)
    {
      divide/=2;
      count++;
    }
    
    
    System.out.println("The number is divisable "+count+" times");
  }
}
  