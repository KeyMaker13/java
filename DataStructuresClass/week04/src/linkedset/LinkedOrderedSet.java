package linkedset;

public class LinkedOrderedSet<T extends Comparable<T>> 

	extends LinkedSet<T> {
  // need to implement the class
  public void add (T element){
    if (!contains(element)) {
      LinearNode<T> node = new LinearNode<T>(element);
      if (isEmpty() || contents.getElement().compareTo(element) > 0) {
      	node.setNext(contents);
      	contents = node;
      } else {
      	LinearNode<T> curr = contents;
      	while (curr.getNext() != null && curr.getNext().getElement().compareTo(element) < 0) {
      		curr = curr.getNext();
      	}
      	node.setNext(curr.getNext());
      	curr.setNext(node);
      }
       count++;
    }
    if (debug) {
      System.out.println("Add " + element+ "\n" + toString());
    }	
  }
}
