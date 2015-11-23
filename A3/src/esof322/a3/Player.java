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

public class Player {

	// Instance variables
  private Room myLoc;
  private Item[] myThings = new Item[2];
  private int itemCount = 0;
  
  	// Public methods
  public void setRoom(Room r){ 
	  myLoc = r;
  }

  /**
   * Gets the current room's description
   * @return current room's description   
   */
  public String look() {
	  return myLoc.getDesc();
   }
  
  /**
   * Modified method, it now takes in the AdventureGameModelFacade as a parameter
   * @param direction integer defined in AdventureGameModelFacade
   * @param model instance passed through
   */
  public void go(int direction, AdventureGameModelFacade model){
	  myLoc.exit(direction, this, model);
  }
  
  /**
   * Old method for command line
   * @param direction to go in
   */
  public void go(int direction){
	  myLoc.exit(direction, this);
  }

  public void pickUp(Item i){
   if (itemCount < 2) {
      myThings[itemCount] = i;
      itemCount++;
      myLoc.removeItem(i);
      }
   }

  public boolean haveItem(Item itemToFind){
     for (int n = 0; n < itemCount ; n++)
       if (myThings[n] == itemToFind) return true;
     return false;
  }

  public void drop(int itemNum){
   if (itemNum > 0 & itemNum <= itemCount){	//index bounds checking (protection)
      switch(itemNum){
      case 1: { myLoc.addItem(myThings[0]);
	        myThings[0]=myThings[1];
	        itemCount--; 
	        break;
	      }
      case 2: { 
    	  myLoc.addItem(myThings[1]);
		itemCount--;
		break;
	      } 
      }
   }
}

  public void setLoc(Room r){myLoc = r;}

  public Room getLoc(){return myLoc;}

  public String showMyThings(){
   String outString = "";
   for (int n = 0; n < itemCount ; n++)
     outString += "\n" + Integer.toString(n+1) + ": " 
       + myThings[n].getDesc() + " ";
   return outString;
  }

  public boolean handsFull(){return itemCount == 2;}

  public boolean handsEmpty(){return itemCount==0;}

  public int numItemsCarried(){return itemCount;}

}// end Player

