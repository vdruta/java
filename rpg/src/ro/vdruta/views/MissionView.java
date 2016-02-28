package ro.vdruta.views;

import ro.vdruta.controlers.MissionController;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by MM on 2016-02-28.
 */
public class MissionView extends javax.swing.JPanel implements Observer {
    MissionController missionController;

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update detected");
    }
}
