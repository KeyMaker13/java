package lib;

import lib.BinaryTreeADT;

/**
 * <p>Defines the interface to a binary search tree </p>
 *
 * @author Lewis and Chase
 * @version 1.0
 */
public interface BinarySearchTreeADT<T extends Comparable>
      extends BinaryTreeADT<T> {

   public void addElement(T element);

   public T removeElement(T targetElement);

   public void removeAllOccurrences(T targetElement);

   public T removeMin();

   public T removeMax();

   public T findMin();

   public T findMax();

} // interface BinarySearchTreeADT
