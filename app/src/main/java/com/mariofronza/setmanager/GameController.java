package com.mariofronza.setmanager;

import com.mariofronza.setmanager.data.Game;
import com.mariofronza.setmanager.data.Set;

public class GameController {

    private Game game;
    private int firstTeamPoints;
    private int secondTeamPoints;
    private int totalSetsFirstTeam;
    private int totalSetsSecondTeam;
    private Set currentSet;

    public GameController(Game game) {
        this.game = game;
        this.firstTeamPoints = 0;
        this.secondTeamPoints = 0;
        this.currentSet = game.getCurrentSet();
    }

    private void incrementFirstTeamPoint() {
        firstTeamPoints++;
    }

    private void incrementSecondTeamPoint() {
        secondTeamPoints++;
    }

    private void verifyWinner() {
        if (firstTeamPoints == 25) {
        } else if (secondTeamPoints == 25) {
        }
    }


}
