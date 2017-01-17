import java.io.*;

public class FileSearcher {
	public FileSearcher(String filename) {
		this.filename = filename;
	}
	
	public void search (String pattern) throws Exception {
		BufferedReader br = new BufferedReader(
											   new InputStreamReader(
																	 new FileInputStream(filename)));
		String line = br.readLine();
		while (line != null && line.indexOf(pattern) == -1)
			line = br.readLine();
		foundIt = line != null;
		br.close();
	}
	
	public String getFileName() { return filename; }
	public boolean found() { return foundIt; }
	private String filename;
	private boolean foundIt;
}