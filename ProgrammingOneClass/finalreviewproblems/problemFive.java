import java.util.*;

public class problemFive
{
  public static void main (String[] args)
  {
    Scanner console = new Scanner (System.in);
    
    System.out.println("How large do you want the array to be");
      int size = console.nextInt();
    System.out.println("Now enter double values into the array");
   
    double[] array = new double[size];
    for (int i = 0; i<array.length; i++)
    {
      array[i] = console.nextDouble();
    }
    
    System.out.println("The sum of the array is " + sumArray(array));
    System.out.println("The max number in the array is " + max(array));
    System.out.println("Every element in the array has been incremented by 1 ");
    incrementAll(array);
    for (int i=0; i < array.length; i++)
    {
      System.out.print(array[i] + " ");
    }
    System.out.println();
    System.out.println("There are " + elementsNegative(array) + " negative numbers in the array");
    System.out.println("Are all the numbers negative? " + allNegative(array));
    System.out.println("Are most of the numbers negative? " + mostNegative(array));
    System.out.println("Now every negative number has been replaced with a zero ");
    replace(array);
    for (int i=0; i < array.length; i++)
    {
      System.out.print(array[i] + " ");
    }
    
    
    
  }
  
  public static double sumArray (double[] list)
  {
    double sum = 0;
    for (int i = 0; i < list.length; i++)
    {
      sum += list[i];
    }
    return sum;
  }
  
  public static double max(double[] list)
  {
    double max = 0;
    for (int i = 0; i < list.length; i++)
    {
      
      
      if (max < list[i])
      {
        max = list[i];
      }
    }
    return max;
  }
  
  public static void incrementAll(double[] list)
  {
    for (int i = 0; i < list.length; i++)
    {
      list[i]++;
    }
  }
  
  public static void replace (double[] list)
  {
    for (int i = 0; i < list.length; i++)
    {
      if (list[i] <0)
      {
        list[i] = 0;
      }
    }
  }
  
  public static int elementsNegative (double[] list)
  {
    int count = 0;
    
    for (int i = 0; i < list.length; i++)
    {
      if (list[i] < 0)
      {
        count++;
      }
    }
    return count;
  }
  public static boolean allNegative(double[] data) {
    int count = 0;
    for (int i = 0; i < data.length; i++) {
        if (data[i] < 0) {
           count++;
        }
    }
    return (count == data.length);
}
  public static boolean mostNegative(double[] list)
  {
    int count = 0;
    for (int i = 0; i < list.length; i++)
    {
      if (list[i] < 0)
      {
        count++;
      }
    }
    return (count > list.length-count);
  }
    
    
    

    
    
  
}
      