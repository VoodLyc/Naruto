package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Clan;
import model.GameCharacter;

class ClanTest {
	
	private Clan clan;
	
	private void setUpScenario1() {
		
		clan = new Clan("test");
		GameCharacter c1 = new GameCharacter("Naruto", "", "", 0);
		GameCharacter c2 = new GameCharacter("Sasuke", "", "", 0);
		GameCharacter c3 = new GameCharacter("Gaara", "", "", 0);
		clan.addFirst(c1);
		clan.addFirst(c2);
		clan.addFirst(c3);
	}

	@Test
	void setCharacterTest() {
		
		setUpScenario1();
		
		GameCharacter tmp;
		
		tmp = clan.getCharacter(2);
		clan.setCharacter(0, tmp);
		tmp = clan.getCharacter(0);
		assertEquals("Naruto", tmp.getName());
		
		tmp = clan.getCharacter(1);
		clan.setCharacter(2, tmp);
		tmp = clan.getCharacter(2);
		assertEquals("Sasuke", tmp.getName());
		
		tmp = clan.getCharacter(0);
		clan.setCharacter(1, tmp);
		tmp = clan.getCharacter(1);
		assertEquals("Naruto", tmp.getName());
		
		for(int i = 0; i < clan.getSize(); i++) {
			
			System.out.println(clan.getCharacter(i).getName());
		}
	}

}
