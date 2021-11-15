package com.example.assignment2cashregistry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ArrayList<StoreItem> listFromMA;
    ListView listOfStoreItems;
    TextView itemName;
    TextView itemPrice;
    TextView itemQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_item);

        itemName=findViewById(R.id.productName_in_row);
        listOfStoreItems=findViewById(R.id.product_list);
    }
}