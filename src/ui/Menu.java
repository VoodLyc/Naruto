package ui;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.Name;

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
	private Technique currentTechnique;
	
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

			System.out.println("1. Enter in a clan");
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
				
				enterInACharacterMenu();
				
				break;
				
			case 2:
				
				registerCharacterMenu();
				
				break;
				
			case 3:
				
				deleteCharacterMenu();
				
				break;
				
			case 4:
				
				showCharactersMenu();
				
				break;
				
			case 5:
				
				updateClan();
				
				break;
				
			case 6:
				
				running = false;
				currentClan = null;
			
			}
		}
	}
	
	public int clanOptionMenu(){

		boolean running = true;
		int choice = 0;

		while(running){
			
			System.out.println("You are in the clan " + currentClan.getName() + "\n");
			System.out.println("1. Enter in a character");
			System.out.println("2. Create a character");
			System.out.println("3. Delete a character");
			System.out.println("4. Show characters");
			System.out.println("5. Update clan");
			System.out.println("6. Exit");
						
			try{

				choice = scanner.nextInt();
				scanner.nextLine();
			}
			catch(InputMismatchException e){

				scanner.next();
			}

			if(choice > 0 && choice < 7){

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
			game.saveClans();
		}
		else {
			
			System.out.println("A character with that name already exist, please try again\n");
		}
		
	}
	
	public void deleteCharacterMenu() {
		
		String name;
		
		System.out.println("Please, enter the character's name");
		name = scanner.nextLine();
		
		if(currentClan.deleteCharacter(name)) {
			
			System.out.println("The character was deleted successfully\n");
			game.saveClans();
		}
		else {
			
			System.out.println("A character with that name doesn't exist, please try again!\n");
		}
	}
	
	public void showCharactersMenu() {
		
		int choice;
		
		System.out.println("1. Sorted characters by the name");
		System.out.println("2. Sorted characters by the personality");
		System.out.println("3. Sorted characters by the power level");
		
		choice = validateInt(1, 3);
		
		System.out.println(currentClan.showCharacters(choice));
	}
	
	public void updateClan() {
		
		String name;
		
		System.out.println("Please enter the new clan's name");
		name = scanner.nextLine();
		
		currentClan.setName(name);
		game.saveClans();
	}
	
	public void enterInACharacterMenu() {
		
		System.out.println("Please enter the character's name");
		String name = scanner.nextLine();
		
		if((currentCharacter = currentClan.getCharacterByName(name)) != null) {
			
			characterMenu();
		}
		else {
			
			System.out.println("A character with that name doesn't exist, please try again\n");
		}
	}
	
	public void characterMenu() {
		
		boolean running = true;
		int choice = 0;
		
		while(running) {
			
			choice = characterOptionMenu();
			
			switch(choice) {
			
			case 1:
				
				enterInATechniqueMenu();
				
				break;
				
			case 2:
				
				registerTechniqueMenu();
				
				break;
				
			case 3:
				
				deleteTechnniqueMenu();
				
				break;
				
			case 4:
				
				System.out.println(currentCharacter.showTechniques() + "\n");
				
				break;
				
			case 5:
				
				updateCharacterMenu();
				
				break;
				
			case 6:
				
				running = false;
				currentCharacter = null;
			
			}
		}
	}
	
	public int characterOptionMenu(){

		boolean running = true;
		int choice = 0;

		while(running){
			
			System.out.println("You are in the character " + currentCharacter.getName() + "\n");
			System.out.println("1. Enter a technique");
			System.out.println("2. Create a technique");
			System.out.println("3. Delete a technique");
			System.out.println("4. Show techniques");
			System.out.println("5. Update character");
			System.out.println("6. Exit");
						
			try{

				choice = scanner.nextInt();
				scanner.nextLine();
			}
			catch(InputMismatchException e){

				scanner.next();
			}

			if(choice > 0 && choice < 7){

				running = false;
			}
			else{
				
				System.out.println("Please enter a correct value\n");
			}
		}

		return choice;
	}
	
	public void registerTechniqueMenu() {
		
		String name;
		double factor;
		
		System.out.println("Please enter the name of the technique");
		name = scanner.nextLine();
		
		System.out.println("Please enter the factor of the technique (a decimal number)");
		factor = validateDouble(0.0, 999.9);
		
		if(currentCharacter.addTechnique(name, factor)) {
			
			System.out.println("The technique was added successfully\n");
			game.saveClans();
		}
		else {
			
			System.out.println("A technique with that name already exist\n");
		}
	}
	
	public void deleteTechnniqueMenu() {
		
		String name;
		
		System.out.println("Please enter the name of the technique that do you want to delete");
		name = scanner.nextLine();
		
		if(currentCharacter.deleteTechnique(name)) {
			
			System.out.println("The technique was deleted successfully\n");
			game.saveClans();
		}
		else {
			
			System.out.println("A technique with that name doesn't exist, please try again\n");
		}
	}
	
	public void updateCharacterMenu() {
		
		String arg;
		int powerLevel, day, month, year;
		int choice = updateCharacterChoice();
		
		switch(choice) {
		
		case 1:
			
			System.out.println("Please enter the new name of the character");
			arg = scanner.nextLine();
			
			if(currentClan.updateCharacter(arg, currentCharacter)) {
				
				System.out.println("The name of the character was changed successfully\n");
				game.saveClans();
			}
			else {
				
				System.out.println("A character with that name already exist, please try again\n");
			}
			
			break;
			
		case 2:
			
			System.out.println("Please enter the new personality of the character");
			arg = scanner.nextLine();
			currentCharacter.setPersonality(arg);
			
			System.out.println("The personality of the character was changed successfully\n");
			game.saveClans();
			
			break;
			
		case 3:
			
			System.out.println("Please enter the new creation date of the character");
			System.out.println("Please enter the character's creation day (A number between 1 and 31)");
			day = validateInt(1, 31);	

			System.out.println("Please enter the character's creation month (A number between 1 and 12)");
			month = validateInt(1, 12);

			System.out.println("Please enter the character's creation year (Example: 2015)");
			year = validateInt(1999, 2025);
			
			arg = day + "/" + month + "/" + year;
			
			currentCharacter.setCreationDate(arg);
			
			System.out.println("The creationd date of the character was changed successfully\n");
			game.saveClans();
			
			break;
			
		case 4:
			
			System.out.println("Please enter the new creation date of the character");
			powerLevel = validateInt(0, 999999);
			currentCharacter.setPowerLevel(powerLevel);
			
			System.out.println("The power level of the character was changed successfully\n");
			game.saveClans();
			
			break;		
		}
	}
	
	public int updateCharacterChoice(){

		boolean running = true;
		int choice = 0;

		while(running){
			
			System.out.println("1. Update name");
			System.out.println("2. Update personality");
			System.out.println("3. Update creation date");
			System.out.println("4. Update power level");
						
			try{

				choice = scanner.nextInt();
				scanner.nextLine();
			}
			catch(InputMismatchException e){

				scanner.next();
			}

			if(choice > 0 && choice < 5){

				running = false;
			}
			else{
				
				System.out.println("Please enter a correct value\n");
			}
		}

		return choice;
	}
	
	public void enterInATechniqueMenu() {
		
		String name;
		
		System.out.println("Please enter the technique name");
		name = scanner.nextLine();
		
		if((currentTechnique = currentCharacter.getTechniqueByName(name)) != null) {
			
			techniqueMenu();
		}
		else {
			
			System.out.println("A character with that name doesn't exist, please try again\n");
		}
	}
	
	public void techniqueMenu() {
		
		boolean running = true;
		int choice = 0;
		
		while(running) {
			
			choice = techniqueOptionMenu();
			
			switch(choice) {
			
			case 1:
				
				updateTechniqueMenu();
				
				break;
				
			case 2:
				
				running = false;
				currentTechnique = null;
			
			}
		}
	}
	
	public int techniqueOptionMenu(){

		boolean running = true;
		int choice = 0;

		while(running){
			
			System.out.println("You are in the technique " + currentTechnique.getName() + "\n");
			System.out.println("1. Update technique");
			System.out.println("2. Exit");
						
			try{

				choice = scanner.nextInt();
				scanner.nextLine();
			}
			catch(InputMismatchException e){

				scanner.next();
			}

			if(choice > 0 && choice < 3){

				running = false;
			}
			else{
				
				System.out.println("Please enter a correct value\n");
			}
		}

		return choice;
	}
	
	public void updateTechniqueMenu() {
		
		String name;
		double factor;
		
		System.out.println("1. Update name");
		System.out.println("2. Update factor");
		int choice = validateInt(1,2);
		
		if(choice == 1) {
			
			System.out.println("Please enter the new name of the technique\n");
			name = scanner.nextLine();
			
			if(currentCharacter.updateTechnique(name, currentTechnique)) {
				
				System.out.println("The technique was changed successfully\n");
				game.saveClans();
			}
			else {
				
				System.out.println("The name of the technique cannot be changed\n");
			}
		}
		else {
			
			System.out.println("Plese enter the new factor of the technique\n");
			
			factor = validateDouble(0.0, 999.9);
			currentTechnique.setFactor(factor);
			currentCharacter.sortTechniquesByFactor();
			
			System.out.println("The factor of the technique was changed successfully\n");
			game.saveClans();
		}
		
		
	}
	
	public int validateInt(int minimum, int max){
		
		boolean running = true;
		int num = -1;
		
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
	
	public double validateDouble(double minimum, double max){
		
		boolean running = true;
		double num = -1;
		
		while(running){
			
			try{

				num = scanner.nextDouble();
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
