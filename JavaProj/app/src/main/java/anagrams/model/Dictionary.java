package anagrams.model;

import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Dictionary 
{
   private String fileName;
   HashMap<String, Integer> words;
   File dictionary;

   public Dictionary() throws IOException
   {
      this.fileName = "dictionary.txt";
      words = new HashMap<String, Integer>();
      
      //read the words from the file
      this.dictionary = new File(fileName);
      Scanner scanner = new Scanner(this.dictionary);
      String nextWord = "";
      while (scanner.hasNextLine())
      {
		 int score = 0;
         nextWord = scanner.nextLine();
         switch(nextWord.length()){
			 case 6:
				score = 2000;
				break;
			 case 5:
				score = 1200;
				break;
			 case 4:
				score = 800;
				break;
			 case 3:
			    score = 400;
			    break;
			 default:
				score = 0;
				break; 
		 }
         words.put(nextWord, score);
      }
   }
   
   
   public int checkWord(String word){
	   int score = words.get(word);
	   words.remove(word);
	   return score;
   }


}
