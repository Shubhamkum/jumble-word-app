package com.example.shubhamkumar.jumblegame;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Data extends AppCompatActivity {
EditText e1,e2;
    SQLiteDatabase db;
    Button b;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        e1= (EditText) findViewById(R.id.editText2);
        e2= (EditText) findViewById(R.id.editText3);
        tv= (TextView) findViewById(R.id.textView);
        b= (Button) findViewById(R.id.button2);
        db=openOrCreateDatabase("jumbled1",MODE_PRIVATE,null);
        if(db!=null)
            Toast.makeText(this,"Database created",Toast.LENGTH_SHORT).show();
        try {
           db.execSQL("create table five(roll varchar(20),name varchar(20))");
            Toast.makeText(this,"Table created",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(this,"Table not created",Toast.LENGTH_SHORT).show();
        }
    }
    public void register(View v)
    {
        String s1=e1.getText().toString().trim();
        String s2=e2.getText().toString().trim();
        try {
            if ((s2.length() == 0) || (s1.length() == 0)) {
                Toast.makeText(this, "enter value", Toast.LENGTH_SHORT).show();
            } else {
                db.execSQL("insert into five values('"+s1+"','"+s2+"')");
                Toast.makeText(this,"values inserted",Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e)
        {
        Toast.makeText(this,"values not inserted",Toast.LENGTH_SHORT).show();
        }
        e1.setText("");
        e2.setText("");
    }
    public void show(View v)
    {
        String s="";
        try {
            Cursor c = db.rawQuery("select * from five", null);
            while (c.moveToNext()) {
                s = s + c.getString(0) + "" + c.getString(1) + "\n";
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this,"problem in getting records",Toast.LENGTH_SHORT).show();
        }
        tv.setText(s);

    }
    public void onBackPressed(){
       if(moveTaskToBack(true))
       {
           Intent i=new Intent(this,check.class);
           startActivity(i);
       }
    }
}
