
class WebClient {
	public WebClient(String hostname,int portnumber,String resource) throws Exception {
		tc  =  new  TCPConnection(hostname,  portnumber); 
		tc.println("GET  "+resource+"  HTTP/1.0\n"); 
		String  s  =  tc.readLine(); 
		while  (s!=null  &&  !s.equals("")) 
			s  =  tc.readLine();
	}
	
	public WebClient(String hostname, String resource) throws Exception {
		this(hostname,80,resource);
	}
	
	public WebClient(String hostname, int portnumber) throws Exception {
		this(hostname,portnumber,"/");
	}
	
	public WebClient(String hostname) throws Exception {
		this(hostname,80,"/");
	}
	
	public String readLine() throws Exception {
		return  tc.readLine();
	}
	
	private  TCPConnection tc;
	
	public static void main(String[] a) throws Exception { 
		if (a.length!=2)
			System.err.println("usage: java WebClient host resource");
		else {
			WebClient wc = new WebClient(a[0],80,a[1]);
			String  s = wc.readLine();
			while (s!=null) {
				System.out.println(s);
				s = wc.readLine();
			}
		}
	}
}
