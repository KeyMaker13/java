package searcingsorting;

public class QuadraticSort <T extends Comparable<T>> {
	private boolean debug;

	public QuadraticSort() {
		this(false);
	}

	public QuadraticSort(boolean d) {
		debug = false;
	}

	public void selectionSort(T[] data) {
		for (int index = 0; index < data.length - 1; index++) {
			int min = findMinPosition(data, index);
			T temp = data[min];
			data[min] = data[index];
			data[index] = temp;
			if (debug)
				printArray(data, ": after sorting [" + index + 
						"... " + (data.length - 1)+ "]");
		}
	}

	private int findMinPosition(T[] data, int start) {
		int min = start;
		for (int scan = start + 1; scan < data.length; scan++)
			if (data[min].compareTo(data[scan]) > 0)
				min = scan;
		return min;
	}

	public void insertionSort(T[] data) {
		for (int i = 1; i < data.length; i++) {
			insertItem(data, i);
			if (debug)
				printArray(data, ": after sorting [0.." + i + "]");
		}
	}

	private void insertItem(T[] data, int index) {
		T key = data[index];
		int pos = index;
		while (pos > 0 && key.compareTo(data[pos - 1]) < 0) {
			data[pos] = data[pos - 1];
			pos--;
		}
		data[pos] = key;
	}

	public void bubbleSort(T[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = 0; j < data.length - 1 - i; j++) {
				if (data[j + 1].compareTo(data[j]) < 0) {
					T tmp = data[j]; // swap
					data[j] = data[j + 1];
					data[j + 1] = tmp;
				}
			}
		}
	}

	public void setDebug() {
		debug = true;
	}
	
	public void clearDebug() {
		debug = false;
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
