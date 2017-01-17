package stack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class ReverseLinesTest {

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		try {
			Scanner scan = new Scanner(new File("lectureSnip.txt"));
			while (scan.hasNextLine())
				s.push(scan.nextLine());
			while (!s.empty())
				System.out.println(s.pop());

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}
