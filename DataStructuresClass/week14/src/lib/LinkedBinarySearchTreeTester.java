package lib;

import java.util.*;
public class LinkedBinarySearchTreeTester {

   public static void main(String[] args) {

      Random rand = new Random();
      Integer temp = null;
      Integer root = new Integer(rand.nextInt(100));
      LinkedBinarySearchTree<Integer> bst = new
            LinkedBinarySearchTree();
      System.out.println("Create bst " + bst + "\n");

      System.out.println("add " + root);
      bst.addElement(root);
      System.out.println("bst = " + bst);
      System.out.print("the list inorder is: ");
      Iterator iter = bst.iteratorInOrder();
      while (iter.hasNext()){
         System.out.print(" "+iter.next());
      }
      System.out.println("\n");

      System.out.print("adding these numbers:");
      for (int i = 0; i < 10; i++){
         temp = new Integer(rand.nextInt(100));
         System.out.print("add "+temp + "\n");
         bst.addElement(temp);
         System.out.println("bst = " + bst);
      }
      System.out.println("");
      System.out.print("the list level order is: ");
      iter = bst.iteratorLevelOrder();
      while (iter.hasNext()){
         System.out.print(" "+iter.next());
      }
      System.out.println("\n");


      System.out.println("remove last one added ");
      bst.remove2(temp);
      System.out.println("bst = " + bst);
      System.out.print("the list preorder is: ");
      iter = bst.iteratorPreOrder();
      while (iter.hasNext()){
         System.out.print(" "+iter.next());
      }
      System.out.println("\n");

      System.out.println("remove root ");
      bst.remove2(root);
      System.out.println("bst = " + bst);
      System.out.print("the list postorder is: ");
      iter = bst.iteratorPostOrder();
      while (iter.hasNext()){
         System.out.print(" "+iter.next());
      }
      System.out.println("\n");

   }
}
