package com.example.testgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity1 extends AppCompatActivity {

    TextView txtAIScore;
    TextView txtPlayerScore;
    TextView txtOutCome;
    TextView txtLogic;

    ImageView imgAI;
    ImageView imgPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

        txtAIScore = findViewById(R.id.txtAIScore);
        txtPlayerScore = findViewById(R.id.txtPlayerScore);
        txtOutCome = findViewById(R.id.txtOutCome);
        txtLogic = findViewById(R.id.txtLogic);

        imgAI = findViewById(R.id.imgAI);
        imgPlayer = findViewById(R.id.imgPlayer);
    }

    public void inc(Boolean x) {
        ImageButton btnRock = findViewById(R.id.btnRock);
        ImageButton btnPaper = findViewById(R.id.btnPaper);
        ImageButton btnScissors = findViewById(R.id.btnScissors);

        int y = Integer.parseInt(txtAIScore.getText().toString());
        int z = Integer.parseInt(txtPlayerScore.getText().toString());

        if (x) {
            y++;
            txtAIScore.setText(String.valueOf(y));
        } else {
            z++;
            txtPlayerScore.setText(String.valueOf(z));
        }

        if (y == 10) {
            txtOutCome.setText(R.string.txtLost);
            btnRock.setEnabled(false);
            btnPaper.setEnabled(false);
            btnScissors.setEnabled(false);
        } else if (z == 10) {
            txtOutCome.setText(R.string.txtWon);
            btnRock.setEnabled(false);
            btnPaper.setEnabled(false);
            btnScissors.setEnabled(false);
        }
    }

    public void btnRock(View v) {
        int choice = 1;
        int ranInt = (int) (Math.random() * 4);

        if (ranInt == choice) {
            imgPlayer.setImageResource(R.drawable.rock);
            imgAI.setImageResource(R.drawable.rock);
            txtLogic.setText(R.string.txtBoth);
        } else if (ranInt == 2) {
            imgPlayer.setImageResource(R.drawable.rock);
            imgAI.setImageResource(R.drawable.paper);
            txtLogic.setText(R.string.txtWonPaper);
            inc(true);
        } else if (ranInt == 3) {
            imgPlayer.setImageResource(R.drawable.rock);
            imgAI.setImageResource(R.drawable.start); // SCISSORS
            txtLogic.setText(R.string.txtWonRock);
            inc(false);
        }
    }

    public void btnPaper(View v) {
        int choice = 2;
        int ranInt = (int) (Math.random() * 4);

        if (ranInt == choice) {
            imgPlayer.setImageResource(R.drawable.paper);
            imgAI.setImageResource(R.drawable.paper);
            txtLogic.setText(R.string.txtBoth);
        } else if (ranInt == 3) {
            imgPlayer.setImageResource(R.drawable.paper);
            imgAI.setImageResource(R.drawable.start); // SCISSORS
            txtLogic.setText(R.string.txtWonScissors);
            inc(true);
        } else if (ranInt == 1) {
            imgPlayer.setImageResource(R.drawable.paper);
            imgAI.setImageResource(R.drawable.rock);
            txtLogic.setText(R.string.txtWonPaper);
            inc(false);
        }
    }

    public void btnScissors(View v) {
        int choice = 3;
        int ranInt = (int) (Math.random() * 4);

        if (ranInt == choice) {
            imgPlayer.setImageResource(R.drawable.start);
            imgAI.setImageResource(R.drawable.start);
            txtLogic.setText(R.string.txtBoth);
        } else if (ranInt == 1) {
            imgPlayer.setImageResource(R.drawable.start);
            imgAI.setImageResource(R.drawable.rock);
            txtLogic.setText(R.string.txtWonRock);
            inc(true);
        } else if (ranInt == 2) {
            imgPlayer.setImageResource(R.drawable.start);
            imgAI.setImageResource(R.drawable.paper);
            txtLogic.setText(R.string.txtWonScissors);
            inc(false);
        }
    }
}