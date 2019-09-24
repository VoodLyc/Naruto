package test;

import static org.junit.jupiter.api.Assertions.*;
import model.GameCharacter;
import model.Technique;
import org.junit.jupiter.api.Test;

class GameCharacterTest {
	
	private GameCharacter character;
	private Technique first;
	
	private void setUpScenario1() {
		
		character = new GameCharacter("", "", "", 3);
		character.setFirst(first);
		first = new Technique("", 0.6);
		Technique t1 = new Technique("", 0.2);
		Technique t2 = new Technique("", 0.7);
		Technique t3 = new Technique("", 0.1);
		Technique t4 = new Technique("", 0.9);
		Technique t5 = new Technique("", 1.5);
		Technique t6 = new Technique("", 2.0);
		character.addTechniqueSorted(t1);
		character.addTechniqueSorted(t2);
		character.addTechniqueSorted(t3);
		character.addTechniqueSorted(t4);
		character.addTechniqueSorted(t5);
		character.addTechniqueSorted(t6);
	}
	
	@Test
	void test() {
		
		setUpScenario1();
		
		System.out.println(character.getTechnique(0).getFactor());
		System.out.println(character.getTechnique(1).getFactor());
		System.out.println(character.getTechnique(2).getFactor());
		System.out.println(character.getTechnique(3).getFactor());
		System.out.println(character.getTechnique(4).getFactor());
		System.out.println(character.getTechnique(5).getFactor());
		System.out.println(character.getTechnique(6).getFactor());
		
		
		assertEquals(0.1, character.getTechnique(0).getFactor());
		assertEquals(0.2, character.getTechnique(1).getFactor());
		assertEquals(0.7, character.getTechnique(2).getFactor());
		assertEquals(0.6, character.getTechnique(3).getFactor());
		assertEquals(0.9, character.getTechnique(4).getFactor());
		assertEquals(1.5, character.getTechnique(5).getFactor());
		assertEquals(2.0, character.getTechnique(6).getFactor());
		
	}

}
