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

// class Wall



public class Wall implements CaveSite {
	 /**
	   * Modified method, it now takes in the AdventureGameModelFacade as a parameter
	   */
	 public void enter(Player p, AdventureGameModelFacade model){
		 
		 if(model != null)
			 model.view = "Ouch! That hurts.";
		 else
			 System.out.println("Ouch! That hurts.");
		
	 }

}

