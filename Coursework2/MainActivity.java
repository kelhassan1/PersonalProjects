package com.example.interestcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int monthPay = 0; // Monthly payment
    public String numYears = ""; // years of loan
    public int numMonths = 0; // to convert years into months

    public int totalInt = 0; // final interest paid

    public int numPrincipal = 0; // Principal


    // Getter for totalInt
    public int getTotalInt() {
        return totalInt;
    }

    // Setter for totalInt
    public void setTotalInt(int totalInt) {
        this.totalInt = totalInt;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText monthlyPay = (EditText) findViewById(R.id.txtMonthly);
        final Spinner years = (Spinner) findViewById(R.id.spnYears);
        final EditText principal = (EditText) findViewById(R.id.txtPrinciple);
        Button calc = (Button) findViewById(R.id.calcBtn);

        calc.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // ( monthly pay x months ) - principal
                numYears = years.getSelectedItem().toString();
                monthPay = Integer.parseInt(monthlyPay.getText().toString());
                numPrincipal = Integer.parseInt(principal.getText().toString());
                if (numYears.equals("10")) {
                    numMonths = 120;
                    totalInt = (monthPay * numMonths) - numPrincipal;
                } else if (numYears.equals("20")) {
                    numMonths = 240;
                    totalInt = (monthPay * numMonths) - numPrincipal;
                } else if (numYears.equals("30")) {
                    numMonths = 360;
                    totalInt = (monthPay * numMonths) - numPrincipal;
                } else {
                    totalInt = 0;
                }


                Intent intent = new Intent(MainActivity.this, FinalActivity.class);
                intent.putExtra("numYears", numYears);
                intent.putExtra("totalInt", totalInt);
                startActivity(intent);
            }
        });
    }
}