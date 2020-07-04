package com.mariofronza.setmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mariofronza.setmanager.R;
import com.mariofronza.setmanager.data.Game;
import com.mariofronza.setmanager.data.Set;
import com.mariofronza.setmanager.data.Team;

import java.util.ArrayList;
import java.util.List;

public class InitGameActivity extends AppCompatActivity {

    private EditText etHour;
    private EditText etFirstTeam;
    private EditText etSecondTeam;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_game);

        Button btnInitGame = findViewById(R.id.btnInitGame);

        etHour = findViewById(R.id.etHour);
        etFirstTeam = findViewById(R.id.etFirstTeam);
        etSecondTeam = findViewById(R.id.etSecondTeam);

        btnInitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateFields();
            }
        });
    }

    private void validateFields() {
        String hourText = etHour.getText().toString();
        String firstTeamName = etFirstTeam.getText().toString();
        String secondTeamName = etSecondTeam.getText().toString();

        if (hourText.isEmpty() || firstTeamName.isEmpty() || secondTeamName.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        } else {
            Team firstTeam = new Team(firstTeamName);
            Team secondTeam = new Team(secondTeamName);
            populateSetsAndCreateGame(hourText, firstTeam, secondTeam);
        }
    }

    private void populateSetsAndCreateGame(String hourText, Team firstTeam, Team secondTeam) {
        List<Set> sets = new ArrayList<>();

        sets.add(new Set(false));
        sets.add(new Set(false));
        sets.add(new Set(false));
        sets.add(new Set(false));
        sets.add(new Set(true));

        game = new Game(hourText, firstTeam, secondTeam, sets);

        initGame();
    }

    private void initGame() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("game", game);
        startActivity(intent);
    }

}