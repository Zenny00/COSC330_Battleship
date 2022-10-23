public class Defend implements State {
    Player player;

    Defend(Player player) {this.player = player;}
    public void setScreen() {
        // disable ship board
        player.setOceanBoardEnabled(false);
        // disable target board
        player.setTargetBoardEnabled(false);
    }
}
