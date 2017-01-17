package dataStructures;

import java.util.NoSuchElementException;

public class RIForBST<T extends Comparable> implements ReversibleIterator<T>{
	//private PublicBTNode<T> current, next ;
	private LinkedBinarySearchTree<T> tree;
	private int count;
	
	//using a LinkedBinarySearchTree to do the iteration
	public RIForBST(LinkedBinarySearchTree<T> treeP){ //O(1)
	//	current = treeP.root;
		tree = treeP;
		count = -1;
	}
	
	//different constructor incase the user needs to select the start variable
	public RIForBST(LinkedBinarySearchTree<T> treeP, T start){ //O(n)
	//	current = treeP.root;
		
		tree = treeP;
		int i = 0;
		// get appropiate count number
		if (!tree.contains(start)){
			while(start.compareTo(tree.getTrack(i))>0){
				i++;
			}
			count = i - 1;
		}else{
		count = treeP.getIndexNumber(start) - 1;
		}
	}

	@Override
	
	//O(1)
	public boolean hasNext() { //returns true if the count variable is within appropriate range
		return (count>=-1 && count<tree.size()-1); 
	//	 return (next() != null);
	}

	@SuppressWarnings("unchecked")
	@Override
	// returns the value in the iteration by finding it from the BinarySearchTree by using find method
	// by grabing the correct item from an inOrder list
	public T next() { //O(n) i couldnt figure out using the node
		if(!hasNext()){
			throw new NoSuchElementException("");
		}
	//	PublicBTNode<T> node;
	// I tried to use the nodes to traverse but I had trouble with it and couldn't figure it out this is as far as I got.	
		
	//	if(current.right!=null){
	//	node = current.right;
	//	while(node.left!=null){
	//		node = node.left;
	//	}
	//	next = node;
	//	current = node;
	//	//node = current;
	//	}
	//	else if (current.right==null){
	//		PublicBTNode<T> child = current;
	//		PublicBTNode<T> parent = current.parent;
	//		
	//		while(parent!=null&&child==parent.right){
	//			child = parent;
	//			parent = parent.parent;
	//		}
			
	//		next = parent;
		//	current = parent;
			//node = parent;
	//	}
	
		//T ref = current.element;
		count++;
		//T ref =  tree.find(tree.getTrack(count));
		T ref = tree.getTrack(count);
		return ref;
	}
	
	@Override
	public void remove() {	
	}

	@Override
	//returns true if the count variable is within appropriate range
	public boolean hasPrevious() { //O(1)
		return (count>0&&count<=tree.size());
	}

	@Override
	//returns previous
	public T previous() { //O(n) // i couldnt get the node version to work
		if(!hasPrevious()){
			throw new NoSuchElementException();
		}
		count--;
	//	T ref =  tree.find(tree.getTrack(count));
		T ref = tree.getTrack(count);
		return ref;
	}
}
