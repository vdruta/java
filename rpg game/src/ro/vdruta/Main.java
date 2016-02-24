package ro.vdruta;

import ro.vdruta.character.DarkMage;
import ro.vdruta.character.Necromancer;
import ro.vdruta.character.Orc;

import java.net.SocketPermission;

/**
 * Created by MM on 2016-02-23.
 */
public class Main{
    public static void main(String[] args) {
        Orc orc = new Orc("Johann", 21);
        Mission mission = new Mission("Level 1: Beat 7 necromancers", 7, orc);

        System.out.print("Hero - Name: ");
        System.out.print(orc.getName());
        System.out.print(" ; Level: ");
        System.out.print(orc.getLevel());
        System.out.print(" ; Health: ");
        System.out.print(orc.getHealth());
        System.out.print(" ; Damage: ");
        System.out.print(orc.getDamage());
        System.out.print(" ; Id: ");
        System.out.println(orc.getId());

        System.out.println("Give " + orc.getName() + " armor and axe:");
        orc.addWeapon("armor");
        orc.addWeapon("axe");
        System.out.print("Hero - Name: ");
        System.out.print(orc.getName());
        System.out.print(" ; Level: ");
        System.out.print(orc.getLevel());
        System.out.print(" ; Health: ");
        System.out.print(orc.getHealth());
        System.out.print(" ; Damage: ");
        System.out.print(orc.getDamage());
        System.out.print(" ; Id: ");
        System.out.println(orc.getId());

        System.out.println("Give hero a mission to beat 7 necromancers!");
        System.out.println(mission.getName());
        System.out.print("necromancers ids: ");
        for (int i = 0; i < mission.getNecromancerCount(); i++)
            System.out.print(mission.getNecromancers()[i].getId() + " ");
        System.out.println();
        System.out.print("necromancers names: ");
        for (int i = 0; i < mission.getNecromancerCount(); i++)
            System.out.print(mission.getNecromancers()[i].getName() + " ");
        System.out.println();

        mission.fightHerovsNecromancer();

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
