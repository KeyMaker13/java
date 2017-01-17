import java.util.*;
public class array1{
  public static void main(String[] args){
    Scanner console = new Scanner(System.in);
    System.out.println("Enter array size");
    int size = console.nextInt();
    int[] values = new int[size];
    for(int i=0; i<values.length; i++){
      values[i]=i+1;
    }
    for(int i=0; i<values.length; i++){
      System.out.print(values[i] +" ");
    }
    System.out.println();
  }// end main
}