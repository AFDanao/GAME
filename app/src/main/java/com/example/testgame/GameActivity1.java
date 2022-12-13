package com.example.testgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class GameActivity1 extends AppCompatActivity {

    TextView txtAIScore;
    TextView txtPlayerScore;
    TextView txtLogic;

    ImageView imgAI;
    ImageView imgPlayer;

    ImageButton btnRock;
    ImageButton btnPaper;
    ImageButton btnScissors;

    int y;
    int z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

        txtAIScore = findViewById(R.id.txtAIScore);
        txtPlayerScore = findViewById(R.id.txtPlayerScore);
        txtLogic = findViewById(R.id.txtLogic);

        imgAI = findViewById(R.id.imgAI);
        imgPlayer = findViewById(R.id.imgPlayer);

        btnRock = findViewById(R.id.btnRock);
        btnPaper = findViewById(R.id.btnPaper);
        btnScissors = findViewById(R.id.btnScissors);

        y = Integer.parseInt(txtAIScore.getText().toString());
        z = Integer.parseInt(txtPlayerScore.getText().toString());
    }

    public void btnBack(View v) {
        finish();
    }

    public void createNewDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        final View popupView = getLayoutInflater().inflate(R.layout.popup, null);

        Button btnChange = popupView.findViewById(R.id.btnChange);
        Button btnRetry = popupView.findViewById(R.id.btnRetry);

        TextView txtOutCome = popupView.findViewById(R.id.txtOutCome);

        GifImageView imgOutcome = popupView.findViewById(R.id.imgOutCome);

        if (y == 10) {
            imgOutcome.setImageResource(R.drawable.lose);
            txtOutCome.setText(R.string.txtLost);
        } else {
            imgOutcome.setImageResource(R.drawable.win);
            txtOutCome.setText(R.string.txtWon);
        }

        dialogBuilder.setView(popupView);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnRock.setEnabled(true);
                btnPaper.setEnabled(true);
                btnScissors.setEnabled(true);

                txtLogic.setText("");
                txtAIScore.setText(R.string.txtZeros);
                txtPlayerScore.setText(R.string.txtZeros);

                imgAI.setImageResource(R.drawable.question_mark);
                imgPlayer.setImageResource(R.drawable.question_mark);

                y = 0;
                z = 0;
                dialog.dismiss();
            }
        });
    }

    public void inc(Boolean x) {

        if (x) {
            y++;
            txtAIScore.setText(String.valueOf(y));
        } else {
            z++;
            txtPlayerScore.setText(String.valueOf(z));
        }

        if (y == 10) {
            btnRock.setEnabled(false);
            btnPaper.setEnabled(false);
            btnScissors.setEnabled(false);
            createNewDialog();
        } else if (z == 10) {
            btnRock.setEnabled(false);
            btnPaper.setEnabled(false);
            btnScissors.setEnabled(false);
            createNewDialog();
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
            imgAI.setImageResource(R.drawable.scissors);
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
            imgAI.setImageResource(R.drawable.scissors);
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
            imgPlayer.setImageResource(R.drawable.scissors);
            imgAI.setImageResource(R.drawable.scissors);
            txtLogic.setText(R.string.txtBoth);
        } else if (ranInt == 1) {
            imgPlayer.setImageResource(R.drawable.scissors);
            imgAI.setImageResource(R.drawable.rock);
            txtLogic.setText(R.string.txtWonRock);
            inc(true);
        } else if (ranInt == 2) {
            imgPlayer.setImageResource(R.drawable.scissors);
            imgAI.setImageResource(R.drawable.paper);
            txtLogic.setText(R.string.txtWonScissors);
            inc(false);
        }
    }
}