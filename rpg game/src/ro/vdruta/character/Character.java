package ro.vdruta.character;
/**
 * Created by MM on 2016-02-23.
 */
public class Character {
    protected String name;
    protected int level;
    protected int health;
    protected int damage;
    private int id;
    private static int idCount = 0;

    public Character(String name, int level){
        this.name = name;
        this.level = level;
        this.id = idCount;
        idCount++;
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

    public int getId() {
        return id;
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

    public boolean equals (Object obj){
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (obj instanceof Character) {
            Character anotherObj = (Character) obj;
            if (this.getId() == anotherObj.getId())
                return true;
        }
        return false;
    }
}
