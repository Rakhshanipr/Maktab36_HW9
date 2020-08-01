package com.example.hw9.Calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.hw9.R;

public class MainCalculatorActivity extends AppCompatActivity {
    //region initialization
    Button mButton1;
    Button mButton2;
    Button mButton3;
    Button mButton4;
    Button mButton5;
    Button mButton6;
    Button mButton7;
    Button mButton8;
    Button mButton9;
    Button mButto0;
    Button mButtonDevide;
    Button mButtonPlus;
    Button mButtonMultiple;
    Button mButtonMinus;
    Button mButtonDelete;



    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);
    }
}