package project1;

import java.util.ArrayList;
import java.util.Iterator;

import linkedlist.LinkedList;
import linkedlist.LinkedListIterator;


public class Tester {
	
	private static String[] sentence = new String[10];
	private static Integer[] intTest = new Integer[10];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Project 1 written by Ivan Capistran\n");
		
		// String variables to be used
		sentence[0] = "The";
		sentence[1] = "white";
		sentence[2] = "apple";
		sentence[3]= "said"; 
		sentence[4] = "grapes"; 
		sentence[5] = "are";
		sentence[6] = "yellow";
		sentence[7] = "so";
		sentence[8] = "eat";
		sentence[9] = "lions";
		
		//ArrayList to for testing
				ArrayList<String> stringArrayList = new ArrayList<String>(); 
				for (int i = 0; i < sentence.length; i++ ){
					stringArrayList.add(sentence[i]);
				}
				// Iterator to be used
				Iterator iterString = stringArrayList.iterator();
				Iterator iterString2 = stringArrayList.iterator();
		
		
		ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
		// creating integer values to be used
		for (int i = 0; i <intTest.length; i++){
			intTest[i] = i + 1;
			integerArrayList.add(intTest[i]);
		}
		Iterator iterInt = integerArrayList.iterator();
		Iterator iterInt2 = integerArrayList.iterator();
		
		
//RIForArrayList
		// Creating RIForArrayList Object
		RIForArrayList RIFAL = new RIForArrayList(stringArrayList);
		// Testing RIForArrayList with strings
		System.out.println("Testing RIForArrayList");
		System.out.println("Testing String objects");
		//testPrint(RIFAL);
		customPrint(RIFAL);
		goNext(RIFAL);
		goPrevious(RIFAL);
		
		//testing with integers
		ArrayList<Integer> oneThroughTen = new ArrayList<Integer>();
		for (int i = 0; i < intTest.length; i++){
			oneThroughTen.add(intTest[i]);
		}
		RIFAL = new RIForArrayList(oneThroughTen);
		System.out.println("Testing Integer ojbects");
		testPrint(RIFAL);
		customPrint(RIFAL);
		goNext(RIFAL);
		goPrevious(RIFAL);
		
//RIForArray
		// Creating RIforArray Object
		RIForArray RIFA = new RIForArray(sentence);
		// Testing RIForArray
		System.out.println("Testing RIForArray");
		System.out.println("Testing String objects");
		//testPrint(RIFA);
		customPrint(RIFA);
		goNext(RIFA);
		goPrevious(RIFA);
		
		// testing with integers
		RIFA = new RIForArray(intTest);
		System.out.println("Testing Integer objects");
		testPrint(RIFA);
		customPrint(RIFA);
		goNext(RIFA);
		goPrevious(RIFA);
		
//RIForLinkedList
		LinkedList sentenceForRIFLL = new LinkedList();
		RIForLinkedList RIFLL;
		for (int i = 0; i < sentence.length; i++ ){
			sentenceForRIFLL.add(sentence[i]);
		}
		RIFLL = new RIForLinkedList(sentenceForRIFLL);
		System.out.println("Testing RIForLinkedList");
		System.out.println("Testing String objects");
		//testPrint(RIFLL);
		customPrint(RIFLL);
		goNext(RIFLL);
		goPrevious(RIFLL);
		LinkedList intsForRIFLL = new LinkedList();
		for (int i = 0; i < intTest.length; i++){
			intsForRIFLL.add(intTest[i]);
		}
		RIFLL = new RIForLinkedList(intsForRIFLL);
		System.out.println("Testing integer objects");
		testPrint(RIFLL);
		customPrint(RIFLL);
		goNext(RIFLL);
		goPrevious(RIFLL);
		
//RIUsingArrayList
		//testing string objects
		RIFAL = new RIForArrayList(stringArrayList);
		RIUsingArrayList RIUAL = new RIUsingArrayList(RIFAL);
		System.out.println("Testing RIUsingArrayList");
		System.out.println("Testing String objects");
		//testPrint(RIUAL);
		customPrint(RIUAL);
		goNext(RIUAL);
		goPrevious(RIUAL);
		
		//testing integer objects;
		RIFAL = new RIForArrayList(oneThroughTen);
		RIUAL = new RIUsingArrayList(RIFAL);
		System.out.println("Testing Integer objects");
		testPrint(RIUAL);
		customPrint(RIUAL);
		goNext(RIUAL);
		goPrevious(RIUAL);
		
//RIUsingArray
		//testing string objects
		RIUsingArray RIUA = new RIUsingArray(iterString);
		System.out.println("Testing RIUsingArray");
		System.out.println("Testing String Objects");
		//testPrint(RIUA);
		customPrint(RIUA);
		goNext(RIUA);
		goPrevious(RIUA);
		System.out.println("Testing Integer Objects");
		RIUA = new RIUsingArray(iterInt);
		testPrint(RIUA);
		customPrint(RIUA);
		goNext(RIUA);
		goPrevious(RIUA);

//RIUsingLinkedList
		
		RIUsingLinkedList RIULL = new RIUsingLinkedList(iterString2);
		System.out.println("Testing RIUsingLinkedList");
		System.out.println("Testing String Objects");
		//customPrint(RIULL);
		goNext(RIULL);
		//goPrevious(RIULL);
		RIULL = new RIUsingLinkedList (iterInt2);
		System.out.println("Testing integer objects");
		goNext(RIULL);
	}
	
	public static void goNext(ReversibleIterator iter){ // O(n)
		System.out.println("----hasNext()----");
		while (iter.hasNext()){
			System.out.println(iter.next());
		}
		System.out.println();
	}
	
	public static void goPrevious (ReversibleIterator iter){ //O(n)
		System.out.println("----hasPrevious()----");
		while (iter.hasPrevious()){
			System.out.println(iter.previous());
		}
		System.out.println();
	}
	
	public static void customPrint (ReversibleIterator iter){ // O(1)
		System.out.println("Testing custom next() and previous() commands");
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.previous());
		System.out.println(iter.previous());
		System.out.println(iter.next());
		System.out.println();
	}
	
	public static void testPrint(ReversibleIterator iter){ // O(1)
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.previous());
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.previous());
		System.out.println(iter.previous());
		System.out.println(iter.next());
		System.out.println(iter.next());
	}
	
}
