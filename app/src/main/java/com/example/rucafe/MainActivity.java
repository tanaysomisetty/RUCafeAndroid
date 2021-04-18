package com.example.rucafe;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    //private Button orderDonutsBtn;
    //private Button orderCoffeeBtn;
    //private Button currentOrderBtn;
    //private Button storeOrdersBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button orderDonutsBtn = (Button) findViewById(R.id.orderDonutsBtn);
        Button orderCoffeeBtn = (Button) findViewById(R.id.orderCoffeeBtn);
        Button currentOrderBtn = (Button) findViewById(R.id.currentOrderBtn);
        Button storeOrdersBtn = (Button) findViewById(R.id.storeOrdersBtn);

        orderDonutsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donutIntent = new Intent(MainActivity.this,OrderingDonutsActivity.class);
                startActivity(donutIntent);
            }
        });

        orderCoffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent coffeeIntent = new Intent(MainActivity.this,OrderingCoffeeActivity.class);
                startActivity(coffeeIntent);
            }
        });

        currentOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent currentOrderIntent = new Intent(MainActivity.this,CurrentOrderActivity.class);
                startActivity(currentOrderIntent);
            }
        });

        storeOrdersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent storeOrdersIntent = new Intent(MainActivity.this,StoreOrdersActivity.class);
                startActivity(storeOrdersIntent);
            }
        });

    }
}

    /*public void openOrderingDonuts() {
        Intent intent = new Intent(this, OrderingDonutsActivity.class);
        startActivity(intent);
    }

    public void openOrderingCoffee() {
        Intent intent = new Intent(this, OrderingCoffeeActivity.class);
        startActivity(intent);
    }
}
*/
