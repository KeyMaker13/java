import java.util.*;
public class CountUpperLower{
  public static void main(String[] args){
    Scanner console = new Scanner(System.in);
    System.out.println("Enter string s1 ");
    String s1 = console.nextLine();
    System.out.println("Echo the string is:  " + s1);
    System.out.println("Enter the char c1");
    String s2 =console.nextLine();
    char c1= s2.charAt(0);
    System.out.println("Echo the character:  " + c1);
    int count1 = countChar(s1,c1);
    System.out.println("the character " + c1 + " appears " + count1 + " times ");
    int countDigits = countDigit(s1,c1); // to count digits in the string
    System.out.println("the count of the digits is: " + countDigits);
  } // end main
  public static int countDigit(String s, char c){
    int count=0;
    for(int i=0; i<s.length(); i++){
      if(Character.isDigit(s.charAt(i))){
        count++;
      }
    }// end loop
     return count;
  }
  public static int countChar(String s, char c){
    int count=0;
    char cU = Character.toUpperCase(c);
    char lU = Character.toLowerCase(c);
    for(int i=0; i<s.length(); i++){
      if(cU==s.charAt(i) || lU == s.charAt(i)){
        count++;
      }
    } //end loop
    return count;
  } //end method
}