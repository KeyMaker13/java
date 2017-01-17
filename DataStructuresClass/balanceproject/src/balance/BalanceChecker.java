package balance;
import jss2.*;

public class BalanceChecker {
	private String expression;
	private int index;
	private boolean balance;
	
	public BalanceChecker(String s){
		expression = s;
		index = -1;
		balance = true;
	}
	
	public int getPosition(){
		initialize();
		return index;
	}
	public String getString(){
		return expression;
	}
	
	public boolean isBalanced(){
		initialize();
		return balance;
	}
	
	public String toString()
	{
		String s = "The expression is "+ expression;
		return s;
	}
	public void initialize()
	{
		ArrayStack<Integer> indexStack = new ArrayStack<Integer>();
		ArrayStack<Character> stack = new ArrayStack<Character>();
		
		boolean b = false;
		
		for (int i = 0; i <expression.length(); i++){
			char c = expression.charAt(i);
			if(c=='('){
				indexStack.push(i);
				stack.push(c);
			}
			else if (c==')'){
				if (stack.isEmpty()){
					balance = false;
					index = i;
					
					return;
				}
				char temp = stack.pop();
				int j = indexStack.pop();
				
				if (temp!= '('){
					balance = false;
					index = j;
					return;
				}
			}
		}
		
		if (!stack.isEmpty())
		{
			balance = false;
			int temp = -1;
			while(!stack.isEmpty()){
				stack.pop();
				temp = indexStack.pop();
			}
			index = temp;
			return;
		}
	}


}
