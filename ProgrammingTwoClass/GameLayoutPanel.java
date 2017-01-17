package craps;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;


public class GameLayoutPanel extends JPanel {
	private int numRolls = 0;
	private int numWins = 0;
	private JLabel lblRolls;
	private JLabel lblWins;
	private DicePanel die1;
	private DicePanel die2;
	
	/**
	 * Inner classes for action listeners
	 */
	private class rollListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {	
			numRolls ++;
			System.out.println("You have clicked ROLL.You now have" + numRolls);
			lblRolls.setText("Rolls: " + numRolls);
			Random rnd = new Random();
			int val1 = rnd.nextInt(6) + 1;
			int val2 = rnd.nextInt(6) + 1;
			
			die1.setValue(val1);
			die2.setValue(val2);
		}
	}
	private class clearListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("You have clicked CLEAR.");
			lblRolls.setText("Rolls: 0");
			lblWins.setText("Wins: 0");
			
			numRolls = 0;
			numWins = 0;
		}
	}
	public GameLayoutPanel(){
		this.setSize(150,150);
		setLayout( new BorderLayout(4,4));
		
		//create north panel
		Panel northPanel = new Panel();
		northPanel.setLayout(new GridLayout(1,2));
		//add the ROLLS and WINS  labels
		lblRolls = new JLabel("Rolls: 0");
		northPanel.add(lblRolls);
		lblWins = new JLabel("Wins: 0");
		northPanel.add(lblWins);
		this.add(northPanel, BorderLayout.NORTH );
		
		//south panel
		Panel southPanel = new Panel();
		southPanel.setLayout(new GridLayout(1,2));
		JButton btnRoll = new JButton("Roll");
		//handling event and responsible for it
		btnRoll.addActionListener( new rollListener() );
		southPanel.add(btnRoll);
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new clearListener() );
		southPanel.add(btnClear);
		this.add(southPanel, BorderLayout.SOUTH );
		
		//center panel
		Panel centerPanel = new Panel();
		centerPanel.setLayout(new GridLayout(1,2));
		//dice 
		die1 = new DicePanel(150 , 20);
		die2 = new DicePanel(150 , 20);
		die1.setValue(0);
		die2.setValue(0);
		centerPanel.add(die1);
		centerPanel.add(die2);
		this.add(centerPanel, BorderLayout.CENTER );
	}

}
