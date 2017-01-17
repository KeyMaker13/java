package binarysearchtree;

import java.util.NoSuchElementException;

import lib.BinaryTreeNode;
import lib.ElementNotFoundException;
import lib.EmptyCollectionException;
import lib.LinkedBinaryTree;


/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2004</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class LinkedBinarySearchTree<T extends Comparable<T>> extends
      LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {

   //================================================================
   //  Creates an empty binary search tree.
   //================================================================
   public LinkedBinarySearchTree() {
      super();
   } // constructor BinarySearchTree

   //================================================================
   //  Creates a binary search with the specified element as its
   //  root.
   //================================================================
   public LinkedBinarySearchTree(T element) {
     super(element);
   } // constructor BinarySearchTree

   //================================================================
   //  Adds the specified object to the binary search tree in the
   //  appropriate position according to its key value.  Note that
   //  equal elements are added to the right.
   //================================================================
   public void addElement(T element) {
	   
	   BinaryTreeNode<T> node = new BinaryTreeNode<T>(element);
	   if(isEmpty()){
		   root = node;
	   }else{
		   BinaryTreeNode<T> current = root;
		   boolean added = false;
		   while(!added){
			   if(element.compareTo(current.getElement())<0){ // go into left subtree
				   if(current.getLeft()==null){
					   current.setLeft(node);
					   added = true;
				   }else{
					   current = current.getLeft();
				   }
				   
			   }else{// go into right subtree
				   if(current.getRight()==null){
					   current.setRight(node);
					   added = true;
				   }else{
					   current = current.getRight();
				   }
				   
				   
				   
			   }
			   
		   }
	   }
	   
	   count++;

   } // method addElement

   //================================================================
   //  Removes the first element that matches the specified target
   //  element from the binary search tree and returns a reference to
   //  it.  Throws a ElementNotFoundException if the specified target
   //  element is not found in the binary search tree.
   //================================================================
   public T removeElement(T targetElement) throws
         ElementNotFoundException {

      T result = null;

      if(isEmpty()){
    	  throw new ElementNotFoundException("Empty BST");
      }else{
    	  if (targetElement.equals(root.getElement())){// element is in the root
    		  result = root.getElement();
    		  root = replacement(root);
    		  count--;
    		  
    	  }else{// search for and delete
    		  BinaryTreeNode<T> current, parent = root;
    		  boolean found = false;
    		  
    		  if(targetElement.compareTo(parent.getElement())<0){
    			  current = parent.getLeft();
    		  }else{
    			  current = parent.getRight();
    		  }
    		  
    		  while(current!=null && !found){
    			  if(targetElement.equals(current.getElement())){
    				  found = true;
    				  count--;
    				  result = current.getElement();
    				  
    				  if(current==parent.getLeft()){
    					  parent.setLeft(replacement(current));
    				  }else{
    					  parent.setRight(replacement(current));
    				  }
    			  }else{// continue search
    				  parent = current;
    				  if(targetElement.compareTo(parent.getElement())<0){
    					  current = parent.getLeft();
    				  }else{
    					  current = parent.getRight();
    				  }
    				  
    				  
    			  }
    		  }
    		  if(!found){
    			  throw new ElementNotFoundException("");
    		  }
    		  
    	  }
    	  
      }
      
      
       return result;

   } // method removeElement

   //================================================================
   //  Removes elements that match the specified target
   //  element from the binary search tree
   //  Throws a ElementNotFoundException if the sepcified target
   //  element is not found in the binary search tree.
   //================================================================
   public void removeAllOccurrences(T targetElement) throws
         ElementNotFoundException {
      removeElement(targetElement);

      try {
         while (contains( (T) targetElement))
            removeElement(targetElement);
      } catch (Exception ElementNotFoundException) {
      }

   } // method removeAllOccurrences

   //================================================================
   //  Removes the node with the least value from the binary search
   //  tree and returns a reference to its element.  Throws an
   //  EmptyBinarySearchTreeException if the binary search tree is
   //  empty.
   //================================================================
   public T removeMin() throws EmptyCollectionException {
	  
	   if(isEmpty()){
		   throw new NoSuchElementException("Empty BST");
	   }
	  // return removeElement(findMin());
	   count--;
	   if(root.getLeft()==null){
		   T result = root.getElement();
		   root = root.getRight();
		   return result;
	   }
	   BinaryTreeNode<T> current = root.right;
	   while(current.right!=null)//
		   current = current.right;
	   return current.element;
	   
      //return null;
   } // method removeMin

   public T findMin(BinaryTreeNode<T> node) {
	   if (isEmpty()){
		   throw new NoSuchElementException();
	   }
	   BinaryTreeNode<T> current = node;
	   while(current.left!=null){
		   current = current.left;
		   
	   }
	   
        return current.element;
   }

   public T remove2(T targetElement) {

      T result = null;
       return result;

   } // method removeElement

   public BinaryTreeNode<T> removeMin(BinaryTreeNode<T> node) {
      if (node == null)
         return null;
      if (node.getLeft() == null)
         return node.getRight();
      node.setLeft(removeMin(node.getLeft()));
      return node;
   }

   //================================================================
   //  Removes the node with the highest value from the binary
   //  search tree and returns a reference to its element.  Throws an
   //  EmptyBinarySearchTreeException if the binary search tree is
   //  empty.
   //================================================================
   public T removeMax() throws EmptyCollectionException {
  	 if(isEmpty())
  		 throw new NoSuchElementException("Empty tree -- can't find max");
  	 
  	 if(root.right==null)//no right subtree
  		// return root.element;
  		 return removeElement(root.element);
  		 
  	 BinaryTreeNode<T> current = root.right;
  	 while(current.right!=null)//make current max node
  		 current = current.right;
  	 return removeElement(current.element);
   }

   // method removeMax

   //================================================================
   //  Returns the element with the least value in the binary search
   //  tree.  It does not remove the node from the binary search
   //  tree.  Throws an EmptyBinarySearchTreeException if the binary
   //  search tree is empty.
   //================================================================
   public T findMin() throws EmptyCollectionException {
      if (isEmpty()) // emtpy tree -- no min
         throw new NoSuchElementException("Empty tree -- can't find min");
      if (root.left == null) // no left subtree
         return root.element;
      BinaryTreeNode<T> current = root.left;
      while (current.left != null) // make current min node
         current = current.left;
      return current.element;

   } // method findMin

   //================================================================
   //  Returns the element with the highest value in the binary
   //  search tree.  It does not remove the node from the binary
   //  search tree.  Throws an EmptyBinarySearchTreeException if the
   //  binary search tree is empty.
   //================================================================
   public T findMax() throws EmptyCollectionException {
      if (isEmpty()) // emtpy tree -- no max
         throw new NoSuchElementException("Empty tree -- can't find max");
      if (root.right == null) // no right subtree
         return root.element;
      BinaryTreeNode<T> current = root.right;
      while (current.right != null) // make current min node
         current = current.right;
      return current.element;

   } // method findMax

   //================================================================
   //  Returns a reference to a node that will replace the one
   //  specified for removal.  In the case where the removed
   //  node has two children, the inorder successor is used
   //  as its replacement.
   //================================================================
   protected BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
      BinaryTreeNode<T> result = null;

      if ( (node.left == null) && (node.right == null))
         result = null;
      else if ( (node.left != null) && (node.right == null))
         result = node.left;
      else if ( (node.left == null) && (node.right != null))
         result = node.right;
      else {
         BinaryTreeNode<T> current = node.right;
         BinaryTreeNode<T> parent = node;

         while (current.left != null) {
            parent = current;
            current = current.left;
         } //while

         if (node.right == current)
            current.left = node.left;
         else {
            parent.left = current.right;
            current.right = node.right;
            current.left = node.left;
         }
         result = current;
      } //else
      return result;

   } // method replacement

} // class BinarySearchTree

