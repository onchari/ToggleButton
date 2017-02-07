package com.example.user2.togglebutton;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private ToggleButton toggleButton1, toggleButton2;
    private Button buttonSubmit;
    private CheckBox pizza, coffee, burger;
    Intent processOrder;
    Spinner spinner;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
        buttonSubmit = (Button) findViewById(R.id.button1);
        pizza = (CheckBox) findViewById(R.id.pizza);
        coffee = (CheckBox) findViewById(R.id.coffe);
        burger = (CheckBox) findViewById(R.id.burger);
        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(this);
        String[] country = {"Kenya", "Uganda", "Tanzania", "Burundi" };
        ArrayAdapter aa = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,country);
        aa.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

    }



    public void openD(View v){

        final StringBuilder result = new StringBuilder();
        CharSequence btn1 = toggleButton1.getText();
        CharSequence btn2 = toggleButton2.getText();
        result.append("Toogle Button 1 : " + btn1 + "\n Toogle Button 2: " + btn2 + "\n---------------------\n");

        int totalAmount = 0;
        if(pizza.isChecked()){
            result.append("Pizza : " + 100);
            totalAmount +=100;
        }

        if (coffee.isChecked()){
            result.append("\nCoffee : " + 50);
            totalAmount +=50;
        }

        if(burger.isChecked()){
            result.append("\nBurger : " + 120);
            totalAmount +=120;
        }
        result.append("\nTotal : " +totalAmount);
        processOrder = new Intent(MainActivity.this, Receipt.class);


        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setTitle("You Ordered the following");
        alertDialog.setMessage(result).setCancelable(false);
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                processOrder.putExtra("res",(Serializable)result);
                startActivity(processOrder);
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alertDialog1 = alertDialog.create();
        alertDialog1.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
