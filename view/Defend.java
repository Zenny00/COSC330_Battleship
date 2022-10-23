public class Defend implements State {
    Player player;

    Defend(Player player)
    {
	    this.player = player;
	    // disable ship board
	    player.setOceanBoardEnabled(false);
	    // disable target board
	    player.setTargetBoardEnabled(false);
    }
    
    public void setScreen() 
    {
    	//TODO
    }
}
