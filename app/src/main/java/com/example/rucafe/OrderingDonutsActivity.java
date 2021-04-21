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
        System.out.println("oncreate called......");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_donuts);

        Spinner spinner = findViewById(R.id.flavorsSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.flavorsSpinner,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        orderBtnDonuts = findViewById(R.id.orderBtnDonut);
        orderBtnDonuts.setOnClickListener(this);

        donutTypeRadioGrp = findViewById(R.id.donutTypeRadioGrp);
        textView = findViewById(R.id.text_view_selected);
        setTitle("Order Donuts");
    }

    /**
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        System.out.println("onItemSelected called......"+view);

        setDonutFlavor(view);
        String flavorsText = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),flavorsText,Toast.LENGTH_SHORT).show();
    }

    /**
     *
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        System.out.println("onNothingSelected called......");

    }

    /**
     *
     * @param v
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
     *
     * @param v
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

    public void setDonutFlavor(View v) {
        System.out.println("setDonutFlavor called......");

        donutFlavorSpinner = findViewById(R.id.flavorsSpinner);
    }

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