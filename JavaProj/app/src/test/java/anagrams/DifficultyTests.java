package anagrams;

import anagrams.model.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class DifficultyTests {
    @Test public void TestHardLength()
    {
		Difficulty diff = new HardMode();
		String letters = new String("");
		boolean check = false;
		
		for(int i = 0; i < 6; i++)
		{
			letters += diff.getLetterAt(i);
		}
		
		if(letters.length() == 6)
		{
			check = true;
		}
		assertTrue(check);
	}
    
	@Test public void TestEasyLength()
    {
		Difficulty diff = new EasyMode();
		String letters = new String("");
		boolean check = false;
		
		for(int i = 0; i < 6; i++)
		{
			letters += diff.getLetterAt(i);
		}
		
		if(letters.length() == 6)
		{
			check = true;
		}
		assertTrue(check);
	}
    
    
    @Test public void EasyModeTestRandom()
    {
		Difficulty diff = new EasyMode();
		String letters = new String("");
		boolean check = false;
		
		ArrayList<String> words = new ArrayList<String>();
		words.add("NMETLA");
		words.add("SSPREA");
		words.add("ESTRAL");
		words.add("AELSTS");
		words.add("AEINST");
		
		for(int i = 0; i < 6; i++)
		{
			letters += diff.getLetterAt(i);
		}
		
		for (String str : words)
		{
			if(str.equals(letters))
			{
				check = true;
			}
		}
		assertTrue(check);
	}
	
	@Test public void HardModeTestRandom()
    {
		Difficulty diff = new HardMode();
		String letters = new String("");
		boolean check = false;
		
		ArrayList<String> words = new ArrayList<String>();
		words.add("NMETLA");
		words.add("SSPREA");
		words.add("ESTRAL");
		words.add("AELSTS");
		words.add("AEINST");
		
		for(int i = 0; i < 6; i++)
		{
			letters += diff.getLetterAt(i);
		}
		
		for (String str : words)
		{
			if(str.equals(letters))
			{
				check = true;
			}
		}
		assertFalse(check);
	}
	
	@Test public void TestingModeTestOutput()
    {
		Difficulty diff = new HardMode();
		String letters = new String("");
		boolean check = false;
		
		ArrayList<String> words = new ArrayList<String>();
		words.add("ABCDEF");
		
		for(int i = 0; i < 6; i++)
		{
			letters += diff.getLetterAt(i);
		}
		
		for (String str : words)
		{
			if(str.equals(letters))
			{
				check = true;
			}
		}
		assertFalse(check);
	}
    
    
}
		
