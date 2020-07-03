package com.mariofronza.setmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mariofronza.setmanager.data.Game;

public class MainActivity extends AppCompatActivity {

    private TextView tvHour;
    private TextView tvFirstPlayer;
    private TextView tvSecondPlayer;
    private TextView tvFirstIncrementPoint;
    private TextView tvSecondIncrementPoint;
    private TextView tvFirstSetPointsTotal;
    private TextView tvSecondFirstSetPointsTotal;

    private ImageButton btnFirstIncrementPoint;
    private ImageButton btnSecondIncrementPoint;

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = (Game) getIntent().getSerializableExtra("game");

        Button btnCancel = findViewById(R.id.btnCancel);

        tvHour = findViewById(R.id.tvHour);
        tvFirstPlayer = findViewById(R.id.tvFirstPlayer);
        tvSecondPlayer = findViewById(R.id.tvSecondPlayer);
        tvFirstIncrementPoint = findViewById(R.id.tvFirstIncrementPoint);
        tvSecondIncrementPoint = findViewById(R.id.tvSecondIncrementPoint);
        tvFirstSetPointsTotal = findViewById(R.id.tvFirstSetPointsTotal);
        tvSecondFirstSetPointsTotal = findViewById(R.id.tvSecondFirstSetPointsTotal);
        btnFirstIncrementPoint = findViewById(R.id.btnFirstIncrementPoint);
        btnSecondIncrementPoint = findViewById(R.id.btnSecondIncrementPoint);

        initGameComponents();
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToInitGameActivity();
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
        tvSecondFirstSetPointsTotal.setText("0");
    }
}