import java.util.*;
public class reviewActivities{
  public static void main(String[] args){
    int varOne = 1; 
    int varTwo = 2;
    int varThree = 3;
    boolean res1;
     System.out.println("check if the three no's are equal: " +varOne + " "
                       + " " + varTwo +" " + varThree );
    res1 = checkThreeEqual(varOne, varTwo, varThree); // 3 no's equal?
     System.out.println(res1);
      System.out.println("check if the three no's are not equal: " +varOne + " "
                       + " " + varTwo +" " + varThree );
    boolean res2 = checkThreeNotEqual(varOne, varTwo, varThree); // 3 no's not-equal?
    System.out.println(res2);
    
    
   
    //replace negative elements with 0
    double [] dArray = {1.1, 2.2, -2.2, -3.3, 5, -5.0, -9.0};  
    System.out.println(Arrays.toString(dArray));   
    System.out.println("replace negative elem's of array with 0's ");
    replaceNegativeWithZero(dArray);
    System.out.println(Arrays.toString(dArray));  
    System.out.println("return true if most elem's are negative in array: " + 
                       mostNegative(dArray) );
    
  }  // END main method
  public static boolean mostNegative(double[] data) {
    int count = 0;
    for (int i = 0; i < data.length; i++) {
        if (data[i] < 0) {
           count++;
        }
    }
    return (count >= data.length/2 +1 );
}
  public static void replaceNegativeWithZero(double[] a){
    for(int i = 0; i < a.length; i++){
      if(a[i] < 0)
        a[i] = 0;
    }
  }
  
  
  public static boolean checkThreeNotEqual(int a, int b, int c){
    boolean res = true;
    if (a==b || b==c || a==c){ 
      res = false;}
    return res;
  }
  public static boolean checkThreeEqual(int a, int b, int c){
    boolean res = false;
    if (a==b && b==c) 
      res = true;
    return res;    
  }    
}