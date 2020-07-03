package com.mariofronza.setmanager.observer;

import com.mariofronza.setmanager.data.Team;

public interface Observer {

    void updateFirstTeamPoint(int firstTeamPoints);

    void updateSecondTeamPoint(int secondTeamPoints);

    void firstTeamWon(int firstSetPoints);

    void secondTeamWon(int secondSetPoints);

    void gameOver(Team winner);

}
