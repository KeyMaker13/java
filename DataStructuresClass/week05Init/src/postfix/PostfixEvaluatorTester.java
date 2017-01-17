package postfix;

import stacks.*;

public class PostfixEvaluatorTester {
	private static PostfixEvaluator eval = new PostfixEvaluator();
	
	public static void test(String exp, double ans ) {
		System.out.println("Evaluate [" + exp + "] = " + eval.evaluate(exp) +
		" [expected " + ans + "]");
		
	}

	public static void main(String[] args) {
		LinkedStack.setDebug(true);
		ArrayStack.setDebug(true);
		PostfixEvaluator.setDebug(true);

		//test("15 4 6 - * 5 / 8 2 7 + / +", -6.0);
		test("1 2 + 3 4 * + 5 6 + -",4.0);
		//test("3 4 +", 7.0);
		//test("3 4 * 2 /", 6.0);
    //test("2 3 + 4 5 - *", -5.0);
    //test("", 0.0);

	}

}
