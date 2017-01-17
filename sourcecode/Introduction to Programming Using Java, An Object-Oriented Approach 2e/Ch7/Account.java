import java.io.*;

public class Account {
	public Account (String id) {
		fileName = id+".act";
	}
	public void withdraw(double amount) throws Exception {
		if (authenticate())
			if (amount < balance) {
				balance -= amount;
				updateBalance();
			} else 
				System.out.println("--| Insufficient Funds |--");
	}
	public void deposit (double amount) throws Exception {
		if (authenticate()) {
			balance += amount;
			updateBalance();
		}
	}
	public void printBalance() throws Exception {
		if (authenticate())
			System.out.println("Current balance: "+balance);
	}
	private boolean authenticate() throws Exception {
		      BufferedReader acctFile = new BufferedReader(
														   new InputStreamReader( 
																				  new FileInputStream(fileName)));
		BufferedReader kbd = new BufferedReader(
												new InputStreamReader(System.in));
		correctPasscode = acctFile.readLine();
		System.out.print("Enter passcode -> ");
		String passcode = kbd.readLine();
		if (!(passcode.equals(correctPasscode))) {
			balance = 0.0;
			System.out.println("--| Password Incorrect |--");
			return false;
		} 
		else {
			balance = Double.parseDouble(acctFile.readLine());
			return true;
		}
	}
	private void updateBalance() throws Exception {
		PrintStream ps = new PrintStream(
										 new FileOutputStream(
															  new File(fileName)));
		ps.println(correctPasscode);
		ps.println(balance);
	}
	private String fileName;
	private String correctPasscode;
	private double balance;
}
