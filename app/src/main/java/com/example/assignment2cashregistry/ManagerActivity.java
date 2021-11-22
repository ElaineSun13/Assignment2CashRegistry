package com.example.assignment2cashregistry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ManagerActivity extends AppCompatActivity {

//    Button btnHistory;
//    Button btnRestock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_view);

//        btnHistory = findViewById(R.id.btnHistory);
//        btnRestock = findViewById(R.id.btnRestock);
    }

    public void show_history(View view) {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

    public void restock_task(View view) {
        Intent intent = new Intent(this, RestockActivity.class);
        startActivity(intent);
    }
}