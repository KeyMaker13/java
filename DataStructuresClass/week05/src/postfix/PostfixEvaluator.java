package postfix;

import java.util.StringTokenizer;

import stack.LinkedStack;
import stack.StackADT;




public class PostfixEvaluator {
	private static final String operators = "+-*/%";
	private StackADT<Double> stack;

	public PostfixEvaluator() {
		stack = new LinkedStack<Double>();
	}

	public double evaluate(String exp) {
		StringTokenizer tokens = new StringTokenizer(exp);
		if (!tokens.hasMoreTokens()) // blank strings evaluate to 0
			return 0;
		
		while (tokens.hasMoreTokens()) {
			String token = tokens.nextToken();
			if (isOperator(token))
				stack.push(evaluateOneOp(token, stack.pop(), stack.pop()));
			else
				stack.push(new Double(token));

		}
		return stack.pop();
	}

	private boolean isOperator(String token) {
		char chOp = token.charAt(0);
		return operators.indexOf(chOp) != -1;
	}

	private Double evaluateOneOp(String token, double op1, double op2) {
		char op = token.charAt(0);
		switch (op) {
		case '+':
			return op2 + op1;
		case '-':
			return op2 - op1;
		case '*':
			return op2 * op1;
		case '/':
			return op2 / op1;
		case '%':
			return op2 % op1;
		}
		return null;
	}
}
