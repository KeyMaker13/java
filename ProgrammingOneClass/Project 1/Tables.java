//import
import java.util.*;
class Tables
{
  //scanner to get user data
  public static final Scanner CONSOLE = new Scanner(System.in);
  
  public static void main (String[] args)
  {
    System.out.println("Project 1 written by Ivan Capistran\n");
    
    // 2 methods in main method
    kilogramToPounds();
    feetInchesToMeters();
  }
  
  
  public static void kilogramToPounds()
  {
    // two variables to get user input
    int firstValue;
    int secondValue;
    
     // print and get user data
    System.out.println("Convert kilograms to pounds\n");
    System.out.println("Enter two numbers to determind the range of your conversation table.");
    System.out.println("First value of the range?");
    firstValue = CONSOLE.nextInt();
    System.out.println("Second value of the range?");
    secondValue = CONSOLE.nextInt();
    System.out.println("Heres is your table\n");
    
    // print table and make for loop
    System.out.println("Kilograms\tPounds");
    
    // for loop to print out values
    for (int i = firstValue; firstValue <= secondValue; firstValue++)
    {
      System.out.printf(firstValue + "\t" + "%.3f",(firstValue * (2.20462262)));
      System.out.println("");
    }
    System.out.println("");
  }
    
  // inches feet to meters table method
  public static void feetInchesToMeters()
    {
      // print out the headers
      System.out.println("Now a table that converts feet and inches to meters\n");
      System.out.println("\tInches");
      System.out.println("Feet\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11");
      
      // two nested for loops to calculate the table of values 
      for (int a = 0; a <=9; a++)
      {
       System.out.print(a);
        for (int b = 0; b<=11; b++)
         {
          double inchesInMeters = 0.0254;
          double feet = a*(inchesInMeters*12);
          System.out.printf("\t" + "%.4f",inchesInMeters*b+feet); 
          System.out.print(" m");
         }
        System.out.println("");
      }
    }
  }
  

    
    
    
                       