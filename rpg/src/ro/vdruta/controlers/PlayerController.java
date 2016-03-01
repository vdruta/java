package ro.vdruta.controlers;

import ro.vdruta.models.Player;

/**
 * Created by MM on 2016-02-28.
 */
public class PlayerController {
    Player player;

    public PlayerController(String username, String heroType, String heroName) {
        player = new Player(username, heroType, heroName);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
