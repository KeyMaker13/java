import java.util.*;
public class FencePost{
  public static void main(String [] args){
  Scanner console = new Scanner(System.in);
  int upper = console.nextInt();
  System.out.print("[");
  for(int i=1; i<= upper; i++){
    if(i< upper){
    System.out.print(i);
    System.out.print(" ");
    }
    else
      System.out.print(i);
  }
  System.out.println("]");
  //sentinal value
  int sum=0, count=0;
  System.out.print("enter the 1st int value and -999 to quit loop");
  int value = console.nextInt();
  while(value != -999){
    sum = sum+value; count++;
    System.out.print("enter the next int value and -999 to quit loop");
    value=console.nextInt();
  }
  System.out.println("sum is " + sum);
  if(sum >0){ 
    System.out.println("avg= " + (double) sum/count);
  }
  }//end main
}