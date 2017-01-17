package recursion;

public class SumTester {

   public static int recurvsiveSum(int n) {
      System.out.println("call recursiveSum(" + n + ")");
      int result = 0;
      if (n == 1)
         result = 1;
      else
         result = n + recurvsiveSum(n - 1);
      System.out.println("returns " + result);
      return result;
   }

   public static int iterativeSum(int n) {
      System.out.println("call iterativeSum(" + n + ")");
      int result = 0;
      for (int i = 1; i <= n; i++) {
         result = result + i;
         System.out.println("i=" + i + " and result=" + result);
      }
      return result;
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
