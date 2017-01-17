/**
 * 
 */
package songs;

/**
 * @author Ivan Capistran
 *
 */
public class CDImageTester {
	// songs to be inputed into CD
	private static Song song4 = new Song("Elvis","When My Blue Moon Turns to Gold Again", 141 );
	private static Song song5 = new Song("Elvis","Tell me why", 120 );
	private static Song song6 = new Song("Test","Testing six", 0 );
	private static Song song0 = new Song("Test","Testing zero", 0 );
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("CS 1713 Lab 6 (CDImageTester): Written by Ivan Capistran");
		System.out.println();
		
		// create CD image
		CDImage CD = new CDImage("The Other Sides","RCA", 5);
		
		// insert a songs by tracks
		// i inserted songs with wrong array index values and songs in again with wrong values...
		// and the code is robust for inputing songs with methods
		CD.setSong(1, "My Baby Left Me", "Elvis", 121);	
		CD.setSong(2,"We're Gonna Move", "Elvis", 150);
		CD.setSong(3, "Poor Boy", "Elvis", 133);
		CD.setSong(0, "Test","testing zero" , 0);
		CD.setSong(6, "Test","testing six" , 0);
		CD.setSong(3, "Test","testing three" , 0);
		
		//insert songs in CD by song objects
		// i inserted songs with wrong array index values and songs in again with wrong values...
		// and the code is robust for inputing songs with methods
		CD.setSongBySong(4, song4);
		CD.setSongBySong(5, song5);
		CD.setSongBySong(0, song0);
		CD.setSongBySong(6, song6);
		CD.setSongBySong(4, song6);
		
		// return a song given a track
		System.out.println("Returning song names from a given track number");
		System.out.println(CD.getSongFromTrack(0));
		System.out.println(CD.getSongFromTrack(1));
		System.out.println(CD.getSongFromTrack(2));
		System.out.println(CD.getSongFromTrack(3));
		System.out.println(CD.getSongFromTrack(4));
		System.out.println(CD.getSongFromTrack(5));
		System.out.println(CD.getSongFromTrack(6));
		System.out.println();
		
		// print CD in a readable form
		System.out.println(CD.printCD(CD));
		System.out.println();
		
		// remove a song given song name and artist
		CD.removeSong("Elvis", "Tell me why");
		System.out.println("Removing 5th song from CD");
		System.out.println(CD.getSongFromTrack(5));
		CD.setSongBySong(5, song5);
		System.out.println();
		
		// Returning track number of song defined by artist name and song name
		System.out.println("Returning track number of the song by ---> Elvis named ---> Poor Boy");
		System.out.print("The song is in track number " );
		System.out.print(CD.getTrackNumber("Elvis", "Poor Boy"));
		System.out.println("Returning track number of the song by ---> Elvis named ---> Fresh Cookies");
		System.out.print("The song is in track number " );
		System.out.print(CD.getTrackNumber("Elvis", "Fresh Cookies"));
		System.out.println();
		System.out.println();
		
		//Returning a string that shows total time in minutes and seconds
		System.out.print("Total length of CD is ");
		System.out.print(CD.totalCDLength(CD));
		
		
	}

}
