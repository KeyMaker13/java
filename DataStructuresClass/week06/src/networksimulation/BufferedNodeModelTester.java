package networksimulation;

public class BufferedNodeModelTester {
  public static void main(String[] args) {
    System.out.println("CS 1723 Lab 7 Part II: written by Tom Bylander");

    System.out.println("\nFirst bullet.  " +
                       "Create, run and print a BufferedNodeModel.\n");
    BufferedNodeModel buffered = new BufferedNodeModel(1, 5);
    buffered.runSimulation(200);
    System.out.println(buffered);

    System.out.println("\nSecond and third bullets.  " +
                       "Create, run and print four BufferedNodeModels.\n");
    buffered = new BufferedNodeModel(2, 5);
    buffered.runSimulation(200);
    System.out.println(buffered);
    System.out.println();
    buffered = new BufferedNodeModel(5, 5);
    buffered.runSimulation(200);
    System.out.println(buffered);
    System.out.println();
    buffered = new BufferedNodeModel(10, 5);
    buffered.runSimulation(200);
    System.out.println(buffered);
    System.out.println();
    buffered = new BufferedNodeModel(20, 5);
    buffered.runSimulation(200);
    System.out.println(buffered);
  }
}
