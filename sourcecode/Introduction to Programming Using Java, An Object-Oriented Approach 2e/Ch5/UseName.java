import java.io.*;
class UseName {
    public static void main(String arg[]) throws Exception {
	Name n; // The name we are modeling
	String first, last, title;
	BufferedReader keyboard = new BufferedReader(
			              new InputStreamReader(System.in));
	System.out.print("First name, please: ");
	first = keyboard.readLine();
	System.out.print("Last name, please: ");
	last = keyboard.readLine();
	System.out.print("Title, please: ");
	title = keyboard.readLine();n = new Name(first,last);
	n.setTitle(title);
	System.out.println(n.getInitials());
	System.out.println(n.getFirstLast());
	System.out.println(n.getLastFirst());
    }
}
