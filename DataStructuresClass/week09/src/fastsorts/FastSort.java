package fastsorts;

public class FastSort<T extends Comparable<T>> {
	public void mergeSort(T[] data, int min, int max) {
		if (min >= max) { // if data does not have at least two elements, quit
			return;
		}

		int mid = (max + min) / 2; // divide array into two subarrays
		printArray(data, min, max, "sort from " + min + " to " + max);

		mergeSort(data, min, mid); // sort left subarray
		printArray(data, min, mid, "After sorting from " + min + " to " + mid);

		mergeSort(data, mid + 1, max); // sort right subarray
		printArray(data, mid + 1, max, "After sorting from " + (mid + 1) + " to "
				+ max);

		merge(data, min, mid, max); // merge the two sorted subarrays
		// printArray(data, min, max, "After merging from " + min + " to " + max);
	}

	public void merge(T[] data, int min, int mid, int max) {
		// copy the sub-array into a temp array and use the original array to hold
		// the merge results
		int tempMin = min - min;
		int tempMid = mid - min;
		int tempMax = max - min;
		T[] temp = (T[]) (new Comparable[tempMax + 1]);
		for (int i = 0; i < temp.length; i++) { // copy into a temporary
			temp[i] = data[i + min];

		}
		int left = tempMin; // start of first sorted subarray
		int right = tempMid + 1; // start of second sorted subarray
		for (int i = min; i <= max; i++) {
			if (left > tempMid) { // finished with the left subarray
				data[i] = temp[right++];
			} else if (right > tempMax) { // finished with right subarray
				data[i] = temp[left++];
			} else if (temp[left].compareTo(temp[right]) < 0) {
				data[i] = temp[left++]; // both active, left smaller
			} else {
				data[i] = temp[right++]; // both active, right smaller
			}
		}
	}

	public int findPartition(T[] data, int min, int max) {
		T temp;
		int left = min;
		int right = max;
		T pivot = data[min]; // keep pivot value aside, place at end
		while (left < right) {
			// search from left for element that is greater than pivot
			while (data[left].compareTo(pivot) <= 0 && left < right) {
				left++;
				// search for element that is less than the pivot
			}
			while (data[right].compareTo(pivot) > 0) {
				right--;
			}
			if (left < right) { // exchange elements if out of order
				temp = data[left];
				data[left] = data[right];
				data[right] = temp;
			}
		}
		data[min] = data[right]; // now place the pivot in right place
		data[right] = pivot;
		return right;
	}

	public void quickSort(T[] data, int min, int max) {
		if (min >= max) {
			return;
		}
		printArray(data, min, max, " sort from " + min + " to " + max);

		int indexOfPartition = findPartition(data, min, max);
		printArray(data, min, max, " after partition from " + min + " to " + max
				+ " at " + indexOfPartition);
		quickSort(data, min, indexOfPartition - 1);
		printArray(data, min, (indexOfPartition - 1), " after sorting from " + min
				+ " to " + (indexOfPartition - 1));

		quickSort(data, indexOfPartition + 1, max);
		printArray(data, (indexOfPartition + 1), max, " after sorting from "
				+ (indexOfPartition + 1) + " to " + max);
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
