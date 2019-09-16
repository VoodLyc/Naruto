package model;

/**
*<b>Description:</b> The class Clan in the package model.<br>
*@author Johan Giraldo.
*/

public class Clan {
	
//Attributes
	
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
	
}
