package test;

import static org.junit.jupiter.api.Assertions.*;
import model.GameCharacter;
import model.Technique;
import org.junit.jupiter.api.Test;

class GameCharacterTest {
	
	private GameCharacter character;
	
	private void setUpScenario1() {
		
		character = new GameCharacter("", "", "", 3);
		character.addTechnique("Sasuke", 0.2);
		character.addTechnique("Naruto", 0.1);
		character.addTechnique("Jiraiya", 2.2);
		character.addTechnique("Itachi", 1.9);
		character.addTechnique("Kakashi", 1.2);
		character.addTechnique("Anko", 2.1);
	}
	
	@Test
	void addTechniquetest() {
		
		setUpScenario1();
		
		assertEquals(0.1, character.getTechnique(0).getFactor());
		assertEquals(0.2, character.getTechnique(1).getFactor());
		assertEquals(1.2, character.getTechnique(2).getFactor());
		assertEquals(1.9, character.getTechnique(3).getFactor());
		assertEquals(2.1, character.getTechnique(4).getFactor());
		assertEquals(2.2, character.getTechnique(5).getFactor());
		
		assertFalse(character.addTechnique("Sasuke", 0));
		assertFalse(character.addTechnique("Itachi", 0));
	}
	
	@Test
	void setTechniquetest() {
		
		setUpScenario1();
		
		Technique tmp;
		
		tmp = character.getTechnique(0);
		character.setTechnique(4, tmp);
		tmp = character.getTechnique(4);
		assertEquals(0.1, tmp.getFactor());
		
		tmp = character.getTechnique(2);
		character.setTechnique(0, tmp);
		tmp = character.getTechnique(0);
		assertEquals(1.2, tmp.getFactor());
		
		tmp = character.getTechnique(5);
		character.setTechnique(2, tmp);
		tmp = character.getTechnique(2);
		assertEquals(2.2, tmp.getFactor());
	}
}
