package sorting;

public class QuadraticSortTester {
	public static void main(String[] args) {
		System.out.println("\nTesting the selection sort for Integer arrays:");
		QuadraticSort<Integer> q1 = new QuadraticSort<Integer>();
		Integer[] testInteger = { 8, 1, 4, 9, 3, 6, 5, 7, 2, 0 };
		Integer[] test1 = testInteger.clone();
		q1.printArray(test1, "before selection sort");
		q1.selectionSort(test1);
		q1.printArray(test1, "after selection sort");

		System.out.println("\nTesting the selection sort for String arrays:");
		String[] testString = { "AAA", "aaab", "Reedf", "Steve", "Hope", "How",
				"How", "Steve", "Cdd", "What" };
		String[] testS1 = testString.clone();
		QuadraticSort<String> q2 = new QuadraticSort<String>();
		q2.printArray(testS1, "before selection sort");
		q2.selectionSort(testS1);
		q2.printArray(testS1, "After selection sort");
	}
}