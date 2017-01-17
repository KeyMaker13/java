// MODIFICATIONS:
//    sort is made static here so we
//    can test it without creating an object
//    main creates a Vector of Strings from input, invokes sort
//	and then checks to see if it is sorted

import java.io.*;
import java.util.*;

class Test_sort {
    static void  exchange(String z[],  int  k,  int  j)  {
        String temp = z[k];
        z[k] = z[j];
        z[j] = temp;
    }

    static void sort(String z[]) {  // On return, the elements of z are
                                    //       sorted in ascending order.
        int k;          // k== the index of the next position in the array
                        //       to take care of.
                        // All elements to the left of k are less than or
                        //       equal to the elements at k or to the right of k.
                        // All elements to the left of k are in ascending
                        //       order.
        int n=z.length; // n== number of elements in the array.
        k = 0;
        while  (k!=n-1)  {
            int j  =  getSmallest(z,k);
            exchange(z,k,j);
            k++;
        }
        // k==n-1 and therefore elements 0, ..., n-2 are sorted; but because
        //      these elements are also less than the element in position n-1 (the
        //      last element), the entire array is sorted.
    }

    // Returns the index of the smallest element in v or -1 if none exist
    static int  getSmallest(String z[],  int  k)  {
        if  (z==null  ||  z.length==k)
            return  -1;
        int    i;     // Index of next element to examine; all elements at positions
                      //      less than k have been examined already.
        int    small; // Index of smallest element examined so far
        i  =  k+1;
        small  =  k;
        while  (i!=z.length)  {
            String current  =  (String)  z[i];
            String  smallest  =  (String)  z[small];
            if  (current.compareTo(smallest)<0)
                small  =  i;
            i++;
        }
        // i==z.length
        return small;
    }



    static private boolean isSorted(String[] z, int size) {
        for (int i=0; i<size-1;i++) {
            if (z[i].compareTo(z[i+1]) > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] a) throws Exception {
        boolean fails=false;
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(f.readLine());
        String[] z = new String[size];
        String line = f.readLine();
        String huge = "";
        int k=0;
        while (k<size) {
            huge = huge.concat(line);
            z[k] = line;
            line = f.readLine();
            k++;
        }

        sort(z);
        if (isSorted(z,size))
            System.out.println("search passes these tests");
        else
            System.out.println("search fails these tests");
    }
}

// Sample test input (must NOT be sorted!) first line is number of data lines
// 8
// antidisestablishmentarianism
// mustard
// butter
// butter
// ketchup
// z
// x
// abc
