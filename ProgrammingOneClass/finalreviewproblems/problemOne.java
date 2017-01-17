import java.util.*;

public class problemOne
{
  public static void main (String[] args)
  {
    Scanner console = new Scanner(System.in);
    
    System.out.println("Enter 3 numbers.\nAnd I will determin which one is smaller.");
    int a = console.nextInt();
    int b = console.nextInt();
    int c = console.nextInt();
    
    System.out.println("The smallest number is " + smallestNumberTwo(a,b,c));
    System.out.println("The smallest number is " + smallestNumber(a,b,c));
    System.out.println("The median number is " + median(a,b,c));
    System.out.println("Are the numbers the same? " + sameNumbers(a,b,c));
    System.out.println("The numbers are not the same? " + notTheSame(a,b,c));
    System.out.println("Are two of the numbers negative? " + negativeNumbers(a,b,c));
    
  }
  public static int smallestNumber (int a, int b, int c)
  {
    int d = 0;
    if ((a < b) && (a<c))
    {
      return a;
    }
    if ((b<a) && (b<c))
    {
      return b;
    }
    if ( (c<a) && (c<b))
    {
      return c;
    }
    return d;
  }
  public static int smallestNumberTwo (int a, int b, int c)
  {
   int d = Math.min(Math.min(a,b),Math.min(a,c));
   return d;
  }
  public static int median(int a, int b, int c)
  {
    int d = 0;
    if ( ((a<c)&&(a>b))||((a<b)&&(a>c)))
    {
      return a;
    }
    if ( ((b<c)&&(b>a))||((b<a)&&(b>c)))
    {
      return b;
    }
    if ( ((c<a)&&(c>b))||((c<b)&&(c>a)))
    {
      return c;
    }
    return d;
}
  public static boolean sameNumbers(int a, int b, int c)
  {
    if (a==b&&b==c)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  public static boolean notTheSame(int a, int b, int c)
  {
    if (a!=b&&b!=c)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  public static boolean negativeNumbers(int a, int b, int c)
  {
    if ((a<0)&&(b<0)&&(c>=0))
    {
      return true;
    }
    if ((a<0)&&(c<0)&&(b>=0))
    {
      return true;
    }
    if ((b<0)&&(c<0)&&(a>=0))
    {
      return true;
    }
    return false;
  }

}



