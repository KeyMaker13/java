
import java.net.*;
import java.io.*;

class TestTCPConnection {
	public  static  void  main(String[]  a)  throws  Exception  {
		TCPConnection  tc = new TCPConnection("www.yahoo.com",80);
		tc.println("GET "  +  "/"  +  " HTTP/1.0\n"); 
		String  s  =  tc.readLine();      
		while  (s!=null)  {
			System.out.println(s);
			s = tc.readLine();
		}
	}
}
