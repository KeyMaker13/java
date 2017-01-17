package lib;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class HeapPriorityQueue<T extends Comparable<T>>
  implements PriorityQueueADT<T>{

  private ArrayListHeap<T> heap;

  public HeapPriorityQueue() {
    heap = new ArrayListHeap<T>();
  }

  public void makeEmpty() {
  }

  public void add(T element) {
    heap.addElement(element);
  }

  public T removeMin() {
    return heap.removeMin();
  }

  public T findMin() {
    return heap.findMin();
  }

  public boolean isEmpty() {
    return heap.isEmpty();
  }

  public int size() {
    return heap.size();
  }

  public String toString() {
    return heap.toString();
  }
}
