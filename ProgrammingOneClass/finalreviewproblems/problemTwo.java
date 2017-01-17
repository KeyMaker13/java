import java.util.*;
public class problemTwo
{
  public static void main (String[] args)
  {
    Scanner console = new Scanner (System.in);
    String test ="";
    System.out.println("Enter a token\nA string, int or double\nAnd i will tell you what the token is");
    
   console.hasNext();
   
   System.out.println("The token is a String? " + console.hasNext());
   System.out.println("The token is a int? " + console.hasNextInt());
   System.out.println("The token is a double? " + console.hasNextDouble());
     
    
    
    
    
  }
  
  
  
  
}