package ro.vdruta;

import ro.vdruta.character.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MM on 2016-02-24.
 */
public class Mission {
    private String name;
    private int monstersCount;
    private Necromancer[] necromancers;
    private ArrayList<Goblin> goblins;
    private Hero hero;

    public Mission(String name, String monsterType, int monstersCount, Hero hero){
        this.name = name;
        this.monstersCount = monstersCount;
        this.hero = hero;

        if (monsterType.compareTo("necromancer") == 0) {
            ArrayList<String> necromancerNames = new ArrayList<String>();
            Charset charset = Charset.forName("US-ASCII");
            Path file = Paths.get("C://Users/MM/IdeaProjects/javatraining/rpg/src/necromancersnameslist.txt");
            try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    necromancerNames.add(line);
                }
            }
            catch (IOException x) {
                System.err.format("IOException: %s%n", x);
            }
            this.necromancers = new Necromancer[monstersCount];
            for (int i = 0; i < monstersCount; i++) {
                necromancers[i] = new Necromancer(necromancerNames.get(i), i + 10);
            }
        }
        else if (monsterType.compareTo("goblin") == 0) {
            ArrayList<String> goblinNames = new ArrayList<String>();
            Charset charset = Charset.forName("US-ASCII");
            Path file = Paths.get("C://Users/MM/IdeaProjects/javatraining/rpg/src/goblinnameslist.txt");
            try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    goblinNames.add(line);
                }
            }
            catch (IOException x) {
                System.err.format("IOException: %s%n", x);
            }
            this.goblins = new ArrayList<Goblin>();
            for (int i = 0; i < monstersCount; i++){
                this.goblins.add(new Goblin(goblinNames.get(i), i + 7));
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getMonstersCount() {
        return monstersCount;
    }

    public Necromancer[] getNecromancers() {
        return necromancers;
    }

    public ArrayList<Goblin> getGoblins() {
        return goblins;
    }

    public Hero getHero() {
        return hero;
    }

    public void fightHerovsNecromancer() {
        for (int i = 0; i < monstersCount; i++){
            if (hero.getHealth() > 0)
                System.out.println(hero.getName() + " vs " + necromancers[i].getName());
            while (hero.getHealth() > 0 && necromancers[i].getHealth() > 0) {
                System.out.println(hero.getName() + " hit " + necromancers[i].getName() + " with " + hero.getDamage() + " damage");
                necromancers[i].receiveDamage(hero.getDamage());
                System.out.println(necromancers[i].getName() + " hit with " + necromancers[i].getDamage());
                hero.receiveDamage(necromancers[i].getDamage());
            }
            if (hero.getHealth() > 0)
                System.out.println(hero.getName() + " killed " + necromancers[i].getName());
            else if (necromancers[i].getHealth() > 0 ) {
                System.out.println(hero.getName() + " died");
                break ;
            }
        }
        if (hero.getHealth() > 0) {
            System.out.println("You WIN! Level UP!");
            hero.levelUp();
        }
        else
            System.out.println("You LOSE!");
    }

    public void fightHerovsGoblin() {
        for (Goblin i: goblins) {
            if (hero.getHealth() > 0)
                System.out.println(hero.getName() + " vs " + i.getName());
            while (hero.getHealth() > 0 && i.getHealth() > 0) {
                System.out.println(hero.getName() + " hit " + i.getName() + " with " + hero.getDamage() + " damage");
                i.receiveDamage(hero.getDamage());
                System.out.println(i.getName() + " hit " + hero.getName() + " with " + i.getDamage() + " damage");
                hero.receiveDamage(i.getDamage());
            }
            if (hero.getHealth() > 0)
                System.out.println(hero.getName() + " killed " + i.getName());
            else if (i.getHealth() > 0) {
                System.out.println(hero.getName() + " died. \n You lose!");
                break ;
            }
        }
        if (hero.getHealth() > 0) {
            System.out.println("You WIN! Level UP");
            hero.levelUp();
        }
        else
            System.out.println("You LOSE!");


    }
}
