// MODIFICATIONS:
//    multiply is made static here so we can test it without creating an object

class Test_multiply {
	///////////////////////////////////////////////////////////////////////////
	private static int multiply(int x, int y) {
		int	count,	// count==the number of additions done.
			result;	// result==0+x+x+...+x (count times), that is, 
				//     result==x*count.
		count = 0;
		result = 0;
		while (count!=y) {
			result += x;
			count++;
		}
		// count==y, result==x*y
		return result;
	}
	///////////////////////////////////////////////////////////////////////////

	private static boolean multiplyFailure(int x, int y, int v) {
		int	w = multiply(x,y);
		if (w!=v) {
			System.err.println("FAILS: multiply("  +  x  +  ","  +  y  +
				 ") returns "  +  w  +  " instead of "  +  v);
			return true;
		} else
			return false;
	}

	public static void main(String[] a) {
		boolean failure=false;
		failure |= multiplyFailure(2,3,6);
		failure |= multiplyFailure(3,2,6);
		failure |= multiplyFailure(5,3,15);
		failure |= multiplyFailure(1,0,0);
		failure |= multiplyFailure(1,1,1);
		failure |= multiplyFailure(1,2,2);
		failure |= multiplyFailure(1,3,3);
		failure |= multiplyFailure(1,999,999);
		failure |= multiplyFailure(0,1,0);
		failure |= multiplyFailure(0,2,0);
		failure |= multiplyFailure(0,3,0);
		failure |= multiplyFailure(0,999,0);
		failure |= multiplyFailure(100,100,10000);
		if (!failure)
			System.out.println("multiply passes our tests");
	}
}
