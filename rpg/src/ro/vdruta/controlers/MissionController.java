package ro.vdruta.controlers;

import ro.vdruta.models.Mission;

/**
 * Created by MM on 2016-02-28.
 */
public class MissionController {
    private Mission mission;

    public MissionController(Mission mission) {
        this.mission = mission;
    }

    public String getMissionName() {
        return mission.getName();
    }

    public Mission getMission() {
        return mission;
    }
}
