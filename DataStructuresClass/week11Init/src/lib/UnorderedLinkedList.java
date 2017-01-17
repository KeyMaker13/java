package lib;

import java.util.NoSuchElementException;

public class UnorderedLinkedList <T>
    extends BasicLinkedList<T>
    implements UnorderedListADT<T>
{
  public void addToFront(T element) {
    count++;
    DoubleNode<T> temp = new DoubleNode<T>(element);
    temp.setNext(front);
    front = temp;
    if (count == 1)
      rear = temp;
    else
      temp.getNext().setPrevious(temp);

    if (debug) {
      System.out.println("add " + element + " to front " + toString());
    }

  }

  public void addToRear(T element) {
   count++;
   DoubleNode<T> temp = new DoubleNode<T>(element);
   temp.setPrevious(rear);
   rear = temp;
   if (count == 1)
     front = temp;
   else
     rear.getPrevious().setNext(rear);

   if (debug) {
     System.out.println("add " + element + " to rear " + toString());
   }
  }

  public void addAfter(T element, T target) {
    DoubleNode<T> current = front;
    while (current != null &&
           !current.getElement().equals(target))
      current = current.getNext();
    if (current == null)
      throw new NoSuchElementException();
    count++;
    DoubleNode<T> temp = new DoubleNode<T>(element);
    temp.setNext(current.getNext());
    temp.setPrevious(current);
    current.setNext(temp);
    if (temp.getNext() == null)
      rear = temp;
    else
      temp.getNext().setPrevious(temp);

    if (debug) {
      System.out.println("add " + element + " after " + target +
                         " " + toString());
    }

  }

}
