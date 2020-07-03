package com.mariofronza.setmanager.data;

import java.io.Serializable;
import java.util.List;

public class Game implements Serializable {

    private String hour;
    private Team firstTeam;
    private Team secondTeam;
    private List<Set> sets;

    public Game(String hour, Team firstTeam, Team secondTeam, List<Set> sets) {
        this.hour = hour;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.sets = sets;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }

    public Set getCurrentSet() {
        return this.sets.get(0);
    }

    public void removeSet() {
        this.sets.remove(0);
    }

}
