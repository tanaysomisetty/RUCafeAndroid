/**
 *The "Activity" class that implements all functionalities pertaining  to the current order of items
 * @author Sailokesh Mondi, Tanay Somisetty
 */

package com.example.rucafe;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.CompoundButton;
import android.widget.TableRow;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.TableLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;

public class CurrentOrderActivity extends AppCompatActivity implements View.OnClickListener {

    private Button removeBtn;
    private Button placeOrderBtn;
    private TableLayout currentOrderTable;
    private TextView subtotalCurrentTextview;
    private TextView totalCurrentTextview;
    private TextView salesTaxCurrentTextview;
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
    final int PADDING_PRICE_TEXTVIEW = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);
        removeBtn = findViewById(R.id.removeBtnCurrentOrder);
        placeOrderBtn = findViewById(R.id.cancelOrderStoreBtn);
        currentOrderTable = findViewById(R.id.tablelayoutCurrentOrder);

        displayItemListAndPrice();
        setTitle("Current Order");


        placeOrderBtn = findViewById(R.id.cancelOrderStoreBtn);
        placeOrderBtn.setOnClickListener(this);

        removeBtn = findViewById(R.id.removeBtnCurrentOrder);
        removeBtn.setOnClickListener(this);


    }

    /**
     * Method to display the item list of the current order and prices of all the items in the current order
     * @param 'none'
     */
    private void displayItemListAndPrice() {


        for (Object e : MainActivity.currOrder.getMenuItemList()) {

            TableRow currRow = new TableRow(this);


            currRow.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

            if (e instanceof Donut) {
                Donut currDonut = (Donut) e;
                CheckBox check = new CheckBox(this);
                check.setId(currDonut.getMenuItemID());

                check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                        MainActivity.currOrder.updateRemovedItems(buttonView.getId(), isChecked);


                    }
                });


                check.setGravity(Gravity.CENTER_HORIZONTAL);
                check.setPadding(LEFT_PADDING_CHECKBOX, TOP_PADDING_CHECKBOX, RIGHT_PADDING_CHECKBOX,
                        BOTTOM_PADDING_CHECKBOX);
                currRow.addView(check);


                TextView idTextview = new TextView(this);
                idTextview.setText(String.valueOf(currDonut.getMenuItemID()));
                idTextview.setTextColor(Color.BLACK);
                idTextview.setGravity(Gravity.CENTER_HORIZONTAL);
                idTextview.setPadding(LEFT_PADDING_ID_TEXTVIEW, TOP_PADDING_ID_TEXTVIEW,
                        RIGHT_PADDING_ID_TEXTVIEW, BOTTOM_PADDING_ID_TEXTVIEW);

                currRow.addView(idTextview);


                TextView detailsTextView = new TextView(this);
                detailsTextView.setText(String.valueOf(currDonut.toString()));
                detailsTextView.setTextColor(Color.BLACK);

                detailsTextView.setGravity(Gravity.CENTER_HORIZONTAL);
                detailsTextView.setPadding(LEFT_PADDING_DETAILS_TEXTVIEW, TOP_PADDING_DETAILS_TEXTVIEW,
                        RIGHT_PADDING_DETAILS_TEXTVIEW, BOTTOM_PADDING_DETAILS_TEXTVIEW);
                currRow.addView(detailsTextView);
                ViewGroup.LayoutParams params = detailsTextView.getLayoutParams();
                params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                detailsTextView.setLayoutParams(params);


                TextView priceTextView = new TextView(this);
                priceTextView.setText("$ " + String.valueOf(Double.toString(currDonut.itemPrice())));
                priceTextView.setTextColor(Color.BLACK);

                priceTextView.setGravity(Gravity.CENTER_HORIZONTAL);
                priceTextView.setPadding(PADDING_PRICE_TEXTVIEW, PADDING_PRICE_TEXTVIEW,
                        PADDING_PRICE_TEXTVIEW, PADDING_PRICE_TEXTVIEW);
                currRow.addView(priceTextView);


            } else if (e instanceof Coffee) {
                Coffee currCoffee = (Coffee) e;

                TextView selectTextview = new TextView(this);
                CheckBox check = new CheckBox(this);
                check.setId(currCoffee.getMenuItemID());

                check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        MainActivity.currOrder.updateRemovedItems(buttonView.getId(), isChecked);


                    }
                });

                check.setGravity(Gravity.CENTER_HORIZONTAL);
                check.setPadding(LEFT_PADDING_CHECKBOX, TOP_PADDING_CHECKBOX, RIGHT_PADDING_CHECKBOX,
                        BOTTOM_PADDING_CHECKBOX);
                currRow.addView(check);

                TextView idTextview = new TextView(this);
                idTextview.setText(String.valueOf(currCoffee.getMenuItemID()));
                idTextview.setTextColor(Color.BLACK);
                idTextview.setGravity(Gravity.CENTER_HORIZONTAL);
                idTextview.setPadding(LEFT_PADDING_ID_TEXTVIEW, TOP_PADDING_ID_TEXTVIEW, RIGHT_PADDING_ID_TEXTVIEW,
                        BOTTOM_PADDING_ID_TEXTVIEW);
                currRow.addView(idTextview);

                TextView detailsTextView = new TextView(this);
                detailsTextView.setText(String.valueOf(currCoffee.toString()));
                detailsTextView.setTextColor(Color.BLACK);
                detailsTextView.setGravity(Gravity.CENTER_HORIZONTAL);
                detailsTextView.setPadding(LEFT_PADDING_DETAILS_TEXTVIEW, TOP_PADDING_DETAILS_TEXTVIEW,
                        RIGHT_PADDING_DETAILS_TEXTVIEW, BOTTOM_PADDING_DETAILS_TEXTVIEW);
                currRow.addView(detailsTextView);
                ViewGroup.LayoutParams params = detailsTextView.getLayoutParams();
                params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                detailsTextView.setLayoutParams(params);


                TextView priceTextView = new TextView(this);
                priceTextView.setText("$ " + ((currCoffee.itemPrice())));
                priceTextView.setTextColor(Color.BLACK);
                priceTextView.setGravity(Gravity.CENTER_HORIZONTAL);
                priceTextView.setPadding(PADDING_PRICE_TEXTVIEW, PADDING_PRICE_TEXTVIEW,
                        PADDING_PRICE_TEXTVIEW, PADDING_PRICE_TEXTVIEW);

                currRow.addView(priceTextView);

            }

            currentOrderTable.addView(currRow, new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT));
        }


        String subtotal = Double.toString(MainActivity.currOrder.getSubtotal());

        subtotalCurrentTextview = findViewById(R.id.subtotalCurrentOrder);
        subtotalCurrentTextview.setText(subtotal);

        String total = Double.toString(MainActivity.currOrder.getTotal());
        totalCurrentTextview = findViewById(R.id.totalDefaultCurrent);
        totalCurrentTextview.setText(total);

        String salesTax = Double.toString(MainActivity.currOrder.getSalesTax());
        salesTaxCurrentTextview = findViewById(R.id.salesTaxCurrentOrder);
        salesTaxCurrentTextview.setText(salesTax);
    }

    /**
     * Method to place an order from the item list in the current order Activity
     * @param v view
     */
    public void placeOrder(View v) {
        Order currentOrder = MainActivity.currOrder;
        StoreOrders storeOrders = MainActivity.storeOrder;
        storeOrders.add(currentOrder);
        MainActivity.setOrder(new Order());
        currentOrder = MainActivity.getOrder();
        currentOrder.removeAllItems();
        finish();

    }

    /**
     *Method to remove an order from the item list in the current order Activity
     * @param 'none'
     */
    public void removeOrder() {
        MainActivity.currOrder.removeItemsFromOrder();

        TableLayout table = findViewById(R.id.tablelayoutCurrentOrder);

        int childCount = table.getChildCount();

        // Remove all rows except the first one
        if (childCount > 1) {
            table.removeViews(1, childCount - 1);
        }


        displayItemListAndPrice();

    }

    /**
     * This method is called upon clicking a certain putton
     * @param v View
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.removeBtnCurrentOrder) {
            removeOrder();
        } else if (id == R.id.cancelOrderStoreBtn) {
            placeOrder(v);
            Toast.makeText(CurrentOrderActivity.this, "Order Placed", Toast.LENGTH_SHORT).show();
        }

    }
}