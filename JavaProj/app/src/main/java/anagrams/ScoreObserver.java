package anagrams;

import java.util.*;
import javax.swing.*;

public interface ScoreObserver
{
	   public void updateScore(int score, String highScore, int time);
	   public void endGame();
}
