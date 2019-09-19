package ui;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.NarutoGame;
import model.GameCharacter;
import model.Technique;

/**
*<b>Description:</b> The class Menu in the package ui.<br>
*@author Johan Giraldo.
*/

public class Menu {
	
//Attributes
	
	private Scanner scanner;
	private NarutoGame game;
	private GameCharacter actualCharacter;
	private Technique actualTechnique;
	
//Constructor
	
	/**
	*<b>Description:</b> The constructor of the class Menu.<br>
	*<b>Post:</b> All attributes of the class are initialized.<br>
	*/
	
	public Menu() {
		
		scanner = new Scanner(System.in);
		game = new NarutoGame();
		game.loadClans();
		actualCharacter = null;
		actualTechnique = null;
	}
	
//Methods
	
	public void SystemMenu() {
		
		boolean running = true;
		int choice = 0;
		
		while(running) {
			
			choice = systemOptionMenu();
			
			switch(choice) {
			
			case 1:
				
				
				
				break;
				
			case 2:
				
				registerClanMenu();
				game.saveClans();
				
				break;
				
			case 5:
				
				running = false;
			
			}
		}
	}
	
	public int systemOptionMenu(){

		boolean running = true;
		int choice = 0;

		while(running){

			System.out.println("1. Enter a clan");
			System.out.println("2. Create a clan");
			System.out.println("3. Delete a clan");
			System.out.println("4. Show clans");
			System.out.println("5. Exit");
						
			try{

				choice = scanner.nextInt();
				scanner.nextLine();
			}
			catch(InputMismatchException e){

				scanner.next();
			}

			if(choice > 0 && choice < 6){

				running = false;
			}
			else{
				
				System.out.println("Please enter a correct value\n");
			}
		}

		return choice;
	}
	
	public void registerClanMenu(){

		String name;

		System.out.println("Please enter the clan's name");
		name = scanner.nextLine();
		
		if(game.addClan(name)) {
			
			System.out.println("The clan was added successfully!\n");
		}
		else {
			
			System.out.println("A clan with that name already exist, please try again!\n");
		}
	}
}
