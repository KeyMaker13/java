import java.io.*;

class TelephoneBook {
	public TelephoneBook (String fileName)  {
		this.fileName = fileName;
	}
	public void  lookup(String data) throws Exception {
		BufferedReader  br  = 
		new BufferedReader(
						   new InputStreamReader(
												 new FileInputStream(fileName)));
		String digits = "0123456789";
		String firstChar = data.substring(0,1);
		int position = digits.indexOf(firstChar);
		Entry e  =  Entry.read(br);
		while  (e != null)  {
			if (position < 0) {
				if (data.equals(e.getName())) 
					System.out.println("Phone number: "+e.getNumber());
			} 
			else {
				if (data.equals(e.getNumber())) 
					System.out.print("Owner: "+e.getName());
			}
			e = Entry.read(br);
		}
	}
	private String fileName;
}
