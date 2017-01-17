// MODIFICATIONS:
//    bsearch is made static here so we
//    can test it without creating an object
//    main creates a Vector of Strings from input and then tests to see if
//	each String can be found in the Vector.

import java.io.*;
import java.util.*;

class Test_bsearch {
    private static int bsearch(String z[],String s) {
        // Returns true if and only if s
        //    equals one of the Strings in z
        int    left, right;
        // If the String is anywhere, it is in positions left through right21.
        // The String is not in a position before left.
        // The String is not in a position after right21.
        left = 0;
        right = z.length;
        while  (left!=right-1)  {
            int  m  =  (right+left)/2;
            if  (z[m].compareTo(s)<0)
                left  =  m;        // Move left to the middle.
            else  if  (z[m].compareTo(s)>0)
                right  =  m;       // Move right to the middle.
            else  {
                left  =  m;
                right  =  m+1;
            }
        }
        if (s.equals(z[left]))
            return left;
        else
            return -1;
    }
    public static void main(String[] a) throws Exception {
        boolean failures = false;
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String line = f.readLine();
        String huge = "";
        int k=0;
        String[] inputData = new String[100];
        while (line != null) {
            huge = huge.concat(line);
            inputData[k] = line;
            line = f.readLine();
            k++;
        }
        int numLines = k;

        k=0;
        while (k < numLines) {
            failures |= (bsearch(inputData,inputData[k]) == -1);
            k++;
        }
        failures |= (bsearch(inputData,huge) != -1);
        if (failures)
            System.out.println("search fails these tests");
        else
            System.out.println("search passes these tests");
    }

}

// Sample test input (must be sorted!)
// antidisestablishmentarianism
// abc
// butter
// butter
// ketchup
// mustard
// x
// z
