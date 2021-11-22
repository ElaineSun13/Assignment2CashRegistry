package com.example.assignment2cashregistry;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RestockActivity extends AppCompatActivity {
    ListView product_List;


    Button btnOK;
    Button btnCannel;

    EditText quantityView;
    ListView listProductItems;

    StoreItem selectedItem = null;

    StoreItemCustomAdapter itemCustomAdapter;
    View previousSelectedItem = null;

    ActivityResultLauncher<Intent> newStockActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);

        btnOK = findViewById(R.id.btnRestockOK);
        btnCannel = findViewById(R.id.btnRestockCancel);
        quantityView = findViewById(R.id.editTextQuantity);
        listProductItems = findViewById(R.id.product_list);


//        int backgroundColor = ((ColorDrawable)listProductItems.getBackground()).getColor();
//        int pressedColor = ((ColorDrawable)btnOK.getBackground()).getColor();

        listProductItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                selectedItem = (StoreItem) itemCustomAdapter.getItem(position); //

                if (previousSelectedItem != null) {
                    previousSelectedItem.setBackgroundColor(Color.WHITE);
                }
                previousSelectedItem = v;
                v.setBackgroundColor(Color.BLUE);
            }
        });

        itemCustomAdapter = new StoreItemCustomAdapter(this, StoreItemManager.getStoreItems());

        listProductItems.setAdapter(itemCustomAdapter);

        btnOK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textQuantity = quantityView.getText().toString().trim();
                int quantity = Integer.parseInt(textQuantity);

                selectedItem.restock(quantity);
                itemCustomAdapter.notifyDataSetChanged();
            }
        });


        btnCannel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}