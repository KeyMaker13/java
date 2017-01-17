import java.net.*;
import java.io.*;

class CheckURL {
	public static void main(String[] a) {
		try {
			URL u = new URL(a[0]);
			HttpURLConnection uC = (HttpURLConnection) u.openConnection();
			int responseCode = uC.getResponseCode();
			System.out.println(responseCode);
			if (responseCode >= 300)
				System.out.println("bad");
			else
				System.out.println("good");
		} catch (Exception e) {
			System.out.println("bad");
		}
	}
}