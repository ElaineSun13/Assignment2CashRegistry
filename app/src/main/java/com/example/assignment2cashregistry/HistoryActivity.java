package com.example.assignment2cashregistry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity  implements StoreItemRecyclerAdapter.StoreItemClickListener{
    RecyclerView list_of_history;

//    TextView productName;
//    TextView totalPrice;
//    TextView purshase_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_recycler_view);

        list_of_history = findViewById(R.id.history_list_recycler);
//        productName = findViewById(R.id.detail_name);
//        totalPrice = findViewById(R.id.detail_price);
//        purshase_date = findViewById(R.id.detail_date);

        ArrayList<StoreItemManager.PurchaseItem> allItems = StoreItemManager.getHistory();

        StoreItemRecyclerAdapter adapter = new StoreItemRecyclerAdapter(this, allItems);
        adapter.listener = this;
        list_of_history.setLayoutManager(new LinearLayoutManager(this));

        list_of_history.setAdapter(adapter);

    }

    @Override
    public void onToDoSelected(StoreItemManager.PurchaseItem item) {
//        productName.setText(item.getProductName());
//        totalPrice.setText(item.getTotal()+"");
//        purshase_date.setText(item.purchase_date.toString());

        Intent intent = new Intent(this, HistoryDetailActivity.class);
        intent.putExtra("productName",item.getProductName());
        intent.putExtra("price",item.getTotal()+"");
        intent.putExtra("purchaseDate",item.purchase_date.toString());

        startActivity(intent);

//        Toast.makeText(this, "The selected task is " + selectedToDo.getProductName(), Toast.LENGTH_LONG).show();
    }
}