package dAryheap;

public class DAryArrayListHeapTester {
	public static void main(String[] args){
		System.out.println("Lab 12 written by Ivan Capistran");
		System.out.println("Testing DAryArrayListHeap for d = 3");
		Integer[] testValues = {20, 8, 7, 13, 15, 1, 25, 4, 7, 3};
		HeapADT<Integer> testHeap = new DAryArrayListHeap<Integer>(3);
		for(int i = 0; i< testValues.length;i++){
			testHeap.addElement(testValues[i]);
		}
		System.out.println("test heap : " + testHeap);
	}
}
