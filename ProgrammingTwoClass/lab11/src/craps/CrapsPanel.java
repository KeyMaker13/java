package craps;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;


public class CrapsPanel extends JPanel {
	private int numRolls = 0;
	private int numWins = 0;
	private JLabel lblRolls;
	private JLabel lblWins;
	private DicePanel die1;
	private DicePanel die2;
	private int val1, val2;
	private JButton btnRoll, btnClear;
	Random rnd = new Random();
	Panel centerPanel = new Panel();
	Panel northPanel = new Panel();
	Panel southPanel = new Panel();
	
	
	/**
	 * Inner classes for action listeners
	 */
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {	
			
			if (event.getSource() == btnRoll) {
		
			numRolls ++;
			System.out.println("You have clicked ROLL.You now have" + numRolls);
			
			val1 = rnd.nextInt(6) + 1;
			 val2 = rnd.nextInt(6) + 1;
			
			
			if 	(val1 + val2 == 7 || val1+val2 == 11)
				numWins++;
			lblRolls.setText("Rolls: " + numRolls);
			lblWins.setText("Wins: " + numWins);
			rnd = new Random();
			
			
			
			centerPanel.removeAll();
			die1 = new DicePanel(150 , 20);
			die2 = new DicePanel(150 , 20);
			 
			 die1.setValue(val1);
			die2.setValue(val2);
			centerPanel.add(die1);
			centerPanel.add(die2);
			centerPanel.repaint();
			
		
				 
			}
			
			if (event.getSource() == btnClear){
				System.out.println("You have clicked CLEAR.");
				lblRolls.setText("Rolls: 0");
				lblWins.setText("Wins: 0");
				
				numRolls = 0;
				numWins = 0;
				
				repaint();
			}
			
		}
	}
	
	public CrapsPanel(){
		this.setSize(150,150);
		setLayout( new BorderLayout(4,4));
		
		//create north panel
		
		northPanel.setLayout(new GridLayout(1,2));
		//add the ROLLS and WINS  labels
		lblRolls = new JLabel("Rolls: 0");
		northPanel.add(lblRolls);
		lblWins = new JLabel("Wins: 0");
		northPanel.add(lblWins);
		this.add(northPanel, BorderLayout.NORTH );
		
		//south panel
	
		southPanel.setLayout(new GridLayout(1,2));
		 btnRoll = new JButton("Roll");
		//handling event and responsible for it
		btnRoll.addActionListener( new ButtonListener() );
		southPanel.add(btnRoll);
		 btnClear = new JButton("Clear");
		btnClear.addActionListener(new ButtonListener() );
		southPanel.add(btnClear);
		this.add(southPanel, BorderLayout.SOUTH );
		
		//center panel

		centerPanel.setLayout(new GridLayout(1,2));
		//dice 
	    die1 = new DicePanel(150 , 20);
		die2 = new DicePanel(150 , 20);
		die1.setValue(1);
		die2.setValue(1);
		centerPanel.add(die1);
		centerPanel.add(die2);
		
		
		this.add(centerPanel, BorderLayout.CENTER );
	}

}
