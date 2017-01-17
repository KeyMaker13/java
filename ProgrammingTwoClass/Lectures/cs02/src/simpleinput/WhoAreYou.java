package simpleinput;

import java.util.*;

public class WhoAreYou {
	
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Hello, what is your name?");
		String response = scan.nextLine();
		System.out.println("Hello " + response + "!");
		
	}

}
