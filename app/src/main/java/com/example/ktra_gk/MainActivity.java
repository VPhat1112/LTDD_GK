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
        ListView listView = findViewById(R.id.listview);
        Item Dog1 = new Item("Dog1", R.mipmap.imgdog_1, "infomation of Dog1");
        Item Dog2 = new Item("Dog2", R.mipmap.imgdog_2, "infomation of Dog2");
        Item Dog3 = new Item("Dog3", R.mipmap.imgdog_3, "infomation of Dog3");
        Item Dog4 = new Item("Dog4", R.mipmap.imgdog_4, "infomation of Dog4");
        Item Dog5 = new Item("Dog5", R.mipmap.imgdog_5, "infomation of Dog5");



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
        final ImageView img=view.findViewById(R.id.img_dinner);
        final TextView nametext= view.findViewById(R.id.namedinnertext);
        final TextView infor= view.findViewById(R.id.dinnerinfomation);
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