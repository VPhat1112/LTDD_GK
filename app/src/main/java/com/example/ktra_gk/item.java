package com.example.ktra_gk;

public class Item
{
    private String itemName;
    private int images_pet;
    private String itemInfo;
    public Item(String itemName,int images_dinner,String itemInfo){
        this.itemName=itemName;
        this.images_pet=images_dinner;
        this.itemInfo=itemInfo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getImages_dinner() {
        return images_pet;
    }

    public void setImages_dinner(int  images_dinner) {
        this.images_pet = images_dinner;
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }
}

