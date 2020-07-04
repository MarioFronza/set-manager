package com.mariofronza.setmanager;

import com.mariofronza.setmanager.data.Game;
import com.mariofronza.setmanager.data.Set;
import com.mariofronza.setmanager.data.Team;
import com.mariofronza.setmanager.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    protected Game game;
    protected int totalSetsFirstTeam;
    protected int totalSetsSecondTeam;
    protected Set currentSet;
    protected List<Observer> observerList;

    public GameController(Game game) {
        this.game = game;
        this.currentSet = game.getCurrentSet();
        this.observerList = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
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

    private void newSet(Team winnerTeam) {
        if (!currentSet.isFinal() && totalSetsFirstTeam < 3 && totalSetsSecondTeam < 3) {
            currentSet.setFirstTeamName(game.getFirstTeam().getName());
            currentSet.setSecondTeamName(game.getSecondTeam().getName());
            currentSet.setWinnerName(winnerTeam.getName());
            notifyNewSetPast(currentSet);
            game.removeSet();
            currentSet = game.getCurrentSet();
        } else {
            notifyGameOver(winnerTeam);
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

    private void notifyNewSetPast(Set pastSet) {
        for (Observer observer : observerList) {
            observer.addNewPastSet(pastSet);
        }
    }

    private void notifyGameOver(Team winner) {
        for (Observer observer : observerList) {
            observer.gameOver(winner);
        }
    }

}
