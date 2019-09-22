package test;

import static org.junit.jupiter.api.Assertions.*;
import model.NarutoGame;
import model.Clan;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class NarutoGameTest {
	
	private NarutoGame game;
	private ArrayList<Clan> clans;
	
	private void setUpScenario1() {
		
		game = new NarutoGame();
		clans = new ArrayList<Clan>();
	}
	
	private void setUpScenario2() {
		
		game = new NarutoGame();
		clans = new ArrayList<Clan>();
		
		clans.add(new Clan ("Nara"));
		clans.add(new Clan ("Aburame"));
		clans.add(new Clan ("Hatake"));
		clans.add(new Clan ("Inuzuka"));
		
		game.setClans(clans);
	}

	@Test
	void addClanTest() {
		
		setUpScenario1();
		
		game.addClan("Uzumaki");
		game.addClan("Uchiha");
		game.addClan("Senju");
		game.addClan("Sarutobi");
		
		clans = game.getClans();
		
		assertEquals("Uzumaki", clans.get(0).getName());
		assertEquals("Uchiha", clans.get(1).getName());
		assertEquals("Senju", clans.get(2).getName());
		assertEquals("Sarutobi", clans.get(3).getName());
		
		assertFalse(game.addClan("Uzumaki"));
		assertFalse(game.addClan("uzumaki"));		
	}
	
	@Test
	void deleteClanTest() {
		
		setUpScenario2();
		
		assertTrue(game.deleteClan("Nara"));
		assertTrue(game.deleteClan("Aburame"));
		
		clans = game.getClans();

		assertFalse(game.deleteClan("Naruto"));
		
		assertEquals(2, clans.size());
		
		assertTrue(game.deleteClan("Hatake"));
		assertTrue(game.deleteClan("Inuzuka"));
		
		clans = game.getClans();
		
		assertEquals(0, clans.size());
	}
	
	@Test
	void getClanTest() {
		
		setUpScenario2();
		
		assertEquals(clans.get(0), game.getClan("Nara"));
		assertEquals(clans.get(2), game.getClan("Hatake"));
		assertEquals(clans.get(1), game.getClan("Aburame"));
		assertEquals(clans.get(3), game.getClan("Inuzuka"));
	}
}
