package balance;

import jss2.ArrayStack;

public class BalanceCheckerAdvance {
	
		private String expression;
		private int index;
		private boolean balance;
		
		public BalanceCheckerAdvance(String s){
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
			
			SymbolCheck obj = new SymbolCheck();
			
			boolean b = false;
			
			for (int i = 0; i <expression.length(); i++){
				char c = expression.charAt(i);
				if(obj.isOpenSymbol(c)){
					indexStack.push(i);
					stack.push(c);
				}
				else if (obj.isCloseSymbol(c)){
					if (stack.isEmpty()){
						balance = false;
						index = i;
						
						return;
					}
					char temp = stack.pop();
					int j = indexStack.pop();
					
					if (temp!= obj.getPaired(c)){
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


