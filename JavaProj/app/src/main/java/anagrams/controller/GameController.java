package anagrams.controller;

import anagrams.ControllerInterface;
import anagrams.view.*;
import anagrams.model.*;
import javax.swing.*;

public class GameController implements ControllerInterface
{
	DifficultySelectionPanel difficultySelect;
	AnagramGUI gui;
	Model model;
	
	//Instantiating the controller by passing in the model
	public GameController(Model model)
	{
		this.model = model;
		this.gui = new AnagramGUI(this);
		this.model.notifyObservers();
	}
	
	public void startGame(Difficulty difficulty)
	{
		model.setDifficulty(difficulty);
		this.gui.showGUI();
	}
	
	//returns model's topLetters when asked
	//Used to register observers
	public TopLetterViewModel getTopLetters()
	{
		return this.model.getTopLetters();
	}
	
	//returns model's bottomLetters when asked
	//Used to register observers
	public BottomLetterViewModel getBottomLetters()
	{
		return this.model.getBottomLetters();
	}
	
	public ScorePanelViewModel getScorePanel()
	{
		return this.model.getScorePanel();
	}
	
	//Performs an model's method when a button is passed into it
	//Used to get information from button clicks
	//Function is determined by determing if its text is 'Enter'
	//or if the button passed in belongs to model's bottom or top letters
	public void buttonSelected(JButton button)
	{
		if (button.getText().equals("Enter"))
		{
			this.model.clickEnter();
		}
		else if (gui.isInBottom(button))
		{
			this.model.clickBottomLetter(button);
		}
		else if (gui.isInTop(button))
		{
			this.model.clickTopLetter();
		}
		else if (button.getText().equals("Easy"))
		{
			System.out.println("Easy Mode Selected");
			Difficulty difficulty = new EasyMode();
			this.startGame(difficulty);
		}
		else if (button.getText().equals("Hard"))
		{
			System.out.println("Hard Mode Selected");
			Difficulty difficulty = new HardMode();
			this.startGame(difficulty);
		}
	}
}
