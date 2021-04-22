package com.example.rucafe;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class OrderingCoffeeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
        View.OnClickListener {

    private Button orderBtnCoffee;
    private CheckBox milkCheckbox, creamCheckbox, whippedCheckbox, syrupCheckbox, caramelCheckbox;
    private RadioGroup coffeeSizeRadioGrp;
    private RadioButton radioButton;
    private Coffee coffeeOrder;
    private TextView subtotalTextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_coffee);
        orderBtnCoffee = findViewById(R.id.orderBtnCoffee);
        orderBtnCoffee.setOnClickListener(this);
        milkCheckbox = findViewById(R.id.milkCheckbox);
        creamCheckbox = findViewById(R.id.creamCheckbox);
        whippedCheckbox = findViewById(R.id.whippedCheckbox);
        syrupCheckbox = findViewById(R.id.syrupCheckbox);
        caramelCheckbox = findViewById(R.id.caramelCheckbox);
        coffeeSizeRadioGrp = findViewById(R.id.coffee_radio_grp);

        creamCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (creamCheckbox.isChecked()) {
                    String creamCheckboxData = creamCheckbox.getText().toString();
                    AddIn cream = new AddIn("cream");
                    coffeeOrder.add(cream);
                    addInSelect(v);
                    Toast.makeText(OrderingCoffeeActivity.this, creamCheckboxData+" selected",
                            Toast.LENGTH_SHORT).show();
                } else if (!creamCheckbox.isChecked()) {
                    String creamUncheckedData = creamCheckbox.getText().toString();
                    AddIn cream = new AddIn("cream");
                    coffeeOrder.remove(cream);
                    addInSelect(v);
                    Toast.makeText(OrderingCoffeeActivity.this, creamUncheckedData+" unselected",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        milkCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (milkCheckbox.isChecked()) {
                    String milkCheckboxData = milkCheckbox.getText().toString();
                    AddIn milk = new AddIn("milk");
                    coffeeOrder.add(milk);
                    addInSelect(v);
                    Toast.makeText(OrderingCoffeeActivity.this,milkCheckboxData+" selected",
                            Toast.LENGTH_SHORT).show();
                } else if (!milkCheckbox.isChecked()) {
                    String milkUncheckedData = milkCheckbox.getText().toString();
                    AddIn milk = new AddIn("milk");
                    coffeeOrder.remove(milk);
                    addInSelect(v);
                    Toast.makeText(OrderingCoffeeActivity.this, milkUncheckedData+" unselected",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });
        whippedCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (whippedCheckbox.isChecked()) {
                    String whippedCheckboxData = whippedCheckbox.getText().toString();
                    AddIn whippedCream = new AddIn("whippedCream");
                    coffeeOrder.add(whippedCream);
                    addInSelect(v);
                    Toast.makeText(OrderingCoffeeActivity.this,whippedCheckboxData+" selected",
                            Toast.LENGTH_SHORT).show();
                } else if (!whippedCheckbox.isChecked()) {
                    String whippedUncheckedData = whippedCheckbox.getText().toString();
                    AddIn whippedCream = new AddIn("whippedCream");
                    coffeeOrder.remove(whippedCream);
                    addInSelect(v);
                    Toast.makeText(OrderingCoffeeActivity.this,whippedUncheckedData+" unselected",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        caramelCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (caramelCheckbox.isChecked()) {
                    String caramelCheckboxData = caramelCheckbox.getText().toString();
                    AddIn caramel = new AddIn("caramel");
                    coffeeOrder.add(caramel);
                    addInSelect(v);
                    Toast.makeText(OrderingCoffeeActivity.this,caramelCheckboxData+" selected",
                            Toast.LENGTH_SHORT).show();
                } else if (!caramelCheckbox.isChecked()) {
                    String caramelUncheckedData = caramelCheckbox.getText().toString();
                    AddIn caramel = new AddIn("caramel");
                    coffeeOrder.remove(caramel);
                    addInSelect(v);
                    Toast.makeText(OrderingCoffeeActivity.this,caramelUncheckedData+" unselected",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        syrupCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (syrupCheckbox.isChecked()) {
                    String syrupCheckBoxData = syrupCheckbox.getText().toString();
                    AddIn syrup = new AddIn("syrup");
                    coffeeOrder.add(syrup);
                    addInSelect(v);
                    Toast.makeText(OrderingCoffeeActivity.this,syrupCheckBoxData+ " selected",
                            Toast.LENGTH_SHORT).show();
                } else if (!syrupCheckbox.isChecked()) {
                    String syrupUncheckedData = syrupCheckbox.getText().toString();
                    AddIn syrup = new AddIn("syrup");
                    coffeeOrder.remove(syrup);
                    addInSelect(v);
                    Toast.makeText(OrderingCoffeeActivity.this, syrupUncheckedData+" unselected",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });
        setTitle("Order Coffee");

        coffeeOrder = new Coffee();
        coffeeOrder.setSize("Short");
        coffeeOrder.add(coffeeOrder);

        String price = Double.toString(coffeeOrder.itemPrice());
        subtotalTextview = findViewById(R.id.default_subtotal_coffee);
        subtotalTextview.setText(price);


    }

    /**
     * Method called when an item in the spinner is selected
     * @param parent, view, position, id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    /**
     * Method relating to the functions of the spinner.
     * Called when nothing is actually selected
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /**
     * On click method called when a certain button is clicked
     * @param v View
     */
    @Override
    public void onClick(View v) {

        addToOrderCoffee(v);
        Toast.makeText(OrderingCoffeeActivity.this,"Order Added",Toast.LENGTH_SHORT).show();
        int radioId = coffeeSizeRadioGrp.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);




    }

    /**
     * Method to set the desired coffee size selected by the user in the Activity
     * @param v view
     */
    public void setCoffeeSize(View v) {
        int radioButtonID = coffeeSizeRadioGrp.getCheckedRadioButtonId();
        radioButton = coffeeSizeRadioGrp.findViewById(radioButtonID);

        if (radioButton.getText().equals("Short")) {
            coffeeOrder.setSize("Short");
        }
        else if (radioButton.getText().equals("Tall")) {
            coffeeOrder.setSize("Tall");

        }
        else if (radioButton.getText().equals("Grande")) {
            coffeeOrder.setSize("Grande");

        } else if (radioButton.getText().equals("Venti")) {
            coffeeOrder.setSize("Venti");
        }

        String price = Double.toString(coffeeOrder.itemPrice());
        subtotalTextview = findViewById(R.id.default_subtotal_coffee);
        subtotalTextview.setText(price);

    }

    /**
     * Method to select the attributes of a coffee object such as the size and add-ins in the Activity
     * @param v view
     */
    public void addInSelect(View v) {
        if (creamCheckbox.isChecked()) {
            String price = Double.toString(coffeeOrder.itemPrice());
            subtotalTextview = findViewById(R.id.default_subtotal_coffee);
            subtotalTextview.setText(price);

        } else if (milkCheckbox.isChecked()) {
            String price = Double.toString(coffeeOrder.itemPrice());
            subtotalTextview.findViewById(R.id.default_subtotal_coffee);
            subtotalTextview.setText(price);

        } else if (whippedCheckbox.isChecked()) {
            String price = Double.toString(coffeeOrder.itemPrice());
            subtotalTextview = findViewById(R.id.default_subtotal_coffee);
            subtotalTextview.setText(price);

        } else if (syrupCheckbox.isChecked()) {
            String price = Double.toString(coffeeOrder.itemPrice());
            subtotalTextview = findViewById(R.id.default_subtotal_coffee);
            subtotalTextview.setText(price);

        } else if (caramelCheckbox.isChecked()) {
            String price = Double.toString(coffeeOrder.itemPrice());
            subtotalTextview = findViewById(R.id.default_subtotal_coffee);
            subtotalTextview.setText(price);
        }



    }

    /**
     * Method to reset the fields of the order object and add the coffee to the order object
     * @param v view
     */
    public void addToOrderCoffee(View v) {
        MainActivity.currOrder.add(coffeeOrder);
        finish();

    }
}