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
 * @author Prof. Weining Zhang
 * @version 1.0
 */
public class EmptySetException
    extends RuntimeException{

  public EmptySetException(){
    super ("Set is Empty");
  }

  public EmptySetException(String msg){
    super("Set is Empty:" +msg);
  }

}
