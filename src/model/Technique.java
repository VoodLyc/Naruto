package model;
import java.io.Serializable;

/**
*<b>Description:</b> The class Technique in the package model.<br>
*@author Johan Giraldo.
*/

public class Technique implements Serializable, Comparable<Technique>{

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
	
	public String toString() {
		
		String toString;
		
		toString = "Name: " + getName() + "\n";
		toString += "Factor: " + getFactor() + "\n";
		
		return toString;
	}
	
	/**
	*<b>Description:</b> This method allows comparing a technique with other technique by the powerLevel.<br>
	*@param technique The technique with which it compares.
	*@return 0 if the factors are equals, 1  if the technique's factor is major than the technique's name which it compares, -1 if the technique's factor is minor than the technique's factor which it compares.
	*/
	
	@Override
	public int compareTo(Technique technique) {
		
		int result = 0;
		
		if(getFactor() > technique.getFactor()) {
			
			result = 1;
		}
		else if(getFactor() < technique.getFactor()) {
			
			result = -1;
		}
		
		return result;
	}
}
