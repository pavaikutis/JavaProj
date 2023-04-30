package anagrams.model;

import java.io.*;
import javax.swing.*;
import anagrams.view.AnagramButton;
import anagrams.view.BlankButton;
import anagrams.AhAhAhFrame;
import anagrams.AhAhAhPanel;

public class Model
{
	public Dictionary dictionary;
	public Difficulty difficulty;
	public GameTimer gameTimer;
	public TopLetterViewModel topLetters;
	public BottomLetterViewModel bottomLetters;
	public ScorePanelViewModel scorePanel;
	int score;
	
	public Model()
	{
		//Create a dictionary
		try{
			this.dictionary = new Dictionary();
		}
		catch(IOException e){
			System.out.println("Caught you!");
		}
		
		//Create words top and bottom logic sections
		//Also conect the two so they can communicate
		this.topLetters = new TopLetterViewModel();
		this.bottomLetters = new BottomLetterViewModel(this.topLetters);
		topLetters.connectModel(bottomLetters);
		this.scorePanel = new ScorePanelViewModel();
	}	
	
	public void setDifficulty(Difficulty difficulty)
	{
		this.difficulty = difficulty;
		this.bottomLetters.importLetters(this.difficulty);
		this.bottomLetters.notifyObservers();
	}
	
	//Method to get the Top and BottomLetterViewModel object
	//Used to set up observers in controller
	public TopLetterViewModel getTopLetters()
	{
		return topLetters;
	}
	
	public BottomLetterViewModel getBottomLetters()
	{
		return bottomLetters;
	}
	
	public ScorePanelViewModel getScorePanel()
	{
		return scorePanel;
	}
	
	//What should happen when you click a botttom letter
	//Used in GameController.buttonClicked
	public void clickBottomLetter(JButton button)
	{
		//Add a letter to the top
		this.topLetters.setLetter(button);
		//Remove it from the bottom
		this.bottomLetters.remove(button);
		this.bottomLetters.index--;
	}
	
	//What should happen when you click a top letter
	//LUsed in GameController.buttonClicked
	public void clickTopLetter()
	{
		BlankButton blankButton = new BlankButton();
		topLetters.index--;
		JButton button = topLetters.buttons.get(topLetters.index);
		bottomLetters.setLetter(button);
		this.topLetters.buttons.set(topLetters.index, blankButton);		
		
		bottomLetters.notifyObservers();
		topLetters.notifyObservers();
	}

	//What should happen when you click Enter
	//Logic taken from view.Enter.actionPerformed	
	public void clickEnter()
	{
		String word = topLetters.getPotentialWord();
		System.out.println(word);
		try{
			this.score = dictionary.checkWord(topLetters.getPotentialWord());
			scorePanel.updateScore(this.score);
			scorePanel.notifyObservers();

		}
		catch(NullPointerException e){
			AhAhAhFrame frame = new AhAhAhFrame();
			
		}
		topLetters.resetLetters();
	}
	
	public void notifyObservers()
	{
		this.bottomLetters.notifyObservers();
		this.topLetters.notifyObservers();
	}
	

}

