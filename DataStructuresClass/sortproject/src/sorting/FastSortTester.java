package sorting;

public class FastSortTester {

	public static void main(String[] args) {
		System.out.println("\nTesting the quick sort for Integer arrays:");
		FastSort<Integer> q1 = new FastSort<Integer>();
		Integer[] testInteger = { 8, 1, 4, 9, 3, 6, 5, 7, 2, 0 };
		Integer[] test1 = testInteger.clone();
		q1.printArray(test1, "before quick sort");
		q1.quickSort(test1, 0, test1.length - 1);
		q1.printArray(test1, "after quick sort");

		System.out.println("\nTesting the quick sort for String arrays:");
		String[] testString = { "AAA", "aaab", "Reedf", "Steve", "Hope", "How",
				"How", "Steve", "Cdd", "What" };
		String[] testS1 = testString.clone();
		FastSort<String> q2 = new FastSort<String>();
		q2.printArray(testS1, "before quick sort");
		q2.quickSort(testS1, 0, testS1.length - 1);
		q2.printArray(testS1, "After quick sort");
		
		System.out.println("\nTesting the merge sort for Integer arrays:");
		Integer[] test2 = testInteger.clone();
		q1.printArray(test2, "before merge sort");
		q1.mergeSort(test2, 0, test1.length - 1);
		q1.printArray(test2, "after merge sort");

		System.out.println("\nTesting the merge sort for String arrays:");
		String[] testS2 = testString.clone();
		q2.printArray(testS2, "before merge sort");
		q2.mergeSort(testS2, 0, testS1.length - 1);
		q2.printArray(testS2, "After merge sort");
	}
}
