public class Program5 {
    public static void main(String[] arg) {
	String word = "antidisestablishmentarianism";
	String middle;
	middle = word.substring(word.length()/2,
				1+word.length()/2);
	System.out.println(middle);
    }
}
