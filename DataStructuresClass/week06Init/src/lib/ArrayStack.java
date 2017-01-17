package lib;
import java.util.*;



public class ArrayStack<T> implements StackADT<T> {
  private static final int DEFAULT_SIZE = 1;
  private int top;
  private T[] stack;


  private static boolean debug = false;
  public static void setDebug(boolean t) {
     debug = t;
  }


  public ArrayStack( ) {
    top = -1;
    stack = (T[])(new Object[DEFAULT_SIZE]);
    if (debug) {
       System.out.println(toString());
    }
  }

  public boolean isEmpty(){
    return top < 0;
  }

  public T peek( ) {
    if (isEmpty())
      throw new NoSuchElementException
           ("peeked an empty stack");
    return stack[top];
  }

  public T pop( ) {
    if (isEmpty())
    throw new NoSuchElementException
         ("popped an empty stack");

    T temp = stack[top];
    top--;
    if (debug) {
       System.out.println("Pop " + temp + "\n" + toString());
    }
    return temp;
  }

  public void push(T element) {
     if(top == stack.length-1) {
        resize();
     }
     top++;
     stack[top] = element;
    if (debug) {
       System.out.println("Push " + element + "\n" + toString());
    }

  }

  public int size( ) {
    return top+1;
  }
  public String toString( ) {
    if (isEmpty()) {
       return "stack: [ ];";
    } else {
       StringBuffer buf = new StringBuffer("stack:[");
       for (int i = top; i > 0; i--) {
          if (i==top) {
             buf.append(stack[i]);
          } else {
             buf.append("\n       " + stack[i]);
          }
       }
       if (top > 0) {
          buf.append("\n       " + stack[0] + "]");
       } else {
          buf.append(stack[0] + "]");
       }
       return buf.toString();
    }
  }

  private void resize( ) {
    T [] temp = (T[])(new Object[2*stack.length]);
    for (int i = 0; i < stack.length; i++)
      temp[i] = stack[i];
    stack = temp;
  }
}
