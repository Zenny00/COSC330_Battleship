public class Initial implements State {
    Player player;

    Initial(Player player) {this.player = player;}
    public void setScreen() {
        // enable ship board
        player.setOceanBoardEnabled(true);
        // disable target board
        player.setTargetBoardEnabled(false);
    }


}