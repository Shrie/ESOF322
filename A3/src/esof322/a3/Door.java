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

// class Door

public class Door implements CaveSite {
  /** In this implementation doors are always locked.
      A player must have the correct key to get through
      a door.  Doors automatically lock after a player
      passes through. */

  private Key myKey;

  /** The door's location. */
  private CaveSite outSite;
  private CaveSite inSite;

  /** We can construct a door at the site. */
  Door(CaveSite out, CaveSite in, Key k){
    outSite = out;
    inSite = in;
    myKey = k;
  }

 /** A player will need the correct key to enter. */
  /**
   * Modified method, it now takes in the AdventureGameModelFacade as a parameter
   */
 public void enter(Player p, AdventureGameModelFacade model){
 if (p.haveItem(myKey)) {
	 
	 if(model != null)
		 model.view += "\nYour key works! The door creaks open,\n" +
				 "and slams behind you after you pass through.";
	 else
		 System.out.println("\nYour key works! The door creaks open,\n" +
				 "and slams behind you after you pass through.");
    
	 if (p.getLoc() == outSite)  
		 inSite.enter(p, model);
	 else if (p.getLoc() == inSite)  
		 outSite.enter(p, model); }
 	 else { 
 		 if(model != null)
 			model.view += "\nYou don't have the key for this door!\nSorry.";
 		 else
 			 System.out.println("\nYou don't have the key for this door!\nSorry.");
 	}
 	}
 
 } // end Door

