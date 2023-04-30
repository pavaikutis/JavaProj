package anagrams.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import anagrams.model.*;
import anagrams.controller.GameController;

public class DifficultySelectionPanel extends JPanel
{
	GameController controller;
	protected Difficulty difficulty;
	JPanel panel;
	JFrame frame;
	JLabel prompt;
	JButton easy;
	JButton hard;
	ActionListener buttonClicked;

	public DifficultySelectionPanel(ActionListener buttonClicked)
	{		
		//Declare purple backgrond color
		Color backgroundColor = new Color(126, 103, 143);
		
		this.setBackground(backgroundColor);
		this.setOpaque(true);
		this.setBounds(0, 25, 516, 335);
		
		this.prompt = new JLabel("Please select a difficulty: ", SwingConstants.CENTER);
		this.prompt.setFont(new Font("Default", Font.BOLD, 32));
		this.prompt.setPreferredSize(new Dimension(516, 100));
		this.add(prompt);
		
		this.easy = new JButton("Easy");
		this.easy.setFont(new Font("Default", Font.BOLD, 24));
		this.easy.setBackground(new Color(204,197,163));
		this.hard = new JButton("Hard");
		this.hard.setFont(new Font("Default", Font.BOLD, 24));
		this.hard.setBackground(new Color(204,197,163));
		this.easy.setPreferredSize(new Dimension(100, 100));
		this.hard.setPreferredSize(new Dimension(100, 100));
		this.easy.addActionListener(buttonClicked);
		this.hard.addActionListener(buttonClicked);
      
		this.add(easy);
		this.add(hard);
		this.setAlignmentY(Component.CENTER_ALIGNMENT);
	}
	
	private void showGameBoard()
	{
		this.controller.startGame(this.difficulty);
	}
	
	


}
