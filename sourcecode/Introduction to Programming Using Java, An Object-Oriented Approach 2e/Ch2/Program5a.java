public class Program5a {
    public static void main(String[] arg) {
	String word = "home";
	String middle;
	if (word.length() % 2 == 1)
	    middle = word.substring(word.length()/2,
				    1+word.length()/2);
	else
	    middle = word.substring(word.length()/2 - 1,
				    1+word.length()/2);
	System.out.println(middle);
    }
}
