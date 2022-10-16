package com.example.ktra_gk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    private EditText editText,info;
    List<Item> list = new ArrayList<>();
    Adapter adapter;
    int currentindex= -1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.Home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case  R.id.Profile:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.Home:
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.LIstview:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });

        ListView listView = findViewById(R.id.listview);
        Item Dog1 = new Item("Alaskan Malamute", R.mipmap.alska, "Nhanh nhẹn, độc lập, trung thành tuyệt đối, thích trượt tuyết");
        Item Dog2 = new Item("chihuahua", R.mipmap.chihuahua, "Hết lòng, trung thành, cảnh giác, nhanh nhẹn");
        Item Dog3 = new Item("husky", R.mipmap.husky, "Khỏe mạnh, vui vẻ, nghe lời, thích chạy nhảy");
        Item Dog4 = new Item("poodle", R.mipmap.poodle, "Lộng lẫy, thông minh, vâng lời, nhanh nhẹn");
        Item Dog5 = new Item("pug", R.mipmap.pug, "Nhanh nhẹn, thân thiện, vâng lời, thông minh");



        list.add(Dog1);
        list.add(Dog2);
        list.add(Dog3);
        list.add(Dog4);
        list.add(Dog5);

        adapter=new Adapter(this, list);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
        // When the user clicks on the ListItem




    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_content,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int which_item=info.position;
        switch (item.getItemId()){
            case R.id.menu_infomation_item:
                this.currentindex=which_item;
                showinfomation();
                return true;
            case R.id.menu_edit_item:
                this.currentindex= which_item;
                showDialogAdd();
                return true;
            case R.id.menu_delete_item:
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.newitem:
                showDialogAdd();
                return true;
            case R.id.help:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void  showinfomation(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        LayoutInflater inflater= getLayoutInflater();
        View view= inflater.inflate(R.layout.activity_detail,null);
        final ImageView img=view.findViewById(R.id.imageView_dog);
        final TextView nametext= view.findViewById(R.id.namedog);
        final TextView infor= view.findViewById(R.id.doginfomation);
        if(currentindex>=0){
            img.setImageResource(list.get(currentindex).getImages_dinner());
            nametext.setText(list.get(currentindex).getItemName());
            infor.setText(list.get(currentindex).getItemInfo());
        }
        builder.setView(view);
        builder.setTitle("Information")
                .setPositiveButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        builder.show();

    }
    private void  showDialogAdd(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        LayoutInflater inflater= getLayoutInflater();
        View view= inflater.inflate(R.layout.activity_dialog,null);
        final EditText editText= view.findViewById(R.id.namedog);
        final EditText info= view.findViewById(R.id.info);
        if(currentindex>=0){
            editText.setText(list.get(currentindex).getItemName());
            info.setText(list.get(currentindex).getItemInfo());
        }
        builder.setView(view);
        builder.setTitle("Add/update item")
                .setPositiveButton("Save item", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String dog =editText.getText().toString();
                        String infor =info.getText().toString();
                        if(currentindex>=0){
                            list.get(currentindex).setItemName(dog);
                            list.get(currentindex).setItemInfo(infor);
                            currentindex=-1;
                        }else {
                            Item Dog6= new Item(dog,R.mipmap.imgdog_6,infor);
                            list.add(Dog6);

                        }

                        adapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        builder.show();
    }

}