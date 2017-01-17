package sorting;

public class FastSort3WayTester {

	public static void main(String[] args) {
		System.out.println("CS 2123 Lab 09 by Ivan Capistran");

		// test array creation
		Integer[][] intTests = { { 8, 1, 4, 9, 6, 3, 6, 2, 7, 0 }, // test 1
				{ 3, 1 }, // test 2
				{ 1, 4 }, // test 3
				{ 9, 8, 7, 6, 5, 4, 3, 2 }, // test 4
				{ 3, 1, 4, 1, 3, 5, 9, 2, 3, 6, 5, 3, 5, 3, 8, 9, 3, 7, 9 }, // test
				// 5
				{ 6, 6, 6, 6, 1 } }; // test 6

		System.out.println("\nTesting the 3 way sorts for integers:");
		FastSort3Way<Integer> fsInt = new FastSort3Way<Integer>();
		Integer[] test;

		// Testing three way quick sort
		System.out.println("\nTesting the 3 way quick sort:");
		for (int k = 0; k < intTests.length; k++) {
			test = intTests[k].clone();
			System.out.println("\nBefore 3 way quick sort ");
			fsInt.printArray(test, " original array");
			fsInt.quickSort3Way(test, 0, test.length - 1);
			fsInt.printArray(test, " after 3 way quick sort");
		}

		// testing merge sort
		System.out.println("\nTesting the 3 way merge sort:");
		for (int k = 0; k < intTests.length; k++) {
			test = intTests[k].clone();
			System.out.println("\nBefore 3 way merge sort ");
			fsInt.printArray(test, " original array");
			fsInt.mergeSort3Way(test, 0, test.length - 1);
			fsInt.printArray(test, " after 3 way merge sort");
		}
	}
}
