package ui;
import java.util.Scanner;
import model.NarutoGame;

/**
*<b>Description:</b> The class Menu in the package ui.<br>
*@author Johan Giraldo.
*/

public class Menu {
	
//Attributes
	
	private Scanner scanner;
	private NarutoGame game;
	
//Constructor
	
	/**
	*<b>Description:</b> The constructor of the class Menu.<br>
	*<b>Post:</b> All attributes of the class are initialized.<br>
	*/
	
	public Menu() {
		
		scanner = new Scanner(System.in);
		game = new NarutoGame();
	}
	
//Methods

}
