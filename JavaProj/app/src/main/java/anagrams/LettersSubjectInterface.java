package anagrams;

import java.util.*;
import javax.swing.*;
import anagrams.*;

public interface LettersSubjectInterface
{
   public ArrayList<JButton> getButtons();
   
   public void register(GameObserver observer);

   public void unregister(GameObserver observer);

   public void notifyObservers();
}
