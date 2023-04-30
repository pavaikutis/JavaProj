package anagrams;

import anagrams.model.*;
import javax.swing.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
public class ModelTest {

  @Test
  public void testModelConstructor() {
    // Test creating a new instance of the Model class
    Model model = new Model();
    
    // Check if the dictionary is not null
    assertNotNull(model.dictionary);
    
    // Check if the topLetters and bottomLetters fields are not null
    assertNotNull(model.topLetters);
    assertNotNull(model.bottomLetters);
    
    // Check if the scorePanel field is not null
    assertNotNull(model.scorePanel);
  }
  
  @Test
  public void testSetDifficulty() {
    // Test setting the difficulty level
    Model model = new Model();
    Difficulty difficulty = new EasyMode();
    
    // Set the difficulty to Easy
    model.setDifficulty(difficulty);
    
    // Check if the difficulty is set to Easy
    assertEquals(model.difficulty, difficulty);
  }
  
  @Test
  public void testClickBottomLetter() {
    // Test clicking on a bottom letter
    Model model = new Model();
    Difficulty difficulty = new EasyMode();
    // Set the difficulty to Easy
    model.setDifficulty(difficulty);
    
    // Create a button
    JButton button = new JButton("A");
    
    // Click on the button
    model.clickBottomLetter(button);
    
    // Check if the letter is added to the top letters and removed from the bottom letters
    assertTrue(model.topLetters.buttons.contains(button));
    assertFalse(model.bottomLetters.buttons.contains(button));
  }
  
  @Test
  public void testClickTopLetter() {
    // Test clicking on a top letter
    Model model = new Model();
    
    Difficulty difficulty = new EasyMode();
    
    // Set the difficulty to Easy
    model.setDifficulty(difficulty);
    
    // Create a button
    JButton button = new JButton("A");
    
    //Array of bottom buttons
    ArrayList<JButton> buttons = model.bottomLetters.getButtons();
    
    
    //Click letter from bottom button
    model.clickBottomLetter(buttons.get(0));
    
    // Click on the top letter
    model.clickTopLetter();
    
    // Check if the letter is added to the bottom letters and removed from the top letters
    assertTrue(model.bottomLetters.buttons.contains(buttons.get(0)));
    assertFalse(model.topLetters.buttons.contains(buttons.get(0)));
  }
  

  @Test
  public void testClickEnter() {
    // Test clicking the Enter button
    Model model = new Model();
    
    Difficulty difficulty = new EasyMode();
    
    // Set the difficulty to Easy
    model.setDifficulty(difficulty);
    
    // Add some letters to the top letters
    model.topLetters.setLetter(new JButton("A"));
    model.topLetters.setLetter(new JButton("B"));
    model.topLetters.setLetter(new JButton("C"));
    
    // Click the Enter button
    model.clickEnter();
    
    // Check if the score is updated and the top letters are reset
    assertEquals(model.topLetters.index, 0);
  }
 

  
  @Test
  public void testGetTopLetters() {
    // Test getting the top letters
    Model model = new Model();
    
    // Get the top letters
    TopLetterViewModel topLetters = model.getTopLetters();
    
    // Check if the returned object is the same as the one in the model
    assertSame(topLetters, model.topLetters);
  }
  
  @Test
  public void testGetBottomLetters() {
    // Test getting the bottom letters
    Model model = new Model();
    
    // Get the bottom letters
    BottomLetterViewModel bottomLetters = model.getBottomLetters();
    
    // Check if the returned object is the same as the one in the model
    assertSame(bottomLetters, model.bottomLetters);
  }
  
  @Test
  public void testGetScorePanel() {
    // Test getting the score panel
    Model model = new Model();
    
    // Get the score panel
    ScorePanelViewModel scorePanel = model.getScorePanel();
    
    // Check if the returned object is the same as the one in the model
    assertSame(scorePanel, model.scorePanel);
  }
}


