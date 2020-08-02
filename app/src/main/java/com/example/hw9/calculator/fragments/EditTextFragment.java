package com.example.hw9.calculator.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.hw9.R;

public class EditTextFragment extends Fragment {
    // region initialization
    static EditText mEditText;

    //endregion

    public static void setText(String value) {
        mEditText.setText(value);
    }

    public static void addText(String value) {
        mEditText.setText(mEditText.getText() + value);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_text, container, false);
        findAllViewsById(view);

        return view;
    }

    private void findAllViewsById(View view) {
        mEditText = view.findViewById(R.id.edit_text_multiLine);
    }
}