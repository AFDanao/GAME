package com.example.testgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;


public class GameActivity2 extends AppCompatActivity {

    TextView txtChip;

    int intChip;

    ImageView cardOne;
    ImageView cardTwo;
    ImageView cardThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        int [] cards = {
                R.drawable.ace_heart,
                R.drawable.two_heart,
                R.drawable.three_heart,
                R.drawable.four_heart,
                R.drawable.five_heart,
                R.drawable.six_heart,
                R.drawable.seven_heart,
                R.drawable.eight_heart,
                R.drawable.nine_heart,
                R.drawable.ten_heart,
                R.drawable.jack_heart,
                R.drawable.queen_heart,
                R.drawable.king_heart
        };

        EditText editInput = findViewById(R.id.editInput);

        TextView loseText = findViewById(R.id.loseText);
        TextView winText = findViewById(R.id.winText);
        TextView hiLow = findViewById(R.id.highLowText);
        txtChip = findViewById(R.id.chipNumberText);
        intChip = Integer.parseInt(txtChip.getText().toString());

        cardOne = findViewById(R.id.cardOne);
        cardTwo = findViewById(R.id.cardTwo);
        cardThree = findViewById(R.id.cardThree);

        Button startButton = findViewById(R.id.startButton);
        Button btnDeal = findViewById(R.id.btnDeal);
        Button btnNoDeal = findViewById(R.id.btnNoDeal);
        Button lowerButton = findViewById(R.id.lowerButton);
        Button higherButton = findViewById(R.id.higherButton);

        btnDeal.setEnabled(false);
        btnNoDeal.setEnabled(false);
        lowerButton.setEnabled(false);
        higherButton.setEnabled(false);

        loseText.setAlpha(0);
        winText.setAlpha(0);
        hiLow.setAlpha(0);
        btnDeal.setAlpha(0);
        btnNoDeal.setAlpha(0);
        lowerButton.setAlpha(0);
        higherButton.setAlpha(0);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ran1 = (int) (Math.random() * 13);
                int ran2 = (int) (Math.random() * 13);

                loseText.setAlpha(0);
                winText.setAlpha(0);

                btnDeal.setAlpha(1);
                btnNoDeal.setAlpha(1);

                btnDeal.setEnabled(true);
                btnNoDeal.setEnabled(true);

                lowerButton.setAlpha(0);
                higherButton.setAlpha(0);

                lowerButton.setEnabled(false);
                higherButton.setEnabled(false);

                cardOne.setImageResource(cards[ran1]);
                cardTwo.setImageResource(cards[ran2]);

                startButton.setEnabled(false);

                btnDeal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btnDeal.setEnabled(false);
                        btnNoDeal.setEnabled(false);

                        int ran3 = (int) (Math.random() * 14);

                        if (((ran3 > ran1) && (ran3 < ran2)) || ((ran3 > ran2) && (ran3 < ran1))) {
//                            txtChip.setText(String.valueOf(intChip + bet));
                            winText.setAlpha(1);

                            cardThree.setImageResource(cards[ran3]);

                            startButton.setEnabled(true);

                            btnDeal.setAlpha(0);
                            btnNoDeal.setAlpha(0);

                            inc(true, Integer.parseInt(editInput.getText().toString()));

                        } else if (ran1 == ran2) {
                            lowerButton.setAlpha(1);
                            higherButton.setAlpha(1);

                            btnDeal.setAlpha(0);
                            btnNoDeal.setAlpha(0);

                            lowerButton.setEnabled(true);
                            higherButton.setEnabled(true);

                            lowerButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if (ran3 < ran1) {
                                        winText.setAlpha(1);
                                        inc(true, Integer.parseInt(editInput.getText().toString()));
                                    } else {
                                        loseText.setAlpha(1);
                                        inc(false, Integer.parseInt(editInput.getText().toString()));
                                    }
                                    cardThree.setImageResource(cards[ran3]);
                                    startButton.setEnabled(true);
                                }
                            });

                            higherButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if (ran3 > ran1) {
                                        winText.setAlpha(1);
                                        inc(true, Integer.parseInt(editInput.getText().toString()));
                                    } else {
                                        loseText.setAlpha(1);
                                        inc(false, Integer.parseInt(editInput.getText().toString()));
                                    }
                                    cardThree.setImageResource(cards[ran3]);
                                    startButton.setEnabled(true);
                                }
                            });
                        } else {
                            loseText.setAlpha(1);

                            cardThree.setImageResource(cards[ran3]);

                            startButton.setEnabled(true);

                            btnDeal.setAlpha(0);
                            btnNoDeal.setAlpha(0);

                            inc(false, Integer.parseInt(editInput.getText().toString()));
                        }
                    }
                });

                btnNoDeal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        loseText.setAlpha(1);

                        btnDeal.setEnabled(false);
                        btnNoDeal.setEnabled(false);

                        btnDeal.setAlpha(0);
                        btnNoDeal.setAlpha(0);

                        startButton.setEnabled(true);

                        inc(false, Integer.parseInt(editInput.getText().toString()));
                    }
                });
            }
        });
    }

    public void inc(Boolean x, int bet) {
        if (intChip > 0) {
            if (x) {
                txtChip.setText(String.valueOf(intChip += bet));
            } else {
                txtChip.setText(String.valueOf(intChip -= bet));
            }
        } else {
            createNewDialog();
        }
    }

    public void createNewDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        final View popupView = getLayoutInflater().inflate(R.layout.popup, null);

        Button btnChange = popupView.findViewById(R.id.btnChange);
        Button btnRetry = popupView.findViewById(R.id.btnRetry);

        TextView txtOutCome = popupView.findViewById(R.id.txtOutCome);

        GifImageView imgOutCome = popupView.findViewById(R.id.imgOutCome);

        txtOutCome.setText(R.string.txtLost);
        imgOutCome.setImageResource(R.drawable.lose);

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
                txtChip.setText("1000");
                intChip = 1000;

                dialog.dismiss();
            }
        });
    }
}
