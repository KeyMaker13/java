// imports to use other methods
import java.util.*;
import java.text.*;

public class FutureValues
{
  // Scanner object
  public static final Scanner CONSOLE = new Scanner(System.in);
  public static void main (String[] args)
  {
    System.out.println("Lab 3 written by Ivan Capistran\n");
    // get user information for compound interest
    System.out.println("Calculate compound interest\n Give me the present value.\n The interest rate. \n and the time.");
    int p = CONSOLE.nextInt();
    int r = CONSOLE.nextInt();
    int t = CONSOLE.nextInt();
    // calculate the compound interest using the method
    double value = compoundInterest(p,r,t);
    System.out.println("This is the value of your compound Interest " + moneyString(value));
    
    System.out.println("");
    // get user information to compute annuity
    System.out.println("Now you must compute your Annuity");
    System.out.println("Give me the values of...\n Your yearly payment.\n The interest rate.\n And the number of years for annuity.");
    int pa = CONSOLE.nextInt();
    int ra = CONSOLE.nextInt();
    int ta = CONSOLE.nextInt();
    // calculate annuity using the method
    double valueA = annuity(pa,ra,ta);
    System.out.println("Heres your annuity " + moneyString(valueA));
  }
   // method to compute compound interest
  public static double compoundInterest(double p, double r, double t)
  {
    // equation that uses parameters 
    double value = p*Math.pow((1 + (r/100)),t);
    return value;
  }
  // method to print annuity
  public static double annuity(double p, double r, double t)
  {
    // equation to calculate annuity
    double value =  p*(((Math.pow((1 + (r/100)),t))-1)/(r/100));
    return value;
  }
 // method to print correct format 
  public static String moneyString(double amount) 
  {
    DecimalFormat dollarsAndCents = new DecimalFormat("$#0.00");
    return dollarsAndCents.format(amount);
  }
    
  
  
  
  
  
}