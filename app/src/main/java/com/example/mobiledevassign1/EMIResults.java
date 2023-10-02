package com.example.mobiledevassign1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import java.text.DecimalFormat;
import android.widget.TextView;


public class EMIResults extends AppCompatActivity {

    private Button recalculateBtn;  //Private variable of the button type for the recalculate button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emiresults);

        /*Uses .getIntent() method to read the inputted values from the Strings in the MainActivity*/

        double originalAmt = getIntent().getDoubleExtra(MainActivity.Mortgage_String, 0);
        double downPayment = getIntent().getDoubleExtra(MainActivity.DownPayment_String, 0);
        double interestRate = getIntent().getDoubleExtra(MainActivity.InterestRate_String, 0);
        double amortizationTerm = getIntent().getDoubleExtra(MainActivity.Amortization_String, 0)*12;  //Multiplies by 12 (12 months in a year)

        /*Calculations for the EMI amount*/

        double principalAmt = originalAmt - downPayment;
        double monthlyInterestRate = interestRate / (12 * 100);
        double monthlyPayment = (monthlyInterestRate * principalAmt)/(1 - Math.pow((1+monthlyInterestRate), -amortizationTerm));
        double totalPayment = monthlyPayment * amortizationTerm;
        double totalInterestPayment = totalPayment - principalAmt;

        /*Formatting the monthly payment result to two decimal places and using the .setText method to display*/

        TextView monthlyPaymentTextView = (TextView) findViewById(R.id.monthlyPayment);
        DecimalFormat d1 = new DecimalFormat("#.##");
        String monthlyPayment_Str = d1.format(monthlyPayment);
        monthlyPaymentTextView.setText(monthlyPayment_Str);

        /*Formatting the total payment results to two decimal places and using the .setText method to display*/

        TextView totalPaymentTextView = (TextView) findViewById(R.id.totalPayment);
        DecimalFormat d2 = new DecimalFormat("#.##");
        String totalPayment_Str = d2.format(totalPayment);
        totalPaymentTextView.setText(totalPayment_Str);

        /*Formatting the total interest payment results to two decimal places and using the .setText method to display*/

        TextView totalInterestPaymentTextView = (TextView) findViewById(R.id.totalInterestPayment);
        DecimalFormat d3 = new DecimalFormat("#.##");
        String totalInterestPayment_Str = d3.format(totalInterestPayment);
        totalInterestPaymentTextView.setText(totalInterestPayment_Str);

        /*Sets an action for the recalculate button and links the two activities together using the Intent class*/

        recalculateBtn = (Button) findViewById(R.id.recalculatebutton);
        recalculateBtn.setOnClickListener((v) -> {

            Intent i = new Intent(EMIResults.this, MainActivity.class);

            EMIResults.this.onBackPressed();
        });


    }
}