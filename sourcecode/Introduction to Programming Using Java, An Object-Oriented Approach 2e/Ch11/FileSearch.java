import java.io.*;

public class FileSearch {
	public static void main(String[] args) throws Exception {
		String pattern = args[0];   // The pattern to search for
	
		
		// search files args[1], args[2], ..., args[args.length-1]
		for (int i=1; i<args.length; i++) {
			FileSearcher fs = new FileSearcher(args[i]);
			fs.search(pattern);
			if (fs.found())
				System.out.println(args[i]);
		}
	}
}