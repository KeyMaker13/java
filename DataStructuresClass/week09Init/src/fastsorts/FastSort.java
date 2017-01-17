package fastsorts;

public class FastSort<T extends Comparable<T>> {
	public void mergeSort(T[] data, int min, int max) {
		// to be implemented

		// printArray(data, min, max, "sort from " + min + " to " + max);

		// printArray(data, min, mid, "After sorting from " + min + " to " + mid);

		// printArray(data, mid+1, max, "After sorting from " + (mid+1) + " to " +
		// max);

		// printArray(data, min, max, "After merging from " + min + " to " + max);
	}

	public void merge(T[] data, int min, int mid, int max) {
		// to be implemented
	}

	public int findPartition(T[] data, int min, int max) {
		// to be implemented
		return 0;
	}

	public void quickSort(T[] data, int min, int max) {
		// to be implemented

		// printArray(data, min, max, " sort from " + min + " to "
		// + max);

		// printArray(data, min, max, " after partition from " + min + " to "
		// + max + " at " + indexOfPartition);

		// printArray(data, min, (indexOfPartition - 1), " after sorting from "
		// + min + " to " + (indexOfPartition - 1));

		// printArray(data, (indexOfPartition +1), max, " after sorting from "
		// + (indexOfPartition +1) + " to " + max );
	}

	public void printArray(T[] data, int l, int h, String msg) {
		System.out.print("[");

		for (int i = 0; i < l; i++) {
			System.out.print(" " + data[i]);
		}
		System.out.print(" (");
		for (int i = l; i <= h; i++) {
			System.out.print(" " + data[i]);
		}
		System.out.print(" )");
		for (int i = h + 1; i < data.length; i++) {
			System.out.print(" " + data[i]);
		}
		System.out.println(" ]: " + msg);
	}
}
