package com.example.rucafe;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class CurrentOrderActivity extends AppCompatActivity {

    private Button removeBtn;
    private Button placeOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);
        //removeBtn = findViewById(R.id.removeItemBtn);
        //placeOrderBtn = findViewById(R.id.placeOrderBtn);
        setTitle("Current Order");
    }

    public void placeOrder() {

    }
}