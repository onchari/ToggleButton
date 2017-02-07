package com.example.user2.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Receipt extends AppCompatActivity {

    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        res = (TextView) findViewById(R.id.display);
        String s = getIntent().getStringExtra("res");

        res.setText(s);

    }
}
