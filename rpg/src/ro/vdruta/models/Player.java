package ro.vdruta.models;

import ro.vdruta.models.characters.*;

/**
 * Created by MM on 2016-02-28.
 */
public class Player {
    private String username;
    private Hero hero;

    public Player(String username, String heroType, String heroName) {
        this.username = username;
        if (heroType.compareTo("Elf") == 0)
            this.hero = new Elf(heroName, 1);
        if (heroType.compareTo("Knight") == 0)
            this.hero = new Knight(heroName, 1);
        if (heroType.compareTo("Mage") == 0)
            this.hero = new Mage(heroName, 1);
        if (heroType.compareTo("Orc") == 0)
            this.hero = new Orc(heroName, 1);

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
