package com.example.assignment2cashregistry;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryDetailActivity extends AppCompatActivity {

    TextView productName;
    TextView totalPrice;
    TextView purshase_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_detail_view);
        productName = findViewById(R.id.detail_name);
        totalPrice = findViewById(R.id.detail_price);
        purshase_date = findViewById(R.id.detail_date);

        StoreItemManager.PurchaseItem item;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            productName.setText(extras.getString("productName"));
            totalPrice.setText(extras.getString("price"));
            purshase_date.setText(extras.getString("purchaseDate"));
        }
    }

//    @Override
//    public void onToDoSelected(StoreItemManager.PurchaseItem item) {
//        productName.setText(item.getProductName());
//        totalPrice.setText(item.getTotal()+"");
//        purshase_date.setText(item.purchase_date.toString());
////        Toast.makeText(this, "The selected task is " + selectedToDo.getProductName(), Toast.LENGTH_LONG).show();
//    }
}