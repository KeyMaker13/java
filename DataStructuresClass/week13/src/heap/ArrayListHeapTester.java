package heap;

//import heap.ArrayListHeap;

public class ArrayListHeapTester {

	public static void main(String[] args) {
		System.out.println("Testing the ArrayListHeap"
				+ " implementation of HeapADT");

		HeapADT<Integer> heap = new ArrayListHeap<Integer>();
		Integer[] testValues = { 3, 18, 20, -1, 5, 7, 9 };
		for (int k = 0; k < testValues.length; k++) {
			heap.addElement(testValues[k]);
			System.out.println("heap: " + heap);
		}

		System.out.println("Removing all elements:");
		while (!heap.isEmpty()) {
			System.out.println("Removed: " + heap.removeMin() + " heap: " + heap);
		}
	}

}
