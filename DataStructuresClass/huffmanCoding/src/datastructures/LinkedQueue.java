package datastructures;
import java.util.*;


public class LinkedQueue<T> implements QueueADT<T> {
  private LinearNode<T> front;
  private LinearNode<T> rear;
  private int count;

  public LinkedQueue() {
    front = null;
    rear = null;
    count = 0;
  }

  public T dequeue() {
    if (front == null)
      throw new NoSuchElementException(
         "Tried to remove from empty queue");
     LinearNode<T> node = front;
     front = node.getNext();
     count--;
     if (front == null)
       rear = null;
     return node.getElement();
  }

  public void enqueue(T element) {
    LinearNode<T> node = new LinearNode(element);
    if (rear != null)
      rear.setNext(node);
    else
      front = node;
    rear = node;
    count++;
  }

  public T first() {
    if (front == null)
      throw new NoSuchElementException(
        "Tried to peek empty queue");
    return front.getElement();
  }

  public boolean isEmpty() {
    return count==0;
  }

  public int size() {
    return count;
  }

  public String toString() {
    StringBuffer buf = new StringBuffer(
      getClass().getName() + " size=" + count);
    LinearNode<T> next = front;
    while (next != null) {
      buf.append("\n" + next.getElement());
      next = next.getNext();
    }
    return buf.toString();
  }
}
