package com.example.testgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageButton btnGame1 = findViewById(R.id.btnGame1);
        ImageButton btnGame2 = findViewById(R.id.btnGame2);

        btnGame1.setOnClickListener(this);
        btnGame2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnGame1) {
            Intent game1 = new Intent(getApplicationContext(), GameActivity1.class);
            startActivity(game1);
        } else if (view.getId() == R.id.btnGame2) {
            Intent game2 = new Intent(getApplicationContext(), GameActivity2.class);
            startActivity(game2);
        }
    }
}