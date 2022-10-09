package com.example.ktra_gk;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SigninActivity extends MainActivity {
    private Button btnLogin;
    private TextView usertext, passwordtext,btnSignUp;
    private EditText user,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        btnLogin = (Button) findViewById(R.id.signin);
        btnSignUp = (TextView) findViewById(R.id.signup);
        usertext = (TextView) findViewById(R.id.usernametextid);
        passwordtext = (TextView) findViewById(R.id.passwordtextid);
        user = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getText().toString().equals("admin") && password.getText().toString().equals("12345"))
                {
                    Intent intent = new Intent(SigninActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
                else new AlertDialog.Builder(SigninActivity.this).setIcon(R.drawable.ic_baseline_error_outline_24)
                        .setTitle("WRONG USERNAME OR PASSWORD")
                        .setMessage("Please enter true")
                        .setNegativeButton("Back",null)
                        .show();



            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence,
                                          int i, int i1, int i2) {
                //Gọi trước khi text thay đổi
            }

            @Override
            public void onTextChanged(CharSequence charSequence,
                                      int i, int i1, int i2) {
                if (charSequence.length() ==0) {
                    user.setError("Bạn bắt buộc phải nhập username");
                } else {
                    user.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Gọi sau khi thay đổi

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence,
                                          int i, int i1, int i2) {
                //Gọi trước khi text thay đổi
            }

            @Override
            public void onTextChanged(CharSequence charSequence,
                                      int i, int i1, int i2) {
                if (charSequence.length() ==0) {
                    password.setError("Bạn bắt buộc phải nhập password");
                } else {
                    password.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Gọi sau khi thay đổi

            }
        });

    }


}
