package com.example.ktra_gk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private Button btnback;
    private TextView name,info;
    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        name=findViewById(R.id.namedog);
        info=findViewById(R.id.doginfomation);
        imageView=findViewById(R.id.imageView_dog);
        btnback=(Button) findViewById(R.id.btnback);

        Intent myintent = getIntent();
        String namephone = myintent.getStringExtra("name");
        name.setText(namephone);



        Intent myintent1 = getIntent();
        int imgoto = myintent.getIntExtra("images",R.mipmap.alska);
        imageView.setImageResource(imgoto);

        Intent myintent2 = getIntent();
        String infomation = myintent.getStringExtra("info");
        info.setText(infomation);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(DetailActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
