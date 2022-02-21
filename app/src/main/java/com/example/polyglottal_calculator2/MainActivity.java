package com.example.polyglottal_calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText1;
    private EditText mEditText2;
    private TextView mTextViewResult;
    private Button mButtonCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = findViewById(R.id.input_weight);
        mEditText2 = findViewById(R.id.input_height);
        mTextViewResult = findViewById(R.id.result);
        mButtonCalc = findViewById(R.id.calc_button);

        mButtonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(mEditText1.getText().toString());
                int num2 = Integer.parseInt(mEditText2.getText().toString());
                int sum = num1 + num2;
                mTextViewResult.setText(String.valueOf(sum));
            }
        });
    }
}