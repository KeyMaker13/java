package recursion;

public class LinearSearchTester {

	public static void main(String[] args) {
		int [] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("Searching test for 4 gives position " + 
				linearSearchIterative(test, 4));
		System.out.println("\n\n");
		System.out.println("Searching test for 4 gives position " + 
				linearSearchRecursive(test, 4, 0));
	}
	
	public static int linearSearchIterative(int [] data, int target) {
		System.out.println("call linearSearchIterative data[] for " + target);
		for (int i = 0; i < data.length; i++) {
			System.out.println("search data[" + i + "]=" + data[i]);
			if (data[i] == target)
				return i;
		}
		return -1;
	}
	
	public static int linearSearchRecursive(int [] data, int target, 
			          int start) {
		System.out.println("call linearSearchRecursive data[] for " + 
												target + " at level " + start);
		if (start >= data.length) {
			System.out.println("Reach the end of data[]");
			return -1; 
		}
		System.out.println("look at data[" + start + "]=" 
				                + data[start]);
		if (data[start] == target) {
			System.out.println("found " + target + " at data[" + start + "]");
			return start;
		}
		int result = linearSearchRecursive(data, target, start+1);
		System.out.println("return " + result);
		//return linearSearchRecursive(data, target, start+1);	
		return result;
	}

}
