package ro.vdruta;

import ro.vdruta.character.Necromancer;
import ro.vdruta.character.Orc;

/**
 * Created by MM on 2016-02-23.
 */
public class Main{
    public static void main(String[] args) {
        Orc orc = new Orc("Ovidiu", 7);
        Necromancer necromancer = new Necromancer("Mark", 3);

        System.out.println("Orc hero name:");
        System.out.println(orc.getName());
        System.out.println("Level:");
        System.out.println(orc.getLevel());
        System.out.println("Health:");
        System.out.println(orc.getHealth());
        System.out.println("Damage:");
        System.out.println(orc.getDamage());

        System.out.println("Necromance villain name:");
        System.out.println(necromancer.getName());
        System.out.println("Level:");
        System.out.println(necromancer.getLevel());
        System.out.println("Health:");
        System.out.println(necromancer.getHealth());
        System.out.println("Damage:");
        System.out.println(necromancer.getDamage());

        System.out.println(orc.getName() + " attack " + necromancer.getName() + " :");
        while (necromancer.getHealth() > 0) {
            necromancer.receiveDamage(orc.getDamage());
            if (necromancer.getHealth() > 0)
                System.out.println(necromancer.getHealth());
            else
                System.out.println(necromancer.getName() + " died!");
        }
        System.out.println("Next battle with weapons! To be continued!");
    }
}
