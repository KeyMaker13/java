package banksimulation;

import java.util.Iterator;

public interface CustomerGenerator {
	public Iterator<Customer> iterator();
	public void addCustomer(Customer c);
	public int getNumberCustomers();
}
