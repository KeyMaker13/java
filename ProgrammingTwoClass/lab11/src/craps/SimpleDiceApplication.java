package craps;

import javax.swing.JFrame;

public class SimpleDiceApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame("Ivan Capistran Simple Dice Application");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DicePanel panel = new DicePanel(150,20);
		panel.setSize(400,400);
	
		
	
		
		
		
		
		
		window.getContentPane().add(panel);
		window.pack();
		window.setVisible(true);
		

	}

}
