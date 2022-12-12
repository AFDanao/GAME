package com.example.testgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;



public class GameActivity2 extends AppCompatActivity {

    Button lowerButton;
    Button higherButton;
    Button startButton;
    TextView highLowText;
    TextView winText;
    TextView loseText;
    //TextView chipsText;
    TextView chipNumberText;
    ImageView cardOne;
    ImageView CardTwo;
    ImageView cardThree;

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


    //InBetween

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        //chipsText = findViewById(R.id.chipsText);
        chipNumberText = findViewById(R.id.chipNumberText);
        lowerButton = findViewById(R.id.lowerButton);
        higherButton = findViewById(R.id.higherButton);
        highLowText = findViewById(R.id.highLowText);
        winText = findViewById(R.id.winText);
        loseText = findViewById(R.id.loseText);
        startButton = findViewById(R.id.startButton);

        //Invisible
        winText.setAlpha(0);
        loseText.setAlpha(0);
        lowerButton.setAlpha(0);
        higherButton.setAlpha(0);
        highLowText.setAlpha(0);

    }

    public void onClick(View view) {
        Random rand = new Random();
        //0-11 cards
        cards = new int[12];

        chipNumberText.setText("1000");



        //papakita na yung cards
        switch (cards){
            case 1:
                cardOne = (ImageView) findViewById(cards)
        }

    }

    //Conditions
//    public void buttonHigher(){
//        if (cardThree > cardOne || cardThree < CardTwo) {
//            winText////
//
//        }
//        else {
//            loseText///
//        }
//    }
//
//    public void buttonLower(){
//        if (cardThree < cardOne || cardThree > CardTwo) {
//            winText///
//        }
//        else {
//            loseText
//        }
//    }


}
