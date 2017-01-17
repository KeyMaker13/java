package doublelinks;

import jss2.DoubleLinkedIterator;
import jss2.DoubleNode;

public class DoubleLinkTester {


	public static void main(String[] args) {
		System.out.println("Lab4 part 2 by Ivan Capistran");
		
		
		DoubleNode<String> node1 = new DoubleNode<String> ("Apple");
		DoubleNode<String> node2 = new DoubleNode<String> ("Orange");
		DoubleNode<String> node3 = new DoubleNode<String> ("Grape");
		
		node1.setNext(node2);
		node2.setNext(node3);
		DoubleNode<String> tempNext = node1;
		
		int i = 0;
		System.out.println("---Testing Next Nodes without iterator---");
		while(tempNext!=null){
			i++;
			System.out.println(i + " Element(Next) : "+tempNext.getElement());
			
			tempNext = tempNext.getNext();
			
		}
		
		System.out.println("\n------Testing Previous Nodes without the iterator");
	
		node3.setPrevious(node2);
		node2.setPrevious(node1);
		DoubleNode<String> tempPrev = node3;
		
		int j = 3;
		while (tempPrev!= null)
		{
			System.out.println(" Element (Prev) : " + tempPrev.getElement());
			j--;
			tempPrev = tempPrev.getPrevious();
		}
		
		System.out.println("\n----Testing using the Iterator");
		DoubleLinkedIterator<String> iter = new DoubleLinkedIterator<String>(node1);
		while (iter.hasNext()){
			System.out.println(iter.next());
		}
		
		
	}

}
