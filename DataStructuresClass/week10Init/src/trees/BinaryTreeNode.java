package trees;

/**
 * <P>Represents a node in a binary tree with a left and right
 * child</p>
 *
 * @author Lewis/Chase
 * @version 1.0
 */
public class BinaryTreeNode<T> {
   /**
    * value of this node
    */
   protected T element;

   /**
    * reference to left subtree at this node
    */
   protected BinaryTreeNode<T> left;

   /**
    * reference to right subtree at this node
    */
   protected BinaryTreeNode<T> right;

   /**
    * Initializes this newly-created with the specified data
    *
    * @param obj value to be assigned this node
    */
   public BinaryTreeNode(T obj) {
      element = obj;
      left = null;
      right = null;
   } // constructor BinaryTreeNode


   /**
    * returns the number of non-null children of this node
    *
    * <P></P>
    * <B>Note:</B> This method may be implemented more efficiently.
    *
    * @return int
    */
   public int numChildren() {
      int children = 0;
      if (left != null)
         children = 1 + left.numChildren();
      if (right != null)
         children = children + 1 + right.numChildren();
      return children;
   } // method numChildren

   public T getElement() {
    return (T) element;
  }

  public BinaryTreeNode<T> getLeft() {
     return (BinaryTreeNode<T>) left;
   }

   public BinaryTreeNode<T> getRight() {
    return (BinaryTreeNode<T>) right;
  }

  public void setLeft(BinaryTreeNode<T> l) {
    left = l;
  }

  public void setRight(BinaryTreeNode<T> r) {
    right = r;
  }

  public void setElement(T e) {
    element = e;
  }
   public String toString() {
      StringBuffer buf = new StringBuffer();
      buf.append("Node[");
      if (left != null) {
         buf.append(left + ", ");
      } else {
         buf.append("null, ");
      }
      buf.append(element + ", ");
      if (right != null) {
         buf.append(right + "]");
      } else {
         buf.append("null]");
      }
      return buf.toString();
   }
} // class BinaryTreeNode
