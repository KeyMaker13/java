public class CharacterMethodsTest{
  public static void main(String[] args){
    char c = 'y';
    String s = c + "es";
    System.out.println(c == 'y');         // prints true
    System.out.println(s == "yes");       // prints false!
    System.out.println(s.equals("yes"));  // prints true
    String s1="yes";
    System.out.println(s1=="yes");         // prints true

    c = '1';
    s = "yes";
    System.out.println(Character.toUpperCase(c));  // prints Y
    System.out.println(s.toUpperCase( ));          // prints YES
    System.out.println(Character.isDigit(c));      // prints true
    System.out.println(Character.isUpperCase(c));   // prints false
    s = "yes";
    char c0 = s.charAt(0);
    char c1 = s.charAt(1);
    char c2 = s.charAt(2);
    System.out.println(c0);  // prints y
    System.out.println(c1);  // prints e
    System.out.println(c2);  // prints s
    char c3 = s.charAt(3);   // causes an error

  }
}