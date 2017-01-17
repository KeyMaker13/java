/**
 * 
 */
package songs;
import java.text.DecimalFormat;

/**
 * @author Ivan Capistran
 * 
 */
public class CDImage {

	// Member variables
	// TODO add member variables : title of CD, label name, and number of tracks
	// ... and, somehow, keep track of multiple Song entries.
	private String title;
	private String label;
	private int numberOfTracks;
	private static Song[] song;
	private static DecimalFormat fmt = new DecimalFormat("00");

	// TODO implement accessor methods for member variables.

	public String getTitle() {
		return title;
	}

	public String getLabel() {
		return label;
	}

	public int getNumberOfTracks() {
		return numberOfTracks;
	}

	/**
	 * Constructor
	 */
	public CDImage(String cdTitle, String recordingLabel, int numberOfTracks) {
		// TODO initialize member variables.
		this.title = cdTitle;
		this.label = recordingLabel;
		this.numberOfTracks = numberOfTracks;
		song = new Song[numberOfTracks];

	}

	// return song given a track
	public String getSongFromTrack(int track) {
		track--;

		if (track < 0 || track >= numberOfTracks) {
			return "No such track number exist";
		}

		if (song[track] == null) {
			return "Song not found";
		} else {
			return song[track].getSongTitle();
		}
	}

	// print cd in readable form
	public String printCD(CDImage CD) {

		String cdArtist = "\""+CD.song[0].getArtistName()+"\"";
		String cdTitle = CD.getTitle();
		String cdLabel = CD.getLabel();

		String toPrint = cdArtist +":" + "\"" + cdTitle + "\"" + " put out by " + cdLabel + " ";
		for (int i = 0; i < numberOfTracks; i++) {
			toPrint += ("\n" + CD.song[i].getSongTitle() + " " + CD.song[i].getTime());
		}
		return toPrint;
	}

	public void setSong(int track, String songName, String artistName, int songLength) {
		track--;
		
		if (track < 0 || track >= numberOfTracks) {
			
		}
		else if (song[track] != null){
		
		}
		else{
		song[track] = new Song(artistName, songName, songLength);
		}
	}

	public void setSongBySong(int track, Song mSong) {
         track--;
		
		if (track < 0 || track >= numberOfTracks) {
			
		}
		else if (song[track] != null){
		
		}
		else{
		song[track] = mSong;
		}
	}

	public void removeSong(String artistName, String songName) {

		for (int i = 0; i < song.length; i++) {
			if ((song[i].getSongTitle() == songName)&& (song[i].getArtistName() == artistName)) {
				song[i] = null;
			}
		}

	}

	public int getTrackNumber(String artist, String songName) {

		int count = 0;
		
		for (int i = 0; i < song.length; i++) {
			if ((song[i].getSongTitle() == songName)&& (song[i].getArtistName() == artist)) {
				count = i + 1;
			}
		}
		if (count ==0){
			return -1;
		}
		else{
			return count;		
			}
	}

	public String totalCDLength(CDImage CD) {

		int totalSeconds = 0;

		for (int i = 0; i < CD.song.length; i++) {
			totalSeconds += CD.song[i].getLengthInSeconds();
		}
		int minutes = totalSeconds / 60;
		int seconds = totalSeconds % 60;

		return minutes + ":" + fmt.format(seconds);
	}

	

}
