package model;
import java.io.Serializable;

/**
*<b>Description:</b> The class GameCharacter in the package model.<br>
*@author Johan Giraldo.
*/

public class GameCharacter implements Serializable {

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
	
	//Methods
}
