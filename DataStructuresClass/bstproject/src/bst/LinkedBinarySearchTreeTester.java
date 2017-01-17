package bst;

import java.util.Iterator;



public class LinkedBinarySearchTreeTester {

	public static void main(String[] args) {
		System.out.println("Laboratory 11: Written by Ivan Capistran");
		LinkedBinarySearchTree<Integer> bst = new LinkedBinarySearchTree();
		Integer[] testValues = { 21, 15, 18, 37, 28, 45, 9, 22, 17 };
		Integer[] badValues = { 8, 16, 30, 80 };

		System.out.println("\nTesting addElement:");
		LinkedBinarySearchTree<Integer> tRoot = new LinkedBinarySearchTree<Integer>();
		for (int k = 0; k < testValues.length; k++)
			tRoot.addElement(testValues[k]);
		System.out.println("tRoot: " + tRoot);

		System.out.print("In order traversal: [ ");
		Iterator<Integer> iter = tRoot.iteratorInOrder();
		while (iter.hasNext())
			System.out.print(iter.next() + " ");
		System.out.println("]");
		
		System.out.println("AddElementRecursive\n");
		
		LinkedBinarySearchTree<Integer> tRoot1 = new LinkedBinarySearchTree<Integer>();
		
		for (int k = 0; k < testValues.length; k++)
			tRoot1.addElementRecursive(testValues[k]);
		System.out.println("tRoot: " + tRoot1);

		System.out.print("In order traversal: [ ");
		Iterator<Integer> iter1 = tRoot1.iteratorInOrder();
		while (iter1.hasNext())
			System.out.print(iter1.next() + " ");
		System.out.println("]");

		System.out.println("\nTesting find for items in the tree: ");
		for (int k = 0; k < testValues.length; k++) {
			try {
				System.out.println("Found " + tRoot.find(testValues[k]));
			} catch (Exception e) {
				System.out.println("Error: should have found " + testValues[k]);
			}
		}

		System.out.println("\nTesting find for items not in the tree: ");
		for (int k = 0; k < badValues.length; k++) {
			try {
				System.out.println("Error: should not have found "
						+ tRoot.find(badValues[k]));
			} catch (Exception e) {
				System.out.println("Did not find " + badValues[k]);
			}
		}

	    /** Add test code for laboratory here *************************************/
		System.out.println("\nTesting findRecursive for items in the tree:");
		for (int k = 0; k < testValues.length; k++) {
			try {
				System.out.println("Found " + tRoot.findRecursive(testValues[k]));
			} catch (Exception e) {
				System.out.println("Error: should have found " + testValues[k]);
			}
		}
		
		System.out.println("\nTesting findRecursive for items not in the tree: ");
		for (int k = 0; k < badValues.length; k++) {
			try {
				System.out.println("Error: should not have found "
						+ tRoot.find(badValues[k]));
			} catch (Exception e) {
				System.out.println("Did not find " + badValues[k]);
			}
		}
		
		System.out.println("\nTesting findMinRecursive");
		System.out.println("Min Value is: " + tRoot.findMinRecursive());
		
		System.out.println("\nTesting findMaxRecursive");
		System.out.println("Max Value is: " + tRoot.findMaxRecursive());
		
		Integer[] test1 = { 21, 15, 18, 37, 28, 45, 9, 22, 17 };
		  Integer[] test2 = { 9, 15, 17, 18, 21, 22, 28, 37, 45 };

		  System.out.println("\nAdding Elements:");
		  LinkedBinarySearchTree<Integer> tR = new LinkedBinarySearchTree<Integer>();
		  for (int k = 0; k < test1.length; k++)
		   tR.addElement(test1[k]);
		  System.out.println("testing : " + tR);

		  System.out.print("Testing preorder levels: \n");
		  Iterator<LevelElement<Integer>> iT = tR
		    .iteratorLevelsPreOrder();
		  while (iT.hasNext())
		   System.out.println(iT.next() + " ");

		  System.out.println("\nAdding Elements:");
		  LinkedBinarySearchTree<Integer> tR2 = new LinkedBinarySearchTree<Integer>();
		  for (int k = 0; k < test2.length; k++)
		   tR2.addElement(test2[k]);
		  System.out.println("testing: " + tR2);

		  System.out.print("Testing preorder levels: \n");
		  Iterator<LevelElement<Integer>> iT2 = tR2
		    .iteratorLevelsPreOrder();
		  while (iT2.hasNext())
		   System.out.println(iT2.next() + " ");
		  System.out.println();
		  
		  System.out.println("Testing height");
		  System.out.println("Height of first tree " + tR.getHeight());
		  System.out.println("Height of second tree " + tR2.getHeight());
		  
		  System.out.println("\nTesting getMaximumLeafLevel");
		  System.out.println("Testing first tree " + getMaximumLeafLevel(tR));
		  System.out.println("Testing second tree " + getMaximumLeafLevel(tR2));
		  
		  System.out.println("\nTesting getMinimumLeafLevel");
		  System.out.println("Testing first tree" + getMinimumLeafLevel(tR));
		  System.out.println("Testing second tree" + getMinimumLeafLevel(tR2));
		  
	}
	
	public static int getMaximumLeafLevel(LinkedBinarySearchTree root){
		// a good value for the countMax value is 0 because the root is zero
		int countMax = 0;
		Iterator<LevelElement<Integer>> iT = root.iteratorLevelsPreOrder();
		
		while(iT.hasNext()){
			LevelElement n = iT.next();
			if(n.isLeaf()){
				if(countMax<n.getLevel()){
					countMax = n.getLevel();
				}
			}
		}
		return countMax;
	}
	
	public static int getMinimumLeafLevel(LinkedBinarySearchTree root){
	// a good value for countMin is the root max because its the worst case scenario 
	int countMin = root.count;
	Iterator<LevelElement<Integer>> iT = root.iteratorLevelsPreOrder();
	while(iT.hasNext()){
		LevelElement n = iT.next();
		if(n.isLeaf()){
			if(countMin > n.getLevel()){
				countMin = n.getLevel();
			}
		}
	}
	return countMin;
	}
	
	
	
}
