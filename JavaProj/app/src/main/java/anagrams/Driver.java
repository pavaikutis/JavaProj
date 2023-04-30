package anagrams;

import anagrams.model.*;
import anagrams.controller.*;
import anagrams.view.*;

public class Driver{

public static void main(String []args)
	{
		//Instantiate model and controller
		Model model = new Model();
		GameController gameController = new GameController(model);	
	}
}
