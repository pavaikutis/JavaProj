package anagrams;

import anagrams.model.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class BottomLettersTests {
	@Test public void TestConstructor()
    {
		Difficulty diff = new TestingMode();
		TopLetterViewModel top = new TopLetterViewModel();
		BottomLetterViewModel bottom = new BottomLetterViewModel(top);
		
		assertNotNull(bottom);
    }

	

}
