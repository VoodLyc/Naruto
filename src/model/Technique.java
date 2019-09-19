package model;
import java.io.Serializable;

/**
*<b>Description:</b> The class Technique in the package model.<br>
*@author Johan Giraldo.
*/

public class Technique implements Serializable {

//Attributes
	
	private static final long serialVersionUID = -7733119021681737732L;
	private String name;
	private double factor;
	private Technique next;
	
	
//Constructor
	
	/**
	*<b>Description:</b> The constructor of the class GameCharacter.<br>
	*<b>Pre:</b> No one parameter can be null.<br>
	*<b>Post:</b> All attributes of the class are initialized.<br>
	*@param name The technique's name.
	*@param factor The technique's factor (how much affects the character power level).
	*/
	
	public Technique(String name, double factor) {
		
		this.name = name;
		this.factor = factor;
		next = null;
	}
}
