import java.io.*;

class ATM {
	   public void getAcctNumber() throws Exception {
		   BufferedReader kbd = new BufferedReader(
												   new InputStreamReader(System.in));      
		   System.out.print("Enter account id: ");
		   String id = kbd.readLine();
		   userAcct = new Account(id);
	   }
	   public void getTransactionChoice() throws Exception {
		   System.out.println("Choose one of: ");
		   System.out.println("W - Withdraw");
		   System.out.println("D - Deposit");
		   System.out.println("B - Get Current Balance");
		   System.out.print("Your choice -> ");
		   BufferedReader kbd = new BufferedReader(
												   new InputStreamReader(System.in));
		   String choice = kbd.readLine();
		   if (choice.equals("W")) {
			   System.out.print("Enter amount to withdraw -> ");
			   String amount = kbd.readLine();
			   double dblAmount = Double.parseDouble(amount);
			   userAcct.withdraw(dblAmount);
		   }
		   else if (choice.equals("D")) {
			   System.out.print("Enter amount to deposit -> ");
			   String amount = kbd.readLine();
			   double dblAmount = Double.parseDouble(amount);
			   userAcct.deposit(dblAmount);
		   }
		   else if (choice.equals("B")) 
			   userAcct.printBalance(); 
		   else
			   System.out.println("--| Invalid Option |--");
		   System.out.println("Thanks for using this machine!");
		   System.out.println();
	   }
	private Account userAcct;
}
