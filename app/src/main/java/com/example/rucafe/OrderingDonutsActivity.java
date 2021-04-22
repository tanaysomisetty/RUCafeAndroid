package com.example.rucafe;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class OrderingDonutsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
        View.OnClickListener {

    private Button orderBtnDonuts;
    private RadioGroup donutTypeRadioGrp;
    private RadioButton radioButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_donuts);

        Spinner spinner = findViewById(R.id.flavorsSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.flavorsSpinner,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        orderBtnDonuts = findViewById(R.id.orderBtnCoffee);
        orderBtnDonuts.setOnClickListener(this);

        donutTypeRadioGrp = findViewById(R.id.donutTypeRadioGrp);
        textView = findViewById(R.id.text_view_selected);
        setTitle("Order Donuts");
    }

    /**
     * Method for a callback to be invoked when an item in the view has been selected
     * @param parent adapter view where the selection happens
     * @param view within the adapter view that was clicked
     * @param position of the view in the adapter
     * @param id of the selected item
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        setDonutFlavor(view);
        String flavorsText = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),flavorsText,Toast.LENGTH_SHORT).show();
    }

    /**
     * Method relating to the functions of the spinner.
     * Called when nothing is actually selected
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        System.out.println("onNothingSelected called......");

    }

    /**
     * On click method called when a certain button is clicked
     * @param v View
     */
    @Override
    public void onClick(View v) {
        System.out.println("onClick called......"+v);

        addToOrderDonut(v);

        Toast.makeText(OrderingDonutsActivity.this, "Order Added", Toast.LENGTH_SHORT).show();
        int radioId = donutTypeRadioGrp.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        textView.setText("Your Choice: "+radioButton.getText());
    }

    /**
     * This method sets the donut type to the desired selection set by the user
     * @param v View
     */
    public void setDonutType(View v) {
        System.out.println("setDonutType called......");

        int radioButtonID = donutTypeRadioGrp.getCheckedRadioButtonId();
        radioButton = donutTypeRadioGrp.findViewById(radioButtonID);

        if (radioButton.getText().equals("Cake Donut")) {
            donutOrder.setType("cake");
        }
        else if (radioButton.getText().equals("Yeast Donut")) {
            donutOrder.setType("yeast");

        }
        else if (radioButton.getText().equals("Donut Hole")) {
            donutOrder.setType("hole");
        }

        String price = Double.toString(donutOrder.itemPrice());
        subtotalTextview = findViewById(R.id.default_subtotal_donut);
        subtotalTextview.setText(price);


    }

    /**
     * This method sets the donut flavor to the desired selection set by the user
     * @param v view
     */
    public void setDonutFlavor(View v) {
        System.out.println("setDonutFlavor called......");

        donutFlavorSpinner = findViewById(R.id.flavorsSpinner);
    }

    /**
     * Method to change the text and call the remove method from the Donut class
     * @param v View
     */
    public void minusCount(View v) {
        System.out.println("minusCount called......");

        if (donutCount > 1) {
            donutCount--;
            donutOrder.remove(donutOrder);

            quantityTextview = findViewById(R.id.quantity_text);
            quantityTextview.setText(Integer.toString(donutCount));

            String price = Double.toString(donutOrder.itemPrice());
            subtotalTextview = findViewById(R.id.default_subtotal_donut);
            subtotalTextview.setText(price);

        }

    }

    /**
     * Method to change the text andd call the add method from the Donut class
     * @param v View
     */
    public void plusCount(View v) {
        System.out.println("plusCount called......");

        donutCount++;
        donutOrder.add(donutOrder);

        quantityTextview = findViewById(R.id.quantity_text);
        quantityTextview.setText(Integer.toString(donutCount));

        String price = Double.toString(donutOrder.itemPrice());
        subtotalTextview = findViewById(R.id.default_subtotal_donut);
        subtotalTextview.setText(price);
    }
}