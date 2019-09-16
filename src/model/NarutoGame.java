package model;
import java.util.ArrayList;

/**
*<b>Description:</b> The class NaturoGame in the package model.<br>
*@author Johan Giraldo.
*/

public class NarutoGame {
	
//Attributes
	
	private ArrayList<Clan> clans;
	
//Constructor
	
	/**
	*<b>Description:</b> The constructor of the class NarutoGame.<br>
	*<b>Post:</b> All attributes of the class are initialized.<br>
	*/	
	
	public NarutoGame() {
		
		clans = new ArrayList<Clan>();
	}
}
