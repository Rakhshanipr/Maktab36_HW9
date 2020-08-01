package com.example.hw9;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    // region set initialization
    Button mButtonSignUp;
    Button mButtonLogIn;
    EditText mEditTextUserName;
    EditText mEditTextPassword;
    static final int REQUEST_CODE_SIGNUP_ACTIVITY = 1;
    String mPassword;
    String mUserName;
    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findAllViewsById();
        setListner();
    }

    private void findAllViewsById() {
        mButtonSignUp = findViewById(R.id.button_Signup);
        mButtonLogIn = findViewById(R.id.button_login);
        mEditTextPassword=findViewById(R.id.edittext_password);
        mEditTextUserName=findViewById(R.id.edittext_username);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK || data == null)
            return;
        if (requestCode == REQUEST_CODE_SIGNUP_ACTIVITY) {
            mUserName = data.getStringExtra(SignUpActivity.EXTRA_USERNAME);
            mPassword = data.getStringExtra(SignUpActivity.EXTRA_PASSWORD);
        }
    }

    private void setListner() {
        mButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SIGNUP_ACTIVITY);
            }
        });

        mButtonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!mEditTextUserName.getText().toString().equals(mUserName) || !mEditTextPassword.getText().toString().equals(mPassword)) {
                    Snackbar snackbar = Snackbar
                            .make(view, "User not found !", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    Snackbar snackbar = Snackbar
                            .make(view, "User is valid", Snackbar.LENGTH_LONG);
                    snackbar.show();

                }
            }
        });
    }
}