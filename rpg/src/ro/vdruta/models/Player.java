package ro.vdruta.models;

import ro.vdruta.models.characters.Hero;

/**
 * Created by MM on 2016-02-28.
 */
public class Player {
    private String username;
    private Hero hero;

    public Player(String username) {
        this.username = username;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
