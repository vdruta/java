package ro.vdruta.character;
/**
 * Created by MM on 2016-02-23.
 */
public class Orc extends Hero {
    public Orc(String name, int level){
        super(name, level);
        health = 100 + level * 20;
        damage = 20 + level * 5;
    }
}
