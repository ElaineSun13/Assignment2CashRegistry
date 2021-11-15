package com.example.assignment2cashregistry;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class StoreItemCustomAdapter extends BaseAdapter {
    ArrayList<StoreItem> listOfStoreItems;
    //Context list_activity_context;
    private Activity context;

    public StoreItemCustomAdapter(Activity context){
        this.context=context;
        listOfStoreItems=new ArrayList<StoreItem>();

        //listOfStoreItems = list;
      // list_activity_context=activity_context;
    }
    public void add(StoreItem item){
        listOfStoreItems.add(item);
    }

    @Override
    public int getCount() {
        return listOfStoreItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfStoreItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //in each row, there is one list of store item from the array list
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= (LayoutInflater.from(context)).inflate(R.layout.list_view_item, null);
        TextView listName=view.findViewById(R.id.productName_in_row);
        TextView listPrice=view.findViewById(R.id.productPrice_in_row);
        TextView listQuantity=view.findViewById(R.id.productQuanity_in_row);
        listName.setText(listOfStoreItems.get(i).getProductName()+ "");
        listPrice.setText(listOfStoreItems.get(i).getPrice()+"");
        listQuantity.setText(listOfStoreItems.get(i).getQuantity()+"");




        return view;


    }
}
