public class Program6 {
    public static void main(String[] arg) {
	String beforeTrim = " spacy ";
	String afterTrim;
	afterTrim = beforeTrim.trim();
	if (beforeTrim.length() == afterTrim.length())
	    System.out.println("String is no shorter.");
	else
	    System.out.println("Shortened the string.");
    }
}
