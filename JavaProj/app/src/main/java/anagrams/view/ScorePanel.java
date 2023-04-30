package anagrams.view;


import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import anagrams.model.*;
import anagrams.*;


public class ScorePanel extends JPanel implements ScoreObserver
	{
	public JLabel guessedWords = new JLabel();
	public JLabel highScoreLabel = new JLabel(); 
	public JLabel timerText = new JLabel();
	public JLabel word = new JLabel();
	public int score = 0;
	public int time = 60;
	public String highScore = "";
	AnagramGUI anagramGUI;
	
	private static EnterPanel enterPanel = null;
	ScoreSubjectInterface subject;
	
	public ScorePanel(EnterPanel enter, ScoreSubjectInterface subject, AnagramGUI anagramGUI)
	{
		this.enterPanel = enter;
		this.anagramGUI = anagramGUI;
		
		this.subject = subject;
		this.subject.register(this);
		
		//Set up a panel for the the Scores
		this.setOpaque(false);
		this.setBounds(0, 0, 500, 50);
		
		
		//Create and add score values
		guessedWords.setText("Current Score: " + this.score);
		guessedWords.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
		guessedWords.setFont(new Font("Default", Font.BOLD, 16));
		this.add(guessedWords);
		
		highScoreLabel.setText("High Score: " + highScore);
		highScoreLabel.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
		highScoreLabel.setFont(new Font("Default", Font.BOLD, 16));
		this.add(highScoreLabel);
		
		//Create and add timer
		timerText.setText("Seconds remaining: " + time);
		timerText.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
		timerText.setFont(new Font("Default", Font.BOLD, 16));
		this.add(timerText);
		
		this.subject.notifyObservers();
	}
	
	public void startTimer()
	{
		this.subject.startTimer();
	}
	
	public void refresh()
	{
			timerText.setText("Seconds remaining: " + time);
			guessedWords.setText("Current Score: " + this.score);
			highScoreLabel.setText("High Score: " + highScore);
			this.repaint();
			enterPanel.tryEnable();
		
	}
	public void addPoints(int pointsToAdd)
	{
		this.score = pointsToAdd;
	}
	
	public void endGame()
	{
		this.anagramGUI.hideGUI();
		this.timerText.setText("Game Over!");
		this.guessedWords.setText("Your Score: " + this.score);
		guessedWords.setFont(new Font("Default", Font.BOLD, 32));
		highScoreLabel.setFont(new Font("Default", Font.BOLD, 32));
		timerText.setFont(new Font("Default", Font.BOLD, 32));
		this.setBounds(0, 75, 500, 150);
		System.out.println("GAME OVER");
	}

	@Override
	public void updateScore(int score, String highScore, int time){
		this.addPoints(score);
		this.highScore = highScore;
		this.time = time;
		this.refresh();
	}
}
