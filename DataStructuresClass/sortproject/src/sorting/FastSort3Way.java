package sorting;

public class FastSort3Way <T extends Comparable> {
	private boolean debug;
	
	public FastSort3Way() {
		this(false);
	}
	
	public FastSort3Way(boolean d) {
		debug = false;
	}
	
	public void mergeSort3Way(T[] data, int min, int max) {
		// Base case
		if (min >= max)  // if data does not have at least two elements, quit
			return;

		// divide into three subarrays [min, left], [left + 1, right], [right + 1, max]
		int left = (2*min + max) / 3; // = min + (max - min)/3
		int right = (2*max + min) / 3; // = min + 2*(max - min)/3
		
		//********** Recursive case FILL IN **********************************
		
		mergeSort3Way(data,min,right);
		mergeSort3Way(data,left+1,right);
		mergeSort3Way(data,right+1,max);
		merge(data,min,left,right,max);
			
	}
	
	private void merge(T [] data, int min, int left, int right, int max) {
		T[] temp = (T[]) (new Comparable[max - min + 1]);
		for (int i = 0; i < temp.length; i++)  // copy into a temporary
			temp[i] = data[i + min];
		
		// current positions in 3 subarrays of temp (or -1 if done)
        int [] index = {0, left - min + 1, right - min + 1};
        // last positions in 3 subarrays of temp 
        int [] high = {left - min, right - min, max - min}; 
		
		for (int i = min; i <= max; i++) {
			checkRange(index, high); // if an index is out of bounds, set to -1
			int minIndex = findMergeIndex(temp, index); // which partition to move
			data[i] = temp[index[minIndex]];
			index[minIndex] = index[minIndex] + 1;
		}  
	} 
	
	// Sets values of index to -1 if their values exceed corresponding values in high
	// -1 means that we have merged all the values from the corresponding partition
	private void checkRange(int [] index, int high[]) {
		for (int k = 0; k < index.length; k++)
			if (index[k] > high[k])
				index[k] = -1;
	}
	
	//Returns the number of the partition from which to take next element or -1 if none available
	private int findMergeIndex(T [] data, int [] index) {
		int minIndex = -1;
		for (int k = 0; k < index.length; k++) {
			if (index[k] == -1)
				continue;
			else if (minIndex == -1)
			    minIndex = k;
			else if (data[index[k]].compareTo(data[index[minIndex]]) < 0)
				minIndex = k;
		}
		return minIndex;
	}
	
	// Initial call is quickSort3Way(data, 0, data.length - 1);
	public void quickSort3Way(T [] data, int min, int max) {	
		if (min >= max) // Base case
			return;

		//********** Recursive case FILL IN **********************************
		int result[] = findPartition(data,min,max);
		quickSort3Way(data,min,result[0]);
		quickSort3Way(data,result[1],max);
		
	}
	
	
	// Partitions into three parts: <pivot =pivot >pivot
	private int[] findPartition(T[] data, int min, int max) {	
		T pivot = data[min];
		int left = min;  // current element when scanning from left to right
		int equal = min; // start of part with elements equal to pivot						
		int right = max + 1; // start of part with elements greater than pivot

		while(left < right){
			if(data[left].compareTo(pivot) < 0){
				swap(data, left, equal);
				equal++;
				left++;
			}else if (data[left].compareTo(pivot) == 0) 
				left++;
			else {
				right--;
				swap(data, left, right);
			}
		}
		int[] toReturn = new int[2];
		//********** Return value FILL IN **********************************
		toReturn[0] = equal;
		toReturn[1] = left;
		return toReturn;
	}
	
	private void swap(T[] data, int i, int j){
		T temp = data[i];
		data[i]=data[j];
		data[j]=temp;
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

