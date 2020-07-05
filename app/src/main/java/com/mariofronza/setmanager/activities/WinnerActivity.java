package com.mariofronza.setmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mariofronza.setmanager.R;
import com.mariofronza.setmanager.data.Game;

public class WinnerActivity extends AppCompatActivity {

    private TextView tvWinnerName;
    private Button btnRestartGame;
    private String winnerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        winnerName = getIntent().getStringExtra("winnerName");

        tvWinnerName = findViewById(R.id.tvWinnerName);
        btnRestartGame = findViewById(R.id.btnRestartGame);

        tvWinnerName.setText("O Time " + winnerName + " venceu o jogo");

        btnRestartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToInitGameActivity();
            }
        });
    }

    private void goToInitGameActivity() {
        startActivity(new Intent(this, InitGameActivity.class));
    }
}