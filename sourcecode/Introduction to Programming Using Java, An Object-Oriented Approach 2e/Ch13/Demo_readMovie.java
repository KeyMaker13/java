
// MODIFICATIONS:
//    We have wrapped readMovie in a minimal Movie class and
//    added a main method for demo purposes

import java.io.*;

class Movie {
	Movie(String name, int playingTime) {
		this.name = name;
		this.playingTime = playingTime;
	}

	void show() {
		System.out.println(name+":"+playingTime); System.out.flush();
	}

	static Movie readMovie(BufferedReader br) throws IOException {
		String name;
		int    playingTime=0;
		boolean gotGoodData;	// True if and only if both name and playingTime 
								// have valid data
		Movie  newMovie;
		name = br.readLine();
		gotGoodData = false;
		while (!(name==null || gotGoodData)) {
			gotGoodData = true;	// Optimistic! but if an Exception
								// is thrown, it will be set to false.
			try {
				playingTime = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {	// Skip this movie; do 
												// next one.
				System.err.print("Bad playing time data for "+name);
				System.err.println(" -- movie skipped");
				gotGoodData = false;
				name = br.readLine();
			}
		}
		if (name==null)
			return null;
		else
			return new Movie(name,playingTime);
	}

	String	name;
	int	playingTime;

	public static void main(String[] a) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Movie	m = Movie.readMovie(br);
		while (m!=null) {
			m.show();
			m = Movie.readMovie(br);
		}
	}
}
