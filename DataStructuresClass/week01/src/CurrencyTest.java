
public class CurrencyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Currency c1 = new Currency("quarter",25, "US");
			System.out.println("c1 =" + c1);
			
			Currency c2 = new Currency("quarter", 25, "dumb");
		
		} catch(Exception e){
			System.err.println(e.getMessage());
			
		}
	}

}
