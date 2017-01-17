package linkedlist;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class DoubleLinkedIterator<T> implements Iterator {
	


		private DoubleNode<T> current;  // the current position

		//-------------------------------------------------------------
		//  Sets up this iterator using the specified items.
		//-------------------------------------------------------------
		public DoubleLinkedIterator (DoubleNode<T> collection)
		{
			current = collection;
		}

		//-------------------------------------------------------------
		//  Returns true if this iterator has at least one more element
		//  to deliver in the iteration.
		//-------------------------------------------------------------
		public boolean hasNext() //O(1)
		{
			return (current!= null);
		}

		//-------------------------------------------------------------
		//  Returns the next element in the iteration. If there are no
		//  more elements in this iteration, a NoSuchElementException is
		//  thrown.
		//-------------------------------------------------------------
		public T next() //O(1)
		{
			if (! hasNext())
				throw new NoSuchElementException();

			T result = current.getElement();
			current = current.getNext();
			return result;
		}

		//-------------------------------------------------------------
		//  The remove operation is not supported.
		//-------------------------------------------------------------
		public void remove() throws UnsupportedOperationException //O(1)
		{
			throw new UnsupportedOperationException();
		}
	

}
