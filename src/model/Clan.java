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
	
//Methods
	
	/**
	*<b>Description:</b> This method allows returning the character linked lists size<br>
	*@return The size of the linked list.
	*/
	
	public int getSize() {
		
		int size = 0;
		GameCharacter tmp = getFirst();
		
		if(tmp != null) {
			
			size++;
			
			while((tmp = tmp.getNext()) != null) {
				
				size++;
			}
		}
		
		return size;
	}
	
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
	*@param character The character that does you want to add. Must be != null.
	*/
	
	public void addFirst(GameCharacter character) {
		
		GameCharacter first = getFirst();
		
		if(first == null) {
			
			setFirst(character);
		}
		else {
			
			first.setPrev(character);
			character.setNext(first);
			setFirst(character);
		}
	}
	
	/**
	*<b>Description:</b> This method allows getting the character by the index.<br>
	*@param index The position of the character that does you want to get. The index must be >= 0 and minor to the characters linked list size.
	*@return The character in that position.
	*/
	
	public GameCharacter getCharacter(int index) {
		
		GameCharacter character = getFirst();
		int counter = 0;
		
		while(counter < index) {
			
			character = character.getNext();
			counter++;
		}
		
		return character;
	}
	
	/**
	*<b>Description:</b> This method allows setting the character by the index.<br>
	*<b>Post:</b> The character was replaced.<br>
	*@param index The position of the character that does you want to replace. The index must be >= 0 and minor to the characters linked list size.
	*@param character1 The character that does you want to set.
	*/
	
	public void setCharacter(int index, GameCharacter character1) {
		
		
		GameCharacter tmp = getCharacter(index);
		GameCharacter character = new GameCharacter(character1.getName(), character1.getPersonality(), character1.getCreationDate(), character1.getPowerLevel());
		
		if(index == 0) {
			
			character.setNext(tmp.getNext());
			
			if((tmp = tmp.getNext()) != null) {
				
				tmp.setPrev(character);
			}
			
			setFirst(character);
		}
		
		else if(index == getSize() - 1) {
			
			tmp = tmp.getPrev();
			tmp.setNext(character);
			character.setPrev(tmp);
		}
		
		else {
			
			GameCharacter tmp2;
			
			character.setNext(tmp.getNext());
			character.setPrev(tmp.getPrev());
			tmp2 = tmp.getPrev();
			tmp2.setNext(character);
			tmp = tmp.getNext();
			tmp.setPrev(character);			
		}
	}
	
	/**
	*<b>Description:</b> This method allows sorting the character from minor to major by the name.<br>
	*<b>Post:</b> The characters are sorted by name from minor to major.<br>
	*/
	
	public void sortCharactersByName() {
		
		for(int i = 0; i < getSize() -1; i++){
			
			GameCharacter minor = getCharacter(i);
			int minorPos = i;
			
			for(int j = i + 1; j < getSize(); j++){
				
				GameCharacter actual = getCharacter(j);
				
				if(actual.compareTo(minor) < 0){
					
					minor = actual;					
					minorPos = j;
				}
			}
			
			GameCharacter tmp = getCharacter(i);
			setCharacter(i, minor);
			setCharacter(minorPos, tmp);
		}
	}
	
	/**
	*<b>Description:</b> This method allows deleting the character who matches with the name.<br>
	*<b>Post:</b> The character was deleted from the doubly linked list.<br>
	*/
	
	public boolean deleteCharacter(String name) {
		
		boolean deleted = false;
		GameCharacter tmp = getFirst();
		GameCharacter tmp2;
		
		if(tmp != null) {
			
			if(tmp.getName().equalsIgnoreCase(name)) {
				
				if((tmp = tmp.getNext()) != null) {
					
					setFirst(tmp);
					tmp.setPrev(null);
					deleted = true;
				}
				else {
					
					setFirst(null);
					deleted = true;
				}
			}
			else {
				
				while(tmp != null && !tmp.getName().equalsIgnoreCase(name)) {
					
					tmp = tmp.getNext();
				}
				
				if(tmp != null) {
					
					tmp2 = tmp.getPrev();
					tmp2.setNext(tmp.getNext());
					deleted = true;
					
					if((tmp = tmp.getNext()) != null) {
						
						tmp.setPrev(tmp2);
						
					}		
				}	
			}	
		}
		
		return deleted;
	}
	
	/**
	*<b>Description:</b> This method allows getting the character with that name.<br>
	*@param name the character's name
	*@return the character with that name, if the character couldn't be found, return null.
	*/
	
	public GameCharacter getCharacterByName(String name) {
		
		GameCharacter character = null;
		boolean running = true;
		
		for(int i = 0; i < getSize() && running; i++) {
			
			if(getCharacter(i).getName().equals(name)) {
				
				character = getCharacter(i);
				running = false;
			}
		}
		
		return character;
	}
}
