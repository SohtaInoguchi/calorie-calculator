package com.example.polyglottal_calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    private TextView mTargetCal;
    private Button mDisplayButton;
    private ListView mTraineeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        mDisplayButton = findViewById(R.id.display_button);
        mTargetCal = findViewById(R.id.targetCal);
        mTraineeList = findViewById(R.id.lv_traineeList);

        Intent intent = getIntent();
        String str = intent.getStringExtra("targetCalorie");
        String nameStr = intent.getStringExtra("name");

        mTargetCal.setText("Daily target: " + str + " kcal");

        mDisplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper = new DataBaseHelper(DisplayActivity.this);
                List<TrainerrModel> everyone = dataBaseHelper.getEveryone(nameStr);
                ArrayAdapter traineeArrayAdapter = new ArrayAdapter<TrainerrModel>(DisplayActivity.this, android.R.layout.simple_list_item_1, everyone);
                mTraineeList.setAdapter((traineeArrayAdapter));
//                Toast.makeText(DisplayActivity.this, everyone.toString(), Toast.LENGTH_SHORT).show();


            }
        });
    }


}