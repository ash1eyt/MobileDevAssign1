package com.example.mobiledevassign1;

import androidx.appcompat.app.AppCompatActivity;        //Imports libraries
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button calculateEMIButton;
    private Button clearButton;

    /*Defines strings for each of the EditText fields*/
    public static final String Mortgage_String = "com.example.mobiledevassign1.originalAmt";
    public static final String DownPayment_String = "com.example.mobiledevassign1.downPayment";
    public static final String InterestRate_String = "com.example.mobiledevassign1.interestRate";
    public static final String Amortization_String = "com.example.mobiledevassign1.amortization";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Finds the calculate button by ID and then creates an object of the EMIButtonListener class*/

        calculateEMIButton = (Button) findViewById(R.id.calculateBtn);
        EMIButtonListener clickListener = new EMIButtonListener(this);
        calculateEMIButton.setOnClickListener(clickListener);

        /*Finds the clear button by ID, and then sets the text fields to "", clearing the user inputs */

        clearButton = (Button) findViewById(R.id.clearBtn);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText originalAmt = (EditText) findViewById(R.id.originalAmt);
                EditText downPayment = (EditText) findViewById(R.id.downPayment);
                EditText interestRate = (EditText) findViewById(R.id.interestRate);
                EditText amortization = (EditText) findViewById(R.id.amortization);

                originalAmt.setText("");
                downPayment.setText("");
                interestRate.setText("");
                amortization.setText("");

            }
        });

    }
}