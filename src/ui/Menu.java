package ui;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.NarutoGame;
import model.Clan;
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
	private Clan currentClan;
	private GameCharacter currentCharacter;
	
//Constructor
	
	/**
	*<b>Description:</b> The constructor of the class Menu.<br>
	*<b>Post:</b> All attributes of the class are initialized.<br>
	*/
	
	public Menu() {
		
		scanner = new Scanner(System.in);
		game = new NarutoGame();
		game.loadClans();
		currentClan = null;
		currentCharacter = null;
	}
	
//Methods
	
	public void systemMenu() {
		
		boolean running = true;
		int choice = 0;
		
		while(running) {
			
			choice = systemOptionMenu();
			
			switch(choice) {
			
			case 1:
				
				enterInAClanMenu();
				
				break;
				
			case 2:
				
				registerClanMenu();
				
				break;
				
			case 3:
				
				deleteClanMenu();
				
				break;
				
			case 4:
				
				System.out.println(game.printClans());
				
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
			
			game.saveClans();
			System.out.println("The clan was added successfully!\n");
		}
		else {
			
			System.out.println("A clan with that name already exist, please try again!\n");
		}
	}
	
	public void deleteClanMenu() {
		
		String name;

		System.out.println("Please enter the clan's name");
		name = scanner.nextLine();
		
		if(game.deleteClan(name)) {
			
			game.saveClans();
			System.out.println("The clan was deleted successfully!\n");
		}
		else {
			
			System.out.println("A clan with that name doesn't exist, please try again!\n");
		}
	}
	
	public void enterInAClanMenu() {
		
		String name;

		System.out.println("Please enter the name of the clan do you wish to enter");
		name = scanner.nextLine();
		
		if((currentClan = game.getClan(name)) != null) {
			
			clanMenu();
		}
		else {
			
			System.out.println("A clan with that name doesn't exist, please try again!\n");
		}
		
	}
	
	public void clanMenu() {
		
		boolean running = true;
		int choice = 0;
		
		while(running) {
			
			choice = clanOptionMenu();
			
			switch(choice) {
			
			case 1:
				
				registerCharacterMenu();
				
				break;
				
			case 2:
				
				
				
				break;
				
			case 3:
				
				
				
				break;
				
			case 4:
				
				
				break;
				
			case 5:
				
				running = false;
			
			}
		}
	}
	
	public int clanOptionMenu(){

		boolean running = true;
		int choice = 0;

		while(running){
			
			System.out.println("You are in the clan " + currentClan.getName() + "\n");
			System.out.println("1. Enter a character");
			System.out.println("2. Create a character");
			System.out.println("3. Delete a character");
			System.out.println("4. Show characters");
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
	
	public void registerCharacterMenu() {
		
		String name, personality, creationDate;
		int powerLevel, day, month, year;
		
		System.out.println("Please enter the character's name");
		name = scanner.nextLine();
		
		System.out.println("Please enter the character's personality");
		personality = scanner.nextLine();
		
		System.out.println("Please enter the character's creation day (A number between 1 and 31)");
		day = validateInt(1, 31);	

		System.out.println("Please enter the character's creation month (A number between 1 and 12)");
		month = validateInt(1, 12);

		System.out.println("Please enter the character's creation year (Example: 2015)");
		year = validateInt(1999, 2025);
		
		creationDate = day + "/" + month + "/" + year;
		
		System.out.println("Please enter the character's power level");
		powerLevel = validateInt(0, 999999);
		
		if(currentClan.addCharacter(name, personality, creationDate, powerLevel)) {
			
			System.out.println("The character was added successfully\n");
		}
		else {
			
			System.out.println("A character with that name already exist, please try again\n");
		}
		
	}
	
	public int validateInt(int minimum, int max){
		
		boolean running = true;
		int num = 0;
		
		while(running){
			
			try{

				num = scanner.nextInt();
				scanner.nextLine();
			}
			catch(InputMismatchException e){
				
				scanner.next();
			}
			
			if(num >= minimum && num <= max){
				
				running = false;
				
			}
			else{
				
				System.out.print("Invalid number, please try again\n");
				
			}
		}
		
		return num;
	}
}
