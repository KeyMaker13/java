import java.util.*;
public class precondition{
  public static void main(String[] args){
   Scanner console = new Scanner(System.in);
   System.out.print("Enter number ");
   double a = console.nextDouble();
   System.out.println("Echo number " + a);
   System.out.println(" the square root is: " + squareRoot(a));
   System.out.print("Enter number1 ");
   int number1 = console.nextInt();
   System.out.println("Echo number " + number1);
   System.out.print("Enter number2 ");
   int number2 = console.nextInt();
   System.out.println("Echo number " + number2);
   System.out.println(" the percent of correct answers is: " + 
                      percentCorrect(number1,number2) );
  }// end main
  public static double percentCorrect(int nQ, int nC){
    // preconditions:  !(nQ >0) and also !(nC <= nQ)
    if(nQ<=0){
      throw new IllegalArgumentException(nQ + " is not positive");}
    if(nC > nQ){
        throw new IllegalArgumentException(nC + " exceeds " +  nQ );} 
    double result = (double)nC/nQ ;
    return result;                               
    // postcondition: the percent of correct answers 
  } // end method
  public static double squareRoot(double a){
    // precondition : a is not negative
    if(a<0){
      throw new IllegalArgumentException(" parameter is negative " + a );
    }
    return Math.sqrt(a);
   // the Math.sqrt(a)  is the square root of a positive double 
  }// end method
}//end class