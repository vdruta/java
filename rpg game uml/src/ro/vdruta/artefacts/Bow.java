package ro.vdruta.artefacts;

/**
 * Created by MM on 2016-02-23.
 */
public class Bow {
    private String name;
    private int damage;

    public Bow(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}