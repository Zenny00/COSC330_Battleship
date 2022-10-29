//Name(s): Joshua Comfort & Justin Conklin
//Description: State object that will not allow the player to attack while the other player plays their turn

public class Defend implements State {
    Player player;

    Defend(Player player)
    {
	    this.player = player;
	    // disable target board
	    player.setTargetBoardEnabled(false);
    }
}
