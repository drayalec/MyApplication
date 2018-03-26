package com.example.draya.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double mealcost;
    double tipcost;
    String tipchoice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText cost = (EditText)findViewById(R.id.txtPercentage);
        final Spinner Group =(Spinner)findViewById(R.id.txtGroup);
        Button charges = (Button)findViewById(R.id.btnCharge);
            charges.setOnClickListener(new View.OnClickListener() {
                final TextView result = (TextView)findViewById(R.id.txtResult);
                @Override
                public void onClick(View view) {
                    mealcost = Double.parseDouble(cost.getText().toString());
                    DecimalFormat currency = new DecimalFormat("$###,###,###");
                    tipchoice = Group.getSelectedItem().toString();
                    double tip_percent = Double.parseDouble(tipchoice);
                    tipcost = mealcost * tip_percent;
                    String finalmessage = "The tip will be" + currency.format((tipcost));
                    result.setText(finalmessage);



                }
            });

    }
}
