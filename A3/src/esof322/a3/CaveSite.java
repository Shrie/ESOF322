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

// interface CaveSite

public interface CaveSite{
	/**
	 * Modified enter method, pass the AdventureGameModelFacade so we can reference it's variables.
	 * @param p is the Player object
	 * @param model is the AdventureGameModelFacade
	 */
  void enter(Player p, AdventureGameModelFacade model);
}

