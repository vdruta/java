package ro.vdruta.views;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ro.vdruta.controlers.MissionController;
import ro.vdruta.controlers.PlayerController;
import ro.vdruta.models.Mission;
import ro.vdruta.models.characters.Goblin;
import ro.vdruta.models.characters.Hero;
import ro.vdruta.models.characters.Knight;
import ro.vdruta.models.characters.Villain;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author MM
 */
public class MissionView extends javax.swing.JPanel implements Observer{

    PlayerController playerController;
    MissionController missionController;
    /**
     * Creates new form MissionView
     */
    public MissionView(String playerName, String heroType, String heroName) {

        playerController = new PlayerController(playerName, heroType, heroName);
        Hero hero = playerController.getPlayer().getHero();
        hero.printStats();
        hero.addObserver(this);
        missionController = new MissionController(new Mission("Mission 1: Beat 7 necromancers", "necromancer", 7, hero));
        for (int i = 0; i < missionController.getMission().getMonstersCount(); i++)
            missionController.getMission().getNecromancers()[i].addObserver(this);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel1.setText(missionController.getMissionName());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Will the hero win?\n");
        jTextArea1.append(" ... take a look in the console\n");
        missionController.getMission().fightHerovsNecromancer();
        if (playerController.getPlayer().getHero().getHealth() > 0)
            this.jTextArea1.append(playerController.getPlayer().getUsername() + " WIN! \nLevel UP");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Hero) {
            this.jTextArea1.append("Necromancer hit " + missionController.getMission().getHero().getName() + " with " + arg + " damage" + "\n");
        }
        if (o instanceof Villain)
            this.jTextArea1.append(missionController.getMission().getHero().getName() + " hit necromancer with " + arg + "\n");
    }
    // End of variables declaration
}
