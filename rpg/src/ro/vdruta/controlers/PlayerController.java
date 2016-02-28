package ro.vdruta.controlers;

import ro.vdruta.models.Player;

/**
 * Created by MM on 2016-02-28.
 */
public class PlayerController {
    Player player;

    public PlayerController(String username) {
        player = new Player(username);
    }


    public void changeUsername(String newUsername) {
        player.setUsername(newUsername);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
