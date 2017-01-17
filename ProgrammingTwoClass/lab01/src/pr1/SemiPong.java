package pr1;

/*
 *  SemiPong written by Ivan Capistran.
 *  Part 1: date started 2/29/2012:
 *          date completed 2/29/2012:
 *          Is this part working correctly? (Yes)
 *         
 *  Part 2: date started: 2/29/2012
 *          date completed:2/29/2012
 *          Is this part working correctly? (Yes)
 *         
 *  Part 3: date started: 2/29/2012
 *          date completed:2/29/2012
 *          Is this part working correctly? (Yes)
 *         
 *  Part 4: date started:2/29/2012
 *          date completed:2/29/2012
 *          Is this part working correctly? (Yes)
 *          
 *  Part 5: date started:2/29/2012
 *          date completed:2/29/2012
 *          Is this part working correctly? (Yes)
 *         
 *  Part 6: date started:2/29/2012
 *          date completed:3/2/2012
 *          Is this part working correctly? (Yes)
 *          Just when the line stabs the ball it bounces back and forth
 *          
 *  The working program submitted represents completion of Part 1 through 6
 *  I certify that what has been handed in is my own work (Yes)
 *  Please describe anything that is not working, other than
 *  what has been already described above.
 */

import javax.swing.JFrame;

public class SemiPong {
	private static final int width = 400;
	private static final int length = 300;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		JFrame frame = new JFrame("Semi-Pong");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SemiPongPanel panel = new SemiPongPanel(width,length);

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

	}

}
