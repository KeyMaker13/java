//*******************************************************************
//
//      BinaryTreeADT.java		Authors:  Lewis/Chase
//
//	   Defines the interface to a binary tree data structure
//*******************************************************************

package lib;

import java.util.Iterator;

/**
 * <p>Defines the interface to a binary tree data structure</p>
 * @author Lewis and Chase
 * @version 1.0
 */
public interface BinaryTreeADT<T> {

   /**
    * remove the left subtree of the root
    * of the binary tree.
    */
   public void removeLeftSubtree();

   /**
    * remove the right subtree of the root
    * of the binary tree
    */
   public void removeRightSubtree();

   /**
    * remove all elements from the binary
    * tree
    */
   public void removeAllElements();

   /**
    * return true if the binary tree is empty and false otherwise
    *
    * @return boolean
    */
   public boolean isEmpty();

   /**
    * return the number of elements in the
    * binary tree
    *
    * @return int
    */
   public int size();

   /**
    * return true if the binary tree contains an element that matches the
    * specified element and false otherwise
    *
    * @param targetElement element to be tested for equality
    * @return true if targetElement is in the tree and false otherwise
    */
   public boolean contains (T targetElement);

   /**
    * return a reference to the specified
    * element if it is found in the binary tree.
    *
    * @param targetElement element to be tested for equality
    * @return Object in tree that matched targetElement
    * @throws Throws an exception if the specified element is not found in the
    *   tree.
    */
   public T find (T targetElement);

   /**
    * returns a String representation of this object
    *
    * @return String representation of this object
    */
   public String toString();

   /**
    * return an Iterator that provides elements of the tree using inorder
    * traversal
    *
    * @return Iterator
    */
   public Iterator<T> iteratorInOrder();

   /**
    * return an Iterator that provides elements of the tree using preorder
    * traversal
    *
    * @return Iterator
    */
   public Iterator<T> iteratorPreOrder();

   /**
    * return an Iterator that provides elements of the tree using postorder
    * traversal
    *
    * @return Iterator
    */
   public Iterator<T> iteratorPostOrder();

   /**
    * return an Iterator that provides elements of the tree using levelorder
    * traversal
    *
    * @return Iterator
    */
   public Iterator<T> iteratorLevelOrder();

}  // interface BinaryTreeADT



