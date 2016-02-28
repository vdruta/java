package ro.vdruta;

import ro.vdruta.models.Mission;
import ro.vdruta.models.artefacts.Armor;
import ro.vdruta.models.artefacts.Sword;
import ro.vdruta.models.characters.*;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Created by MM on 2016-02-23.
 */
public class Main {
    public static void main(String[] args) {

        Orc orc = new Orc("Largakh", 21);
        Mission mission;
        int i = 0;

        orc.printStats();
        System.out.println("Give " + orc.getName() + " helmet, armor and axe:");
        try {
            orc.addStartWeapon("helmet");
            orc.addStartWeapon("armor");
            orc.addStartWeapon("axe");
            orc.addStartWeapon("axe");
        }
        catch (Exception inventoryFull) {
            System.out.println(inventoryFull.getMessage());
        }
        orc.printStats();

        //Play missions until the end!
        while (orc.getHealth() > 0) {
            if (orc.getHealth() > 0) {
                mission = new Mission("Level 1: Beat 7 goblins", "goblin", 7, orc);
                System.out.println(mission.getName());
                mission.fightHerovsGoblin();
            }
            if (orc.getHealth() > 0) {
                System.out.println("Level completed!");
                orc.printStats();
            }
            if (orc.getHealth() > 0) {
                mission = new Mission("Level 2: Beat 10 necromancers", "necromancer", 10, orc);
                System.out.println(mission.getName());
                mission.fightHerovsNecromancer();
            }
            if (orc.getHealth() > 0) {
                System.out.println("Level completed!");
                orc.printStats();
            }
            if (orc.getHealth() > 0) {
                ArrayList<String> map = new ArrayList<>();
                Charset charset = Charset.forName("US-ASCII");
                Path file = Paths.get("C://Users/MM/IdeaProjects/javatraining/rpg/src/mapgoblins.txt");
                try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        map.add(line);
                    }
                }
                catch (IOException x) {
                    System.err.format("IOException: %s%n", x);
                }
                mission = new Mission(map.get(0), map.get(1), Integer.parseInt(map.get(2)), orc);
                System.out.println(mission.getName());
                mission.fightHerovsGoblin();
            }
        }

/*******************NEW MISSION : load *********************************/
        System.out.println();
        System.out.println("Create a new hero and try to give him 4 artefacts in the inventory:");
        Knight knight = new Knight("Knight 1", 24);
        /*Devil devil = new Devil("Devil", 4);
        Goblin goblin = new Goblin("Goblin", 5);
        Necromancer necromancer = new Necromancer("Necromance", 6);*/

        knight.printStats();
        try {
            knight.addArtefact(new Armor("body helmet", 250));
            knight.addArtefact(new Sword("big sword 1", 77));
            knight.addArtefact(new Sword("big sword 2", 77));
            knight.addArtefact(new Sword("big sword 3", 77));
        }
        catch (Exception inventoryFull) {
            System.out.println(inventoryFull.getMessage());
        }
        knight.printStats();
        knight.printInventory();
        System.out.println("Save hero to file hero.ser");
        knight.saveHeroToFile("C://Users/MM/IdeaProjects/javatraining/rpg/src/hero.ser");
        System.out.println("Load hero from file hero.ser");
        knight = (Knight) Hero.readHeroFromFile("C://Users/MM/IdeaProjects/javatraining/rpg/src/hero.ser");
        knight.printStats();
        knight.printInventory();
        System.out.println("Load monsters from file for a specific map");
        /*devil.saveVillainToFile("C://Users/MM/IdeaProjects/javatraining/rpg/src/devil.ser");
        goblin.saveVillainToFile("C://Users/MM/IdeaProjects/javatraining/rpg/src/goblin.ser");
        necromancer.saveVillainToFile("C://Users/MM/IdeaProjects/javatraining/rpg/src/necromancer.ser");*/
        Mission mission2 = new Mission("Herro  vs villains from file", 7, knight);

        /*******************NEW MISSION DONE *********************************/

/*******************MVC *********************************/

    }
}
