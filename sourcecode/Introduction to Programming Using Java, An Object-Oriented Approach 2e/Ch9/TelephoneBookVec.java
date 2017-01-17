import java.io.*;
import java.util.*;

public class TelephoneBookVec {
    public TelephoneBookVec()  {/*exercise*/}
	public static TelephoneBookVec read (String  fileName) throws Exception {    
		TelephoneBookVec tb  =  new TelephoneBookVec();
		BufferedReader br =
			new BufferedReader(
							   new InputStreamReader(
													 new FileInputStream(fileName)));
		Entry e =  Entry.read(br);
		while  (e != null)  {
			tb.entries.add(e);
			e = Entry.read(br);
		}
		return tb;
	}
	
	public void  lookup(String  data)  {
		String digits = "0123456789";
		String firstChar = data.substring(0,1);
		int position = digits.indexOf(firstChar);
		for (int i=0; i< entries.size(); i++) {
			Entry e = (Entry) entries.elementAt(i);
			if (position < 0) {
				if (data.equals(e.getName()))
					System.out.println(e.getNumber());      
			}
			else {
				if (data.equals(e.getNumber()))
					System.out.println(e.getName());
			}
		}
	}
	
	
	private Vector entries;
}

