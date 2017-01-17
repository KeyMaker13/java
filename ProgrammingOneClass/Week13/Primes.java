import java.util.*;
public class Primes{
  public static void main(String[] args){
    Scanner console = new Scanner(System.in);
    int[]values = {13, 17, 19, 23, 29,2, 3, 5, 7, 11};
    int[] values1 =Arrays.copyOf(values,20);
    Arrays.fill(values1,10);
    int sum=0;
    for(int i=0; i<values.length; i++){
      sum= sum+values[i];
    }
    
    System.out.println(" sum " + sum);
    System.out.println(Arrays.toString(values));
    Arrays.sort(values);
    System.out.println(Arrays.toString(values));
    System.out.println(Arrays.toString(values1));
    System.out.println(Arrays.equals(values,values1));
  }// end main
}