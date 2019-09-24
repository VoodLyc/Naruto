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
//Getters
	
	/**
	*<b>Description:</b> This method allows returning the attribute name.<br>
	*@return The attribute name.
	*/
	
	public String getName() {
		return name;
	}

	/**
	*<b>Description:</b> This method allows returning the attribute factor.<br>
	*@return The attribute factor.
	*/
	
	public double getFactor() {
		return factor;
	}
	
	/**
	*<b>Description:</b> This method allows returning the attribute next.<br>
	*@return The attribute next.
	*/
	
	public Technique getNext() {
		return next;
	}
	
//Setters
	
	/**
	*<b>Description:</b> This method allows setting the attribute name.<br>
	*/
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	*<b>Description:</b> This method allows setting the attribute factor.<br>
	*/
	
	public void setFactor(double factor) {
		this.factor = factor;
	}
	
	/**
	*<b>Description:</b> This method allows setting the attribute next.<br>
	*/

	public void setNext(Technique next) {
		this.next = next;
	}
	
//Methods
	
}
