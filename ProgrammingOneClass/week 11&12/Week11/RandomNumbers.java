import java.util.*;
public class RandomNumbers{
  public static void main(String [] args){
    Random rand = new Random();
    Scanner console = new Scanner(System.in);
    int r=0;
    while(r != 10){
      r = 1+ rand.nextInt(10);
      System.out.print( r + " ");
    }
    System.out.println();
    //RollDice 
    int sum=0;
    while(sum !=7){
      int roll1= 1+ rand.nextInt(6);
      int roll2= 1+ rand.nextInt(6);
      System.out.println("roll1: " + roll1 + " roll2: " + roll2);
      sum = roll1 + roll2;
    }
    int answer=1, n1=1,n2=1;
    while(answer == n1*n2){
      
      n1= 1 + rand.nextInt(10);
      n2= 1 + rand.nextInt(10);
      System.out.println("n1 = " + n1 + " n2= " + n2);
      System.out.print("Enter answer ");
      answer= console.nextInt();
    }
  }
}