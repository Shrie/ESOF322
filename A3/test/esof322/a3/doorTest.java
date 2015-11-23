package esof322.a3;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class doorTest {
	private Door door;
	private Room room1;
	private Room room2;
	private Key correctKey;
	private Key wrongKey;
	private Player hunter;
	private final ByteArrayOutputStream os = new ByteArrayOutputStream();
	private final String success = "\nYour key works! The door creaks open,\n" +
			 "and slams behind you after you pass through.\nnullRoom Contents: ";
	private final String failure = "\nYou don't have the key for this door!\nSorry.\n";

	
	@Before
	public void setUp()throws Exception {
		hunter = new Player();
		room1 = new Room();
		room2 = new Room();
		correctKey = new Key();
		wrongKey = new Key();
		door = new Door(room1, room2, correctKey);
		room1.addItem(correctKey);
		room1.addItem(wrongKey);
		hunter.setLoc(room1);
		System.setOut(new PrintStream(os));
	}
	@After
	public void tearDown() throws Exception{
		hunter = null;
		room1 = null;
		room2 = null;
		correctKey = null;
		wrongKey = null;
		door = null;
		System.setOut(null);
	}
	@Test
	public void test1() {
		hunter.pickUp(correctKey);
		door.enter(hunter, null);
		assertEquals(success.replace("\n", "").replace("\r",""), os.toString().replace("\n", "").replace("\r",""));
	}
	@Test
	public void test2() {
		hunter.pickUp(wrongKey);
		door.enter(hunter, null);
		assertEquals(failure.replace("\n", "").replace("\r",""), os.toString().replace("\n", "").replace("\r",""));
	}
	@Test
	public void test3() {
		door.enter(hunter, null);
		assertEquals(failure.replace("\n", "").replace("\r",""), os.toString().replace("\n", "").replace("\r",""));
	}

}
