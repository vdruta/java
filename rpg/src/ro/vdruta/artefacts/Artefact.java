package ro.vdruta.artefacts;

/**
 * Created by MM on 2016-02-25.
 */
public abstract class Artefact {
    private String name;

    protected void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
