package anagrams.model;

import anagrams.*;
import anagrams.GameObserver;
import anagrams.LettersSubjectInterface;
import anagrams.view.AnagramButton;
import java.util.*;
import javax.swing.*;

public class BottomLetterViewModel implements LettersSubjectInterface
{
	//Store list of observers (there will only be view.BottomLetters
	protected ArrayList<GameObserver> observers;
    
    //Create an ArrayList of buttons
    //This will be communicated to view.BottomLetters
    public static ArrayList<JButton> buttons;
	public int index = 5;
	private static TopLetterViewModel topLetterViewModel = null;
    
    public BottomLetterViewModel(TopLetterViewModel top)
	{
		this.observers = new ArrayList<GameObserver>();
		this.buttons = new ArrayList<JButton>();
		//Set up a panel for the bottom buttons (enabled)

		this.topLetterViewModel = top;
	}
	
	public void importLetters(Difficulty difficulty)
	{
		for (int i = 0; i < 6; i++)
		{
			AnagramButton button = new AnagramButton(String.valueOf(difficulty.getLetterAt(i)));
			buttons.add(button);
		}
	}
	
	
	//Imported from view.BottomLetters
	public void setLetter(JButton button){
		this.buttons.add(button);
		index++;
	}
	
	//Imported from view.BottomLetters
	public void remove(JButton button)
	{
		this.buttons.remove(button);
		this.notifyObservers();
	}
	
	public ArrayList<JButton> getButtons()
	{
		return buttons;
	} 
    
    //Next three are for observers
    @Override
    public void register(GameObserver observer){
		this.observers.add(observer);
    }
	
	@Override
    public void unregister(GameObserver observer){
		this.observers.remove(observer);
    }
	
	@Override
	public void notifyObservers(){
		for (GameObserver observer : observers){
			observer.updateButtons(this.buttons);
			observer.update();
		}
		topLetterViewModel.notifyObservers();
	}
	
	public void instantiateObservers(){
		for (GameObserver observer : observers){
			observer.updateButtons(this.buttons);
			observer.update();
		}
		topLetterViewModel.notifyObservers();
	}
}
