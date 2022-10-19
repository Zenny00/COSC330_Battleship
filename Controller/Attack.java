package controller;

import model.*;
import view.*;

public class Attack implements State {
    Player player;

    Attack(Player player) {this.player = player;}
    public void setScreen() {
        // disable ship board
        player.setOceanBoardEnabled(false);
        // enable target board
        player.setTargetBoardEnabled(true);
    }
}