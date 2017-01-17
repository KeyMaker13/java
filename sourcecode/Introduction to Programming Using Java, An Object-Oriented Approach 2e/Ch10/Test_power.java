// MODIFICATIONS:
//    power is made static here so we can test it without creating an object

class Test_power {
	///////////////////////////////////////////////////////
	private static int power(int x, int y) {
		int	count,	// count==the number of multiplications done.
			result; // result==1*x*x*...*x (count times), that is, 
				//    result==x**count.
		count = 0;
		result = 1;
		while (count!=y) {
			result *= x;
			count++;
		}
		// count==y, result==x**y
		return result;
	}
	///////////////////////////////////////////////////////

	private static boolean powerFailure(int x, int y, int v) {
		int	w = power(x,y);
		if (w!=v) {
			System.err.println("FAILS: power("  +  x  +  ","  +  y  +
				 ") returns "  +  w  +  " instead of "  +  v);
			return true;
		} else
			return false;
	}

	public static void main(String[] a) {
		boolean failure=false;
		failure |= powerFailure(2,3,8);
		failure |= powerFailure(3,2,9);
		failure |= powerFailure(5,3,125);
		failure |= powerFailure(1,0,1);
		failure |= powerFailure(1,1,1);
		failure |= powerFailure(1,2,1);
		failure |= powerFailure(1,3,1);
		failure |= powerFailure(1,999,1);
		failure |= powerFailure(0,1,0);
		failure |= powerFailure(0,2,0);
		failure |= powerFailure(0,3,0);
		failure |= powerFailure(0,999,0);
		if (!failure)
			System.out.println("power passes our tests");
	}
}
