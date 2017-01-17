package craps;

import javax.swing.JFrame;

public class CrapsApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame("Ivan Capistran Simple Dice Application");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CrapsPanel panel = new CrapsPanel();
		panel.setSize(400,400);
	
		
	
		
		
		
		
		
		window.getContentPane().add(panel);
		window.pack();
		window.setVisible(true);
		

	}

}
