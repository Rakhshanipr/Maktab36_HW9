package com.example.hw9.calculator.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
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
    Button mButtonEqual;
    Button mButtonDot;


    //endregion
    String number1 = "";
    String number2 = "";
    String operator = "";
    public static final String BOUNDLE_NUMBER1 = "calculator buttonfragments save number1";
    public static final String BOUNDLE_NUMBER2 = "calculator buttonfragments save number2";
    public static final String BOUNDLE_OPERATOR = "calculator buttonfragments save operator";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            number1 = savedInstanceState.getString(BOUNDLE_NUMBER1);
            number2 = savedInstanceState.getString(BOUNDLE_NUMBER2);
            operator = savedInstanceState.getString(BOUNDLE_OPERATOR);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(BOUNDLE_NUMBER1, number1);
        outState.putString(BOUNDLE_NUMBER2, number2);
        outState.putString(BOUNDLE_OPERATOR, operator);
        super.onSaveInstanceState(outState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buttons, container, false);
        findAllViewsById(view);
        setOnclickListner();
        return view;
    }

    private void setOnclickListner() {
        try {
            //region setOnclickListner for numric button and opeartor - + / *
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
            mButtonPlus.setOnClickListener(this);
            mButtonMinus.setOnClickListener(this);
            mButtonDivide.setOnClickListener(this);
            mButtonMultiple.setOnClickListener(this);
            mButtonDelete.setOnClickListener(this);
            mButtonDot.setOnClickListener(this);

            //endregion
            //region setOnclick for equal button
            mButtonEqual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    double number = 0;
                    switch (operator) {
                        case "-":
                            number = Double.parseDouble(number1) - Double.parseDouble(number2);
                            break;
                        case "+":
                            number = Double.parseDouble(number1) + Double.parseDouble(number2);
                            break;
                        case "*":
                            number = Double.parseDouble(number1) * Double.parseDouble(number2);
                            break;

                        case "/":
                            number = Double.parseDouble(number1) / Double.parseDouble(number2);
                            break;
                    }
                    EditTextFragment.setText(Double.toString(number));
                    number1 = Double.toString(number);
                    operator = number2 = "";
                }
            });


            //endregion
            //region setOnClick for delete
            mButtonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditTextFragment.setText("");
                    operator = number2 = number1 = "";
                }
            });

            //endregion
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
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
        mButtonEqual = view.findViewById(R.id.button_equal);
        mButtonDot = view.findViewById(R.id.button_dot);
    }

    @Override
    public void onClick(View view) {
        try {
            Button b = (Button) view;
            String buttonText = b.getText().toString();
            Toast.makeText(getContext(), buttonText, Toast.LENGTH_SHORT).show();
            if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")) {
                if (!operator.equals("")) {
                    Toast.makeText(getContext(), "you can't use two operator", Toast.LENGTH_SHORT).show();
                } else {
                    operator = buttonText;
                    EditTextFragment.addText(buttonText);
                }
            } else {
                if (operator.equals("")) {
                    number1 += buttonText;
                } else {
                    number2 += buttonText;

                }
                EditTextFragment.addText(buttonText);
            }

        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}