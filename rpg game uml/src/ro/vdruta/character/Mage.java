package ro.vdruta.character;
/**
 * Created by MM on 2016-02-23.
 */
public class Mage extends Hero {
    public Mage(String name, int level){
        super(name, level);
        health = 100 + level * 5;
        damage = 7 + level * 5;
    }
}
