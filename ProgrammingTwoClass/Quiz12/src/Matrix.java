import java.util.Scanner;


public class Matrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] number1 = new int[3][3];
        int[][] number2 = new int[3][3];
        int[][] number3 = new int[3][3];
       
       
        Scanner scan = new Scanner(System.in);
        int[] values = new int[9];
        int[] values2 = new int[9];
        int index = 0;
       
        System.out.println("Enter the values for the first array");
        for (int i = 0; i<values.length; i++){
            values[i] = scan.nextInt();
        }
        System.out.println("Enter the values for the second array");
        for (int i = 0; i<values2.length; i++){
            values2[i] = scan.nextInt();
        }
       
       
        // fill values for number 1
        for (int row = 0; row<number1.length;row++){
            for (int col = 0; col<number1[row].length; col++){
                number1[row][col] = values[index];
                index++;
            }
           
        }
        index = 0;
        // fill values for number 2
        for (int row = 0; row<number2.length;row++){
            for (int col = 0; col<number2[row].length; col++){
                number2[row][col] = values2[index];
                index++;
            }
           
        }
       
        System.out.println("Printing first array");
        // print values for number 1
        for (int row = 0; row<number1.length;row++){
            for (int col = 0; col<number1[row].length; col++)
                System.out.print(number1[row][col] + "\t");
                System.out.println();
        }
   
        System.out.println();
        System.out.println("Printing second array");
        // print values for number 2
        for (int row = 0; row<number2.length;row++){
            for (int col = 0; col<number2[row].length; col++)
                System.out.print(number2[row][col] + "\t");
                System.out.println();   
        }
        // multiply arrays together
        for (int row = 0; row<number3.length;row++){
            for (int col = 0; col<number3[row].length; col++){
                number3[row][col] = (number1[row][col] * number2[row][col]);
            }
           
        }
        System.out.println("Multiplying the arrays together the new values are below");
        // print values for number 3
        for (int row = 0; row<number3.length;row++){
            for (int col = 0; col<number3[row].length; col++)
                System.out.print(number3[row][col] + "\t");
                System.out.println();   
        }
       


	}

}
