/**
 * 
 */
package songs;

import java.text.DecimalFormat;

/**
 * @author Ivan Capistran
 * 
 */
public class Song implements Comparable {

	// Member variables
	private int lengthInSeconds;
	private String songTitle;
	private static DecimalFormat fmt = new DecimalFormat("00");

	public int getLengthInSeconds() {
		return lengthInSeconds;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public String getArtistName() {
		return artistName;
	}

	private String artistName;

	// TODO add member variables : length in secs, artist name, and song name.
	// TODO implement accessor methods for member variables.

	/**
	 * Constructor for a song.
	 */
	public Song(String strArtist, String strSong, int iLength) {
		this.artistName = strArtist;
		this.songTitle = strSong;
		this.lengthInSeconds = iLength;
		// TODO initialize member variables. Should we accept some parameters?
	}

	public String toString() {
		return this.getClass() + ": " + "Artist: " + this.artistName
				+ "Song Title: " + this.songTitle + "Length (s): "
				+ this.lengthInSeconds; // TODO output other member variables.
	}

	public int compareTo(Object other) {
		if (other == null) {
			throw new NullPointerException();
		}
		int iResult = 0;
		Song otherSong = (Song) other;

		// TODO Compare "this" to "otherSong" and set iResult to appropriate
		// value. How do we handle a NULL passed in?
		iResult = this.songTitle.compareTo(otherSong.getSongTitle());

		return iResult;
	}

	public boolean equals(Song other) {
		if (other == null) {
			return false;
		}
		boolean bIsEqual = false;

		// TODO determine if "this" song is equal to the "other" song. Use
		// "compare()".
		bIsEqual = (0 == this.compareTo(other));

		return bIsEqual;
	}

	/*
	 * returns a string containing the running time of the song in
	 * minutes:seconds format. For example, a song with a running time of 130
	 * seconds will return a getTime string of "2:10"
	 */
	public String getTime() {
		// TODO return string of proper format. Use the DecimalFormat class to
		// make sure that the seconds are always displayed with 2 digits
		
		
		int minutes = this.lengthInSeconds/60;
		int seconds = this.lengthInSeconds % 60;

		String strTime = minutes+":"+ fmt.format(seconds);
		
		return strTime;
	}

}
