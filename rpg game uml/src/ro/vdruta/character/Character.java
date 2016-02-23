package ro.vdruta.character;
/**
 * Created by MM on 2016-02-23.
 */
public class Character {
    protected String name;
    protected int level;
    protected int health;
    protected int damage;

    public Character(String name, int level){
        this.name = name;
        this.level = level;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public int getLevel(){
        return level;
    }

    public int getDamage(){
        return damage;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void receiveDamage(int value){
        health -= value;
    }

}
