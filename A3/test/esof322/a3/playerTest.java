package esof322.a3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class playerTest {
	private Player hunter;
	private Room room1;
	private Room room2;
	private Item item1;
	//private Item item2;
	private Item item3;
	private Item[] expected;
	private Item[] result;
	

	@Before
	public void setUp() throws Exception {
		hunter = new Player();
		
		room1 = new Room();
		room2 = new Room();
		
		hunter.setLoc(room1);
		room1.setDesc("Test room 1!");
		room2.setDesc("Test room 2!");
		room1.setSide(2, room2);
		
		room1.addItem(item1);
		//room2.addItem(item2);
		room1.addItem(item3);
		
		hunter.pickUp(item3);
	}
	
	@After
	public void tearDown() throws Exception {
		room1 = null;
		room2 = null;
		item1 = null;
		//item2 = null;
		item3 = null;
		hunter = null;
	}
	
	@Test
	public void test1() { //pickUp
		hunter.pickUp(item1); 
		assertTrue(hunter.haveItem(item1));
	}
	
	@Test
	public void test2() { //drop
		hunter.drop(1);
		result = room1.getRoomContents();
		expected = new Item[2];
		expected[0] = item1;
		expected[1] = item3;
		assertArrayEquals(expected,result);
	}
	
	@Test 
	public void test3() { //go
		hunter.setLoc(room1);
		hunter.go(2);
		assertTrue(hunter.getLoc().getDesc().equals(room2.getDesc()));
	}

}
