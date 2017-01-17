/**
 * 
 */
package songs;

/**
 * @author Ivan Capistran
 * 
 */
public class SongTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out
				.println("CS 1713 Lab 6 (SongTester): Written by Ivan Capistran");

		// PART I:
		// =============================
		// TODO create an array of 4 Song objects called hits.
		Song[] hits = new Song[4];
		hits[0] = new Song("Billy Joel", "We didn't start the fire", 321);
		hits[1] = new Song("Greg Hoffer", "Tune To Program by", 14);
		hits[2] = new Song("Ivan Capistran", "Ivan's new song title", 512);
		hits[3] = new Song("The Pope", "Hym for Solemn Mass in D", 234);

		// TODO output each Song entry of the array
		for (int i = 0; i < 4; i++) {
			System.out.println("[" + i + "]:" + hits[i].toString());
		}

		// PART II:
		// =============================
		// TODO for each entry in hits, compare it to all other entries in hits.
		// Output results.
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("\t" + hits[i].compareTo(hits[j]));
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("\t" + hits[i].equals(hits[j]));
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < hits.length; i++) {
			System.out.println(hits[i].getArtistName() + " "
					+ hits[i].getSongTitle() + " "
					+ hits[i].getLengthInSeconds());
			System.out.println(hits[i].getArtistName() + " "
					+ hits[i].getSongTitle() + " " + hits[i].getTime());
		}

	}

}
