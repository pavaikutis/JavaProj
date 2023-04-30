package anagrams.model;

import java.util.Random;
import java.util.ArrayList;


public class EasyMode implements Difficulty
{
	private ArrayList<Character> letters = new ArrayList<Character>();
	public EasyMode()
	{
		ArrayList<String> words = new ArrayList<String>();
		words.add("NMETLA");
		words.add("SSPREA");
		words.add("ESTRAL");
		words.add("AELSTS");
		words.add("AEINST");
		
		//pick random starting word
		Random rand = new Random();
		int num = rand.nextInt(0, 4);
		String chars = new String(words.get(num));
		for(int i = 0; i < 6; i++)
		{
			this.letters.add(chars.charAt(i));
			
		}
	}
	
	@Override
	public char getLetterAt(int pos)
	{
		return this.letters.get(pos);
	}
	
}
