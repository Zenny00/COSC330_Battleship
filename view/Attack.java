public class Attack implements State {
    Player player;

    Attack(Player player) 
    {
	    this.player = player;
	    // disable ship board
	    player.setOceanBoardEnabled(false);
	    // enable target board
	    player.setTargetBoardEnabled(true);
    }

    public void setScreen() {
    	//TODO        
    }
}
