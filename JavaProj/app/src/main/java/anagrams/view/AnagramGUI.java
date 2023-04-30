package anagrams.view;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;

import anagrams.controller.*;

public class AnagramGUI implements ActionListener
{	
	JFrame frame;
	GameController controller;
	
	BottomLetters bottomButtons;
	TopLetters topButtons;	
	EnterPanel enterPanel;
	ScorePanel scorePanel;
	DifficultySelectionPanel difficultySelect;

	//Contstructor takes in the controller that instantiates it for communication
    public AnagramGUI(GameController controller)
    {	  		
		this.controller = controller;
		
		//Declare purple backgrond color
		Color backgroundColor = new Color(126, 103, 143);
		
	    //Setting up the frame
		this.frame = new JFrame("Word Game");
		this.frame.getContentPane().setBackground(backgroundColor);
		this.frame.setSize(516, 285 + 50);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLayout(null);
		
		
		//Set up a panel for the top buttons (disabled) // NOT IN AN ARRAYLIST YET
		//Pass in the TopLettersViewModel and this (for actionlistener)
		this.topButtons = new TopLetters(this.controller.getTopLetters(), this);
		//this.bottombuttons = new BottomLetters(topbuttons, this.controller.getBottomLetters(), this);
		this.enterPanel = new EnterPanel(this.controller.getTopLetters(), this);
		this.scorePanel = new ScorePanel(enterPanel, this.controller.getScorePanel(), this);
		this.difficultySelect = new DifficultySelectionPanel(this);
		
		this.frame.add(scorePanel);
		this.frame.add(topButtons);
		this.frame.add(enterPanel);
		//this.frame.add(bottombuttons);
		this.frame.add(difficultySelect);
		
		this.topButtons.setVisible(false);
		this.enterPanel.setVisible(false);
		this.scorePanel.setVisible(false);
		this.frame.setVisible(true);
	}
	
	public void showGUI()
	{
		this.topButtons.setVisible(true);
		this.enterPanel.setVisible(true);
		this.scorePanel.setVisible(true);
		this.difficultySelect.setVisible(false);

		this.scorePanel.startTimer();
		
		this.bottomButtons = new BottomLetters(topButtons, this.controller.getBottomLetters(), this);
		this.frame.add(bottomButtons);
		this.frame.repaint();
	}
	
	public void hideGUI()
	{
		this.topButtons.setVisible(false);
		this.bottomButtons.setVisible(false);
		this.enterPanel.setVisible(false);
		//this.scorePanel.setVisible(false);
		this.frame.repaint();
	}
	
	//Method to determine if a button is in view.BottomButtons
	//Used in GameController.buttonSelected to determine where the click came from
	//Done this way to get buttons to work
	public boolean isInBottom(JButton button)
	{
		if (bottomButtons.buttons.contains(button))
		{ return true; }
		else { return false; }
	}

	//Same as before, but with top buttons
	public boolean isInTop(JButton button)
	{
		if (topButtons.buttons.contains(button))
		{ return true; }
		else { return false; }
	}
	
	//The actoinPerformed that is actually supposed to function
	//Gets the button that is clicked
	//Passes it to controller.buttonSelected
	//Repaints top and bottom buttons
	@Override
	public void actionPerformed(ActionEvent event)
    {
		JButton button = (JButton)event.getSource();
		this.controller.buttonSelected(button);
		this.bottomButtons.repaint();
		this.topButtons.repaint();
		this.frame.repaint();
	}
}

