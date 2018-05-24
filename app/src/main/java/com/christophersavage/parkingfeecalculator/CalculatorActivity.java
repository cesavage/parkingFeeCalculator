package com.christophersavage.parkingfeecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    private TextView mCalculatedCost_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Button mCalculateCostButton = findViewById(R.id.calculateCost_button);
        mCalculateCostButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mCalculatedCost_textView = findViewById(R.id.calculatedCost);
                EditText mHoursParked_editText = findViewById(R.id.hoursParked);
                int amountInt;
                try{
                    amountInt = Integer.parseInt(mHoursParked_editText.getText().toString());
                }
                catch (NumberFormatException e){
                    amountInt = 0;
                    Toast.makeText(CalculatorActivity.this, "Enter the number of hours parked, rounded to the next hour.", Toast.LENGTH_LONG).show();
                }

                double cost = calculateCost(amountInt);

                mCalculatedCost_textView.setText(Double.toString(cost));

            }
        });
    }

    protected double calculateCost(int hoursParked){
        double totalCost;

        if (hoursParked == 0){
            totalCost = 0;
        }
        else if (hoursParked <= 3){
            totalCost = 5;
        }

        else if (hoursParked < 12){
            totalCost = 5 + (1.5 * (hoursParked-3));
        }

        else{
            totalCost = 18;
        }

        return totalCost;
    }
}
