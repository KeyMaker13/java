package project2;

import java.util.Iterator;

public class Tester {
	public static void main(String[] args) {
		CircularList<Integer> list =new CircularLinkedList<Integer>();
			for (int i = 1; i <= 4; i++) {
			    list.add(i);
			}

			System.out.println("Should print 1 2 3 4 1 2 3 4 1 2 3");
			Iterator<Integer> iter = list.iterator();
			for (int i = 1; iter.hasNext() && i <= 11; i++) {
			    System.out.print(" " + iter.next());
			}
			System.out.println();

			list.setFront(3);

			System.out.println("Should print 3 4 1 2 3 4 1 2 3 4 1");
			iter = list.iterator();
			for (int i = 1; iter.hasNext() && i <= 11; i++) {
			    System.out.print(" " + iter.next());
			}
			System.out.println();

			list.add(-1);

			System.out.println("Should print 3 4 1 2 -1 3 4 1 2 -1 3");
			iter = list.iterator();
			for (int i = 1; iter.hasNext() && i <= 11; i++) {
			    System.out.print(" " + iter.next());
			}
			System.out.println();

			list.remove(4);

			System.out.println("Should print 3 1 2 -1 3 1 2 -1 3 1 2");
			iter = list.iterator();
			for (int i = 1; iter.hasNext() && i <= 11; i++) {
			    System.out.print(" " + iter.next());
			}
			System.out.println();
			
			//Testing strings
			String[] theList = {"Dr.Zhang ", "studied ", "the ", "world ", "in ", "one ", "day. "};
			CircularList<String> listStrings =new CircularLinkedList<String>();
				    for(int i = 0; i<theList.length; i++){
				    	listStrings.add(theList[i]);
				    }
			Iterator<String> iter2 = listStrings.iterator();
			for (int i = 1; iter2.hasNext() && i <= 11; i++) {
			    System.out.print(" " + iter2.next());
			}
			System.out.println();
			System.out.println("Adding to the back of the list");
			
			listStrings.add(" With");
			listStrings.add(" one");
			listStrings.add(" book.");
			
			iter2 = listStrings.iterator();
			for (int i = 1; iter2.hasNext() && i <= 11; i++) {
			    System.out.print(" " + iter2.next());
			}
			System.out.println();
			
			listStrings.setFront(" book.");
			
			System.out.println("Changing front value");
			iter2 = listStrings.iterator();
			for (int i = 1; iter2.hasNext() && i <= 11; i++) {
			    System.out.print(" " + iter2.next());
			}
			System.out.println();
			
			listStrings.setFront("Dr.Zhang ");
			
			System.out.println("removing some strings");
			listStrings.remove("the ");
			listStrings.remove("world ");
			listStrings.remove("in ");
			iter2 = listStrings.iterator();
			for (int i = 1; iter2.hasNext() && i <= 11; i++) {
			    System.out.print(" " + iter2.next());
			}
			System.out.println();
			
			
	}

}
