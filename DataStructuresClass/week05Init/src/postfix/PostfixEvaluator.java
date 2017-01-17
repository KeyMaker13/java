package postfix;

import java.util.StringTokenizer;

import stacks.ArrayStack;
import stacks.LinkedStack;
import stacks.StackADT;

public class PostfixEvaluator {
	private static final String operators = "+-*/%";
	private StackADT<Double> stack ;
	
	private static boolean debug = false;
	  public static void setDebug(boolean t) {
	     debug = t;
	  }
	
	public PostfixEvaluator(){
	//	LinkedStack.setDebug(true);
		//stack = new LinkedStack<Double>();
		stack = new ArrayStack<Double>();
	}
	public double evaluate(String exp) {
		StringTokenizer tokens = new StringTokenizer(exp);
		if (!tokens.hasMoreTokens()){
			return 0;
		}
		while(tokens.hasMoreTokens()){
			String token = tokens.nextToken();
			if (isOperator(token)){
				double d1 = stack.pop();
				double d2 = stack.pop();
				if(debug){
					System.out.println("evaluate " + d2 + " " + token + " " + d1);
				}
				
				stack.push(evaluateOp(token, d1,d2));
			}
			else{
				stack.push(new Double(token));
			}
		}
		return stack.pop();
	}
	
	private boolean isOperator(String token){
		
		char c = token.charAt(0);
		return operators.indexOf(c)!= -1 ;
		
	}
	
	private double evaluateOp(String token, double d1, double d2){
		
		char op = token.charAt(0);
		
		switch(op){
		case '+': return d2 + d1;
		case '-': return d2 - d1;
		case '*': return d2*d1;
		case '/': return d2/d1;
		case '%': return d2%d1;
		}
		
		
		return 0;
	}

}
