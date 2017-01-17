package bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class RandomCustomerGenerator implements CustomerGenerator {
	
	ArrayList<Customer> custList;
	
	private int nCustomer;
	private int largestArrival;
	private int largestService;
	
	public RandomCustomerGenerator(int c, int lA, int lS){
		
		custList = new ArrayList<Customer>();
		nCustomer = c;
		largestArrival = lA;
		largestService = lS;
		
		Random r = new Random();
		
		for (int i = 0; i < nCustomer; i++){
			Customer c1 = new Customer(r.nextInt(largestArrival), r.nextInt(largestService));
			
			addCustomer(c1);
		}
		
	}


public void addCustomer(Customer c) {
	custList.add(c);
}

public Iterator<Customer> iterator() {
	return custList.iterator();
}
    
public int getNumberCustomers() {
	return custList.size();
}

public String toString() {
	String result = getClass().getName() + ":[ ";
	Iterator<Customer> iter = custList.iterator();
	while (iter.hasNext())
		result = result + iter.next() + " ";
	return result + "]";
}

}
