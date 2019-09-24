package model;
import java.io.Serializable;
import java.util.Comparator;

/**
*<b>Description:</b> The class GameCharacter in the package model.<br>
*@author Johan Giraldo.
*/

public class GameCharacter implements Serializable, Comparable <GameCharacter>, Comparator <GameCharacter> {

//Attributes
	
	private static final long serialVersionUID = -5403520228781839941L;
	private String name;
	private String personality;
	private String creationDate;
	private int powerLevel;
	private GameCharacter next;
	private GameCharacter prev;
	private Technique firstTechnique;
	
//Constructor
	
	/**
	*<b>Description:</b> The constructor of the class GameCharacter.<br>
	*<b>Pre:</b> No one parameter can be null.<br>
	*<b>Post:</b> All attributes of the class are initialized.<br>
	*@param name The character's name.
	*@param personality The character's personality.
	*@param creationDate The character's creation date.
	*@param powerLevel The character's power level.
	*/
	
	public GameCharacter(String name, String personality, String creationDate, int powerLevel) {
		
		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.powerLevel = powerLevel;
		next = null;
		prev = null;
		firstTechnique = null;
	}
	
	//Getters
	
	/**
	*<b>Description:</b> This method allows returning the attribute next.<br>
	*@return The attribute next.
	*/
	
	public GameCharacter getNext() {
		
		return next;
	}
	
	/**
	*<b>Description:</b> This method allows returning the attribute previous.<br>
	*@return The attribute previous.
	*/
	
	public GameCharacter getPrev() {
		
		return prev;
	}
	
	/**
	*<b>Description:</b> This method allows returning the attribute personality.<br>
	*@return The attribute personality.
	*/
	
	public String getPersonality() {
		
		return personality;
	}
	
	/**
	*<b>Description:</b> This method allows returning the attribute creationDate.<br>
	*@return The attribute creationDate.
	*/
	
	public String getCreationDate() {
		
		return creationDate;
	}
	
	/**
	*<b>Description:</b> This method allows returning the attribute powerLevel.<br>
	*@return The attribute powerLevel.
	*/
	
	public int getPowerLevel() {
		
		return powerLevel;
	}
	
	/**
	*<b>Description:</b> This method allows returning the attribute name.<br>
	*@return The attribute name.
	*/
	
	public String getName() {
		
		return name;
	}
	
	/**
	*<b>Description:</b> This method allows returning the attribute firstTechnique.<br>
	*@return The attribute firstTechnique.
	*/
	
	public Technique getFirst() {
		
		return firstTechnique;
	}
	
	//Setters
	
	/**
	*<b>Description:</b> This method allows setting the attribute next.<br>
	*/
	
	public void setNext(GameCharacter character) {
		
		next = character;
	}
	
	/**
	*<b>Description:</b> This method allows setting the attribute previous.<br>
	*/
	
	public void setPrev(GameCharacter character) {
		
		prev = character;
	}
	
	/**
	*<b>Description:</b> This method allows setting the attribute name.<br>
	*/
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	*<b>Description:</b> This method allows setting the attribute personality.<br>
	*/

	public void setPersonality(String personality) {
		this.personality = personality;
	}
	
