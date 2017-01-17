// MODIFICATIONS:
//    search is made static here so we can test it without creating an object
//    main creates an array of Strings from input and then tests to see if
//	each String can be found in the array.

import java.io.*;
import java.util.*;

class Test_search {
    private static int search(String z[], String s) {
        int k;     // k== the index of the next position in the array to check.
                   // No match has been found in positions 0 through k-1.
        k = 0;
        while (!(k==z.length || s.equals(z[k])))
            k++;
        // k==v.size || s.equals(z[k])

        if (k==z.length)
            return -1;
        else
            return k;
    }

    public static void main(String[] a) throws Exception {
        boolean fails=false;
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String[] inputData = new String[100];
        String line = f.readLine();
        String huge = "";
        int k = 0;
        while (line != null && k < 100) {
            huge = huge.concat(line);
            inputData[k] = line;
            line = f.readLine();
            k++;
        }
        int numLines = k;
        k=0;
        while (k < numLines) {
            if (search(inputData,inputData[k])!=k) {
                System.err.println("search failure");
                fails = true;
            }
            k++;
        }
        if (search(inputData,huge)!=-1) {
            System.err.println("search failure");
            fails = true;
        }
        if (!fails)
            System.out.println("search passes these tests");
    }

}

// Sample test input (no duplicates allowed!)
// butter
// mustard
// ketchup
// abc
// x
// z
// antidisestablishmentarianism
