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
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String flavorsText = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),flavorsText,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(OrderingDonutsActivity.this, "Order Added", Toast.LENGTH_SHORT).show();
        int radioId = donutTypeRadioGrp.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        textView.setText("Your Choice: "+radioButton.getText());
    }

    public void checkButton(View v) {
        int radioId = donutTypeRadioGrp.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        Toast.makeText(this, radioButton.getText()+" selected", Toast.LENGTH_SHORT).show();
    }
}