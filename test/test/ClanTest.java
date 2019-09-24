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
	
	private void setUpScenario5() {
		
		clan = new Clan("test");
	}
	
	private void setUpScenario6() {
		
		clan = new Clan("test");
		GameCharacter c1 = new GameCharacter("", "Judging", "", 0);
		GameCharacter c2 = new GameCharacter("", "Jung", "", 0);
		GameCharacter c3 = new GameCharacter("", "Feeling", "", 0);
		GameCharacter c4 = new GameCharacter("", "Introversion", "", 0);
		GameCharacter c5 = new GameCharacter("", "Thinking", "", 0);
		GameCharacter c6 = new GameCharacter("", "Intuition", "", 0);
		clan.addFirst(c1);
		clan.addFirst(c2);
		clan.addFirst(c3);
		clan.addFirst(c4);
		clan.addFirst(c5);
		clan.addFirst(c6);
	}
	
	private void setUpScenario7() {
		
		clan = new Clan("test");
		GameCharacter c1 = new GameCharacter("", "", "", 16329);
		GameCharacter c2 = new GameCharacter("", "", "", 8700);
		GameCharacter c3 = new GameCharacter("", "", "", 2879);
		GameCharacter c4 = new GameCharacter("", "", "", 18500);
		GameCharacter c5 = new GameCharacter("", "", "", 4300);
		GameCharacter c6 = new GameCharacter("", "", "", 12800);
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
	void sortCharactersByPersonalityTest() {
		
		setUpScenario6();
		
		clan.sortCharactersByPersonality();

		assertEquals("Feeling", clan.getCharacter(0).getPersonality());
		assertEquals("Introversion", clan.getCharacter(1).getPersonality());
		assertEquals("Intuition", clan.getCharacter(2).getPersonality());
		assertEquals("Judging", clan.getCharacter(3).getPersonality());
		assertEquals("Jung", clan.getCharacter(4).getPersonality());
		assertEquals("Thinking", clan.getCharacter(5).getPersonality());
	}
	
	@Test
	void sortCharactersByPowerLevelTest() {
		
		setUpScenario7();
		
		clan.sortCharactersByPowerLevel();

		assertEquals(2879, clan.getCharacter(0).getPowerLevel());
		assertEquals(4300, clan.getCharacter(1).getPowerLevel());
		assertEquals(8700, clan.getCharacter(2).getPowerLevel());
		assertEquals(12800, clan.getCharacter(3).getPowerLevel());
		assertEquals(16329, clan.getCharacter(4).getPowerLevel());
		assertEquals(18500, clan.getCharacter(5).getPowerLevel());
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
	
	@Test
	void getCharacterByName() {
		
		setUpScenario1();
		
		GameCharacter c1;
		GameCharacter c2;
		
		c1 = clan.getCharacter(0);
		c2 = clan.getCharacterByName("Gaara");
		
		assertEquals(c1, c2);
		
		c1 = clan.getCharacter(1);
		c2 = clan.getCharacterByName("Sasuke");
		
		assertEquals(c1, c2);
		
		c1 = clan.getCharacter(2);
		c2 = clan.getCharacterByName("Naruto");
		
		assertEquals(c1, c2);
	}
	
	@Test
	void addCharacterTest() {
		
		setUpScenario5();
		
		assertTrue(clan.addCharacter("Naruto", "", "", 8));
		assertEquals(1, clan.getSize());
		
		assertFalse(clan.addCharacter("Naruto", "", "", 8));
		assertEquals(1, clan.getSize());
		
		assertTrue(clan.addCharacter("Sasuke", "", "", 8));
		assertEquals(2, clan.getSize());
		
		assertTrue(clan.addCharacter("Itachi", "", "", 8));
		assertEquals(3, clan.getSize());
		
		assertTrue(clan.addCharacter("Kakashi", "", "", 8));
		assertEquals(4, clan.getSize());
	}
}
