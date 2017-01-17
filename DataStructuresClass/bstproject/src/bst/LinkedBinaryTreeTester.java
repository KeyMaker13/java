package bst;

import java.util.*;

public class LinkedBinaryTreeTester {
   public static void main(String[] args) {

	   // root's left subtree
       LinkedBinaryTree<Integer> twentyone = new LinkedBinaryTree<Integer>(21);
       LinkedBinaryTree<Integer> five =
               new LinkedBinaryTree<Integer>(5,null,twentyone);

       // root's right subtree 
       LinkedBinaryTree<Integer> fourtytwo = new LinkedBinaryTree<Integer>(42);
       LinkedBinaryTree<Integer> twenty =
               new LinkedBinaryTree<Integer>(20, fourtytwo,null);

       LinkedBinaryTree<Integer> seven = new LinkedBinaryTree<Integer>(7);
       LinkedBinaryTree<Integer> six =
               new LinkedBinaryTree<Integer>(6,seven,twenty);

       LinkedBinaryTree<Integer> tree =
               new LinkedBinaryTree<Integer>(4,five,six);

       System.out.println(tree.toString());
       System.out.println("tree size = "+tree.size());
       
       // test inorder traversal
       System.out.println("Inorder traversal:");
       Iterator<Integer> it = tree.iteratorInOrder();
       while(it.hasNext()){
    	   System.out.print(it.next()+" ");
       }
       System.out.println();

       System.out.println("\nPreorder traversal:");
       it = tree.iteratorPreOrder();
       while(it.hasNext()){
    	   System.out.print(it.next()+" ");
       }
       System.out.println();

       System.out.println("\nPostorder traversal:");
       it = tree.iteratorPostOrder();
       while(it.hasNext()){
    	   System.out.print(it.next()+" ");
       }
       System.out.println();

       System.out.println("\nLevelorder traversal:");
       it = tree.iteratorLevelOrder();
       while(it.hasNext()){
    	   System.out.print(it.next()+" ");
       }
       System.out.println();


   }
}
