package anagrams;

import java.util.*;
import javax.swing.*;

public interface GameObserver
{
   public void update();
   public void updateButtons(ArrayList<JButton> buttons);
}
