package com.example.assignment2cashregistry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView product_List;static StoreItemManager storeItemManager = new StoreItemManager();


    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button buttonClear;
    ListView listProductItems;


    Button buttonBuy;
    TextView productItemView;
    TextView totalPriceView;
    TextView quantityView;


    StoreItem itemTobuy = new StoreItem();
    StoreItem selectedItem = null;
    ArrayList<StoreItem> storeItemLists = new ArrayList<>(0);
    StoreItemCustomAdapter itemCustomAdapter;
    //ArrayList<StoreItem> storeItemLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btnOne);
        button2 = findViewById(R.id.btnTwo);
        button3 = findViewById(R.id.btnThree);
        button4 = findViewById(R.id.btnFour);
        button5 = findViewById(R.id.btnFive);
        button6 = findViewById(R.id.btnSix);
        button7 = findViewById(R.id.btnSeven);
        button8 = findViewById(R.id.btnEight);
        button9 = findViewById(R.id.btnNine);
        button0 = findViewById(R.id.btnZero);
        buttonBuy = findViewById(R.id.btnBuy);
        buttonClear = findViewById(R.id.btnClear);
        productItemView = findViewById(R.id.productType);
        totalPriceView = findViewById(R.id.totalPrice);
        quantityView = findViewById(R.id.textQuantity);
        listProductItems = findViewById(R.id.product_list);
        quantityView.setText("");
        itemCustomAdapter = new StoreItemCustomAdapter(this);

        listProductItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        listProductItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                selectedItem = (StoreItem) itemCustomAdapter.getItem(position); //
                itemTobuy.productName = selectedItem.getProductName();
                itemTobuy.price = selectedItem.getPrice();
                productItemView.setText(selectedItem.getProductName() + "");
                totalPriceView.setText("");
                updateTotal();
            }
        });

        StoreItem pants = new StoreItem("Pants", 24.45, 20);
        StoreItem shoes = new StoreItem("Shoes", 45.70, 100);
        StoreItem hats = new StoreItem("Hats", 15.20, 40);

        itemCustomAdapter.add(pants);
        itemCustomAdapter.add(shoes);
        itemCustomAdapter.add(hats);

        listProductItems.setAdapter(itemCustomAdapter);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonBuy.setOnClickListener(this);

    }


    void updateTotal() {

        String amount = quantityView.getText().toString().trim();

//            String.format("%.2f", itemTobuy.getTotal());
//                    //+ "");



            if (!amount.isEmpty()&& selectedItem !=null) {
                totalPriceView.setText(itemTobuy.getTotal() + "");;

        }
            else{
                totalPriceView.setText("Total");

            }




    }

    @Override
    public void onClick(View v) {
        String amount = quantityView.getText().toString().trim();
        if (v == buttonBuy) {
            try{
                selectedItem.buy(itemTobuy.quantity);
                totalPriceView.setText(itemTobuy.getTotal()+"");
                itemCustomAdapter.notifyDataSetChanged();//to update listview

            }
            catch(IllegalArgumentException e) {
                Context context = getApplicationContext();
                String text=e.getMessage();
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            catch(Exception e){
                Context context = getApplicationContext();
                String text= "All fields are required!!";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


            }

        }

        else if (v == buttonClear) {
            quantityView.setText("");
            productItemView.setText("");
            totalPriceView.setText("");
            itemTobuy.quantity=0;
            itemTobuy.productName=null;
            selectedItem = null;


        } else
            {
            Button b = (Button) v;
            String buttonText = b.getText().toString().trim();

            String new_result = quantityView.getText().toString().trim();
            new_result += buttonText;
            quantityView.setText(new_result);

            itemTobuy.quantity = Integer.parseInt(new_result);
            totalPriceView.setText("");
            productItemView.setText("");
            //updateTotal();
        }

    }
}