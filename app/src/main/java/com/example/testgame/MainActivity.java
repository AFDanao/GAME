package com.example.testgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                finish();
            }
        });
    }
}