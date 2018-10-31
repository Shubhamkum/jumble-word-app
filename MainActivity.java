package com.example.shubhamkumar.jumblegame;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
EditText et;
    TextView tv,tv2,tv3,tv4,tv5;
    Button b,b1;EditText e;
    ImageView iv;
    SQLiteDatabase db;
    String wrong;
    String message;
    int c1=0,n;
    Cursor c;int correct=0;
    int k=0;String a1,a2;String get="",shuffle="";
    ArrayList<String >a=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b= (Button) findViewById(R.id.button);
        iv= (ImageView) findViewById(R.id.imageView2);
        b1= (Button) findViewById(R.id.button6);
        tv= (TextView) findViewById(R.id.textView3);
       // tv2= (TextView) findViewById(R.id.textView4);
        tv3= (TextView) findViewById(R.id.textView5);
       // tv4= (TextView) findViewById(R.id.textView6);
        tv5= (TextView) findViewById(R.id.textView10);
        e= (EditText) findViewById(R.id.editText);
        db=openOrCreateDatabase("jumbled1",MODE_PRIVATE,null);
        Intent i=getIntent();
        message=i.getStringExtra("1").toString();
        //Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        if(message.equals("begineer")) {
            //tv4.setText("begineer");
             c=db.rawQuery("select * from five",null);
        }
        else if(message.equals("pro")) {
             c=db.rawQuery("select * from four",null);
           // tv4.setText("intermediate");
        }
        else if(message.equals("intermediate")) {
            //tv4.setText("pro");
             c=db.rawQuery("select * from three",null);
        }
        while (c.moveToNext())
        {
            a.add(c.getString(1));
        }
        Collections.shuffle(a);
         n=a.size();
        iv.setImageResource(R.drawable.start);
        //tv4.setText(Integer.toString(n));
    }
    public void onStart()
    {
        iv.setImageResource(R.drawable.start);
        super.onStart();
        a1=a.get(0);
        ArrayList<Character>c=new ArrayList<>();
        for(int i=0;i<a1.length();i++)
        {
            c.add(a1.charAt(i));
        }
        Collections.shuffle(c);
        shuffle="";
        for(Character ch:c)
        {
            shuffle=shuffle+ch;
        }
        tv.setText(shuffle);

    }
public void jumble(View v)
{
    if(c1<3) {
        a2 = e.getText().toString();
        e.setText("");
        if (a2.equals(a1)) {
            //tv2.setText("Correct");
            iv.setImageResource(R.drawable.tick);
            correct=correct+1;
            //tv5.setText(Integer.toString(correct));
            k = k + 1;
            tv5.setText("Score" + "" + "=" + "" + k);
            if(k==n)
            {
                k=k-1;
                Intent j=new Intent(this,FinalScreen.class);
                j.putExtra("r",Integer.toString(correct));
                startActivity(j);
                finish();
            }
        } else {
            //tv2.setText("Incorrect");
            iv.setImageResource(R.drawable.cross);
            c1 = c1 + 1;
            wrong = Integer.toString(c1);
        }
        tv3.setText("wrong" + "" + "=" + "" + c1);
        a1 = a.get(k);
        ArrayList<Character> c = new ArrayList<>();
        for (int i = 0; i < a1.length(); i++) {
            c.add(a1.charAt(i));
        }
        Collections.shuffle(c);
        shuffle = "";
        for (Character ch : c) {
            shuffle = shuffle + ch;
        }
        tv.setText(shuffle);

    }
    else if(c1==3)
    {
        c1=c1+1;
    }
    if(c1==4)
    {
        Intent j=new Intent(this,FinalScreen.class);
        j.putExtra("r",Integer.toString(correct));
        startActivity(j);
        finish();
    }

}
    public void quit(View v)
    {
        Intent j=new Intent(this,FinalScreen.class);
        j.putExtra("r",Integer.toString(correct));
        startActivity(j);
        finish();
    }
}
