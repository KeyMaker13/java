public class ATMTestDriver {
	public static void main(String[] arg) throws Exception {
		ATM myATM = new ATM();
		for (int i=0; true; i++) {
			myATM.getAcctNumber();
			myATM.getTransactionChoice();
		}
	}
}
