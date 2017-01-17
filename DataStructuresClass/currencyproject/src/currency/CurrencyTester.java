package currency;
import java.util.Random;


public class CurrencyTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Lab 1 written by Ivan Capistran\n");
		
		Currency c1 = new Currency (50,"Dollars", "US");
		Currency c2 = new Currency ();
		c2.setValue(40);
		c2.setName("Dollar");
		c2.setCountryCode("US");
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println("Test for Equality: " + c1.equals(c2) + "\n");
		
		// Part II 
		
		// Loop 10 times
		System.out.println("Part II");
		Random rand = new Random();
		
		int max = 0;
		int min = 101;
		int avg = 0;
		
		
		for (int i = 0; i< 10; i++){
			
			int r = rand.nextInt(100) + 1 ; 
			
			if ( r > max){
				max = r;
			}
			if ( r < min){
				min = r;
			}
			
			Currency myCurrency = new Currency (r,"theCurrency", "US");
			
			System.out.println(myCurrency.toString());
			
			avg += myCurrency.getValue();
		}
		
		System.out.println("\nThe max currency is " + max);
		System.out.println("The min currency is " + min);
		System.out.println("The average currency is " + avg/10);
		System.out.println();
		
		// Add the Dime, Nickel and Penny classes to the currencyproject. Add test code to CurrencyTester to create and compare various currency.
		Quarter q1 = new Quarter();
		Nickel n1 = new Nickel();
		Dime d1 = new Dime();
		Penny p1 = new Penny();
		
		// testing inheritance for toString method in parent class
		System.out.println(q1.toString() + "\n");
		System.out.println(n1.toString() + "\n");
		System.out.println(d1.toString() + "\n");
		System.out.println(p1.toString() + "\n");
		
		// testing equals method in parent class
		System.out.println("Does a quarter equal a nickel? " + q1.equals(n1) + "\n");
		System.out.println("Does a nickel equal a dime? " + n1.equals(d1) + "\n");
		System.out.println("Does a dime equal a penny? " + d1.equals(p1) + "\n");
		System.out.println("Does a quarter equal a quarter? " + q1.equals(q1) + "\n");

	}

}
