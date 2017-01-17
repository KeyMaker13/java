package bst;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {
	protected int count;
	protected BinaryTreeNode<T> root;

	/** Create an empty binary tree */
	public LinkedBinaryTree() {
		count = 0;
		root = null;
	}

	/** Create a binary tree with specified element as its root. */
	public LinkedBinaryTree(T element) {
		count = 1;
		root = new BinaryTreeNode<T>(element);
	}

	/** Create a binary tree with specified child trees. */
	public LinkedBinaryTree(T element, LinkedBinaryTree<T> leftSubtree,
			LinkedBinaryTree<T> rightSubtree) {
		root = new BinaryTreeNode<T>(element);
		count = 1;

		if (leftSubtree != null) {
			count = count + leftSubtree.size();
			root.left = leftSubtree.root;
		} else
			root.left = null;

		if (rightSubtree != null) {
			count = count + rightSubtree.size();
			root.right = rightSubtree.root;
		} else
			root.right = null;
	}

	/** Remove the left subtree of the root of this binary tree. */
	public void removeLeftSubtree() {
		if (root.left != null)
			count = count - root.left.numChildren() - 1;
		root.left = null;
	}

	/** Remove the right subtree of the root of this binary tree. */
	public void removeRightSubtree() {
		if (root.right != null)
			count = count - root.right.numChildren() - 1;

		root.right = null;
	}

	/** Remove all elements from this binary tree. */
	public void removeAllElements() {
		count = 0;
		root = null;

	}

	/** Return true if this binary tree is empty and false otherwise. */
	public boolean isEmpty() {
		return (count == 0);
	}

	/** Return the number of elements in this binary tree. */
	public int size() {
		return count;
	}

	/** Return true if the binary tree contains targetElement */
	public boolean contains(T targetElement) {
		boolean found = false;
		try {
			find(targetElement);
			found = true;
		} catch (Exception e) {
			found = false;
		}
		return found;
	}

	/** Return targetElement if found, otherwise throw exception */
	public T find(T targetElement) {
		BinaryTreeNode<T> current = findAgain(targetElement, root);
		if (current == null)
			throw new NoSuchElementException("binary tree find");

		return (current.element);
	}

	private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {
		if (next == null)
			return null;

		if (next.element.equals(targetElement))
			return next;

		BinaryTreeNode<T> temp = findAgain(targetElement, next.left);

		if (temp == null)
			temp = findAgain(targetElement, next.right);

		return temp;
	}

	/** Return the string representation of the binary tree. */
	public String toString() {
		ArrayList<T> tempList = new ArrayList<T>();
	    preorder (root, tempList);
        return getClass().getName() + ":" + tempList.toString();
	}

	/** Return iterator for inorder traversal */ 
	public Iterator<T> iteratorInOrder() {
		ArrayList<T> tempList = new ArrayList<T>();
		inorder(root, tempList);

		return tempList.iterator();
	}

	/** Perform a recursive inorder traversal, saving nodes in ArrayList */
	protected void inorder(BinaryTreeNode<T> node, ArrayList<T> tempList) {
		if (node != null) {
			inorder(node.left, tempList);
			tempList.add(node.element);
			inorder(node.right, tempList);
		}
	}

	/** Return iterator for preorder traversal */ 
	public Iterator<T> iteratorPreOrder() {
		ArrayList<T> tempList = new ArrayList<T>();
		preorder(root, tempList);
		return tempList.iterator();
	}

	/** Perform a recursive preorder traversal, saving nodes in ArrayList */
	protected void preorder(BinaryTreeNode<T> node, ArrayList<T> tempList) {
		if (node != null) {
			tempList.add(node.element);
			preorder(node.left, tempList);
			preorder(node.right, tempList);
		}
	}

	/** Create an iterator for postorder traversal */
	public Iterator<T> iteratorPostOrder() {
		ArrayList<T> tempList = new ArrayList<T>();
		postorder(root, tempList);
		return tempList.iterator();
	}

	/** Perform a recursive postorder traversal, saving nodes in ArrayList */
	protected void postorder(BinaryTreeNode<T> node, ArrayList<T> tempList) {
		if (node != null) {
			postorder(node.left, tempList);
			postorder(node.right, tempList);
			tempList.add(node.element);
		}
	}

	/** Create an iterator for level order traversal */
	public Iterator<T> iteratorLevelOrder() {
		ArrayList<BinaryTreeNode<T>> nodes = new ArrayList<BinaryTreeNode<T>>();
		ArrayList<T> tempList = new ArrayList<T>();
		BinaryTreeNode<T> current;

		nodes.add(root);
		while (!nodes.isEmpty()) {
			current = (BinaryTreeNode<T>) (nodes.remove(0));

			if (current != null) {
				tempList.add(current.element);
				if (current.left != null)
					nodes.add(current.left);
				if (current.right != null)
					nodes.add(current.right);
			} else
				tempList.add(null);
		}
		return tempList.iterator();
	}
}
