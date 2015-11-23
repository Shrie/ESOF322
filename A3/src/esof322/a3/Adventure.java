/**
 * Team Members: Hunter Oehrtman, Chad Bowman, Karl Ohaus, Michael Manning
 *
 */

package esof322.a3;

/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
                
**/

/**  Adventure Game  Program Code
Copyright (c) 1999-2012 James M. Bieman
The Adventure game is based on the "Colossal Cave Adventure" originally
designed by Will Crowther and implemented by Will Crowther
and Don Wood in Fortran in 1975 and 1976.

This micro-version is a variant of the original cave system and is implemented in Java
with just a few rooms and with a much more limited vocabulary.

Updated August 2010, January 2012
- Code is put into package cs314.a2 to match current CS314 coding standards.
Updated January 2012
- Renamed as the "Adventure Game"

To compile: javac cs314.a2.AdventureGame.java
To run:     java cs314.a2.AdventureGame

The main routine is AdventureGame.main
			    
			    **/

/** class Adventure: Primary method, createCave, creates the cave system.
        It eventually be replaced with a more flexible mechanism
        to support input and output from devices other than
        an ASCII terminal.

		Room descriptions are followed by a room identifier,
		to ease debugging and testing.  These would be removed
		to help confuse the user, which is our ultimate aim.

		I haven't added all of the room descriptions.  They
		will be done later.
		
		In this version all I/O is through standard I/O;
		I/O is to and from the console. 

*/

public class Adventure {

  private Room entrance;
  
  public Room createAdventure(){
    // The outside: 
      Room  outside = new Room();
      outside.setDesc(
        "You awake, standing, on the edge of a cliff.  The full moon \n" +
        "provides natural light as you familiarize with your surroundings.\n" + 
    	"You quickly notice the gapping maw of a cave leading downwards.");
   
   // Room 1:
      Room r1 = new Room();
      r1.setDesc(
    	"The entrance to the cave is lined with emaciated bodies and the rusted\n" +
    	"husks of ancient armor.  To the east you notice a narrow passage");

   // Connect the outside to Room 1:
      outside.setSide(5,r1);
      r1.setSide(4,outside);
      entrance = outside;

   // Room 2:
      Room r2 = new Room();
      r2.setDesc(
    	"You enter a large, cavernous room decorated with ancient markings and tapestries.  \n" + 
    	"A sliver of moonlight shines from the west, and a narrow, dark hole opens to the east.");

  // Room 3:
     Room r3 = new Room();
     r3.setDesc(
    	"The suffacating darkness quickly surrounds you, making you wish for a torch.\n"+
		"As your eyes adjust to the darkness you notice a widening passage to the west.\n" +
		"To the east you notice a cavernous opening.  Just in front of you is a deep hole\n" +
		"with a rickety, old latter.  You cannot see the bottom.\n");

  // Connect Rooms 1, 2, & 3:
     r1.setSide(2,r2);
     r2.setSide(3,r1);
     r2.setSide(2,r3);
     r3.setSide(3,r2);

  // Room 4:
     Room r4 = new Room();
     r4.setDesc(
    	"The room is rather barron with only a giant grizzly bear skull in a corner.\n"+
    	"A tappering passage goes westward, while a slightly more comfortable one\n" +
		"leads to the north. A worn staircase leads downward where you can hear the\n"
		+ "shrieks of bats.");

  // Room 5:
     Room r5 = new Room();
     r5.setDesc(
    		 "An old, rickety ladder goes to the room above.  Mysterious shrieks\n" +
    		 "puncture the silence, clearly coming from a passageway to the east.");

  // Room 6:
     Room r6 = new Room();
     r6.setDesc(
    		 "The room is full of shrieking cave owls, upset that their slumber\n" +
    		 "has been interuppted.");

  // Room 7:
     Room r7 = new Room();
     r7.setDesc(
    		"The room exudes a damp, musty smell and you notice a cieling full of\n" +
    		"bats.  There are puddles on the floor.  It would be best to go back up\n" +
    		"the stairs.");

  // Connect rooms 3, 4, 5, 6, & 7.
     r3.setSide(2,r4);
     r3.setSide(5,r5);
     r4.setSide(3,r3);
     r4.setSide(5,r7);
     r5.setSide(4,r3);
     r5.setSide(2,r6);
     r6.setSide(3,r5);
     r7.setSide(4,r4);

  // Room 8:
     Room r8 = new Room();
     r8.setDesc(
    		"As you enter the room you notice piles of shed skin.  You determine it would\n" +
     		"be better not to investigate the slithering by your foot.  A small footpath\n" +
    		"runs to the east.  To the west is a nice door marked 'Tavern'");

  // Room 9:
     Room r9 = new Room();
     r9.setDesc(
    		 "You open the door to see a jovial tavern full of patrons.  The music is pleasant\n" +
    		 "and the bartender motions you over.  Despite you desire to stay you should probably\n" +
    		 "go back east.");

  // Room 10:
     Room r10 = new Room();
     r10.setDesc(
    		"Someone has clearly been here before.  The room bears the signs of a violent struggle\n" +
     		"with blood and pieces of metal literring the floor's intricate design. Upon furhter\n" +
     		"inspection you notice one piece of the floor is off.  It is a trap door!  However,\n" +
     		"it is locked.");

 // Room 11:
    Room r11 = new Room();
    r11.setDesc(
    		"This room shines with the intensity of a billion suns. At the source of such magnificent\n" +
    		"you notice");
    Treasure theTreasure = new Treasure();
    theTreasure.setDesc("A bag filled with gold bars.");
    r11.addItem(theTreasure);

 // Lets connect them:
    r4.setSide(0,r8);
    r8.setSide(1,r4);
    r8.setSide(3,r9);
    r8.setSide(2,r10);
    r9.setSide(2,r8);
    r10.setSide(3,r8);

 // Create a key and put it in r6:
    Key theKey = new Key();
    theKey.setDesc("A shiny gold key.");
    r6.addItem(theKey);

 // We add a door between r10 and r11: 
    Door theDoor = new Door(r10,r11,theKey);
    r10.setSide(5,theDoor);
    r11.setSide(4,theDoor);

 // Now return the entrance:
    entrance = outside;
    return entrance;

  }
}

