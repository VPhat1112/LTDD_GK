package com.example.ktra_gk;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    private List<Item> itemList;
    private LayoutInflater layoutInflater;
    private Activity activity;
    public Adapter(Activity activity,List<Item> itemList){
        this.activity=activity;
        this.itemList=itemList;
    }
    @Override
    public int getCount(){
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= activity.getLayoutInflater();
        view = inflater.inflate(R.layout.layout_item,null);
        ImageView dinnerView = (ImageView) view.findViewById(R.id.imageView_dinner);
        TextView itemNameView = (TextView) view.findViewById(R.id.textView_itemName);
        TextView infoView = (TextView) view.findViewById(R.id.textView_info);

        Item item =itemList.get(i);

        dinnerView.setImageResource(item.getImages_dinner());
        itemNameView.setText(item.getItemName());
        infoView.setText(item.getItemInfo());



        return view;
    }
    public int getMipmapResIdByName(String resName)  {
        String pkgName = activity.getPackageName();
        // Return 0 if not found.
        int resID = activity.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }


}
