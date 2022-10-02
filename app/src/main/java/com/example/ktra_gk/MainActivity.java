package com.example.ktra_gk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnAdd;
    private EditText editText,info;
    ArrayList<item> list;
    private List<item> getListData() {
        list = new ArrayList<item>();
        item Dog1 = new item("Dog1", "imgdog_1", "infomation of Dog1");
        item Dog2 = new item("Dog2", "imgdog_2", "infomation of Dog2");
        item Dog3 = new item("Dog3", "imgdog_3", "infomation of Dog3");
        item Dog4 = new item("Dog4", "imgdog_4", "infomation of Dog4");
        item Dog5 = new item("Dog5", "imgdog_5", "infomation of Dog5");



        list.add(Dog1);
        list.add(Dog2);
        list.add(Dog3);
        list.add(Dog4);
        list.add(Dog5);

        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<item> image_details = getListData();
        Adapter adapter=new Adapter(this, image_details);
        final ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        btnAdd = (Button) findViewById(R.id.btn);
        editText= (EditText) findViewById(R.id.namedog);
        info= (EditText) findViewById(R.id.info);
        // When the user clicks on the ListItem

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dog =editText.getText().toString();
                String infomation =info.getText().toString();
                item Dog6= new item(dog,"imgdog_6",infomation);
                list.add(Dog6);
                adapter.notifyDataSetChanged();

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> a, View view, int i, long id) {
                final int which_item=i;

                new AlertDialog.Builder(MainActivity.this).setIcon(R.drawable.ic_baseline_delete_24)
                        .setTitle("Are you sure delete this?")
                        .setMessage("Do you want to delete?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                list.remove(which_item);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();

                return true;
            }
        });
    }


}