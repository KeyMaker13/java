package dataStructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBinarySearchTree<T extends Comparable> extends
		LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {
	
	public LinkedBinarySearchTree() { 
		super();
	}

	public LinkedBinarySearchTree(T element) {
		super(element);
	}

	/** Constructor needed for extra-credit part IV of the lab. */
	public LinkedBinarySearchTree(PublicBTNode<T> root) {
		this.root = root;
	}

	/** Overridden methods ************************************** */

	/** Constructor overridden since left and right subtree might not be ordered */
	public LinkedBinarySearchTree(T element, LinkedBinaryTree<T> leftSubtree,
			LinkedBinaryTree<T> rightSubtree) {
		throw new UnsupportedOperationException(
				"Constructor with leftSubtree and rightSubtree parameters is not supported in LinkedBinarySearchTree.");
	}

	/** Add element in the tree so as to maintain the order */
	@SuppressWarnings("unchecked")
	public void addElement(T element) {
		PublicBTNode<T> temp = new PublicBTNode<T>(element);

		if (isEmpty()) {
			root = temp;
			count++;
		//	track.add(temp.element);
			return;
		}
		PublicBTNode<T> current = root;
		boolean added = false;

		while (!added) {
			if (element.compareTo(current.element) < 0) {
				if (current.left == null) {
					current.left = temp;
				
				
					added = true;
				} else
					current = current.left;
			} else {
				if (current.right == null) {
					current.right = temp;
				

					added = true;
				} else
					current = current.right;
			}
		}
		count++;
		
	}

	/** Part II: addElementRecursive goes here ************************** */

	public void addElementRecursive(T element){
		
		if(isEmpty()){
			root = new PublicBTNode<T>(element);
			count++;
			return;
		}else{
		
		addElementRecursive(element,root);
		}
	}
	private void addElementRecursive(T element, PublicBTNode node){
		if(element.compareTo(node.element) <0){
			if(node.left == null)
			{
			node.left = new PublicBTNode<T>(element);
			count++;
			return;
			}
			else
			{
			addElementRecursive(element,node.left);
			}
		}
		else
		{
			if(node.right==null)
			{
				node.right = new PublicBTNode<T> (element);
				count++;
				return;
			}
			else
			{
				addElementRecursive(element,node.right);
			}
		}
	}
	
	//Discussion
	// Base case when the left node is empty or right node is empty 
	// recursive is when the destined node is not null then method will 
	//call again until you find a null node that is following the guidelines of
	//whether its larger or smaller
	
	// add element iterative runs through the nodes using a while loop
	// add element recursive calls the method again until it finds a null appropiate node
	
	/** Return element matching targetElement(overrides find in LinkedBinaryTree) */
	public T find(T targetElement) { // Runtime: O(height)
		PublicBTNode<T> current = root;
		while (current != null) {
			if (targetElement.compareTo(current.getElement()) == 0)
				return current.getElement();
			else if (targetElement.compareTo(current.getElement()) < 0)
				current = current.getLeft();
			else
				current = current.getRight();
		}
		throw new NoSuchElementException("Find");
	}

	/** Part II: findRecursive goes here **************************** */
	
	public T findRecursive(T targetElement){
		
		if(isEmpty()){
			throw new NoSuchElementException("Find");
		}
		return findRecursive(targetElement,root);
	}
	//need to change to private
	private T findRecursive(T targetElement, PublicBTNode<T> node){
		PublicBTNode<T> current = node;
	
		//if (current.left !=null || current.right!=null && current.element!=null){
			if (targetElement.equals(current.element)){
				return  current.getElement();
			}
			else if (targetElement.compareTo(current.element)<0){
				
				current = current.getLeft();
				return findRecursive(targetElement, current);
				
			}
			else{
			
				current = current.getRight();
				return findRecursive(targetElement,current);
				
			}
			}
	
	// Discussion
	// Base case - when the node equals the targetElement
	// Recursive case - test whether the element is smaller or greater than the node
	// to determine whether to traverse left node or right node
	
	// Iterative solution used a while loop with the same checks of if statements 
	// as the recursive case.
	

	/** Return a reference to the smallest element in this tree. */
	public T findMin() {
		if (isEmpty())
			throw new NoSuchElementException(
					"binary search tree findMin: empty tree");

		PublicBTNode<T> current = root;
		while (current.left != null)
			current = current.left;
		return current.element;
	}

	/** Part II: findMinRecursive goes here **************************** */
	
	public T findMinRecursive(){
		
		if(isEmpty()){
			
			throw new NoSuchElementException();
		}
		return findMinRecursive(root);
	}
	
	private T findMinRecursive(PublicBTNode<T> node){
		
		PublicBTNode<T> ref = node;
		if(ref.left!=null){
			return findMinRecursive(ref.left);
		}
			return ref.element;
	}
	
	// Base case - no base case
	
	/** Return a reference to the largest element in this tree. */
	public T findMax() {
		if (isEmpty())
			throw new NoSuchElementException(
					"binary search tree findMax: empty tree");
		PublicBTNode<T> current = root;
		while (current.right != null)
			current = current.right;
		return current.element;
	}

	/** Part II: findMaxRecursive goes here **************************** */

	public T findMaxRecursive(){
		if(isEmpty()){
			throw new NoSuchElementException("Blah Fail");
		}
		return findMaxRecursive(root);
	}
	
	private T findMaxRecursive(PublicBTNode<T> node)
	{
		PublicBTNode<T> ref = node;
		if (ref.right!=null){
			return findMaxRecursive(ref.right);
		}
		return ref.element;
	}
	// Base case - no base case

	/** Remove and return the specified element from this tree. */
	public T removeElement(T targetElement) {
		T result = null;
		if (isEmpty())
			throw new NoSuchElementException("removeElement: is empty");

		if (targetElement.equals(root.element)) { // Root has target element
			result = root.element;
			root = replacement(root);
			count--;
			return result;
		}
		PublicBTNode<T> parent = root;
		PublicBTNode<T> current;
		if (targetElement.compareTo(root.element) < 0)
			current = root.left;
		else
			current = root.right;

		while (current != null) {
			if (targetElement.compareTo(current.element) == 0) {
				count--;
				result = current.element;
				if (current == parent.left)
					parent.left = replacement(current);
				else
					parent.right = replacement(current);
				return result;
			}
			parent = current;
			if (targetElement.compareTo(current.element) < 0)
				current = current.left;
			else
				current = current.right;
		} // while
		throw new NoSuchElementException("binary search tree");
	}

	/** Remove all occurrences of the specified element from this tree. */
	public void removeAllOccurrences(T targetElement) {
		removeElement(targetElement);
		while (contains((T) targetElement))
			removeElement(targetElement);
	}

	/** Remove and return the smallest element from this tree. */
	public T removeMin() {
		T result = null;

		if (isEmpty())
			throw new NoSuchElementException(
					"binary search tree removeMin: empty tree");
		if (root.left == null) { // root is smallest element
			result = root.element;
			root = root.right;
			count--;
			return result;
		}

		PublicBTNode<T> parent = root;
		PublicBTNode<T> current = root.left;
		while (current.left != null) {
			parent = current;
			current = current.left;
		}
		result = current.element;
		parent.left = current.right;
		count--;
		return result;
	}

	/** Remove and return the largest element from this tree. */
	public T removeMax() {
		T result = null;
		if (isEmpty())
			throw new NoSuchElementException(
					"binary search tree removeMax: empty tree");

		if (root.right == null) { // root is largest
			result = root.element;
			root = root.left;
			count--;
			return result;
		}

		PublicBTNode<T> parent = root;
		PublicBTNode<T> current = root.right;
		while (current.right != null) {
			parent = current;
			current = current.right;
		}
		result = current.element;
		parent.right = current.left;
		count--;
		return result;
	}

	/** Helper function to put node in the correct place */
	private PublicBTNode<T> replacement(PublicBTNode<T> node) {
		PublicBTNode<T> result = null;

		if ((node.left == null) && (node.right == null))
			return null;

		if ((node.left != null) && (node.right == null))
			return node.left;

		if ((node.left == null) && (node.right != null))
			return node.right;

		PublicBTNode<T> current = node.right;
		PublicBTNode<T> parent = node;

		while (current.left != null) {
			parent = current;
			current = current.left;
		}

		if (node.right == current)
			current.left = node.left;
		else {
			parent.left = current.right;
			current.right = node.right;
			current.left = node.left;
		}
		return current;
	}
	
	public int getHeight()
	{
	if(isEmpty())
	throw new NoSuchElementException("Empty Tree");

	return getHeightRecursive(root);

	}
	/** Part III: getHeightRecursive goes here ************************ */
	private int getHeightRecursive(PublicBTNode<T> node)
	{
	if(node.left==null && node.right==null)
	{
	return 0;
	}

	int leftHeight=-1;
	int rightHeight=-1;

	if(node.left!=null)
	{
	leftHeight=getHeightRecursive(node.left);
	}

	if(node.right!=null)
	{
	rightHeight=getHeightRecursive(node.right);
	}
	return 1+ Math.max(leftHeight, rightHeight);

	} 	
	/** Part III: printTreeLevels goes here ****************** */
	
	public Iterator <LevelElement <T>> iteratorLevelsPreOrder(){
		ArrayList<LevelElement<T>> list = new ArrayList<LevelElement<T>>();
		preorderLevels(root,list,0);
		return list.iterator();
		
		
	}
	
	protected void preorderLevels(PublicBTNode<T> node, ArrayList<LevelElement <T>> list, int level){
		if(node!=null){
		
		LevelElement<T> element = new LevelElement<T>(node.getElement(),level,node.numChildren()==0);
		list.add(level,element);
		level = level +1;
		preorderLevels(node.left,list,level);
		preorderLevels(node.right,list,level);
	}}
	
	
	public T getTrack(int i){
		if (i < 0||i>size()){
			throw new ArrayIndexOutOfBoundsException();
		}
	
		ArrayList<T> list = changeToInOrder();
		
		return (T) list.get(i);
	}
	
	public int getIndexNumber(T element){
		ArrayList<T>list = changeToInOrder();
	
		int i = 0;
		
		while(list.get(i)!=element){
			i++;
		}
		
	return i;
	}
	private ArrayList<T> changeToInOrder(){
		Iterator<T> iter = super.iteratorInOrder();
		ArrayList<T> list = new ArrayList<T>();
		while(iter.hasNext()){
		list.add((T) iter.next());	
		}
		return list;
	}
	
}
