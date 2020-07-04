package com.mariofronza.setmanager.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {

    private String hour;
    private Team firstTeam;
    private Team secondTeam;
    private List<Set> sets;

    public Game(String hour, Team firstTeam, Team secondTeam) {
        this.hour = hour;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.sets = new ArrayList<>();
    }

    public String getHour() {
        return hour;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void createSets() {
        sets.add(new Set(false));
        sets.add(new Set(false));
        sets.add(new Set(false));
        sets.add(new Set(false));
        sets.add(new Set(true));
    }

    public Set getCurrentSet() {
        return sets.get(0);
    }

    public void removeSet() {
        sets.remove(0);
    }

}
