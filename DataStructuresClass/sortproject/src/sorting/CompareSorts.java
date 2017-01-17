package sorting;

import java.util.Random;

public class CompareSorts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		System.out.println("CS 2123 Lab 09 by Ivan Capistran");
		
		Random rand = new Random();
		int[] sizes={10, 100, 1000, 10000, 20000, 50000, 100000, 200000, 500000};
		int numRepetitions = 10;
		
		System.out.println("\n\nTesting fast sorts:");
		System.out.println("\nsize\t\tQuicksort\t Mergesort\t ");
		FastSort <Integer> fSort = new FastSort<Integer> ();
		for(int i=0; i < sizes.length; i++){ //size
			int size = sizes[i];
			long timeQuickSort = 0;
			long timeMergeSort = 0;
			long startTime;
			long endTime;
			for(int k = 0; k < numRepetitions; k++){ // repetition
				// generate a test array for this repetition
				Integer [] testOriginal = new Integer[size]; 
				for(int j=0; j < size; j++) 
					testOriginal[j] = new Integer(rand.nextInt(999));//random 0...999
					           
				Integer [] test = testOriginal.clone();
				
				startTime= System.currentTimeMillis();
				fSort.quickSort(test, 0, size - 1);
				endTime = System.currentTimeMillis();
				timeQuickSort += (endTime - startTime);

				test = testOriginal.clone();
				startTime = System.currentTimeMillis();
				fSort.mergeSort(test, 0, size - 1);
				endTime = System.currentTimeMillis();
				timeMergeSort += (endTime - startTime);
			}
			System.out.print(size + "\t\t");
			System.out.print(timeQuickSort/numRepetitions + "\t\t ");
			System.out.print(timeMergeSort/numRepetitions + "\t\t ");
			System.out.println();
		}
		
	
		// 3 ways
	
	
		System.out.println("\n\nTesting 3 way fast sort:");
		System.out.println("\nsize\t\t3WayQuicksort\t 3WayMergesort\t ");
		FastSort3Way <Integer> f3Sort = new FastSort3Way<Integer> ();
		for(int i=0; i < sizes.length; i++){ //size
			int size = sizes[i];
			long timeQuickSort = 0;
			long timeMergeSort = 0;
			long startTime;
			long endTime;
			for(int k = 0; k < numRepetitions; k++){ // repetition
				// generate a test array for this repetition
				Integer [] testOriginal = new Integer[size]; 
				for(int j=0; j < size; j++) 
					testOriginal[j] = new Integer(rand.nextInt(999));//random 0...999
					           
				Integer [] test = testOriginal.clone();
				
				startTime= System.currentTimeMillis();
				f3Sort.quickSort3Way(test, 0, size - 1);
				endTime = System.currentTimeMillis();
				timeQuickSort += (endTime - startTime);

				test = testOriginal.clone();
				startTime = System.currentTimeMillis();
				f3Sort.mergeSort3Way(test, 0, size - 1);
				endTime = System.currentTimeMillis();
				timeMergeSort += (endTime - startTime);
			}
			System.out.print(size + "\t\t");
			System.out.print(timeQuickSort/numRepetitions + "\t\t ");
			System.out.print(timeMergeSort/numRepetitions + "\t\t ");
			System.out.println();
		}
		
		
		//Selection sort bubble sort
		
		long averageTimeSelectionSort =0;
		long averageTimeBubbleSort=0;
		
		
		int[] sizesOYO={10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000};
		
		System.out.println("\n\nTesting Selection sort and Bubble sort:");
		System.out.println("\nsize\t\tSelectionsort\t Bubblesort\t ");
		QuadraticSort <Integer> fSortOYO = new QuadraticSort<Integer> ();
		for(int i=0; i < sizesOYO.length; i++){ //size
			int size = sizesOYO[i];
			long timeSelectionSort = 0;
			long timeBubbleSort = 0;
			long startTime;
			long endTime;
			for(int k = 0; k < numRepetitions; k++){ // repetition
				// generate a test array for this repetition
				Integer [] testOriginal = new Integer[size]; 
				for(int j=0; j < size; j++) 
					testOriginal[j] = new Integer(rand.nextInt());//random 0...999
					           
				Integer [] test = testOriginal.clone();
				
				startTime= System.currentTimeMillis();
				fSortOYO.selectionSort(test);
				endTime = System.currentTimeMillis();
				timeSelectionSort += (endTime - startTime);

				test = testOriginal.clone();
				startTime = System.currentTimeMillis();
				fSortOYO.bubbleSort(test);
				endTime = System.currentTimeMillis();
				timeBubbleSort += (endTime - startTime);
			}
			System.out.print(size + "\t\t");
			averageTimeSelectionSort += timeSelectionSort/numRepetitions ;
			averageTimeBubbleSort += timeBubbleSort/numRepetitions;
			System.out.print(timeSelectionSort/numRepetitions + "\t\t ");
			System.out.print(timeBubbleSort/numRepetitions + "\t\t ");
			System.out.println();
		}
		System.out.println("Average run time for Selection Sort: " + averageTimeSelectionSort/10);
		System.out.println("Average run time for Bubble Sort: " + averageTimeBubbleSort/10);
		
		
	}
}
