import java.util.*;
public class percentCorrect{
  public static void main(String[] args){
  Scanner console = new Scanner(System.in);
  System.out.print("Enter no of questions");
  int nQ=console.nextInt();
  System.out.print("Enter no of correct answers");
  int nC=console.nextInt();
   System.out.println("The percentage of correct answers is: " + percent(nQ,nC) );
   } //end main
  public static double percent(int nQ, int nC){
   if(nQ <=0) {
     throw new IllegalArgumentException(nQ + " is not positive");}
     
    if(nC > nQ){
      throw new IllegalArgumentException(nC + " is not less than " + nQ); }   
  //if(nC > nQ) {
  //  throw new IllegalArgumentException( nC + "is greater than " + nQ);}
   
 /* if (nC > nQ) {
        throw new IllegalArgumentException(nC + 
                                           " is greater than " + nQ );} */
   
   // System.out.println("The percentage of correct answers is: " + (double)nC/nQ );
   return (double)nC/nQ;
  }
 
  
  
}//end class