import java.util.*;

public class ArrayString {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // Input the size of the string array 
        System.out.print("size of the string array");
        int n = console.nextInt( );

        // Declare a string array
        String[ ] s = new String[n];

        // Input and store strings in the array
        for (int i = 0; i < s.length; i++) {
            System.out.print("enter new string " );
            s[i] = console.next( );
        } // now the string array is initialized from the user-input 
        System.out.println(Arrays.toString(s)); 
        // search for a string from the user: 
         System.out.print("enter string to search for in the array " );
          String  t1 = console.next( );
           System.out.println( );
            int i1 = methodIndexOf(s,t1);
            System.out.println("index of s1 is:  " + i1 );
            System.out.print("enter string to replace: " +
                             t1  + " in the array " );
                             
             String  t2 = console.next( );
            int i2 = replace(s,t1,t2);
            System.out.println("index of elem. replaced is " + i2 );
            System.out.println(Arrays.toString(s));
    
    } //END MAIN
    public static int methodIndexOf(String[] a, String target) {
     for (int i = 0; i < a.length; i++) {
         if (a[i].equals( target) ) {
             return i;
         }
     }
    return -1;
 }
   // This method replaces one string with another.
// It returns the index that was replaced or -1 if not found.
  public static int replace(String[ ] array, String value, String newValue) {
    for (int i = 0; i < array.length; i++) {
        if (value.equals( array[i]) ) {
            array[i] = newValue;
            return i;
        }
    }
    // To get to this point, the value must not be in the array.
    return -1;
}


}
