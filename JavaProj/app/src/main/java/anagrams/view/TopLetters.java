package anagrams.view;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import anagrams.*;
import anagrams.model.*;


public class TopLetters extends JPanel implements GameObserver
{
	public static ArrayList<JButton> buttons = new ArrayList<JButton>();
	String potentialWord;
	LettersSubjectInterface subject;
	int index = 0;
	ActionListener buttonClicked;

	public TopLetters(LettersSubjectInterface subject, ActionListener buttonClicked)
	{
		//Define subject and register the observer to it
		this.subject = subject;
		this.subject.register(this);
		this.updateButtons(this.subject.getButtons());
		this.update();
		//Set up a panel for the word
		this.setOpaque(false);
		this.setBounds(0, 100, 500, 100);
		this.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
	}
	
	public void setLetter(String letter){
		AnagramButton button = new AnagramButton(letter);
		button.addActionListener(buttonClicked);
		this.buttons.set(this.index, button);
		this.refresh();
		index++;
	}
	
	private void refresh(){
		this.removeAll();
		for (JButton button : buttons){
			this.add(button, BorderLayout.CENTER);
			button.addActionListener(buttonClicked);
		}
	}
	
	public String getPotentialWord(){
		this.potentialWord = "";
		for (JButton button : buttons){
			this.potentialWord = this.potentialWord + button.getText();
		}
		return this.potentialWord;
	}
	@Override
	public void updateButtons(ArrayList<JButton> buttons)
	{
		this.buttons = buttons;
	}
	//To update this observer
	//Called in model.TopLetterViewModel.notifyObservers()
	//Should take view.TopLetterViewModel.buttons and copy it to this buttons
	@Override
	public void update()
	{
		this.refresh();
	}
	public void updateScore(int score, String highScore){}// useless apart of GameObserver -- work on removing
}
