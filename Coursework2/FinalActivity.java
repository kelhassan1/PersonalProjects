package com.example.interestcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.Locale;

public class FinalActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        ImageView image = (ImageView) findViewById(R.id.mainPic);

        // Retrieve the totalInt value from the Intent
        String numYearsValue = getIntent().getStringExtra("numYears");
        int totalIntValue = getIntent().getIntExtra("totalInt", 0);

        final TextView result = findViewById(R.id.txtResult);
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        result.setText("Total Interest: " + nf.format(totalIntValue));
        if (numYearsValue.equals("10"))
        {
            image.setImageResource(R.drawable.num10);
        }
        else if (numYearsValue.equals("20"))
        {
            image.setImageResource(R.drawable.num20);
        }
        else if (numYearsValue.equals("30"))
            {
                image.setImageResource(R.drawable.num30);
            }
        }
    }
