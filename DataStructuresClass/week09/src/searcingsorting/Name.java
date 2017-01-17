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
public class Name implements Comparable<Name> {
  private String firstName;
  private String midInt;
  private String lastName;

  public Name(String fn, String mi, String ln) {
    firstName = fn;
    midInt = mi;
    lastName = ln;
  }

  public int compareTo(Name o) {
    if (lastName.compareTo(o.getLastName())!=0){
      return lastName.compareTo(o.getLastName());
    } else if (firstName.compareTo(o.getFirstName())!=0){
      return firstName.compareTo(o.getFirstName());
    } else {
      return midInt.compareTo(o.getMidInit());
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
