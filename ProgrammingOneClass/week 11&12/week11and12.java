import java.util.*;
public class week11and12
{
  public static void main (String args[])
  {
    
    
    // Definite loops
     //print hello 10 times
   for (int i = 1; i <=10; i++)
   {
     System.out.println("Hello");
   }
   
   //sum of the odd numbers between 10 and 99. How many times will this loop be executed?
   // it will executed 88 times
   int sum =0;
   for (int j=10; j<=99; j++)
   {
     if (j%2==1)
     {
       sum+=j;
     }
   }
   System.out.println(sum);
   
   // Count the number of blanks in a string. How many times will this loop be executed.
   String s = "To be or not to be";
   int count = 0;
   for (int k=0; k<s.length(); k++)
   {
     if (' ' == s.charAt(k))
     {
       count ++;
     }
   }
   System.out.println(count);
   
   // indefinite loops
   //unclear how many times it will execute
   double r = Math.random();
   while (r <0.5)
   {
     r = Math.random();
   }
   
   // another example of a whiel loop
   int num =1;
   while( num< 200)
   {
     System.out.print(num + " ");
     num *=2;
   }
   System.out.print(num);
   System.out.println();
   
   // deviding an integer by 2 untill it reaches 0
   // start out with 100
   int devidebytwo=100;
     while(devidebytwo>0)
   {
     System.out.print(devidebytwo + " ");
     devidebytwo = devidebytwo / 2;
   }  
   System.out.print(devidebytwo);
   System.out.println();
   
   
   
   // rightmost digit is take off each time 
  Random rand = new Random();
  int digit = -10000 + rand.nextInt(10000);
   
   while(digit>0 || digit <0)
   {
     System.out.print(digit + " ");
     digit = digit/10;
   }
  
   
   
    
    
    
    
  }
}