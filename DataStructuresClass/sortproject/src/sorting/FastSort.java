package sorting;

public class FastSort<T extends Comparable> {
	private boolean debug;

	public FastSort() {
		this(false);
	}

	public FastSort(boolean d) {
		debug = false;
	}

	public void mergeSort(T[] data, int min, int max) {
		if (min >= max) { // if data does not have at least two elements, quit
			return;
		}

		int mid = (max + min) / 2; // divide array into two subarrays
		if (debug)
			printArray(data, min, max, "sort from " + min + " to " + max);

		mergeSort(data, min, mid); // sort left subarray
		if (debug)
			printArray(data, min, mid, "After sorting from " + min + " to "
					+ mid);

		mergeSort(data, mid + 1, max); // sort right subarray
		if (debug)
			printArray(data, mid + 1, max, "After sorting from " + (mid + 1)
					+ " to " + max);

		merge(data, min, mid, max); // merge the two sorted subarrays
	}

	private void merge(T[] data, int min, int mid, int max) { // O(n)
		T[] temp = (T[]) (new Comparable[max - min + 1]);
		for (int i = 0; i < temp.length; i++) { // copy into a temporary
			temp[i] = data[i + min];

		}
		int left = 0; // position in first sorted subarray
		int right = mid - min + 1; // position in second sorted subarray
		for (int i = min; i <= max; i++) {
			if (left > mid - min) // finished with the left subarray
				data[i] = temp[right++];
			else if (right > max - min) // finished with right subarray
				data[i] = temp[left++];
			else if (temp[left].compareTo(temp[right]) < 0)
				data[i] = temp[left++]; // both active, left smaller
			else
				data[i] = temp[right++]; // both active, right smaller
		}
	}



	public void quickSort(T[] data, int min, int max) {
		if (min >= max)
			return;

		if (debug)
			printArray(data, min, max, " sort from " + min + " to " + max);

		int indexOfPartition = findPartition(data, min, max);
		if (debug)
			printArray(data, min, max, " after partition from " + min + " to "
					+ max + " at " + indexOfPartition);
		quickSort(data, min, indexOfPartition - 1);
		if (debug)
			printArray(data, min, (indexOfPartition - 1), " after sorting "
					+ "from " + min + " to " + (indexOfPartition - 1));

		quickSort(data, indexOfPartition + 1, max);
		if (debug)
			printArray(data, (indexOfPartition + 1), max, " after sorting "
					+ "from " + (indexOfPartition + 1) + " to " + max);
	}
	
	private int findPartition(T[] data, int min, int max) {
		int left = min;
		int right = max;
		T pivot = data[min]; // keep pivot value aside, place at end
		while (left < right) {
			// search from left for element that is greater than pivot
			while (data[left].compareTo(pivot) <= 0 && left < right)
				left++; // search for element less than pivot
			while (data[right].compareTo(pivot) > 0)
				right--;
			if (left < right) { // exchange elements if out of order
				T temp = data[left];
				data[left] = data[right];
				data[right] = temp;
			}
		}
		data[min] = data[right]; // now place the pivot in right place
		data[right] = pivot;
		return right;
	}

	public void setDebug() {
		debug = true;
	}

	public void printArray(T[] list, String msg) {
		System.out.print("[");
		for (int i = 0; i < list.length; i++)
			System.out.print(" " + list[i]);
		System.out.println(" ]:" + msg);
	}

	public void printArray(T[] data, int low, int high, String msg) {
		System.out.print("[");
		for (int i = 0; i < low; i++) 
			System.out.print(" " + data[i]);
		System.out.print(" (");
		for (int i = low; i <= high; i++) 
			System.out.print(" " + data[i]);	
		System.out.print(" )");
		for (int i = high + 1; i < data.length; i++) 
			System.out.print(" " + data[i]);
		System.out.println(" ]: " + msg);
	}
}
