//Name(s): Joshua Comfort & Justin Conklin
//Description: State object that will only allow the player to place their ships

public class Initial implements State 
{
	Player player;

	Initial(Player player) 
	{
		this.player = player;
		
		// disable target board
		player.setTargetBoardEnabled(false);
	}
}
