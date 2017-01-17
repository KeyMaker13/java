package doublelinks;

import jss2.LinearNode;
import jss2.LinkedIterator;

public class SingleLinkTester {
  public static void main(String[] args) {
	  System.out.println("Lab 4 written by Ivan Capistran");
	  
	  LinearNode<String> node1 = new LinearNode<String> ("apple");
	  LinearNode<String> node2 = new LinearNode<String> ("orange");
	  LinearNode<String> node3 = new LinearNode<String> ("grape");
	  
	  node1.setNext(node2);
	  node2.setNext(node3);
	  
	  LinkedIterator<String> iter = new LinkedIterator<String>(node1);
	  
	  String temp;
	  
	  while (iter.hasNext()){
		  temp = iter.next();
		  System.out.println(temp);
		  
	  }
	  
	  
	  
  }
}
