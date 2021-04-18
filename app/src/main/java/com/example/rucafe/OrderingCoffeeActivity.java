package com.example.rucafe;

import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class OrderingCoffeeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
        View.OnClickListener {

    private Button orderBtnCoffee;
    private CheckBox milkCheckbox, creamCheckbox, whippedCheckbox, syrupCheckbox, caramelCheckbox;
    private Spinner sizeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_coffee);
        sizeSpinner = findViewById(R.id.sizeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sizeSpinner,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizeSpinner.setAdapter(adapter);
        sizeSpinner.setOnItemSelectedListener(this);
        orderBtnCoffee = findViewById(R.id.orderBtnCoffee);
        orderBtnCoffee.setOnClickListener(this);
        milkCheckbox = findViewById(R.id.milkCheckbox);
        creamCheckbox = findViewById(R.id.creamCheckbox);
        whippedCheckbox = findViewById(R.id.whippedCheckbox);
        syrupCheckbox = findViewById(R.id.syrupCheckbox);
        caramelCheckbox = findViewById(R.id.caramelCheckbox);

        creamCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (creamCheckbox.isChecked()) {
                    String creamCheckboxData = creamCheckbox.getText().toString();
                    Toast.makeText(OrderingCoffeeActivity.this, creamCheckboxData+" selected",
                            Toast.LENGTH_SHORT).show();
                } else if (!creamCheckbox.isChecked()) {
                    String creamUncheckedData = creamCheckbox.getText().toString();
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
                    Toast.makeText(OrderingCoffeeActivity.this,milkCheckboxData+" selected",
                            Toast.LENGTH_SHORT).show();
                } else if (!milkCheckbox.isChecked()) {
                    String milkUncheckedData = milkCheckbox.getText().toString();
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
                    Toast.makeText(OrderingCoffeeActivity.this,whippedCheckboxData+" selected",
                            Toast.LENGTH_SHORT).show();
                } else if (!whippedCheckbox.isChecked()) {
                    String whippedUncheckedData = whippedCheckbox.getText().toString();
                    Toast.makeText(OrderingCoffeeActivity.this,whippedUncheckedData+" selected",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        caramelCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (caramelCheckbox.isChecked()) {
                    String caramelCheckboxData = caramelCheckbox.getText().toString();
                    Toast.makeText(OrderingCoffeeActivity.this,caramelCheckboxData+" selected",
                            Toast.LENGTH_SHORT).show();
                } else if (!caramelCheckbox.isChecked()) {
                    String caramelUncheckedData = caramelCheckbox.getText().toString();
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
                    Toast.makeText(OrderingCoffeeActivity.this,syrupCheckBoxData+ " selected",
                            Toast.LENGTH_SHORT).show();
                } else if (!syrupCheckbox.isChecked()) {
                    String syrupUncheckedData = syrupCheckbox.getText().toString();
                    Toast.makeText(OrderingCoffeeActivity.this, syrupUncheckedData+" unselected",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });
        setTitle("Order Coffee");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(OrderingCoffeeActivity.this,"Order Added",Toast.LENGTH_SHORT).show();

    }
}