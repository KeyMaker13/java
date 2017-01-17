package files;

import java.io.IOException;

public class LineReaderTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LineReader line = new LineReader("short.txt");
			System.out.println("Opened " + line);
			while (line.hasNext())
				System.out.println(line.next());
		} catch (IOException e) {
			System.err.println(e.getMessage() + " Couldn't open file");
		}
	}

}
