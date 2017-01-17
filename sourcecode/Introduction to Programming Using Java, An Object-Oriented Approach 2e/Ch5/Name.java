import java.io.*;
class Name {
    public Name(String first, String last) {
	firstName = first;
	lastName = last;
	title = "";
    }
    public String getInitials() {
	String s;
	s = firstName.substring(0,1);
	s = s.concat(".");
	s = s.concat(lastName.substring(0,1));
	s = s.concat(".");
	return s;
    }
    public String getLastFirst() {
	return lastName+", "+firstName;
    }
    public String getFirstLast() {
	return title+" "+firstName+" "+lastName;
    }

    public void setTitle(String newTitle) {
	title = newTitle;
    }
    void print(PrintStream target) {
	target.print(title);
	target.print(" ");
	target.print(firstName);
	target.print(" ");
	target.print(lastName);
    }

    public static Name read(BufferedReader br) 	throws Exception {
	String first = br.readLine();
	if (first == null)
	    return null;
	String last = br.readLine();
	if (last == null)
	    return null;
	Name n = new Name(first,last);
	return n;
    }

    public String toString() {
	String output = title+" "+firstName+" "+lastName;
	return output;
    }
    public boolean equals(Name n) {
	return this.toString().equals(n.toString());
    }
private String firstName;
private String lastName;;
private String title;
}
