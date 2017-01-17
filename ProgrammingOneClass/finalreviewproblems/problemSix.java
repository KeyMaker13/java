import java.util.*;

public class problemSix
{
  public static void main (String[] args)
  {
    Scanner console = new Scanner (System.in);
    System.out.println("How many Strings are you going to type?");
     int size = console.nextInt();
    System.out.println("Input them in and I will compute the average letters per string");
    
    
    String[] average = new String [size];
    
    for (int i = 0; i <average.length; i++)
    {
      average[i] = console.next();
    }
    System.out.println(averageLetters(average));
    System.out.println(reverse(average[0]));
    
  
   }
  
  public static double averageLetters(String[] list)
  {
    double sum =0;
    String add = "";
    for (int i =0; i< list.length; i++)
    {
      add += list[i];
      
    }
    for (int i =0; i < add.length(); i++)
    {
      sum++;
    }
    System.out.println(add);
    return (sum/list.length);
    
  }
  
  public static String reverse(String phrase) {
String result = "";
for (int i = 0; i < phrase.length(); i++) {
char c = phrase.charAt(i);
result = c + result;
}
return result;
}
  
  
  
}