package com.christophersavage.parkingfeecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private Button mCalculateCostButton;
    private TextView mCalculatedCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        mCalculateCostButton = findViewById(R.id.calculateCost_button);
        mCalculateCostButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCalculatedCost = findViewById(R.id.calculatedCost);

                TextView mHoursParked = findViewById(R.id.hoursParked);
                String amount = mHoursParked.getText().toString();
                int amountInt = Integer.parseInt(amount);

                double cost = calculateCost(amountInt);

                mCalculatedCost.setText(Double.toString(cost));
            }
        });
    }

    protected double calculateCost(int hoursParked){
        double totalCost;

        if (hoursParked <= 3){
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
