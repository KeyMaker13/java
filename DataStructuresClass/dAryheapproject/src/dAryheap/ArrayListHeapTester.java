package dAryheap;
import java.util.*;

public class ArrayListHeapTester {
	public static void main(String[] args) {
		System.out.println("Testing the ArrayListHeap" +
		" implementation of HeapADT");
		
		/** Testing addElement **********************************/
		Integer [] testValues = {20, 8, 7, 13, 15, 1, 25, 4, 7, 3};
		HeapADT <Integer> testHeap = new ArrayListHeap<Integer> ();
		for (int k = 0; k < testValues.length; k++)
			testHeap.addElement(testValues[k]);
		System.out.println("testHeap: " + testHeap);
		
		
		System.out.print("Removing values from testHeap: ");
		for (int k = 0; k < testValues.length; k++)
			System.out.print(testHeap.removeMin() + " ");
		System.out.println(" [Expected values in increasing order]");
	}
}
