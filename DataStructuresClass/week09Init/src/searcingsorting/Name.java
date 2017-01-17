package searcingsorting;

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
public class Name implements Comparable {
  private String firstName;
  private String midInt;
  private String lastName;

  public Name(String fn, String mi, String ln) {
    firstName = fn;
    midInt = mi;
    lastName = ln;
  }

  public int compareTo(Object o) {
    Name n = (Name)o;
    if (lastName.compareTo(n.lastName)!=0){
      return lastName.compareTo(n.lastName);
    } else if (firstName.compareTo(n.firstName)!=0){
      return firstName.compareTo(n.firstName);
    } else {
      return midInt.compareTo(n.midInt);
    }
  }

  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMidInit() {
    return midInt;
  }

  public String toString() {
    return "<"+firstName + " " + midInt + ". " + lastName+ "> ";
  }

}
