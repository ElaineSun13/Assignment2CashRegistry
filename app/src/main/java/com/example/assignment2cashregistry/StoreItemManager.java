package com.example.assignment2cashregistry;

import java.util.ArrayList;

public class StoreItemManager {//app model
    //collection of StoreItems
    ArrayList<StoreItem> listOfStoreItems=new ArrayList<>(0);
    Double total=0.0;

    public ArrayList<StoreItem> getListOfStoreItems(){
        return listOfStoreItems;
    }
    public void addNewStoreItem(StoreItem item){

        listOfStoreItems.add(item); //database locally
    }

    public Double getTotal(){
//        for(int i=0; i<listOfStoreItems.size();i++){
//
//        }
        return 0.0;
    }



}
