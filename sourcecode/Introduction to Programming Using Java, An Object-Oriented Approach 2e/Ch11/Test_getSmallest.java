// MODIFICATIONS:
//    getSmallest is made static here so we can test it without creating an object
//    main creates a Vector of Strings which it uses to test the method

import java.io.*;
import java.util.*;

class Test_getSmallest {
    // Returns the index of the smallest element in v or -1 if none exist
    static int  getSmallest(String z[])  {
        if  (z==null  ||  z.length==0)
            return -1;
        int    k;      // Index of next element to examine; all elements at
                       //       positions less than k have been examined already.
        int    small;  // Index of smallest element examined so far
        k  =  1;
        small  =  0;
        while  (k!=z.length)  {
            String current  =  (String)  z[k];
            String  smallest  =  (String)  z[small];
            if  (current.compareTo(smallest)<0)
                small  =  k;
            k++;
        }
        // k==z.length
        return small;
    }
    
        
    private static boolean works(String[] z, String s, int index, int k) {
        z[index] = s;
        return getSmallest(z)==k;
    }

    public static void main(String[] a) throws Exception {
        boolean	passesTests = true;
        String[] z = {"zzz","zzz","zzz","zzz","zzz","zzz","zzz"};
        passesTests &= works(z,"football",0,0);
        passesTests &= works(z,"skiing",1,0);
        passesTests &= works(z,"baseball",2,2);
        passesTests &= works(z,"fencing",3,2);
        passesTests &= works(z,"wrestling",4,2);
        passesTests &= works(z,"archery",5,5);
        passesTests &= works(z,"swimming",6,5);
        if (passesTests)
            System.out.println("getSmallest passes these tests");
        else
            System.out.println("getSmallest fails these tests");
    }
}
