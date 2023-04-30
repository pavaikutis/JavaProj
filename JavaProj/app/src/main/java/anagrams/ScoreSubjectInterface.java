package anagrams;

import java.util.*;
import javax.swing.*;
import anagrams.*;

public interface ScoreSubjectInterface
{   
   public void register(ScoreObserver observer);

   public void unregister(ScoreObserver observer);

   public void notifyObservers();
   
   public void startTimer();
}
