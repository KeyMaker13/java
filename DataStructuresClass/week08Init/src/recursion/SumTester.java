package recursion;

/***********************************
 * 
 * @author wzhang
 *
 */

public class SumTester {

	// To be implemented
	
   public static int recurvsiveSum(int n) {
      System.out.println("call recursiveSum(" + n + ")");
//      System.out.println("returns " + result);
      return 0;
   }

   public static int iterativeSum(int n) {
      System.out.println("call iterativeSum(" + n + ")");
  //        System.out.println("i=" + i + " and result=" + result);
  
      return 0;
   }

   public static void runTest(int n) {
      System.out.println("iterative sum of " +n +
                       " is " +iterativeSum(n) + "\n");

      int sum1 = recurvsiveSum(n);
     System.out.println("recursive Sum of " + n + 
    		 								" is " + sum1 + "\n");
   }
   public static void main(String[] args) {
      runTest(4);
      runTest(100);
   }
}
