package com.example.polyglottal_calculator2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Credentials;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import io.realm.Realm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextTargetWeight;
    private DatePicker mTargetDate;
    private EditText mEditTextWeight;
    private EditText mEditTextHeight;
    private EditText mEditTextName;
    private EditText mEditTextAge;
    private Spinner mSpinnerGender;
    private Spinner mSpinnerActivity;
    private Button mButtonCalc;
    private Button mButtonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);

        mEditTextWeight = findViewById(R.id.input_weight);
        mEditTextTargetWeight = findViewById(R.id.target_weight);
        mTargetDate = findViewById(R.id.target_date);

        mEditTextHeight = findViewById(R.id.input_height);
        mEditTextName = findViewById(R.id.input_name);
        mEditTextAge = findViewById(R.id.input_age);
        mSpinnerGender = findViewById(R.id.input_gender);
        mSpinnerActivity = findViewById(R.id.activity_level);

        mButtonCalc = findViewById(R.id.calc_button);
        mButtonSave = findViewById(R.id.save_button);


        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TrainerrModel trainerrModel;
                try {
                    trainerrModel = new TrainerrModel(1,
                            Integer.parseInt(mEditTextTargetWeight.getText().toString()),
                            Integer.parseInt(mEditTextWeight.getText().toString()),
                            mEditTextName.getText().toString(),
                            Integer.parseInt(mEditTextHeight.getText().toString()),
                            Integer.parseInt(mEditTextAge.getText().toString()),
                            mSpinnerGender.getSelectedItem().toString(),
                            mSpinnerActivity.getSelectedItem().toString());

                    Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error creating trainee", Toast.LENGTH_SHORT).show();
                    trainerrModel = new TrainerrModel(-1, 0, 0, "error", 0, 0, "error", "error");
                }
                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                boolean success = dataBaseHelper.addOne(trainerrModel);
            }
        });

        mButtonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weight = Integer.parseInt(mEditTextWeight.getText().toString());
                int targetWeight = Integer.parseInt(mEditTextTargetWeight.getText().toString());
                int weightDiff = targetWeight - weight;
                int calNeeded = 7200 * weightDiff;
                System.out.println(targetWeight);

                Calendar calenderCur = Calendar.getInstance();
                Date curDate = calenderCur.getTime();

                int day = mTargetDate.getDayOfMonth();
                int month = mTargetDate.getMonth();
                int year = mTargetDate.getYear();
                Calendar calender = Calendar.getInstance();
                calender.set(year, month, day);
                Date targetDate = calender.getTime();

                long dateDiff = targetDate.getTime() - curDate.getTime();

                long difference_In_Days
                        = (dateDiff
                        / (1000 * 60 * 60 * 24))
                        % 365;

                double dailyCal = calNeeded / difference_In_Days;
                int height = Integer.parseInt(mEditTextHeight.getText().toString());
                int age = Integer.parseInt(mEditTextAge.getText().toString());
                String name = mEditTextName.getText().toString();
                Boolean isMale = mSpinnerGender.getSelectedItem().toString().equals("Male");
                String activity = mSpinnerActivity.getSelectedItem().toString();
                double bmr;
                double coefficient;

                if (activity.equals("Sedantary")) {
                    coefficient = 1.2;
                } else if (activity.equals("Light activity")) {
                    coefficient = 1.375;
                } else if (activity.equals(("Moderate Activity"))) {
                    coefficient = 1.55;
                } else if (activity.equals("Very Active")) {
                    coefficient = 1.9;
                } else {
                    coefficient = 1.0;
                }

                if (isMale) {
                    bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
                } else {
                    bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
                }

                double amr = coefficient * bmr;
                double dailyCalTotal = amr + dailyCal;
                String dailyCalTotalStr = String.format("%4.0f", dailyCalTotal);
                System.out.println(dailyCalTotal);

                        Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("targetCalorie", dailyCalTotalStr);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }
}