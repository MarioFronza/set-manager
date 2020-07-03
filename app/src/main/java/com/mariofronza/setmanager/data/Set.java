package com.mariofronza.setmanager.data;

import java.io.Serializable;

public class Set implements Serializable {

    private boolean isFinal;
    private int firstTeamPoints;
    private int secondTeamPoints;

    public Set(boolean isFinal) {
        this.isFinal = isFinal;
        this.firstTeamPoints = 0;
        this.secondTeamPoints = 0;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public int getFirstTeamPoints() {
        return firstTeamPoints;
    }

    public void setFirstTeamPoints(int firstTeamPoints) {
        this.firstTeamPoints = firstTeamPoints;
    }

    public int getSecondTeamPoints() {
        return secondTeamPoints;
    }

    public void setSecondTeamPoints(int secondTeamPoints) {
        this.secondTeamPoints = secondTeamPoints;
    }

    public void incrementFirstTeamPoint() {
        this.firstTeamPoints++;
    }

    public void incrementSecondTeamPoint() {
        this.secondTeamPoints++;
    }
}
