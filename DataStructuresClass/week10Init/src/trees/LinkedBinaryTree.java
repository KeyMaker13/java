package trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import lib.LinkedQueue;
import lib.QueueADT;

/**
 * <p>Linked implementation of a binary tree supporting 4 traversals</p>
 *
 * <P></p>
 * @author not attributable
 * @version 1.0
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {
   protected BinaryTreeNode<T> root;
   protected int count;

   /**
    * Initializes a newly-created empty binary tree
    */
   public LinkedBinaryTree() {
      // to be implemented
	   this(null,null,null);
   }

   /**
    * Initializes a newly-created binary tree with no subtrees.
    *
    * @param element Object
    */
   public LinkedBinaryTree(T element) {
      // to be implemented
	   this(element,null,null);
   }

   /**
    * Initializes a newly-created binary tree with both left and right subtrees
    *
    * @param element value of this node
    * @param leftSubtree left subtree at this node
    * @param rightSubtree right subtree at this node
    */
   public LinkedBinaryTree(T element,
                           LinkedBinaryTree<T> leftSubtree,
                           LinkedBinaryTree<T> rightSubtree) {
 
  	 // to be implemented
	   if (element == null){
		   root = null;
		   count = 0;
	   }else{
		   
		   root = new BinaryTreeNode(element);
		   count =1;
		   
		   if(leftSubtree!=null){
			   root.left = leftSubtree.root;
			   count += leftSubtree.size();
		   }
		   if(rightSubtree!=null){
			   root.right = rightSubtree.root;
			   count+= rightSubtree.size();
		   }
	   }
  	 
   }

   /**
    * return true if the binary tree contains an element that matches the
    * specified element and false otherwise
    *
    * @param targetElement element to be tested for equality
    * @return true if targetElement is in the tree and false otherwise
    */
   public boolean contains(T targetElement) {
  	 // to be implemented
	   
	   
  	 
      return getElement(root,targetElement)!=null;
   }

   /**
    * return a reference to the specified
    * element if it is found in the binary tree.
    *
    * @param targetElement element to be tested for equality
    * @return Object in tree that matched targetElement
    * @throws Throws an exception if the specified element is not found in the
    *   tree.
    */
   public T find(T targetElement) {
  	 // to be implemented
	 T obj = getElement(root,targetElement);
	 if(obj==null){
		 throw new NoSuchElementException(targetElement + " not found");
	 }
  	 return getElement(root,targetElement)	;
   }
   /**
    * return true if the binary tree is empty and false otherwise
    *
    * @return boolean
    */
   public boolean isEmpty() {
  	 // to be implemented
      return count==0;
   }

   /**
    * return an Iterator that provides elements of the tree using inorder
    * traversal
    *
    * @return Iterator
    */
   public Iterator<T> iteratorInOrder() {
  	 // to be implemented
	   ArrayList<T> tempList = new ArrayList<T>();
	   inorder(tempList,root);
	   
  	 return tempList.iterator();
  	 }

   /**
    * return an Iterator that provides elements of the tree using levelorder
    * traversal
    *
    * @return Iterator
    */
   public Iterator<T> iteratorLevelOrder() {
  	 // to be implemented
	   ArrayList<T> tempList = new ArrayList<T>();
	   levelorder(tempList);
	   
  	 return tempList.iterator();

   }

   /**
    * return an Iterator that provides elements of the tree using postorder
    * traversal
    *
    * @return Iterator
    */
   public Iterator<T> iteratorPostOrder() {
  	 // to be implemented
	   
	   ArrayList<T> tempList = new ArrayList<T>();
	   postorder(tempList,root);
	   
  	 return tempList.iterator();
  	
   }

   /**
    * return an Iterator that provides elements of the tree using preorder
    * traversal
    *
    * @return Iterator
    */
   public Iterator<T> iteratorPreOrder() {
  	 // to be implemented
	   
	   ArrayList<T> tempList = new ArrayList<T>();
	   preorder(tempList,root);
	   
  	 return tempList.iterator();
  	
    }

   /**
    * remove the left subtree of the root
    * of the binary tree.
    */
   public void removeLeftSubtree() {
  	 // to be implemented
	   
	   if (root.left == null) return;
	   count = count-1 -root.left.numChildren();
	   root.left = null;
	   
   }

   /**
    * remove the right subtree of the root
    * of the binary tree
    */
   public void removeRightSubtree() {
  	 // to be implemented
	   if (root.right == null) return;
	   count = count-1 -root.right.numChildren();
	   root.right = null;
   }

   /**
    * remove all elements from the binary
    * tree
    */
   public void removeAllElements() {
  	 // to be implemented
	   root = null;
			   count =0;
   }

   /**
    * return the number of elements in the
    * binary tree
    *
    * @return int
    */
   public int size() {
      return count;
   }

   /**
    * returns a String representation of this object
    *
    * @return String representation of this object
    */
   public String toString() {
      StringBuffer sb = new StringBuffer(getClass().getName() +
                                         " size=" + size() + "\n");
 /*    Iterator itr = this.iteratorInOrder();
     while (itr.hasNext()) {
       sb.append(itr.next() + "\n");
     }
      return sb.toString();
 */
     if (!isEmpty()) {
        sb.append("[" + root.toString() + "]");
     } else {
        sb.append("[null]");
     }
     return sb.toString();
   }

   //*************************PRIVATE METHODS*********************************

    private void inorder(ArrayList<T> list, BinaryTreeNode<T> node) {
       if (node == null)
          return;
       inorder(list, node.left);
       list.add(node.element);
       inorder(list, node.right);
    }

 
   private void postorder(ArrayList<T> list, BinaryTreeNode<T> node) {
      if (node == null)
         return;
      postorder(list, node.left);
      postorder(list, node.right);
      list.add(node.element);
   }

   private void preorder(ArrayList<T> list, BinaryTreeNode<T> node) {
      if (node == null)
         return;
      list.add(node.element);
      preorder(list, node.left);
      preorder(list, node.right);
   }

   private void levelorder(ArrayList<T> list) {
     QueueADT<BinaryTreeNode<T>> queue = new LinkedQueue<BinaryTreeNode<T>>();
     queue.enqueue(root);
     while (!queue.isEmpty()) {
        BinaryTreeNode<T> node = (BinaryTreeNode<T>) (queue.dequeue());
        list.add(node.element);
        if (node.left != null)
           queue.enqueue(node.left);
        if (node.right != null)
           queue.enqueue(node.right);
     }
  }

   private T getElement(BinaryTreeNode<T> node, T target) {
      if (node == null)
         return null;
      if (node.element.equals(target))
         return (T)node.element;
      T obj = getElement(node.left, target);
      if (obj != null)
         return obj;
      return getElement(node.right, target);
   }

}