	/**
	*<b>Description:</b> This method allows setting the attribute creationDate.<br>
	*/

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	/**
	*<b>Description:</b> This method allows setting the attribute powerLevel.<br>
	*/

	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}
	
	/**
	*<b>Description:</b> This method allows setting the attribute firstTechnique.<br>
	*/

	public void setFirst(Technique firstTechnique) {
		this.firstTechnique = firstTechnique;
	}

	
	//Methods
	
	/**
	 *<b>Description:</b> This method allows comparing a character with other character by the name.<br>
	 *@param character The character with which it compares.
	 *@return 0 if the names are equals, 1  if the character's name is major than the character's name which it compares, -1 if the character's name is minor than the character's name which it compares.
	 */
	
	@Override
	public int compareTo(GameCharacter character) {
		
		int result = 0;
		
		if(getName().compareToIgnoreCase(character.getName()) > 0) {
			
			result = 1;
		}
		else if (getName().compareToIgnoreCase(character.getName()) < 0) {
			
			result = -1;
		}

		return result;
	}
	
	/**
	 *<b>Description:</b> This method allows comparing a character with other character by the personality.<br>
	 *@param character The character with which it compares.
	 *@param character2 The other character with it compares.
	 *@return 0 if the personalities are equals, 1  if the character's personality is major than the character's name which it compares, -1 if the character's name is minor than the character's name which it compares.
	 */

	@Override
	public int compare(GameCharacter character, GameCharacter character2) {
		
		int result = 0;
		
		if(character.getPersonality().compareTo(character2.getPersonality()) > 0) {
			
			result = 1;
		}
		
		else if(character.getPersonality().compareTo(character2.getPersonality()) < 0) {
			
			result = -1;
		}
		
		return result;
	}
	
	/**
	 *<b>Description:</b> This method allows comparing a character with other character by the powerLevel.<br>
	 *@param character The character with which it compares.
	 *@return 0 if the poweLevel are equals, 1  if the character's powerLevel is major than the character's name which it compares, -1 if the character's powerLevel is minor than the character's powerLevel which it compares.
	 */
	
	public int compareByPowerLevel(GameCharacter character) {
		
		int result = 0;
		
		if(getPowerLevel() > character.getPowerLevel()) {
			
			result = 1;
		}
		else if(getPowerLevel() < character.getPowerLevel()) {
			
			result = -1;
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		
		String toString;
		
		toString = "Name: " + getName() + "\n";
		toString += "Personality: " + getPersonality() + "\n";
		toString += "Creation date: " + getCreationDate() + "\n";
		toString += "Power level: " + getPowerLevel() + "\n";
		toString += "Number Of techniques: " + "\n";
		
		return toString;
	}
	
	/**
	*<b>Description:</b> This method allows returning the technique linked lists size<br>
	*@return The size of the linked list.
	*/
	
	public int getSize() {
		
		Technique tmp = getFirst();
		int size = 0;
		
		if(tmp != null) {
			
			while(tmp != null) {
				
				tmp = tmp.getNext();
				size++;
			}
		}
		
		return size;	
	}
	
	/**
	*<b>Description:</b> This method allows getting the technique by the index.<br>
	*@param index The position of the technique that does you want to get. The index must be >= 0 and minor to the technique linked list size.
	*@return The technique in that position.
	*/
	
	public Technique getTechnique(int index) {
		
		int counter = 0;
		Technique tmp = getFirst();
		
		while(counter < index) {
			
			tmp = tmp.getNext();
			counter++;
		}
		
		return tmp;
	}
	
	/**
	*<b>Description:</b> This method allows setting the technique by the index.<br>
	*<b>Post:</b> The technique was replaced.<br>
	*@param index The position of the technique that does you want to replace. The index must be >= 0 and minor to the technique linked list size.
	*@param technique1 The technique that does you want to set.
	*/
	
	public void setTechnique(int index, Technique technique1) {
		
		Technique tmp, tmp2;
		Technique technique = new Technique(technique1.getName(), technique1.getFactor());
		
		if(index == 0) {
			
			tmp = getTechnique(index);
			technique.setNext(tmp.getNext());
			setFirst(technique);
		}
		else if(index == getSize() - 1) {
			
			tmp = getTechnique(index - 1);
			tmp.setNext(technique);
		}
		else {
			
			tmp = getTechnique(index - 1);
			tmp2 = tmp.getNext();
			tmp2 = tmp2.getNext();
			tmp.setNext(technique);
			technique.setNext(tmp2);
		}
	}
	
	/**
	*<b>Description:</b> This method allows checking if already exist a technique with that name.<br>
	*@param name The technique's name.
	*@return A boolean true if a technique with that name exists and false if don't exist.
	*/
	
	public boolean checkIfExistTechniqueWithThisName(String name) {
		
		boolean exist = false;
		boolean running = true;
		
		for(int i = 0; i < getSize() && running; i++) {
			
			if(getTechnique(i).getName().equalsIgnoreCase(name)) {
				
				exist = true;
				running = false;
			}
		}
		
		return exist;
	}
	
	public boolean addTechnique(String name, double factor) {
		
		boolean added = true;
		
		try {
			
			if(checkIfExistTechniqueWithThisName(name)) {
				
				throw new IllegalNameException("A technique with that name already exist");
			}
			else {
				
				addFirst(new Technique(name, factor));
				sortTechniquesByFactor();
			}
		}
		catch(IllegalNameException e) {
			
			added = false;
		}
		
		return added;	
	}
	
	/**
	*<b>Description:</b> This method allows showing the techniques.<br>
	*@return A message with all the characters.
	*/
	
	public String showTechniques() {
		
		String techniques = "";
		
		for(int i = 0; i < getSize(); i++) {
			
			techniques += getTechnique(i).toString();
		}
		
		return techniques;
	}
	
	/**
	*<b>Description:</b> This method allows adding a technique as the head of the linked list.<br>
	*@param character The character that does you want to add. Must be != null.
	*/
	
	public void addFirst(Technique technique) {
		
		Technique first = getFirst();
		
		if(first == null) {
			
			setFirst(technique);
		}
		else {
			
			technique.setNext(first);
			setFirst(technique);
		}
	}
	
	/**
	*<b>Description:</b> This method allows sorting the techniques from minor to major by the factor.<br>
	*<b>Post:</b> The technique are sorted by the factor from minor to major.<br>
	*/
	
	public void sortTechniquesByFactor() {
		
		for(int i = getSize(); i > 0; i--){	
			for(int j = 0; j < i - 1; j++){
				
				if(getTechnique(j).compareTo(getTechnique(j+1)) > 0){
					
					Technique tmp = getTechnique(j);
					setTechnique(j, getTechnique(j+1));
					setTechnique(j+1, tmp);
				}
			}
		}
	}
}
