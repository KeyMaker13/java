package bank;

import java.util.ArrayList;
import java.util.Iterator;

public class StandardCustomerGenerator implements CustomerGenerator{
	ArrayList <Customer> custList;
	
	public StandardCustomerGenerator () {
		custList = new ArrayList <Customer> ();
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
