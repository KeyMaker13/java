class MailClient {
	public MailClient(String to, String from) throws Exception {
		int atInTo  =  to.indexOf("@"); 
		int atInFrom  =  from.indexOf("@"); 
		String serverHost  = to.substring(atInTo+1);
		String senderHost  = from.substring(atInFrom+1);
		String recipient = to.substring(0,atInTo);
		tc = new TCPConnection(serverHost, 25); 
		println("EHLO "+senderHost); 
		println("MAIL From: <"+from+">"); 
		println("RCPT To: <"+to+">"); 
		println("DATA"); 
	}
	
	public boolean success() throws Exception {
		String s  =  tc.readLine();
		while  (s!=null  &&  !s.substring(0,1).equals("5"))
			s = tc.readLine();
		return  s==null; 
	}
	
	public void println(String s) {
		tc.println(s);
	}
	
	public void close() {
		println("\n.\nQUIT");
	}
	
	private TCPConnection tc;
	
	public static void main(String[] a) throws Exception {
		MailClient mc = new MailClient(a[0],a[1]);
		mc.println("Subject: test message!");
		mc.println("Just let me know if you received this. Thanks!");
		mc.close();
		if (mc.success())
			System.out.println("mail success");
		else
			System.out.println("mail failure");
	}
}
