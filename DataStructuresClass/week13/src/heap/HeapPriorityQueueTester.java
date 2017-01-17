package heap;


public class HeapPriorityQueueTester {

	public static void main(String[] args) {
		System.out.println("Testing the HeapPriorityQueue"
				+ " implementation of PriorityQueueADT");
		
    PriorityQueueADT<Integer> pq = new HeapPriorityQueue<Integer> ();

    for (int i=0; i<5; i++) {
      Integer d = new Integer(15-i);
      pq.add(d);
    }

    System.out.println(pq);


	}
}
