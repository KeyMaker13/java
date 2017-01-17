package linkedlistset;
public class SimpleNode<T>
 {
    public SimpleNode<T> next;
    public T element;

    //---------------------------------------------------------
    //  Creates an empty node.
    //---------------------------------------------------------
    public SimpleNode(T ele)
    {
      next = null;
      element = ele;
    }

}
