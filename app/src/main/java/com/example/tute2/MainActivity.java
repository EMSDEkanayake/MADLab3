package com.example.tute2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button calculate;
    RadioButton celcius;
    RadioButton Fahrenheit;
    TextView result;
    EditText input;
    Calculation calculation = new Calculation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate = (Button) findViewById(R.id.btn_Calculate);
        celcius = (RadioButton) findViewById(R.id.rd_btn_C);
        Fahrenheit = (RadioButton) findViewById(R.id.rd_btn_F);
        result = (TextView) findViewById(R.id.Outut);
        input =  (EditText) findViewById(R.id.Input);
    }

    @Override
    protected void onResume() {
        super.onResume();
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer() {
        Calculation cal= new Calculation();
//        String value = input.getText().toString();
        if(TextUtils.isEmpty(String.valueOf(input.getText().toString()))){
            Toast.makeText(this, "Please enter the temperature", Toast.LENGTH_LONG).show();
//            result.setText("");
//            result.setBackgroundColor(Color.WHITE);
        }
        /*else if(input.getText().toString().matches("-?\\d+(\\.\\d+)")){
            Toast.makeText(MainActivity.this,"Please Enter a number", Toast.LENGTH_LONG).show();
            result.setText("");
        }*/
        else{
            float a = Float.parseFloat(String.valueOf(input.getText().toString()));
            if( celcius.isChecked() ){
                a = cal.convertCelciusToFahrenheit(a);
                result.setBackgroundColor(Color.BLUE);
                result.setText(String.format("%.4f0",calculation.convertCelciusToFahrenheit(a))+"C");

            }else if(Fahrenheit.isChecked()){
                a = cal.convertFahrenheitToCelcius(a);
                result.setText(String.format("%.4f",calculation.convertCelciusToFahrenheit(a))+"F");
                result.setBackgroundColor(Color.RED);
            }
            else{
                Toast.makeText(MainActivity.this,"Select the button",Toast.LENGTH_SHORT).show();
                a = 0.0f;
            }
            result.setText(new Float(a).toString());
        }
    }
}