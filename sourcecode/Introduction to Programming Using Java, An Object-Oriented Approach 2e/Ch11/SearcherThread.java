
public class SearcherThread extends Thread{
	public SearcherThread(FileSearcher fs, String pattern) {
		this.fs = fs;
		this.pattern = pattern;
	}
	public void run() {
		try {
			fs.search(pattern);
			if (fs.found())
				System.out.println(fs.getFileName());
		} catch (Exception e) {}
	}
	private FileSearcher fs;
	private String pattern;

}
