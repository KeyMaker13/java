package dataStructures;



public class PublicBTNode<T> {
	protected T element;
	protected PublicBTNode<T> left, right, parent;

	 public PublicBTNode(T elt) {
	  element = elt;
	  left = right = parent = null;
	 }
	 public T getElement() {
			return element;
		}
		
		/** Return a reference to the left subtree at this node */
		public PublicBTNode<T> getLeft() {
			return left;
		}
		
		/** Return a reference to the right subtree at this node */
		public PublicBTNode<T> getRight() {
			return right;
		}	
		
		/** Set reference to the left subtree at this node */
		public void setLeft(PublicBTNode<T> node) {
			left = node;
		}
		
		/** Set reference to the right subtree at this node */
		public void setRight(PublicBTNode<T> node) {
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
