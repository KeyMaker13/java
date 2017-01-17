package bank;

public class RandomCustomerGeneratorTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\nFirst Test Random Tester");
		UnbufferedSimulation  test1 = UnbufferedSimulationTester.randomSimulation(10);
		UnbufferedSimulationTester.analyzeSimulation(test1);
	}

}
