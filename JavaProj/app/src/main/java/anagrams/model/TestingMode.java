package anagrams.model;

import java.util.Random;
import java.util.ArrayList;


public class TestingMode implements Difficulty
{
	private ArrayList<Character> letters = new ArrayList<Character>();
	
	public TestingMode()
	{
		for (int i = 65; i < 71; i++)
		{
			char c = (char)i;
			letters.add(c);
		}
	}
	
	@Override
	public char getLetterAt(int pos)
	{
		return this.letters.get(pos);
	}
}
