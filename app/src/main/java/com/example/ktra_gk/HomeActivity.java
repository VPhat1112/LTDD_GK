package com.example.ktra_gk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private LinearLayout btnprofile,btnlistview;
    private Button btnlogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnprofile = (LinearLayout) findViewById(R.id.Profile);
        btnlistview = (LinearLayout) findViewById(R.id.LIstview);
        btnlogout = (Button) findViewById(R.id.Logout);
        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        btnlistview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(HomeActivity.this).setIcon(R.drawable.ic_baseline_exit_to_app_24)
                        .setTitle("Are you sure Exit this?")
                        .setMessage("Do you want to Exit?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                Intent intent = new Intent(HomeActivity.this, SigninActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();



            }
        });


    }

}
