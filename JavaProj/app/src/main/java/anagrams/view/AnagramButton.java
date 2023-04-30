package anagrams.view;

import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;


public class AnagramButton extends JButton
{
	//letter is what letter the button will show
   protected char letter;

	//To be used by TopLetters and BottomLetters
   public AnagramButton(String text)
   {
      super(text);
      this.letter = text.charAt(0);
      this.setPreferredSize(new Dimension(75, 75));
	  this.setFont(new Font("Default", Font.BOLD, 32));
	  this.setBackground(new Color(204,197,163));
	  this.setForeground(Color.BLACK);
	  this.setOpaque(true);
	  this.setBorderPainted(false);
   }
   
   //return the button's letter
   public int getLetter(){return this.letter;}
}
