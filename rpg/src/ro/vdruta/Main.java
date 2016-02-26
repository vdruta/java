package ro.vdruta;

import ro.vdruta.character.DarkMage;
import ro.vdruta.character.Necromancer;
import ro.vdruta.character.Orc;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketPermission;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by MM on 2016-02-23.
 */
public class Main{
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

        //suicide mission :)
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


/*
        System.out.println("Is " + orc.getName() + " a necromancer?");
        System.out.println(orc.equals(necromancer) + "\n");

        System.out.print("Orc Hero - Name: ");
        System.out.print(orc.getName());
        System.out.print(" ; Level: ");
        System.out.print(orc.getLevel());
        System.out.print(" ; Health: ");
        System.out.print(orc.getHealth());
        System.out.print(" ; Damage: ");
        System.out.print(orc.getDamage());
        System.out.print(" ; Id: ");
        System.out.println(orc.getId());

        System.out.print("Necromance Villain - Name: ");
        System.out.print(necromancer.getName());
        System.out.print(" ; Level: ");
        System.out.print(necromancer.getLevel());
        System.out.print(" ; Health: ");
        System.out.print(necromancer.getHealth());
        System.out.print("; Damage: ");
        System.out.print(necromancer.getDamage());
        System.out.print(" ; Id: ");
        System.out.println(necromancer.getId());

        System.out.println(orc.getName() + " attack " + necromancer.getName() + " :");
        while (necromancer.getHealth() > 0) {
            necromancer.receiveDamage(orc.getDamage());
            if (necromancer.getHealth() > 0)
                System.out.println(necromancer.getHealth());
            else
                System.out.println(necromancer.getName() + " died!");
        }
*/
    }
}
