package com.mariofronza.setmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.mariofronza.setmanager.data.Game;
import com.mariofronza.setmanager.data.Team;
import com.mariofronza.setmanager.observer.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private TextView tvHour;
    private TextView tvFirstPlayer;
    private TextView tvSecondPlayer;
    private TextView tvFirstIncrementPoint;
    private TextView tvSecondIncrementPoint;
    private TextView tvFirstSetPointsTotal;
    private TextView tvSecondSetPointsTotal;

    private Game game;
    private GameController gameController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = (Game) getIntent().getSerializableExtra("game");
        gameController = new GameController(game);
        gameController.addObserver(this);

        Button btnCancel = findViewById(R.id.btnCancel);
        ImageButton btnFirstIncrementPoint = findViewById(R.id.btnFirstIncrementPoint);
        ImageButton btnSecondIncrementPoint = findViewById(R.id.btnSecondIncrementPoint);

        tvHour = findViewById(R.id.tvHour);
        tvFirstPlayer = findViewById(R.id.tvFirstPlayer);
        tvSecondPlayer = findViewById(R.id.tvSecondPlayer);
        tvFirstIncrementPoint = findViewById(R.id.tvFirstIncrementPoint);
        tvSecondIncrementPoint = findViewById(R.id.tvSecondIncrementPoint);
        tvFirstSetPointsTotal = findViewById(R.id.tvFirstSetPointsTotal);
        tvSecondSetPointsTotal = findViewById(R.id.tvSecondSetPointsTotal);

        initGameComponents();
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToInitGameActivity();
            }
        });

        btnFirstIncrementPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameController.incrementFirstTeamPoint();
            }
        });

        btnSecondIncrementPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameController.incrementSecondTeamPoint();
            }
        });
    }

    private void goToInitGameActivity() {
        startActivity(new Intent(this, InitGameActivity.class));
    }

    private void initGameComponents() {
        tvHour.setText(game.getHour());
        tvFirstPlayer.setText(game.getFirstTeam().getName());
        tvSecondPlayer.setText(game.getSecondTeam().getName());
        tvFirstIncrementPoint.setText("0");
        tvSecondIncrementPoint.setText("0");
        tvFirstSetPointsTotal.setText("0");
        tvSecondSetPointsTotal.setText("0");
    }

    @Override
    public void updateFirstTeamPoint(int firstTeamPoints) {
        tvFirstIncrementPoint.setText(Integer.toString(firstTeamPoints));
    }

    @Override
    public void updateSecondTeamPoint(int secondTeamPoints) {
        tvSecondIncrementPoint.setText(Integer.toString(secondTeamPoints));
    }

    @Override
    public void firstTeamWon(int firstSetPoints) {
        tvFirstSetPointsTotal.setText(Integer.toString(firstSetPoints));
    }

    @Override
    public void secondTeamWon(int secondSetPoints) {
        tvSecondSetPointsTotal.setText(Integer.toString(secondSetPoints));
    }

    @Override
    public void gameOver(Team winner) {
        Toast.makeText(this, "O time " + winner.getName() + " venceu!", Toast.LENGTH_SHORT).show();
        goToInitGameActivity();
    }
}