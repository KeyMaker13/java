package exceptions;

public class EmptyListException extends RuntimeException {
	
  public EmptyListException(){
    super ("Set is Empty");
  }

  public EmptyListException(String msg){
    super("Set is Empty:" +msg);
  }

}
