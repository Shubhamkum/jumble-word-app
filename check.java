package com.example.shubhamkumar.jumblegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class check extends AppCompatActivity {
    Button b,d;RadioGroup rg;
    RadioButton r1,r2,r3;
    int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        b= (Button) findViewById(R.id.button4);
        rg= (RadioGroup) findViewById(R.id.radioGroup2);
        r1= (RadioButton) findViewById(R.id.radioButton4);
        r2= (RadioButton) findViewById(R.id.radioButton5);
        r3= (RadioButton) findViewById(R.id.radioButton6);
       // d=(Button)findViewById(R.id.button7);

    }
   /* public void data(View v){
        Intent j=new Intent(this,Data.class);
        startActivity(j);
    }*/
    public void start(View v) {
        if(r1.isChecked())
        {
            c=1;
            //Toast.makeText(this,"Begin",Toast.LENGTH_SHORT).show();
        }
        else if(r2.isChecked())
        {
            c=2;
            //Toast.makeText(this,"Inter",Toast.LENGTH_SHORT).show();
        }
        else if(r3.isChecked())
        {
            c=3;
            //Toast.makeText(this,"pro",Toast.LENGTH_LONG).show();
        }

        Intent i=new Intent(this,MainActivity.class);
        if(c==1){
        i.putExtra("1","begineer");

        }
        else if(c==2)
            i.putExtra("1","intermediate");
        else if(c==3)
            i.putExtra("1","pro");
        startActivity(i);
        }
    }


