package anagrams.model;

import java.util.Random;
import java.util.ArrayList;


public class HardMode implements Difficulty
{
	private ArrayList<Character> randLetters = new ArrayList<Character>();
	
	public HardMode()
	{
		String chars = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		while(randLetters.size() < 6)
		{
			//generate random number between 0 and 25 (range of 26 letters
			Random rand = new Random();
			int num = rand.nextInt(0, chars.length()-1);
			//convert number to character, add character to arraylist
			this.randLetters.add(chars.charAt(num));
			
		}
	}
	
	@Override
	public char getLetterAt(int pos)
	{
		return this.randLetters.get(pos);
	}
	
}
