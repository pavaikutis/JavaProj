package anagrams.model;

import anagrams.*;
import anagrams.GameObserver;
import anagrams.ScoreSubjectInterface;
import anagrams.view.BlankButton;
import anagrams.view.AnagramButton;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.Timer;

public class ScorePanelViewModel implements ActionListener, ScoreSubjectInterface
{
	protected List<ScoreObserver> observers;
	public int score = 0;
	protected HighScore highScore;
	protected Timer timer;
	GameTimer gameTimer = new GameTimer();

	public ScorePanelViewModel()
	{
		this.observers = new ArrayList<ScoreObserver>();
		try{
			this.highScore = new HighScore();
		}
		catch(IOException e){
			System.out.println("Error in reading HighScore.txt");
			e.printStackTrace();
		}
		
		this.timer = new Timer(1000, this);
	}
	
	public void updateScore(int score){
		this.score += score;
	}
	
	public void startTimer()
	{
		this.timer.start();
	}
	
	public void endGame()
	{
		for (ScoreObserver observer : observers){
			observer.endGame();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		gameTimer.updateTime();
		this.notifyObservers();
		if(gameTimer.getTime() == 0){
			this.endGame();
			this.timer.stop();
		}
	}	
		
	@Override
	public void register(ScoreObserver observer){
		this.observers.add(observer);
    }
	
	@Override
    public void unregister(ScoreObserver observer){
		this.observers.remove(observer);
    }
	@Override
	public void notifyObservers()
	{
		for (ScoreObserver observer : observers){
			
			int i = Integer.parseInt(this.highScore.getHighScore());
			if (score > i)
			{
				highScore.setHighScore(score);
				highScore.writeHighScore();
			}
			
			observer.updateScore(this.score, this.highScore.getHighScore(), gameTimer.getTime());			
	    }
	}
}
