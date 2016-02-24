package ro.vdruta.character;

import ro.vdruta.artefacts.*;

/**
 * Created by MM on 2016-02-23.
 */
public class Hero extends Character{

    public Hero(String name, int level) {
        super(name, level);
    }

    public void levelUp(){
        level++;
    }

    public void addWeapon(String weapon){
        if (weapon.compareTo("armor") == 0){
            Armor armor = new Armor("armor", 330);
            health += armor.getHealth();
        }
        else if (weapon.compareTo("helmet") == 0){
            Helmet helmet = new Helmet("helmet", 130);
            health += helmet.getHealth();
        }
        else if (weapon.compareTo("axe") == 0){
            Axe axe = new Axe("axe", 60);
            damage += axe.getDamage();
        }
        else if (weapon.compareTo("bow") == 0){
            Bow bow = new Bow("bow", 20);
            damage += bow.getDamage();
        }
        else if (weapon.compareTo("staff") == 0){
            Staff staff = new Staff("staff", 40);
            damage += staff.getDamage();
        }
        else if (weapon.compareTo("sword") == 0){
            Sword sword = new Sword("sword", 70);
            damage += sword.getDamage();
        }
    }
}
