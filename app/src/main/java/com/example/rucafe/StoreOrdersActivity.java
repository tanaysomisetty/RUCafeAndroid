package com.example.rucafe;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.CompoundButton;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TableLayout.LayoutParams;
import android.widget.ScrollView;
import android.view.View.OnClickListener;

public class StoreOrdersActivity extends AppCompatActivity implements View.OnClickListener {

    private Button cancelStoreOrders;
    private TableLayout storeOrderTable;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);
        cancelStoreOrders = findViewById(R.id.cancelOrderStoreBtn);
        storeOrderTable = findViewById(R.id.tableLayoutStoreOrder);

        displayOrderListAndTotal();
        setTitle("Store Orders");

        cancelStoreOrders = findViewById(R.id.cancelOrderStoreBtn);
        cancelStoreOrders.setOnClickListener(this);
    }

    /**
     * Method to display the list of all orders and the total amount for each order
     * @param 'none'
     */
    private void displayOrderListAndTotal() {
        for (Object e : MainActivity.storeOrder.getOrderList()) {

            TableRow currRow = new TableRow(this);

            currRow.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

            if (e instanceof Order) {
                final Order currOrder = (Order) e;
                CheckBox check = new CheckBox(this);
                check.setId(currOrder.getOrderID());
                Button button = new Button(this);
                button.setId(currOrder.getOrderID());

                check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        MainActivity.storeOrder.updateRemovedOrders(buttonView.getId(), isChecked);
                    }
                });
                final int LEFT_PADDING_CHECKBOX = 50;
                final int RIGHT_PADDING_CHECKBOX = 50;
                final int TOP_PADDING_CHECKBOX = 10;
                final int BOTTOM_PADDING_CHECKBOX = 10;
                final int LEFT_PADDING_ID_TEXTVIEW = 20;
                final int TOP_PADDING_ID_TEXTVIEW = 10;
                final int RIGHT_PADDING_ID_TEXTVIEW = 50;
                final int BOTTOM_PADDING_ID_TEXTVIEW = 10;
                final int LEFT_PADDING_DETAILS_TEXTVIEW = 20;
                final int TOP_PADDING_DETAILS_TEXTVIEW = 10;
                final int RIGHT_PADDING_DETAILS_TEXTVIEW = 10;
                final int BOTTOM_PADDING_DETAILS_TEXTVIEW = 10;
                final int PADDING_TOTAL_TEXTVIEW = 10;


                        check.setGravity(Gravity.CENTER_HORIZONTAL);
                check.setPadding(LEFT_PADDING_CHECKBOX, TOP_PADDING_CHECKBOX, RIGHT_PADDING_CHECKBOX,
                        BOTTOM_PADDING_CHECKBOX);
                currRow.addView(check);

                TextView idTextview = new TextView(this);
                idTextview.setText(String.valueOf(currOrder.getOrderID()));
                idTextview.setTextColor(Color.BLACK);
                idTextview.setGravity(Gravity.CENTER_HORIZONTAL);
                idTextview.setPadding(LEFT_PADDING_ID_TEXTVIEW, TOP_PADDING_ID_TEXTVIEW, RIGHT_PADDING_ID_TEXTVIEW,
                        BOTTOM_PADDING_ID_TEXTVIEW);

                currRow.addView(idTextview);

                TextView totalAmountTextView = new TextView(this);
                totalAmountTextView.setText("$" +((currOrder.getTotal())));

                Button detailsButton = new Button(this);
                detailsButton.setText("Click to view");
                detailsButton.setTextColor(Color.BLACK);

                detailsButton.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        displayDetails(currOrder.getOrderID());
                    }
                });

                detailsButton.setGravity(Gravity.CENTER_HORIZONTAL);
                detailsButton.setPadding(LEFT_PADDING_DETAILS_TEXTVIEW, TOP_PADDING_DETAILS_TEXTVIEW,
                        RIGHT_PADDING_DETAILS_TEXTVIEW, BOTTOM_PADDING_DETAILS_TEXTVIEW);
                currRow.addView(detailsButton);
                ViewGroup.LayoutParams params = detailsButton.getLayoutParams();
                params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                detailsButton.setLayoutParams(params);




              totalAmountTextView.setTextColor(Color.BLACK);

                totalAmountTextView.setGravity(Gravity.CENTER_HORIZONTAL);
                totalAmountTextView.setPadding(PADDING_TOTAL_TEXTVIEW, PADDING_TOTAL_TEXTVIEW,
                        PADDING_TOTAL_TEXTVIEW, PADDING_TOTAL_TEXTVIEW);
                currRow.addView(totalAmountTextView);


                storeOrderTable.addView(currRow, new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT));
            }

        }
    }

    /**
     * Method to cancel the order in the Store Orders Activity
     * @param 'none'
     */
    public void cancelOrder() {
        MainActivity.storeOrder.removeOrdersFromStore();

        TableLayout table = findViewById(R.id.tableLayoutStoreOrder);

        int childCount = table.getChildCount();

        if (childCount > 1) {
            table.removeViews(1, childCount - 1);
        }
        displayOrderListAndTotal();
        scrollView = findViewById(R.id.scrollViewid);
        scrollView.removeAllViews();

    }

    /**
     * Displays an order's details to a ScrollView
     * @param 'v' View
     */
    public void displayDetails(int orderID) {
        scrollView = findViewById(R.id.scrollViewid);
        for (Order e : MainActivity.storeOrder.getOrderList()) {
            if (e.getOrderID() == orderID) {
                TextView tv = new TextView(this);
                tv.setText(e.toString());
                scrollView.removeAllViews();
                scrollView.addView(tv);
            }
        }
    }


    /**
     * On click method called when a certain button is clicked
     * @param v View
     */
    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.cancelOrderStoreBtn) {
            cancelOrder();
            Toast.makeText(StoreOrdersActivity.this, "Order Cancelled", Toast.LENGTH_SHORT).show();

        }

    }
}

