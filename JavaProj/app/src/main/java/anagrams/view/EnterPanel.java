package anagrams.view;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import anagrams.model.*;
import anagrams.AhAhAhFrame;
import anagrams.AhAhAhPanel;

public class EnterPanel extends JPanel
{
	JButton enterButton;
	private static TopLetterViewModel topbuttons = null;
	public Dictionary words;
	ActionListener buttonClicked;
	
	public EnterPanel(TopLetterViewModel top, ActionListener buttonClicked)
	{
		
		this.topbuttons = top;
		
		this.setOpaque(false);
		this.setBounds(0, 50, 500, 50);
		
		this.enterButton = new JButton("Enter");
		this.enterButton.setPreferredSize(new Dimension(350, 50));
		this.enterButton.setFont(new Font("Default", Font.BOLD, 32));
		this.enterButton.setVerticalAlignment(JLabel.CENTER);
		this.enterButton.setHorizontalAlignment(JLabel.CENTER);
		this.enterButton.setBackground(new Color(110,74,125));
		this.enterButton.setForeground(Color.BLACK);
		this.enterButton.setOpaque(true);
		this.enterButton.setBorderPainted(false);
		this.enterButton.setEnabled(false);
		
		this.enterButton.addActionListener(buttonClicked);
		this.add(enterButton);
	}
	
	public void tryEnable()
	{
		if (topbuttons.getIndex() > 2)
		{
			this.enterButton.setEnabled(true);
		}
		else{
			this.enterButton.setEnabled(false);
		}
	}
	
}
