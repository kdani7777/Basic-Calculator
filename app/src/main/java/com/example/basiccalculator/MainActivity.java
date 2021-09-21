package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view) {
        EditText firstTextField = (EditText) findViewById(R.id.firstNumber);
        EditText secondTextField = (EditText) findViewById(R.id.secondNumber);
        String firstNumber = firstTextField.getText().toString();
        String secondNumber = secondTextField.getText().toString();
        if (firstNumber.equals("") || secondNumber.equals("")) {
            Toast.makeText(MainActivity.this, firstNumber, Toast.LENGTH_LONG).show();
        } else {

            int num1 = Integer.parseInt(firstNumber);
            int num2 = Integer.parseInt(secondNumber);
            int button  = view.getId();
            //Button op = (Button) view;
            //String operation = op.getText().toString();

            String result = "";
            if (button == R.id.additionButton) {
                result = String.valueOf(num1 + num2);
            } else if (button == R.id.subtractionButton) {
                result = String.valueOf(num1 - num2);
            } else if (button == R.id.multiplicationButton) {
                result = String.valueOf(num1 * num2);
            } else if (button == R.id.divisionButton) {
                if (num2 == 0) {
                    result = "Error";
                } else {
                    result = String.valueOf(num1 / num2);
                }
            }

            goToResult(result);

        }

    }

    public void goToResult(String result) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}