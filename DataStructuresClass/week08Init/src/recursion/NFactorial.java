package recursion;

public class NFactorial {

	/**
	 * @param args
	 */
	
	public static int ifac(int n){
		int result = 1;
		for (int i =n; i >=1; i--){
			result = i*result;
		}
		return result;
	}
	
	public static int rfac(int n){
		if (n==1){
			return 1;
		}
		else{
			int result = rfac(n-1);
			return n*result;
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Iterative solution" + ifac(10) );
		System.out.println("Reversive solution" + rfac(10));
	}

}
