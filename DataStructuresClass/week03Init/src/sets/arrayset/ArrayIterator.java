package sets.arrayset;
import java.util.*;

public class ArrayIterator <T> implements Iterator <T> {
	private T[] array;
	private int current;
	private int arrayCount;

	public ArrayIterator(T [] contents,
                       int count) {
	   current = 0;
	   array = contents;
	   arrayCount = count;
  }

  public boolean hasNext() {
	    return(current<arrayCount);
   }

  public T next() {
	if (current < arrayCount){
		T obj = array[current];
		current++;
		return obj;
	}
	throw new NoSuchElementException();
   }

  public void remove () {
    throw new
        UnsupportedOperationException(
            "remove not implemented for ArrayIterator");
  }

}
