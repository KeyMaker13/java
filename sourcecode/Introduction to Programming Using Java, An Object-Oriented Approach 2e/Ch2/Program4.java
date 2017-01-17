public class Program4 {
    public static void main(String[] arg) {
	String s1 = "deoxyribonucleic";
	String s2 = "hippopotamus";
	String s3 = "a short ride in a fast car";
	int length1 = s1.length();
	int length2 = s2.length();
	int length3 = s3.length();
	int average = (length1+length2+length3) / 3;
	System.out.print("The average length is ");
	System.out.println(average);
    }
}
