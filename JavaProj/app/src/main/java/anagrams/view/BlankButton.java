package anagrams.view;

import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;


public class BlankButton extends JButton
{
	//Blank button to be utilized by TopLetters
   public BlankButton()
   {
      super();
      this.setPreferredSize(new Dimension(75, 75));
	  this.setEnabled(false);
      
   }
   
}
