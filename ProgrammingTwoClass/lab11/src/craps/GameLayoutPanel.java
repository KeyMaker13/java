package craps;
import java.awt.*;
import java.util.Random;

import javax.swing.*;


public class GameLayoutPanel extends JPanel {
	private int numRolls = 0;
	private int numWins = 0;
	private JLabel lblRolls;
	private JLabel lblWins;
	private DicePanel die1;
	private DicePanel die2;
	
	private JButton btnRoll, btnClear;
	Random rnd = new Random();
	Panel centerPanel = new Panel();
	Panel northPanel = new Panel();
	Panel southPanel = new Panel();
	
	
	/**
	 * Inner classes for action listeners
	 */
	
	
	public GameLayoutPanel(){
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
		
		southPanel.add(btnRoll);
		 btnClear = new JButton("Clear");
	
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
