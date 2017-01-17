package bst;

/** Represents a node in a binary tree with a left and right child */ 
public class BinaryTreeNode<T> {
	protected T element; // element stored in this node
	protected  BinaryTreeNode<T> left; // reference to left subtree 
	protected  BinaryTreeNode<T> right; // reference to right subtree 
	
	/** Create a new tree node with the specified data */
	BinaryTreeNode(T obj) {
		element = obj;
		left = null;
		right = null;
	}
	
	/** Return the object stored in this node */
	public T getElement() {
		return element;
	}
	
	/** Return a reference to the left subtree at this node */
	public BinaryTreeNode<T> getLeft() {
		return left;
	}
	
	/** Return a reference to the right subtree at this node */
	public BinaryTreeNode<T> getRight() {
		return right;
	}	
	
	/** Set reference to the left subtree at this node */
	public void setLeft(BinaryTreeNode<T> node) {
		left = node;
	}
	
	/** Set reference to the right subtree at this node */
	public void setRight(BinaryTreeNode<T> node) {
		right = node;
	}

	/** Return the number of non-null children of this node */
	public int numChildren() {
		int children = 0;
		if (left != null)
			children = 1 + left.numChildren();
		if (right != null)
			children = children + 1 + right.numChildren();
		return children;
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Node[");
		if (left != null) 
			buf.append(left + ", ");
		else 
			buf.append("null, ");
		
		buf.append(element + ", ");
		if (right != null) 
			buf.append(right + "]");
		else 
			buf.append("null]");
		return buf.toString();
	}
} 
