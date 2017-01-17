package networksimulation;

public class UnbufferedNodeModelTester {
   public static void main(String[] args) {
      System.out.println("CS 2123 Lab 6 Part VI: written by Tom Bylander");

      System.out.println("\nFirst bullet.  " +
                         "Create and print an UnbufferedNodeModel.\n");
      UnbufferedNodeModel unbuffered = new UnbufferedNodeModel(1,5);
      System.out.println(unbuffered);

      System.out.println("\nSecond bullet.  " +
                         "Run and print the UnbufferedNodeModel.\n");
      unbuffered.runSimulation(200);
      System.out.println(unbuffered);

      System.out.println("\nThird bullet.  " +
                         "Create, run and print four UnbufferedNodeModels.\n");
      unbuffered = new UnbufferedNodeModel(2,5);
      unbuffered.runSimulation(200);
      System.out.println(unbuffered);
      System.out.println();
      unbuffered = new UnbufferedNodeModel(5,5);
      unbuffered.runSimulation(200);
      System.out.println(unbuffered);
      System.out.println();
      unbuffered = new UnbufferedNodeModel(10,5);
      unbuffered.runSimulation(200);
      System.out.println(unbuffered);
      System.out.println();
      unbuffered = new UnbufferedNodeModel(20,5);
      unbuffered.runSimulation(200);
      System.out.println(unbuffered);

      System.out.println("\nFourth bullet.  " +
                         "Create, run and print some " +
                         "multiple line UnbufferedNodeModels.\n");
      unbuffered = new UnbufferedNodeModel(5,5,2,1);
      unbuffered.runSimulation(200);
      System.out.println(unbuffered);
      System.out.println();
      unbuffered = new UnbufferedNodeModel(5,5,1,2);
      unbuffered.runSimulation(200);
      System.out.println(unbuffered);
      System.out.println();
      unbuffered = new UnbufferedNodeModel(5,5,2,2);
      unbuffered.runSimulation(200);
      System.out.println(unbuffered);
      System.out.println();
      unbuffered = new UnbufferedNodeModel(5,5,2,3);
      unbuffered.runSimulation(200);
      System.out.println(unbuffered);
   }
}
