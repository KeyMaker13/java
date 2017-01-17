package networksimulation;

public class IncomingOnlyModelTester {
  public static void main(String[] args) {
    System.out.println("CS 1723 Lab 6 Part IV: written by Tom Bylander");

    System.out.println("\nFirst bullet.  " +
                       "Create, run, and print a IncomingLineModel object.\n");
    IncomingOnlyModel incomingOnly =
        new IncomingOnlyModel("IncomingOnlyModel", 20);
    incomingOnly.setDebug(true);
    incomingOnly.runSimulation(100);
    System.out.println(incomingOnly);

    System.out.println("\nThird bullet.  " +
                       "Run the IncomingLineModel 200 more time units.\n");
    incomingOnly.setDebug(false);
    incomingOnly.runSimulation(300);
    System.out.println(incomingOnly);

    System.out.println("\nSixth and seventh bullets.  " +
                       "Create and run some multiple line models.\n");
    incomingOnly = new IncomingOnlyModel("3 lines with interarrival=2", 2, 3);
    incomingOnly.runSimulation(200);
    System.out.println(incomingOnly);
    System.out.println();
    incomingOnly = new IncomingOnlyModel("8 lines with interarrival=5", 5, 8);
    incomingOnly.runSimulation(200);
    System.out.println(incomingOnly);
    System.out.println();
    incomingOnly = new IncomingOnlyModel("2 lines with interarrival=10", 10, 2);
    incomingOnly.runSimulation(200);
    System.out.println(incomingOnly);
    System.out.println();
    incomingOnly = new IncomingOnlyModel("6 lines with interarrival=20", 20, 6);
    incomingOnly.runSimulation(200);
    System.out.println(incomingOnly);
  }
}
