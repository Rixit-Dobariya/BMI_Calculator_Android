package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText txtHeightIn,txtHeightFt,txtWeight;
        Button calculate;

        txtResult=findViewById(R.id.txtviewResult);
        txtHeightIn=findViewById(R.id.edtHeightIn);
        txtHeightFt=findViewById(R.id.edtHeightFeet);
        txtWeight=findViewById(R.id.edtWeight);
        calculate=findViewById(R.id.btnBMI);
        LinearLayout llMain = findViewById(R.id.llMain);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight=Integer.parseInt(txtWeight.getText().toString());
                int inches=Integer.parseInt(txtHeightIn.getText().toString());
                int feet=Integer.parseInt(txtHeightFt.getText().toString());

                inches=feet*12+inches;
                double cm=inches*2.54;
                double m=cm/100;

                double bmi=weight/(m*m);

                if(bmi>24.9)
                {
                    txtResult.setText(R.string.overweight);
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                }
                else if(bmi<18.5)
                {
                    txtResult.setText(R.string.underweight);
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                }
                else
                {
                    txtResult.setText(R.string.healthy);
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }
            }
        });

    }
}