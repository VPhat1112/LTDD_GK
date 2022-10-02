package com.example.ktra_gk;

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
    private List<item> itemList;
    private LayoutInflater layoutInflater;
    private Context context;
    public Adapter(Context context,List<item> itemList){
        this.context=context;
        this.itemList=itemList;
        layoutInflater=LayoutInflater.from(context);
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
        ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.layout_item, null);
            holder = new ViewHolder();
            holder.dinnerView = (ImageView) view.findViewById(R.id.imageView_dinner);
            holder.itemNameView = (TextView) view.findViewById(R.id.textView_itemName);
            holder.infoView = (TextView) view.findViewById(R.id.textView_info);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        item dinner = this.itemList.get(i);
        holder.itemNameView.setText(dinner.getItemName());
        holder.infoView.setText(dinner.getItemInfo());

        int imageId = this.getMipmapResIdByName(dinner.getImages_dinner());

        holder.dinnerView.setImageResource(imageId);

        return view;
    }
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }
    static class ViewHolder {
        ImageView dinnerView;
        TextView itemNameView;
        TextView infoView;
    }

}
