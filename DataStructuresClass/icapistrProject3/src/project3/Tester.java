package project3;

import java.util.Random;

import dataStructures.ReversibleIterator;
import dataStructures.SortedBST;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// copy and pasted from the example on the website
		Integer[] foo = {21, 15, 18, 37, 28, 45, 9, 22, 17};
	
		SortedBST<Integer> tree = new SortedBST<Integer>();

		for (int i = 0; i < foo.length; i++) {
		    tree.add(foo[i]);
		}
		System.out.println("tree.iterator()");
		System.out.println("Should print: 9 15 17 18 21 22 28 37 45 37 28 22 21 18 17 15 9");
		
		ReversibleIterator <Integer> iter = tree.iterator();

		while (iter.hasNext()) {
		    System.out.print(" " + iter.next());
		}
		
		
		while (iter.hasPrevious()) {
		    System.out.print(" " + iter.previous());
		}
		System.out.println();
		System.out.println();
		System.out.println("tree.iterator(20)");
		System.out.println("Should print: 21 22 28 37 45 37 28 22 21 18 17 15 9");
	
		iter = tree.iterator(20);
		
		while (iter.hasNext()) {
		    System.out.print(" " + iter.next());
		}
		while (iter.hasPrevious()) {
		    System.out.print(" " + iter.previous());
		}
		System.out.println();
		System.out.println();
		System.out.println("tree.iterator(20)");
		System.out.println("Should print: 18 17 15 9 15 17 18 21 22 28 37 45");
		iter = tree.iterator(20);
		while (iter.hasPrevious()) {
		    System.out.print(" " + iter.previous());
		}
		while (iter.hasNext()) {
		    System.out.print(" " + iter.next());
		}
		System.out.println();
		
		//Extra testing
		
		//testing Strings
		String[] phrase = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};
		
		SortedBST<String> treeS = new SortedBST<String>();

		for (int i = 0; i < phrase.length; i++) {
		    treeS.add(phrase[i]);
		}
		
		System.out.println();
		System.out.println("tree.iterator()");
		System.out.println("Should print: A B C D E F G H I J K L M L K J I H G F E D C B A");
		
		ReversibleIterator<String> iterS = treeS.iterator();
		
		while(iterS.hasNext()){
			System.out.print(" " + iterS.next());
		}
		while(iterS.hasPrevious()){
			System.out.print(" " + iterS.previous());
		}
		
		System.out.println();
		System.out.println();
		System.out.println("tree.iterator(H)");
		System.out.println("Should print: H I J K L M L K J I H G F E D C B A ");
		
		iterS = treeS.iterator("H");
		
		while(iterS.hasNext()){
			System.out.print(" " + iterS.next());
		}
		while(iterS.hasPrevious()){
			System.out.print(" " + iterS.previous());
		}
		
		System.out.println();
		System.out.println();
		System.out.println("tree.iterator(B)");
		System.out.println("Should print: B C D E F G H I J K L M L K J I H G F E D C B A");
		
		iterS = treeS.iterator("B");
		
		while(iterS.hasNext()){
			System.out.print(" " + iterS.next());
		}
		while(iterS.hasPrevious()){
			System.out.print(" " + iterS.previous());
		}
		
		System.out.println();
		//testing doubles
		Double[] doubleTest = {10.4,29.245,5.55,4.1514,34.1234,82.241,351.341,134.1341,752.4527};
		SortedBST<Double> treeD = new SortedBST<Double>();
		for (int i = 0; i < doubleTest.length; i++){
			treeD.add(doubleTest[i]);
		}
		
		System.out.println();
		System.out.println("tree.iterator()");
		System.out.println("Should print: 4.1514, 5.55, 10.4, 29.245, 34.1234, 82.241, 134.1341, 351.341, 752.4527, 351.341, 134.1341, 82.241, 34.1234, 29.245, 10.4, 5.55, 4.1514 ");
		ReversibleIterator<Double> iterD = treeD.iterator();
		while(iterD.hasNext()){
			System.out.print(" " + iterD.next());
		}
		while(iterD.hasPrevious()){
			System.out.print(" " + iterD.previous());
		}
		System.out.println();
		System.out.println();
		System.out.println("tree.iterator(10.00)");
		System.out.println("Should print: 10.4, 29.245, 34.1234, 82.241, 134.1341, 351.341, 752.4527, 351.341, 134.1341, 82.241, 34.1234, 29.245, 10.4, 5.55, 4.1514 ");
		
		iterD = treeD.iterator(10.00);
		
		while(iterD.hasNext()){
			System.out.print(" " + iterD.next());
		}
		while(iterD.hasPrevious()){
			System.out.print(" " + iterD.previous());
		}
		System.out.println();
		System.out.println();
		System.out.println("tree.iterator(100.00)");
		System.out.println("Should print: 134.1341 351.341 752.4527 351.341 134.1341 82.241 34.1234 29.245 10.4 5.55 4.1514 ");
		
		iterD = treeD.iterator(100.00);
		while(iterD.hasNext()){
			System.out.print(" " + iterD.next());
		}
		while(iterD.hasPrevious()){
			System.out.print(" " + iterD.previous());
		}
		
	}

}
