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

        mCalculateCostButton = findViewById(R.id.calculateCostButton);
        mCalculateCostButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCalculatedCost = findViewById(R.id.calculatedCost);

                TextView hoursParked = findViewById(R.id.hibble);
                String amount = hoursParked.getText().toString();
                int amountInt = Integer.parseInt(amount);



                mCalculatedCost.setText(Integer.toString(amountInt));

            }
        });
    }

}
