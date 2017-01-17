package lib;

import java.util.*;

public class LinkedBinaryTreeTester {
   public static void main(String[] args) {

      LinkedBinaryTree<String> myTree = new LinkedBinaryTree<String>(
            "+",
            new LinkedBinaryTree<String>("a"),
            new LinkedBinaryTree<String>(
                  "*",
                  new LinkedBinaryTree<String>(
                        "-",
                        new LinkedBinaryTree<String>("b"),
                        new LinkedBinaryTree<String>("c")),
                  new LinkedBinaryTree<String>("d"))
            );

      System.out.println(myTree);

      System.out.println("\nTesting contains and find:");
      System.out.println("   Does myTree contain b? " + myTree.contains("b"));
      System.out.println("   Does myTree contain 20? " + myTree.contains("20"));
      System.out.println("   To find d in myTree, we got: " + myTree.find("d"));

      System.out.print("\nInorder traversal of myTree: [");
      Iterator<String> iter = myTree.iteratorInOrder();
      while (iter.hasNext())
         System.out.print(iter.next() + " ");
      System.out.println("]");
           

      System.out.print("Preorder traversal of myTree: [");
      iter = myTree.iteratorPreOrder();
      while (iter.hasNext())
         System.out.print(iter.next() + " ");
      System.out.println("]");
      
      System.out.print("Postorder traversal of myTree: [");
      iter = myTree.iteratorPostOrder();
      while (iter.hasNext())
         System.out.print(iter.next() + " ");
      System.out.println("]");

      System.out.print("Levelorder traversal of myTree: [");
      iter = myTree.iteratorLevelOrder();
      while (iter.hasNext())
         System.out.print(iter.next() + " ");
      System.out.println("]");


   }
}
