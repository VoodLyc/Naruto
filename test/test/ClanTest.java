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
	
	private void setUpScenario2() {
		
		clan = new Clan("test");
		GameCharacter c1 = new GameCharacter("Yamato", "", "", 0);
		clan.addFirst(c1);
	}
	
	private void setUpScenario3() {
		
		clan = new Clan("test");
		GameCharacter c1 = new GameCharacter("Yamato", "", "", 0);
		GameCharacter c2 = new GameCharacter("Anko", "", "", 0);
		GameCharacter c3 = new GameCharacter("Jiraiya", "", "", 0);
		GameCharacter c4 = new GameCharacter("Junsai", "", "", 0);
		GameCharacter c5 = new GameCharacter("Asura", "", "", 0);
		GameCharacter c6 = new GameCharacter("Jiraiya", "", "", 0);
		clan.addFirst(c1);
		clan.addFirst(c2);
		clan.addFirst(c3);
		clan.addFirst(c4);
		clan.addFirst(c5);
		clan.addFirst(c6);
	}
	
	private void setUpScenario4() {
		
		clan = new Clan("test");
		GameCharacter c1 = new GameCharacter("Junsai", "", "", 0);
		GameCharacter c2 = new GameCharacter("Jigen", "", "", 0);
		GameCharacter c3 = new GameCharacter("Anko", "", "", 0);
		GameCharacter c4 = new GameCharacter("Yamato", "", "", 0);
		GameCharacter c5 = new GameCharacter("Asura", "", "", 0);
		GameCharacter c6 = new GameCharacter("Jiraiya", "", "", 0);
		clan.addFirst(c1);
		clan.addFirst(c2);
		clan.addFirst(c3);
		clan.addFirst(c4);
		clan.addFirst(c5);
		clan.addFirst(c6);
	}

	@Test
	void setCharacterTest() {
		
		setUpScenario1();
		
		GameCharacter tmp;
		GameCharacter tmp2;
		
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
		
		setUpScenario2();
		
		tmp2 = tmp;
		tmp = clan.getCharacter(0);
		clan.setCharacter(0, tmp2);
		tmp = clan.getCharacter(0);
		assertEquals("Naruto", tmp.getName());
	}
	
	@Test
	void sortCharactersByNameTest() {
		
		setUpScenario3();
		
		clan.sortCharactersByName();

		assertEquals("Anko", clan.getCharacter(0).getName());
		assertEquals("Asura", clan.getCharacter(1).getName());
		assertEquals("Jiraiya", clan.getCharacter(2).getName());
		assertEquals("Jiraiya", clan.getCharacter(3).getName());
		assertEquals("Junsai", clan.getCharacter(4).getName());
		assertEquals("Yamato", clan.getCharacter(5).getName());
	}
	
	@Test
	void deleteCharacterTest() {
		
		setUpScenario4();
		
		assertTrue(clan.deleteCharacter("Yamato"));
		assertEquals(5, clan.getSize());
		
		assertTrue(clan.deleteCharacter("Anko"));
		assertEquals(4, clan.getSize());
		
		assertTrue(clan.deleteCharacter("Jiraiya"));
		assertEquals(3, clan.getSize());
		
		assertTrue(clan.deleteCharacter("Junsai"));
		assertEquals(2, clan.getSize());
		
		assertTrue(clan.deleteCharacter("Asura"));
		assertEquals(1, clan.getSize());
		
		assertTrue(clan.deleteCharacter("Jigen"));
		assertEquals(0, clan.getSize());
		
		assertFalse(clan.deleteCharacter(""));
	}
}
