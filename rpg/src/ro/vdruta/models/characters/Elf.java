package ro.vdruta.models.characters;
/**
 * Created by MM on 2016-02-23.
 */
public class Elf extends Hero{
    public Elf(String name, int level){
        super(name, level);
        health = 1700 + level * 5;
        damage = 70 + level * 5;
    }
}
