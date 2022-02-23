package com.example.polyglottal_calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    private TextView mTargetCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        mTargetCal = findViewById(R.id.targetCal);

        Intent intent = getIntent();
        String str = intent.getStringExtra("targetCalorie");

        System.out.println(str);
        mTargetCal.setText("Daily target: " + str + " kcal");

    }
}