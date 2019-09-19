package model;
import java.io.Serializable;

/**
*<b>Description:</b> The class Clan in the package model.<br>
*@author Johan Giraldo.
*/

public class Clan implements Serializable {
	
//Attributes
	
	private static final long serialVersionUID = 190832976922047379L;
	private String name;
	private GameCharacter firstCharacter;
	private int size;

//Constructor
	
	/**
	*<b>Description:</b> The constructor of the class Clan.<br>
	*<b>Pre:</b> No one parameter can be null.<br>
	*<b>Post:</b> All attributes of the class are initialized.<br>
	*@param name The clan's name.
	*/	
	
	public Clan(String name) {
		
		this.name = name;
		firstCharacter = null;
		size = 0;
	}
	
//Getters
	
	/**
	*<b>Description:</b> This method allows returning the attribute name<br>
	*@return The attribute name.
	*/
	
	public String getName() {
		
		return name;
	}
	
	/**
	*<b>Description:</b> This method allows returning the attribute size<br>
	*@return The attribute size.
	*/
	
	public int getSize() {
		
		return size;
	}
	
	/**
	*<b>Description:</b> This method allows returning the attribute firstCharacter<br>
	*@return The attribute firstCharacter.
	*/
	
	public GameCharacter getFirst() {
		
		return firstCharacter;
	}
	
//Setters
	
	/**
	*<b>Description:</b> This method allows setting the attribute name<br>
	*/
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	/**
	*<b>Description:</b> This method allows setting the attribute firstCharacter<br>
	*/
	
	public void setFirst(GameCharacter first) {
		
		firstCharacter = first;
	}
	
	/**
	*<b>Description:</b> This method allows setting the attribute name<br>
	*/
	
	public void setSize(int size) {
		
		this.size = size;
	}
	
//Methods
	
	/**
	*<b>Description:</b> The constructor of the class GameCharacter.<br>
	*@param name The character's name.
	*@param personality The character's personality.
	*@param creationDate The character's creation date.
	*@param powerLevel The character's power level.
	*@return A boolean true if the character was added and false if not.
	*/
	
	public boolean addCharacter(String name, String personality, String creationDate, int powerLevel) {
		
		boolean added = true;
		
		try {
			
			if(checkIfExistCharacterWithThisName(name)) {
				
				throw new IllegalNameException("A character with that name already exist");
			}
			else {
				
				addFirst(new GameCharacter(name, personality, creationDate, powerLevel));
			}
		}
		catch(IllegalNameException e) {
			
			added = false;
		}
		
		return added;	
	}
	
	/**
	*<b>Description:</b> This method allows checking if already exist a character with that name.<br>
	*@param name The character's name.
	*@return A boolean true if a character with that name exists and false if don't exist.
	*/
	
	public boolean checkIfExistCharacterWithThisName(String name) {
		
		boolean exist = false;
		boolean running = true;
		
		for(int i = 0; i < getSize() && running; i++) {
			
			if(getCharacter(i).getName().equals(name)) {
				
				exist = true;
				running = false;
			}
		}
		
		return exist;
	}
	
	/**
	*<b>Description:</b> This method allows adding the character as the head of the linked list.<br>
	*@param character The character that does you want to add.
	*/
	
	public void addFirst(GameCharacter character) {
		
		GameCharacter first = getFirst();
		
		if(first == null) {
			
			first = character;
		}
		else {
			
			first.setPrev(character);
			character.setNext(first);
			setFirst(character);
			setSize(getSize() + 1);
		}
	}
	
	/**
	*<b>Description:</b> This method allows getting the character by the index.<br>
	*@param index The position of the character that does you want to get. The index must be >= 0 and minor to size.
	*@return The character in that position.
	*/
	
	public GameCharacter getCharacter(int index) {
		
		GameCharacter character = null;
		GameCharacter first = getFirst();
		
		if(index == 0) {
			
			character = first;
		}
		else {
			
			int counter = 0;
			GameCharacter tmp = first;
			
			while(counter < index) {
				
				tmp = tmp.getNext();
				counter++;
			}
			
			character = tmp;
		}
		
		return character;
	}
	
	/**
	*<b>Description:</b> This method allows setting the character by the index.<br>
	*<b>Post:</b> The character was replaced.<br>
	*@param index The position of the character that does you want to replace. The index must be >= 0 and minor to size.
	*@param character The character that does you want to set.
	*/
	
	public void setCharacter(int index, GameCharacter character) {
		
		GameCharacter first = getFirst();
		
		if(index == 0) {
			
			character.setNext(first.getNext());
			setFirst(character);
		}
		else {
			
			int counter = 0;
			GameCharacter tmp = first;
			
			while(counter < index) {
				
				tmp = tmp.getNext();
				counter++;
			}
			
			character.setNext(tmp.getNext());
			tmp = tmp.getPrev();
			tmp.setNext(character);
		}
	}
}
