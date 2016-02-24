package ro.vdruta;

import ro.vdruta.character.*;

import java.lang.reflect.Array;

/**
 * Created by MM on 2016-02-24.
 */
public class Mission {
    private String name;
    private int necromancerCount;
    private Necromancer[] necromancers = new Necromancer[1000];
    private Hero hero;

    public Mission(String name, int necromancerCount, Hero hero){
        this.name = name;
        this.necromancerCount = necromancerCount;
        this.hero = hero;

        for (int i = 0; i < necromancerCount; i++) {
            necromancers[i] = new Necromancer("necro" + i, i + 10);
        }
    }

    public Hero getHero() {
        return hero;
    }

    public String getName() {
        return name;
    }

    public int getNecromancerCount() {
        return necromancerCount;
    }

    public Necromancer[] getNecromancers() {
        return necromancers;
    }

    public void fightHerovsNecromancer() {
        for (int i = 0; i < necromancerCount; i++){
            System.out.println(hero.getName() + " vs " + necromancers[i].getName());
            while (hero.getHealth() > 0 && necromancers[i].getHealth() > 0) {
                System.out.println(hero.getName() + " hit " + necromancers[i].getName() + " with " + hero.getDamage() + " damage");
                necromancers[i].receiveDamage(hero.getDamage());
                hero.receiveDamage(necromancers[i].getDamage());
                System.out.println(necromancers[i].getName() + " hit with " + necromancers[i].getDamage());
            }
            if (hero.getHealth() > 0)
                System.out.println(hero.getName() + " killed " + necromancers[i].getName());
            if (necromancers[i].getHealth() > 0)
                System.out.print(hero.getName() + " died");
        }
    }
}
