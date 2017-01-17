import java.util.*;
public class SwitchCase{
  public static void main(String[] args){
    Scanner console = new Scanner(System.in);
    System.out.println("Enter string s1 ");
    String s1 = console.nextLine();
    System.out.println("Echo the string is:  " + s1);
    String s2= switchMethod(s1);
    System.out.println(" the changed case string is: " + s2 );
    
  } // end main
  public static String switchMethod(String s){
     String result = "";
    for(int i=0; i< s.length(); i++){
      char c =s.charAt(i);
       if(Character.isUpperCase(c)){
        result = result+ Character.toLowerCase(c); 
       }
      if(Character.isLowerCase(c)){
        result = result+ Character.toUpperCase(c); 
        }
     }// end loop
     return result;
   }// end method
  
}// end class