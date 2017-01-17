package queues;
import java.util.*;
import lib.*;


public class LinkedQueue<T> implements QueueADT<T> {
  private LinearNode<T> front;
  private LinearNode<T> rear;
  private int count;

  private static boolean debug = false;
  public static void setDebug(boolean t){
    debug = t;
  }

  public LinkedQueue() {
    front = null;
    rear = null;
    count = 0;
    if (debug) {
      System.out.println("Construct queue\n" + toString());
    }
  }

  public void enqueue(T element) {
    LinearNode<T> node = new LinearNode<T>(element);
    if (count == 0) {
      front = node;
    } else {
      rear.setNext(node);
    }
    rear = node;
    count++;

     if (debug) {
       System.out.println("enqueue " + element + "\n" + toString());
     }

   }


  public T dequeue() {
    if (count==0) {
      throw new NoSuchElementException(
          "Tried to remove element from empty queue");
    }
    LinearNode<T> node= front;
    front = node.getNext();
    count--;
    if (count==0) {
      rear = null;
    }
     if (debug) {
       System.out.println("dequeue " + node.getElement() + "\n" + toString());
     }
     return node.getElement();
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
      getClass().getName() + ": size=" + count);
    buf.append("\nfront --------->");
    LinearNode<T> next = front;
    while (next != null) {
      buf.append("\n" + next.getElement());
      next = next.getNext();
    }
    buf.append("\n<--------- rear");
    return buf.toString();
  }
}
