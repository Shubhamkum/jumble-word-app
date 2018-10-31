package com.example.shubhamkumar.jumblegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalScreen extends AppCompatActivity {
String result;TextView tv;Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);
        tv= (TextView) findViewById(R.id.textView12);
        b= (Button) findViewById(R.id.button5);
        Intent i=getIntent();
        result=i.getStringExtra("r").toString();
        tv.setText(result);
    }
    public void home(View v)
    {
        Intent i=new Intent(this,check.class);
        startActivity(i);

    }
}
