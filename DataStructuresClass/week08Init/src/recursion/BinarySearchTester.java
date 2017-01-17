package recursion;

public class BinarySearchTester {

	public static void main(String[] args) {
		int [] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("Searching test for 4 gives position " + 
				binarySearchRecursive(test, 4, 0, test.length - 1));
	}
	
	public static int binarySearchIterative(int [] data, int target) {// data is sorted		
		int low = 0;
		int high = data.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (data[mid] == target)
				return mid;
			else if (data[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
	
	public static int binarySearchRecursive(int [] data, int target,
			int low, int high) {// data is sorted		
		if (low > high)
		  return -1;
		int mid = (low + high)/2;
		if (data[mid] == target)
			return mid;
		if (data[mid] < target)
			return binarySearchRecursive(data, target, mid + 1, high);
		return binarySearchRecursive(data, target, low, mid - 1);
	}

}
