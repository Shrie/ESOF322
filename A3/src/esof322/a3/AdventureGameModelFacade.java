/**
 * Team Members: Hunter Oehrtman, Chad Bowman, Karl Ohaus, Michael Manning
 *
 */

package esof322.a3;

/**
 * Team Members: Hunter Oehrtman, Chad Bowman, Karl Ohaus, Michael Manning
 *
 */

public class AdventureGameModelFacade {

	// Constants
	private static final int NORTH = 0,
							SOUTH = 1,
							EAST = 2,
							WEST = 3,
							UP = 4,
							DOWN= 5;
	
 // some private fields to reference current location,
 // its description, what I'm carrying, etc.
	 public String view;
	 public Player player;
	 
	 private Adventure cave;

	 private Room room;
 
/**
 * This method is the control interface to the game.
 */

  AdventureGameModelFacade(int in_level) { // we initialize
  	  
	  player = new Player(); //initialize player
	  
	  if(in_level == 0){
		  cave = new Adventure();			//instantiate the adventure
	  } else if(in_level == 1){
		  //cave = new Level1Factory(1);
	  }
	  
	  
	  room = cave.createAdventure();	//generate the starting room
	  player.setRoom(room);				//place the player in the starting room
	  view = room.getDesc();			//output the room description
	 
  }
  
  /**
   * This method moves the player up then updates the view
   */

  public void goUp(){
	 player.go(UP, this);
  }
  
  /**
   * This method moves the player down then updates the view
   */

  public void goDown(){
	  player.go(DOWN, this);
    }
  
  /**
   * This method moves the player north then updates the view
   */

  public void goNorth(){
	  player.go(NORTH, this);
    }
  
  /**
   * This method moves the player south then updates the view
   */
      
  public void goSouth(){
	  player.go(SOUTH, this);
    }
  
  /**
   * This method moves the player east then updates the view
   */

  public void goEast(){
	  player.go(EAST, this);
    }
  
  /**
   * This method moves the player west then updates the view
   */
      
  public void goWest(){
	  player.go(WEST, this);
    }
  
  /**
   * This method updates the view
   */

  public void look(){
	  view = player.getLoc().getDesc();
  }
  
  public void level0(){
	  view = "Difficulty Level 0 Selected, look around to begin the adventure";
  }
  
  public void level1(){
	  view = "Difficulty Level 1 Selected, look around to begin the adventure";
  }
  
  /**
   * The getView method returns the variable view to the GUI
   * @return String
   */
  public String getView(){ 
     return view;
     }

  /**
   * The getItems method returns the things carried by the player to the GUI
   * @return String
   */
  public String getItems(){
     return player.showMyThings();
     }

}
