
public class FileSearchWithThreads {
	public static void main(String[] args) throws Exception {
		String pattern = args[0];
		for (int i=1; i < args.length; i++) {
			FileSearcher fs = new FileSearcher(args[i]);
			SearcherThread searcher = new SearcherThread(fs,pattern);
			searcher.start();
		}
	}
}
