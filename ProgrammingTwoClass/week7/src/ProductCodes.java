import java.util.Scanner;

public class ProductCodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String code;
		char zone;
		int district, valid = 0, banned =0;
		
		Scanner scan = new Scanner (System.in);
		
		System.out.print("Enter product code (XXX to quit): ");
		code = scan.nextLine();
		
		while (!code.equals("XXX"))
		{
			try
			{
				zone = code.charAt(9);
				district = Integer.parseInt(code.substring(3,7));
				valid++;
				if (zone == 'R' && district >2000)
					banned++;
			}
			catch (StringIndexOutOfBoundsException exception)
			{
				System.out.println("Improper code length: " + code);
			}
			catch (NumberFormatException exception)
			{
				System.out.println("District is not numeric: " +code);
			}
			System.out.print("Enter product code (XXX to quit): ");
			code = scan.nextLine();
		}
		System.out.println("# of valid codes entered: " + valid);
		System.out.println("# of banned codes entered: " +banned);
	}

}
