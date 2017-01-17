package sorting;

public class Search<T extends Comparable> {

	public int linearSearch(T[] data, T target) {
		for (int i = 0; i < data.length; i++)
			if (data[i].compareTo(target) == 0)
				return i;
		return -1;
	}

	public int binarySearch(T[] data, T target) {// data is sorted		
		int low = 0;
		int high = data.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int comparison = data[mid].compareTo(target);
			if (comparison == 0)
				return mid;
			else if (comparison < 0)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
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
