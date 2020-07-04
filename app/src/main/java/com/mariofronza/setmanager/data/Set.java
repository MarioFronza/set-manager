package com.mariofronza.setmanager.data;

import java.io.Serializable;

public class Set implements Serializable {

    private boolean isFinal;
    private int firstTeamPoints;
    private int secondTeamPoints;
    private String firstTeamName;
    private String secondTeamName;
    private String winnerName;

    public Set(boolean isFinal) {
        this.isFinal = isFinal;
        this.firstTeamPoints = 0;
        this.secondTeamPoints = 0;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public int getFirstTeamPoints() {
        return firstTeamPoints;
    }

    public int getSecondTeamPoints() {
        return secondTeamPoints;
    }

    public String getFirstTeamName() {
        return firstTeamName;
    }

    public void setFirstTeamName(String firstTeamName) {
        this.firstTeamName = firstTeamName;
    }

    public String getSecondTeamName() {
        return secondTeamName;
    }

    public void setSecondTeamName(String secondTeamName) {
        this.secondTeamName = secondTeamName;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public void incrementFirstTeamPoint() {
        this.firstTeamPoints++;
    }

    public void incrementSecondTeamPoint() {
        this.secondTeamPoints++;
    }
}
