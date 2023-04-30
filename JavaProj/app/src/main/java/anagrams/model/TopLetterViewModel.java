package anagrams.model;

import anagrams.*;
import anagrams.GameObserver;
import anagrams.LettersSubjectInterface;
import anagrams.view.BlankButton;
import anagrams.view.AnagramButton;
import java.util.*;
import javax.swing.*;

public class TopLetterViewModel implements LettersSubjectInterface
{
	//Create list for observers
	//Should only add view.TopLetters
	protected List<GameObserver> observers;
   
    //Create an ArrayList of buttons
   	public static ArrayList<JButton> buttons;
	BottomLetterViewModel bottomLetterViewModel;
	String potentialWord;
	public int index = 0;
	
	//Constructor taken from view.TopLetters
	public TopLetterViewModel()
	{
		this.observers = new ArrayList<GameObserver>();
		this.buttons = new ArrayList<JButton>();
		for (int i = 0; i < 6; i++)
		{
			BlankButton button = new BlankButton();
			buttons.add(button);
		}
	}
	
	//Next 4 methods taken from view.TopLetters
	public void setLetter(JButton button){
		this.buttons.set(this.index, button);
		index++;
	}
	
	public void resetLetters(){
		for (int i = 0; i < index; i++){
			bottomLetterViewModel.setLetter(this.buttons.get(i));
		}
		this.buttons.clear();
		for (int i = 0; i < 6; i++){
			BlankButton button = new BlankButton();
			buttons.add(button);
		}
		this.index = 0;
		notifyObservers();
		bottomLetterViewModel.notifyObservers();
	}
	
	public String getPotentialWord(){
		this.potentialWord = "";
		for (JButton button : buttons){
			this.potentialWord = this.potentialWord + button.getText();
		}
		return this.potentialWord;
	}
	
	public void connectModel(BottomLetterViewModel bottomLetters){
		this.bottomLetterViewModel = bottomLetters;
	}
	
	public int getIndex(){
		return this.index;
	}
	
	public ArrayList<JButton> getButtons()
	{
		return buttons;
	}
	
	//Next 3 for observers
	@Override
	public void register(GameObserver observer){
		this.observers.add(observer);
    }
	
	@Override
    public void unregister(GameObserver observer){
		this.observers.remove(observer);
    }
    
    //Pass in this.buttons into observer.update
	@Override
    public void notifyObservers(){
		for (GameObserver observer : observers){
			observer.updateButtons(this.buttons);
			observer.update();
	    }
    }
}
