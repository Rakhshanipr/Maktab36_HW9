package com.example.hw9.calculator.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hw9.R;
import com.example.hw9.calculator.MainCalculatorActivity;

public class ButtonsFragment extends Fragment implements View.OnClickListener {
    //region initialization button
    Button mButton1;
    Button mButton2;
    Button mButton3;
    Button mButton4;
    Button mButton5;
    Button mButton6;
    Button mButton7;
    Button mButton8;
    Button mButton9;
    Button mButton0;
    Button mButtonDivide;
    Button mButtonPlus;
    Button mButtonMultiple;
    Button mButtonMinus;
    Button mButtonDelete;

    //endregion
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buttons, container, false);
        findAllViewsById(view);
        setOnclickListner();
//        EditText editText=view2.findViewById(R.id.edit_text_multiLine);
        EditTextFragment.setText("mohammad");
        return view;
    }

    private void setOnclickListner() {
        //region setOnclickListner for numric button
        mButton0.setOnClickListener(this);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);
        mButton7.setOnClickListener(this);
        mButton8.setOnClickListener(this);
        mButton9.setOnClickListener(this);
        //endregion

    }

    private void findAllViewsById(View view) {
        mButton0 = view.findViewById(R.id.button_0);
        mButton1 = view.findViewById(R.id.button_1);
        mButton2 = view.findViewById(R.id.button_2);
        mButton3 = view.findViewById(R.id.button_3);
        mButton4 = view.findViewById(R.id.button_4);
        mButton5 = view.findViewById(R.id.button_5);
        mButton6 = view.findViewById(R.id.button_6);
        mButton7 = view.findViewById(R.id.button_7);
        mButton8 = view.findViewById(R.id.button_8);
        mButton9 = view.findViewById(R.id.button_9);
        mButtonDelete = view.findViewById(R.id.button_delete);
        mButtonDivide = view.findViewById(R.id.button_divide);
        mButtonPlus = view.findViewById(R.id.button_plus);
        mButtonMinus = view.findViewById(R.id.button_minus);
        mButtonMultiple = view.findViewById(R.id.button_multiple);
    }

    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        Toast.makeText(getContext(), b.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}