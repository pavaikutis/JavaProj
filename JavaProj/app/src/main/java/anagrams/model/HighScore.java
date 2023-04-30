package anagrams.model;

import java.io.*;
import java.util.Scanner;

public class HighScore
{
	String highScore;
	
	public HighScore() throws IOException
	{
		File file = new File("HighScore.txt");
		Scanner scanner = new Scanner(file);
		
		this.highScore = scanner.nextLine();		
	}
	
	public String getHighScore()
	{
		return this.highScore;
	}
	
	public void setHighScore(int score)
	{
		Integer i = score;
		this.highScore = i.toString();
	}
	
	public void writeHighScore()
	{
		try
		{
			File newScoreFile = new File("HighScore.txt");
			FileWriter myWriter = new FileWriter("HighScore.txt");
			myWriter.write(this.highScore);
			myWriter.close();
		}
		catch(IOException e)
		{
			System.out.println("An error occured in saving the high score");
			e.printStackTrace();
		}
		
	}

}
