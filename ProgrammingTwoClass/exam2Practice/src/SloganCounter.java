
public class SloganCounter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Slogan obj;
		
		obj = new Slogan ("Remember the Alamo.");
		System.out.println(obj);
		
		obj = new Slogan ("Dont worry. Be Happy.");
		System.out.println(obj);
		
		obj = new Slogan ("Life free or Die");
		System.out.println(obj);
		
		obj = new Slogan ("Talk is cheap");
		System.out.println(obj);
		
		obj = new Slogan ("Write once, run anywhere");
		System.out.println(obj);
		
		System.out.println();
		System.out.println("Slogans created: " + Slogan.getCount());
		int x = 5;
		   int y = 3;
		   double z = 3.0;
		   double w = 2.0;

		System.out.println(x/y);
		System.out.println(x/z);
		System.out.println((x + w + z)/y);
		System.out.println(x % y);
		System.out.println(x/y+z);
		   
	}

}
