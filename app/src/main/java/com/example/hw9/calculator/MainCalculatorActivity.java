package com.example.hw9.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.hw9.R;
import com.example.hw9.calculator.fragments.ButtonsFragment;
import com.example.hw9.calculator.fragments.EditTextFragment;

public class MainCalculatorActivity extends AppCompatActivity {
    //region initialization

    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.fragment_container_edittext, new EditTextFragment())
                .add(R.id.fragment_container_buttons, new ButtonsFragment())
                .commit();
    }
}