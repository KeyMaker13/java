package postfixV2;

public class PostfixEvaluatorTester {
   public static void main(String[] args) {
      //System.out.println(Double.parseDouble("123"));

      String test1 = new String("3 4 5 + +");
      PostfixEvaluator.setDebug(true);
      PostfixEvaluator eval = new PostfixEvaluator();
      Token result = eval.evaluate(test1);
      System.out.println("result of " + test1 + " is " + result);

      String test2 = new String("3 4 + 5 -");
      result = eval.evaluate(test2);
      System.out.println("result of "+ test2 + " is " + result);

   }
}
