package com.example.mobiledevassign1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

public class EMIButtonListener implements View.OnClickListener {

    private MainActivity mortgageinputActivity;     //Private variable for the input activity of type MainActivity
    public EMIButtonListener(MainActivity m){
        this.mortgageinputActivity = m;
    }
    @Override
    public void onClick(View v){

        /*Finds original amount TextView by ID and parses it to a double from a string */

        TextView originalAmtTextView = (TextView) mortgageinputActivity.findViewById(R.id.originalAmt);
        double originalAmt = Double.parseDouble(originalAmtTextView.getText().toString());

        /*Finds down payment TextView by ID and parses it to a double from a string */

        TextView downPaymentTextView = (TextView) mortgageinputActivity.findViewById(R.id.downPayment);
        double downPayment = Double.parseDouble(downPaymentTextView.getText().toString());

        /*Finds interest rate TextView by ID and parses it to a double from a string */

        TextView interestRateTextView = (TextView) mortgageinputActivity.findViewById(R.id.interestRate);
        double interestRateValue = Double.parseDouble(interestRateTextView.getText().toString());

        /*Finds amortization TextView by ID and parses it to a double from a string */

        TextView amortizationTextView = (TextView) mortgageinputActivity.findViewById(R.id.amortization);
        double amortizationTerm = Double.parseDouble(amortizationTextView.getText().toString());

        /*Creates new intent, connecting the mortgage input activity with the EMI results class*/

        Intent i = new Intent(mortgageinputActivity, EMIResults.class);

        /*Uses the .putExtra() method to send the information from the string to the variables*/

        i.putExtra(MainActivity.Mortgage_String, originalAmt);
        i.putExtra(MainActivity.DownPayment_String, downPayment);
        i.putExtra(MainActivity.InterestRate_String, interestRateValue);
        i.putExtra(MainActivity.Amortization_String, amortizationTerm);

        mortgageinputActivity.startActivity(i);     //Starts the activity with the intent as a parameter



    }
}