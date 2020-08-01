package com.example.hw9.LogIn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hw9.R;

public class SignUpActivity extends AppCompatActivity {
    Button mButtonLogin;
    EditText mEditTextUserName;
    EditText mEditTextPassword;

    public static final String EXTRA_USERNAME = "extra_singup_username";
    public static final String EXTRA_PASSWORD = "extra_singup_password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        findAllViewsById();
        setListners();
    }

    private void setListners() {
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextPassword.getText().equals("") || mEditTextUserName.getText().equals("")) {
                    Toast.makeText(SignUpActivity.this, "Password or UserName is empty!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra(EXTRA_USERNAME, mEditTextUserName.getText().toString());
                    intent.putExtra(EXTRA_PASSWORD, mEditTextPassword.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    private void findAllViewsById() {
        mButtonLogin = findViewById(R.id.button_Signup);
        mEditTextUserName = findViewById(R.id.edittext_username);
        mEditTextPassword = findViewById(R.id.edittext_password);
    }
}