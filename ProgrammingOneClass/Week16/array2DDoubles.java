import java.util.*;
public class array2DDoubles{
  public static void main(String[] args){
    Scanner console = new Scanner(System.in);
    int rows=5;
     int columns=5;
    double[ ][ ] iris = new double[rows][columns];

  for (int row = 0; row < rows; row++) {
    for (int col = 0; col < columns; col++) {
        iris[row][col] = (double) (row+col);
    }
  }
    // This assignment also initializes the new array with zeroes.
    double[ ] average = new double[columns];
     for (int col = 0; col < columns; col++) {
       average[col]=0.0;
        for (int r= 0; r < 5; r++) {
           average[col] += iris[r][col];
    }
} 

for (int col = 0; col < columns; col++) {
    average[col] /= rows;
} 
System.out.println("The averages are " + Arrays.toString(average) );
   for (int row = 0; row < rows; row++) {
       System.out.print("row: " + row + " "); 
       for (int col = 0; col < columns; col++) {
          System.out.print(iris[row][col] + " "); 
    }
       System.out.println();
      
}
   for (int row = 0; row < rows; row++) {
      System.out.println(Arrays.toString(iris[row]));
   }

}// end main
}// end class
