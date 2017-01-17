package sets.arrayset;
import java.util.*;
/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author Prof. Weining Zhang
 * @version 1.0
 */

public class ArrayIterator <T> implements Iterator<T> {
  private int current; // position of next
  private int arrayCount;
  private T [] array;
  public ArrayIterator(T [] contents,
                       int count) {
    current = 0;
    array = contents;
    arrayCount = count;
  }

  public boolean hasNext() {
     return current < arrayCount;
  }

  public T next() {
    if (current < arrayCount) {
       T obj = array[current];
       current++;
       return obj;
    }
    throw new NoSuchElementException(
         "At end ");
  }

  public void remove () {
    throw new
        UnsupportedOperationException(
            "remove not implemented for ArrayIterator");
  }

}
