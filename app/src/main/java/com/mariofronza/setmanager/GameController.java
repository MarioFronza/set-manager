package com.mariofronza.setmanager;

import com.mariofronza.setmanager.data.Game;
import com.mariofronza.setmanager.data.Set;
import com.mariofronza.setmanager.data.Team;
import com.mariofronza.setmanager.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private Game game;
    private int totalSetsFirstTeam;
    private int totalSetsSecondTeam;
    private Set currentSet;

    private List<Observer> observerList;

    public GameController(Game game) {
        this.game = game;

        this.currentSet = game.getCurrentSet();
        this.observerList = new ArrayList<>();
    }

    void addObserver(Observer observer) {
        this.observerList.add(observer);
    }


    public void incrementFirstTeamPoint() {
        currentSet.incrementFirstTeamPoint();
        notifyUpdateFirstTeamPoint();
        verifyWinner();
    }

    public void incrementSecondTeamPoint() {
        currentSet.incrementSecondTeamPoint();
        notifyUpdateSecondTeamPoint();
        verifyWinner();
    }

    private void verifyWinner() {
        int totalSetPoints = !currentSet.isFinal() ? 25 : 15;
        int firstTeamPoints = currentSet.getFirstTeamPoints();
        int secondTeamPoints = currentSet.getSecondTeamPoints();

        if (firstTeamPoints >= totalSetPoints) {
            if (firstTeamPoints - secondTeamPoints >= 2) {
                totalSetsFirstTeam++;
                notifyFirstTeamWon();
                newSet(game.getFirstTeam());
            }
        } else if (secondTeamPoints >= totalSetPoints) {
            if (secondTeamPoints - firstTeamPoints >= 2) {
                totalSetsSecondTeam++;
                notifySecondTeamWon();
                newSet(game.getSecondTeam());
            }
        }
    }

    private void newSet(Team team) {
        if (!currentSet.isFinal() && totalSetsFirstTeam < 3 && totalSetsSecondTeam < 3) {
            game.removeSet();
            currentSet = game.getCurrentSet();
            notifyUpdateFirstTeamPoint();
            notifyUpdateSecondTeamPoint();
        } else {
            notifyGameOver(team);
        }
    }

    private void notifyUpdateFirstTeamPoint() {
        for (Observer observer : observerList) {
            observer.updateFirstTeamPoint(currentSet.getFirstTeamPoints());
        }
    }

    private void notifyUpdateSecondTeamPoint() {
        for (Observer observer : observerList) {
            observer.updateSecondTeamPoint(currentSet.getSecondTeamPoints());
        }
    }

    private void notifyFirstTeamWon() {
        for (Observer observer : observerList) {
            observer.firstTeamWon(totalSetsFirstTeam);
        }
    }

    private void notifySecondTeamWon() {
        for (Observer observer : observerList) {
            observer.secondTeamWon(totalSetsSecondTeam);
        }
    }

    private void notifyGameOver(Team winner) {
        for (Observer observer : observerList) {
            observer.gameOver(winner);
        }
    }


}
