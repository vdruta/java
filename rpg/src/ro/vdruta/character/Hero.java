package ro.vdruta.character;

import ro.vdruta.artefacts.*;

import java.util.ArrayList;

/**
 * Created by MM on 2016-02-23.
 */
public class Hero extends Character{
    private ArrayList<Artefact> inventory = new ArrayList<Artefact>();
    private int inventoryCount;
    private int inventorySize = 3;

    public Hero(String name, int level) {
        super(name, level);
    }

    public ArrayList<Artefact> getInventory() {
        return inventory;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void levelUp(){
        level++;
        inventorySize++;
    }

    public void addStartWeapon(String weapon)throws Exception{
        inventoryCount++;
        if (inventoryCount > inventorySize ) {
            throw new Exception("Inventory is full. A hero can keep in the inventory max " + inventorySize + " artefacts");
        }
            if (weapon.compareTo("armor") == 0) {
                Armor armor = new Armor("armor", 330);
                health += armor.getHealth();
            } else if (weapon.compareTo("helmet") == 0) {
                Helmet helmet = new Helmet("helmet", 130);
                health += helmet.getHealth();
            } else if (weapon.compareTo("axe") == 0) {
                Axe axe = new Axe("axe", 60);
                damage += axe.getDamage();
            } else if (weapon.compareTo("bow") == 0) {
                Bow bow = new Bow("bow", 20);
                damage += bow.getDamage();
            } else if (weapon.compareTo("staff") == 0) {
                Staff staff = new Staff("staff", 40);
                damage += staff.getDamage();
            } else if (weapon.compareTo("sword") == 0) {
                Sword sword = new Sword("sword", 70);
                damage += sword.getDamage();
            }
    }

    public void addArtefact(Artefact artefact) {
        if (artefact instanceof Armor) {
            this.inventory.add(artefact);
            this.health += ((Armor) artefact).getHealth();
            this.inventoryCount += 1;
        }
        if (artefact instanceof Axe) {
            this.inventory.add(artefact);
            this.damage += ((Axe) artefact).getDamage();
            this.inventoryCount += 1;
        }
        if (artefact instanceof Bow) {
            this.inventory.add(artefact);
            this.damage += ((Bow) artefact).getDamage();
            this.inventoryCount += 1;
        }
        if (artefact instanceof Helmet) {
            this.inventory.add(artefact);
            this.health += ((Helmet) artefact).getHealth();
            this.inventoryCount += 1;
        }
        if (artefact instanceof Staff) {
            this.inventory.add(artefact);
            this.damage += ((Staff) artefact).getDamage();
            this.inventoryCount += 1;
        }
        if (artefact instanceof Sword) {
            this.inventory.add(artefact);
            this.damage += ((Sword) artefact).getDamage();
            this.inventoryCount += 1;
        }
    }
}
