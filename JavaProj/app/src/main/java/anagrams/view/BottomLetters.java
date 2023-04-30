package anagrams.view;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import anagrams.*;
import anagrams.model.*;
import anagrams.GameObserver;
import anagrams.LettersSubjectInterface;

public class BottomLetters extends JPanel implements GameObserver
{
	//buttons contains button objects which represent letters
	public static ArrayList<JButton> buttons = new ArrayList<JButton>();
	int index = 5;
	TopLetters topLetters;
	LettersSubjectInterface subject;
	ActionListener buttonClicked;
	
	public BottomLetters(TopLetters top, LettersSubjectInterface subject, ActionListener buttonClicked)
	{
		//Define the observer subject and register this to it
		this.subject = subject;
		this.subject.register(this);
		this.updateButtons(this.subject.getButtons());
		
		//Set up a panel for the bottom buttons (enabled)
		this.topLetters = top;
		this.setOpaque(false);
		this.setBounds(0, 200, 500, 100);
		
		for (JButton button : buttons)
		{
			button.addActionListener(buttonClicked);
			this.add(button);
		}
	}
	
	//Removes all old buttons and re-adds them from the buttons list
	public void refresh()
	{
		this.removeAll();
		for (JButton button : buttons){
			this.add(button);
		}
		this.repaint();
		
	}
	@Override
	public void updateButtons(ArrayList<JButton> buttons)
	{
		this.buttons = buttons;
	}
	//To update this observer
	//Called in model.BottomLetterViewModel.notifyObservers()
	//Should take view.BottomLetterViewModel.buttons and copy it to this buttons
	@Override
	public void update()
	{
		this.refresh();
	}
	public void updateScore(int score, String highScore){}// useless apart of GameObserver -- work on removing

}
