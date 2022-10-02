package com.example.ktra_gk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SigninActivity extends MainActivity {
    private Button btnLogin,btnSignUp;
    private TextView user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        btnLogin = (Button) findViewById(R.id.signin);
        btnSignUp = (Button) findViewById(R.id.signup);
        user = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getText().toString().equals("admin") && password.getText().toString().equals("12345"))
                {
                    Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA", "onStart Sinin_Activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAA","onStop Sinin_Activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AAA","onDestroy Sinin_Activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AAA","onPause Sinin_Activity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA","onRestart Sinin_Activity");
    }
}
