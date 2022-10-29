//Name(s): Joshua Comfort & Justin Conklin
//Description: State object that allows the player to attack

public class Attack implements State {
    Player player;

    Attack(Player player) 
    {
	    this.player = player;
	    // enable target board
	    player.setTargetBoardEnabled(true);
    }
}
