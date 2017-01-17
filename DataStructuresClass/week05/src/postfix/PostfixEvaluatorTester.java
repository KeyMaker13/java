package postfix;

import stack.LinkedStack;

public class PostfixEvaluatorTester {
	private static PostfixEvaluator eval = new PostfixEvaluator();
	
	public static void test(String exp, double ans ) {
		System.out.println("Evaluate [" + exp + "] = " + eval.evaluate(exp) +
		" [expected " + ans + "]");
		
	}

	public static void main(String[] args) {
		LinkedStack.setDebug(false);

		test("3 4 +", 7.0);
		test("3 4 * 2 /", 6.0);
    test("2 3 + 4 5 - *", -5.0);
    test("", 0.0);

	}

}
