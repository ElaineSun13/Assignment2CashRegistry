package com.example.assignment2cashregistry;

import android.content.ClipData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class StoreItemManager {//app model
    //collection of StoreItems
    static ArrayList<StoreItem> storeItems=new ArrayList<StoreItem>(
            Arrays.asList(
                   new StoreItem("Pants", 24.45, 20),
    new StoreItem("Shoes", 45.70, 100),
    new StoreItem("Hats", 15.20, 40)
            ));

    public static class PurchaseItem extends StoreItem {
        Date purchase_date;

        public PurchaseItem(StoreItem item) {
            productName = item.productName;
            price = item.price;
            quantity = item.quantity;
            purchase_date = new Date();
        }

    }
    static ArrayList<PurchaseItem> history = new ArrayList<>();

    static public ArrayList<StoreItem> getStoreItems(){
        return storeItems;
    }
    static public ArrayList<PurchaseItem> getHistory(){
        return history;
    }

    static public void buy(StoreItem item){
        history.add(new PurchaseItem(item));
    }

}
