package com.example.testgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnTest = findViewById(R.id.btnStart);

        TranslateAnimation animation = new TranslateAnimation(0.0f, 0.0f, btnTest.getY() + 10.0f,  btnTest.getY() - 10.0f);

        animation.setDuration(2000);
        animation.setRepeatCount(-1);
        animation.setRepeatMode(2);

        animation.setFillAfter(true);
        btnTest.startAnimation(animation);

        btnTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity2.class));
        finish();
    }
}