public class Initial implements State 
{
	Player player;

	Initial(Player player) 
	{
		this.player = player;
		
		// enable ship board
		player.setOceanBoardEnabled(true);
		// disable target board
		player.setTargetBoardEnabled(false);
	}

	public void setScreen() 
	{
		//TODO
	}
}
