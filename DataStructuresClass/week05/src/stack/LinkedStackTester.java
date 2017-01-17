package stack;

import java.util.Scanner;



public class LinkedStackTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   LinkedStack.setDebug(true);
	   StackADT<Object> s = new LinkedStack<Object> ();

	   try {
	       System.out.println("s = " + s);
	       System.out.println("s is empty " + s.isEmpty());
	       s.push(new Integer(3));
	       s.push("Apple");
	       s.push("Grape");
	       s.push("Pear");
	       //System.out.println("s after pushing four is " + s);
	       System.out.println("s is empty " + s.isEmpty());
	       s.pop();
	       s.pop();
	       s.pop();
	    } catch (Exception e) {
	      System.out.println("Exception " + e);
	    }
	    System.out.println("Normal finish");
	   /*
	    try {
	       s.pop();
	       s.pop();
	    } catch (Exception e) {
	      System.out.println("Exception " + e);
	    }
	    */
	    
/*	    StackADT<String> stack = new LinkedStack<String>( );
	    Scanner scan = new Scanner(System.in);
	    for (int i = 0; i < 10; i++) {
	      System.out.print("Enter word " + i + ": ");
	      String word = scan.nextLine();
	      stack.push(word);
	    }
	    while(!stack.isEmpty())
	       System.out.println(stack.pop());
*/	    
	}
}
