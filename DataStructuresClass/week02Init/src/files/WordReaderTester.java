package files;

import java.io.IOException;

public class WordReaderTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WordReader word = new WordReader("short.txt");
			System.out.println("Opened " + word);
			while (word.hasNext())
				System.out.println(word.next());
		} catch (IOException e) {
			System.err.println(e.getMessage() + " Couldn't open file");
		}

	}

}
