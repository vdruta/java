package ro.vdruta.artefacts;

/**
 * Created by MM on 2016-02-23.
 */
public class Helmet {
    private String name;
    private int health;

    public Helmet(String name, int health){
        this.name = name;
        this.health = health;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }
}