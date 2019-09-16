package model;

/**
*<b>Description:</b> The class GameCharacter in the package model.<br>
*@author Johan Giraldo.
*/

public class GameCharacter {

//Attributes
	
	private String name;
	private String personality;
	private String creationDate;
	private int powerLevel;
	private GameCharacter next;
	private GameCharacter previous;
	private int size;
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
		previous = null;
		size = 0;
		firstTechnique = null;
	}

}
