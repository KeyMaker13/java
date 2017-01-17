package lib;


public class OrderedLinkedList <T extends Comparable>
    extends BasicLinkedList<T>
    implements OrderedListADT<T>{

  public void add(T element) {

    count++;
    // create a new node
    DoubleNode<T> node = new DoubleNode<T>(element);

    // if list is empty
    //    add to an empty list
    if (front==null) {
      front = rear = node;
    } else {

      // search for the position to add
      DoubleNode<T> current = front;
      while (current != null &&
             current.getElement().compareTo(element) < 0) {
        current = current.getNext();
      }

      if (current == null) {
        // if off the end
        //    add as the last node
        rear.setNext(node);
        node.setPrevious(rear);
        rear = node;
      }
      else {
        if (current == front) {
          // if still at the front
          //    add as the first node
          front.setPrevious(node);
          node.setNext(front);
          front = node;
        }
        else {
          // add before the current position
          node.setNext(current);
          node.setPrevious(current.getPrevious());
          current.setPrevious(node);
          node.getPrevious().setNext(node);
        }
      }
    }
    if (debug) {
      System.out.println("add " + element + " "  + toString());
    }

  }

}
