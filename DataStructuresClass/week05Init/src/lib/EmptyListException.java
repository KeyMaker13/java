package lib;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class EmptyListException
    extends RuntimeException{

  public EmptyListException(){
    super ("Set is Empty");
  }

  public EmptyListException(String msg){
    super("Set is Empty:" +msg);
  }

}
