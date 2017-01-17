
public class Slogan {
	
	private String phrase;
	private static int count = 0;
	
	// Sets up the slogan and counts the number of instances created
	public Slogan (String str){
		phrase = str;
		count++;
	}
	
	//returns this slogan as a string
	public String toString(){
		return phrase;
	}
	
	// returns the number of instances of this class that have been created.
	public static int getCount(){
		return count;
	}

}
