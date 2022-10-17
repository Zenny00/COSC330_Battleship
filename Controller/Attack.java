public class Attack implements State {
    Player player;

    Attack(Player player) {this.player = player;}
    public void setScreen() {
        // disable ship board
        // enable target board
    }
}