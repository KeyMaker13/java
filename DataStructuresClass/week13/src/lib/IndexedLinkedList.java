package lib;


import java.util.NoSuchElementException;

public class IndexedLinkedList <T>
    extends BasicLinkedList<T>
    implements IndexedListADT<T>{

  public void add(int index, T element) {
     if (index > count)
        throw new NoSuchElementException("Position " + index +
                                         " out of bounds");
     if (index == 0)
        addToFront(element);
     else if (index == count)
        add(element);
     else
        addAfter(findNode(index - 1), element);
  }

  //  Adds the specified element to the rear of this list
  public void add(T element) {
     DoubleNode<T> node = new DoubleNode(element);
     if (front == null)
        front = node;
     else {
        node.setPrevious(rear);
        rear.setNext(node);
     }
     rear = node;
     count++;

     if (debug) {
       System.out.println("add " + element + " " + toString());
     }

  }

  //  Returns a reference to the element at the specified index
  public T get(int index) {
     if (index >= count)
        throw new NoSuchElementException("No element at position " + index);
     return findNode(index).getElement();
  }

  //  Returns the index of the specified element
  public int indexOf(T element) {
     DoubleNode<T> next = front;
     for (int i = 0; i < count && next != null; i++) {
        if (next.getElement().equals(element))
           return i;
        next = next.getNext();
     }
     return -1;
  }

  //  Removes and returns the element at the specified index
  public T remove(int index) {
     if (index >= count)
        throw new NoSuchElementException("Element " + index + " doesn't exist");
     if (index == 0)
        return removeFirst();
     else if (index == count - 1)
        return removeLast();
     DoubleNode<T> node = findNode(index);
     node.getNext().setPrevious(node.getPrevious());
     node.getPrevious().setNext(node.getNext());
     count--;
     if (debug) {
       System.out.println("remove element at " + index + " " + toString());
     }

     return node.getElement();
  }

  //  Sets the element at the specified index
  public void set(int index, T element) {
     DoubleNode<T> node = findNode(index);
     if (node == null)
        throw new NoSuchElementException("No element at " + index);
     node.setElement(element);
     if (debug) {
       System.out.println("set " + element + " at position " +
                          index + " " + toString());
     }

  }

  //*************************PRIVATE HELPERS ****************************
   // return reference to node i or null if there is no node i
   private DoubleNode<T> findNode(int i) {
      if (i >= count)
         return null;
      if (i == 0)
         return front;
      else if (i == count - 1)
         return rear;
      DoubleNode<T> next = front;
      for (int j = 1; j <= i; j++)
         next = next.getNext();
      return next;
   }

  //  add node containing element to the front
  private void addToFront(Object element) {
     DoubleNode<T> node = new DoubleNode(element);
     if (front == null)
        rear = node;
     else {
        node.setNext(front);
        front.setPrevious(node);
     }
     front = node;
     count++;
  }

// add node containing element after previous
  private void addAfter(DoubleNode<T> previous, Object element) {
     DoubleNode<T> node = new DoubleNode(element);
     node.setNext(previous.getNext());
     node.setPrevious(previous);
     node.getNext().setPrevious(node);
     previous.setNext(node);
     count++;
  }

}
