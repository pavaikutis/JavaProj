package anagrams;

import java.awt.*;

import javax.swing.*;

public class AhAhAhFrame extends JFrame{
	
	AhAhAhPanel panel;
	
	public AhAhAhFrame(){
		
		panel = new AhAhAhPanel();
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}  
}
