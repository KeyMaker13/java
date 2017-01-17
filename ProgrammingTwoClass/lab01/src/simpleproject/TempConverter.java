package simpleproject;

public class TempConverter{
	// computes Fahrenheit to Celsius
	
	public static void main (String[] args){
		final int BASE = 32;
		final double CONVERSION_FACTOR = 9.0/5.0;
		
		double fahrenheitTemp;
		int celsiusTemp = 24; // value to convert
		
		fahrenheitTemp = celsiusTemp * CONVERSION_FACTOR + BASE;
		
		System.out.println("Celsius Temperature: " + celsiusTemp);
		System.out.println("Fahrenheit Equivalent: " + fahrenheitTemp);
	}

}
