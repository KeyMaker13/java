import java.util.*;
public class CountAChar{
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
  } // end main
  public static int countChar(String s, char c){
    int count=0;
    for(int i=0; i<s.length(); i++){
      if(c==s.charAt(i)){
        count++;
      }
    } //end loop
    return count;
  } //end method
}