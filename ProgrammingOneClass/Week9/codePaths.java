import java.util.*;
public class codePaths{
  public static void main(String[] args){
   Scanner console = new Scanner(System.in);
   System.out.print("Enter number ");
   double a = console.nextInt();
   System.out.println("Echo number " + a);
   System.out.print("Enter number1 ");
   double b = console.nextInt();
   System.out.println("Echo number " + b);
   System.out.print("Enter number2 ");
   int c = console.nextInt();
   System.out.println("Echo number " + c);
   System.out.println(" closest = " + closestZero(a,b,c) );
  }// end main
 /* public static double max(double a, double b, double c) {
    if (a > b) {
        if (c > a) {
            return c;
        } else {
            return a;
        }
    }
    if (c > b) {
        return c;
    }
    return b;
} */
  public static double max1(double a, double b, double c){
    if(a>b && a>c){
      return a;}
    if(b>a && b>c) {
      return b; }
      // if(c>a && c>b) , the last mutally exclusive case
    return c;
          
  } // end method
  public static double closestZero(double a, double b, double c){
    double da =Math.abs(a);double db=Math.abs(b);double dc=Math.abs(c);
    if(da<db && da<dc){
      return a;}
    if(db<da && db<dc) {
      return b; }
      // if(dc<da && dc<db) , the last mutally exclusive case
    return c;
          
  } // end method
// SWITCH inequalities for Minimum
  
} //end class