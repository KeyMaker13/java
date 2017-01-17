
import  java.lang.*;
import  java.io.*;
class  ReverseIntegers  {
	public  static  void  main(String[]  a)  throws Exception {
		BufferedReader kb  =  new  BufferedReader(new  InputStreamReader(System.in));
		int[]  z = new int[100];
		int    i=0;	// Next position to fill; all positions before position i 
				//       have been filled.
		while  (i!=100)  {
			z[i]  =  Integer.parseInt(kb.readLine());
			i++;
		}
		int k=99;	// k== the index of the next position in array to print.
				// positions 99, 98, ..., k+1 have already been printed.
				// positions k, k-1, ..., 0 remain to be printed.
		while  (k!=-1)  {
			System.out.println(z[k]);
			--k;
		}
	}
}	
