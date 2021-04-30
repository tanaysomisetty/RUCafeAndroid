/**
 *The "Activity" class that acts as the Main Menu to all other activities
 * @author Sailokesh Mondi, Tanay Somisetty
 */

package com.example.rucafe;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    public static Order currOrder = new Order();

    public static StoreOrders storeOrder = new StoreOrders();

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

    /**
     * Accessory method to set the current order
     * @param order Object
     */
    public static void setOrder(Order order) {
        currOrder = order;
    }

    /**
     * Accessory method to get the current order
     * @return currOrder Object
     */
    public static Order getOrder() {
        return currOrder;
    }
}

