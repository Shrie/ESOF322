package esof322.a3;

import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class roomTest {
	private Room room1;
	private Room room2;
	private Item testItem;
	private Player hunter;
	private final ByteArrayOutputStream os = new ByteArrayOutputStream();
	private String room1desc = "It's test room 1!Room Contents: ";
	
	
	@Before
	public void setUp() throws Exception {
		room1 = new Room();
		room1.setDesc("It's test room 1!");
		room2 = new Room();
		room2.setDesc("It's test room 2!");
		room2.addItem(testItem);
		hunter = new Player();
		hunter.setLoc(room2);
		room1.setSide(2, room2);
		room2.setSide(3, room1);
		System.setOut(new PrintStream(os));
	}
	@After
	public void tearDown() throws Exception {
		room1 = null;
		room2 = null;
		testItem = null;
	}
	@Test
	public void test1() { //add item
		room1.addItem(testItem);
		assertFalse(room1.roomEmpty());
	}
	@Test
	public void test2() { //remove item
		room2.removeItem(testItem);
		assertTrue(room2.roomEmpty());
	}
	@Test
	public void test3() { //enter
		room1.enter(hunter, null);
		assertEquals(room1desc.replace("\n","").replace("\r",""),os.toString().replace("\n","").replace("\r",""));	
	}
	@Test
	public void test4() { //exit
		room2.exit(3, hunter);
		assertEquals(room1desc.replace("\n","").replace("\r",""),os.toString().replace("\n","").replace("\r",""));
	}

}