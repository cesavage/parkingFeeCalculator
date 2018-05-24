package com.christophersavage.parkingfeecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    private TextView mCalculatedParkingCost_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Button mCalculateCostButton = findViewById(R.id.calculateCost_button);
        mCalculateCostButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mCalculatedParkingCost_textView = findViewById(R.id.calculatedParkingCost);
                EditText mHoursParked_editText = findViewById(R.id.hoursParked);

                int hoursParked;
                try{
                    hoursParked = Integer.parseInt(mHoursParked_editText.getText().toString());
                }
                catch (NumberFormatException e){
                    hoursParked = 0;
                    Toast.makeText(CalculatorActivity.this, R.string.userInputPrompt, Toast.LENGTH_LONG).show();
                }

                double calculatedParkingCost = calculateCost(hoursParked);
                mCalculatedParkingCost_textView.setText(String.format(Double.toString(calculatedParkingCost), "%d"));
            }
        });
    }

    protected double calculateCost(int hoursParked){
        double parkingCost;

        if (hoursParked == 0){
            parkingCost = 0;
        }

        else if (hoursParked <= 3){
            parkingCost = 5;
        }

        else if (hoursParked < 12){
            parkingCost = 5 + (1.5 * (hoursParked-3));
        }

        else{
            parkingCost = 18;
        }

        return parkingCost;
    }
}