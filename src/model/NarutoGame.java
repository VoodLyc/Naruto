package model;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
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
	
//Methods
	
	/**
	*<b>Description:</b> This method allows adding owners in the ArrayList of owners.<br>
	*@param name The clan's name.
	*@return A boolean that indicates if the clan was added or not.
	*/
	
	public boolean addClan(String name) {
		
		boolean added;
		
		try {
			
			if(checkIfExistClanWithThisName(name)) {
				
				throw new IllegalNameException("A clan with that name already exist");
			}
			else {
				
				clans.add(new Clan(name));
				added = true;
			}
		}
		catch(IllegalNameException e) {
			
			added = false;
		}
		
		return added;
	}
	
	
	/**
	*<b>Description:</b> This method allows checking if already exist a clan with that name.<br>
	*@param name The clan's name.
	*@return A boolean true if a clan with that name exists and false if don't exist.
	*/
	
	public boolean checkIfExistClanWithThisName(String name) {
		
		boolean exist = false;
		boolean running = true;
		
		for(int i = 0; i < clans.size() && running; i++) {
			
			if(clans.get(i).getName().equalsIgnoreCase(name)) {
				
				exist = true;
				running = false;
			}
		}
		
		return exist;
	}
	
	/**
	*<b>Description:</b> This method allows saving the clans.<br>
	*<b>Post:</b> The clans were serialized.<br>
	*/
	
	public void saveClans() {
		
		FileOutputStream file;
		ObjectOutputStream output;
		
		try {
			
			file = new FileOutputStream("data/Clans.clan");
			output = new ObjectOutputStream(file);
			output.writeObject(clans);
			output.close();
			
		}
		catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	*<b>Description:</b> This method allows loading the clans.<br>
	*<b>Post:</b> The clans were rebuilt.<br>
	*/
	
	public void loadClans() {
		
		File file;
		FileInputStream object;
		ObjectInputStream input;
		file = new File("data/Clans.clan");
		
		if(file.exists()) {
			
			try {
				
				object = new FileInputStream(file);
				input = new ObjectInputStream(object);
				clans = (ArrayList<Clan>) input.readObject();
				input.close();
			}
			catch(FileNotFoundException e) {
				
				e.printStackTrace();
			}
			catch(IOException e) {
				
				e.printStackTrace();
			}
			catch(ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
		}
		else {
			
			saveClans();
		}
	}
	
	/**
	*<b>Description:</b> This method allows showing the clans.<br>
	*@return A message with the clans.
	*/
	
	public String printClans() {
		
		String print = "";
		
		for(int i = 0; i < clans.size(); i++) {
			
			print += clans.get(i).toString() + "\n";
		}
		
		return print;
	}
	
	/**
	*<b>Description:</b> This method allows deleting a clan by the name.<br>
	*@return A boolean true if the clan was deleted, false if the clan couldn't be deleted.
	*/
	
	public boolean deleteClan(String name) {
		
		boolean deleted = false;
		
		for(int i = 0; i < clans.size(); i++) {
			
			if(clans.get(i).getName().equalsIgnoreCase(name)) {
				
				clans.remove(i);
				deleted = true;
			}
		}
		
		return deleted;
	}
	
	
	/**
	*<b>Description:</b> This method allows getting a clan by the name.<br>
	*@return The clan who matches with that name.
	*/
	
	public Clan getClan(String name) {
		
		Clan clan = null;
		
		for(int i = 0; i < clans.size(); i++) {
			
			if(clans.get(i).getName().equalsIgnoreCase(name)) {
				
				clan = clans.get(i);
			}
		}
		
		return clan;
	}
	
	/**
	 *<b>Description:</b> This method allows returning the attribute clans<br>
	 *@return The attribute clans.
	 */
	
	public ArrayList<Clan> getClans() {
		return clans;
	}
	
	/**
	 *<b>Description:</b> This method allows setting the attribute clans<br>
	 */

	public void setClans(ArrayList<Clan> clans) {
		this.clans = clans;
	}

}
