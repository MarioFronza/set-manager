package com.mariofronza.setmanager;

import com.mariofronza.setmanager.data.Game;
import com.mariofronza.setmanager.data.Team;

import org.junit.Test;

import static org.junit.Assert.*;


public class GameControllerTest {

    @Test
    public void testTeamPoints() {
        String hour = "10:00";
        Team firstTeam = new Team("First Team");
        Team secondTeam = new Team("Second Team");
        Game game = new Game(hour, firstTeam, secondTeam);
        game.createSets();
        GameController gameController = new GameController(game);

        gameController.incrementFirstTeamPoint();
        gameController.incrementFirstTeamPoint();
        gameController.incrementFirstTeamPoint();

        gameController.incrementSecondTeamPoint();
        gameController.incrementSecondTeamPoint();
        gameController.incrementSecondTeamPoint();
        gameController.incrementSecondTeamPoint();

        assertEquals(gameController.currentSet.getFirstTeamPoints(), 3);
        assertEquals(gameController.currentSet.getSecondTeamPoints(), 4);
    }

    @Test
    public void testSetPoints() {
        String hour = "10:00";
        Team firstTeam = new Team("First Team");
        Team secondTeam = new Team("Second Team");
        Game game = new Game(hour, firstTeam, secondTeam);
        game.createSets();
        GameController gameController = new GameController(game);

        for (int i = 0; i < 25 * 2; i++) {
            gameController.incrementFirstTeamPoint();
        }

        for (int i = 0; i < 25 * 2; i++) {
            gameController.incrementSecondTeamPoint();
        }

        assertEquals(gameController.totalSetsFirstTeam, 2);
        assertEquals(gameController.totalSetsSecondTeam, 2);
        assertTrue(gameController.currentSet.isFinal());
    }


}