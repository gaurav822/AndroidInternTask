package com.example.scoreboardapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    int a=0;
    int b=0;
    Button b1;
    Button b2;
    Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView) findViewById(R.id.teamAScore);
        tv2=(TextView) findViewById(R.id.teamBScore);
        b1=(Button) findViewById(R.id.onePointB);
        b2=(Button) findViewById(R.id.twoPointB);
        b3=(Button) findViewById(R.id.threePointB);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                b=b+1;
                tv2.setText(""+b);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=b+2;
                tv2.setText(""+b);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=b+3;
                tv2.setText(""+b);
            }
        });

        if(savedInstanceState!=null){

            String s1=savedInstanceState.getString(("key1"));
            a=Integer.parseInt(s1);
            tv1.setText(""+a);
            String s2=savedInstanceState.getString(("key2"));
            b=Integer.parseInt(s2);
            tv2.setText(""+b);

        }
    }

    public void onePointA(View view) {
        a=a+1;
        tv1.setText(""+a);
    }

    public void twoPointA(View view) {
        a=a+2;
        tv1.setText(""+a);
    }

    public void threePointA(View view) {
        a=a+3;
        tv1.setText(""+a);
    }

    public void resetFunction(View view) {
        a=0;
        b=0;
        tv1.setText(""+a);
        tv2.setText(""+b);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key1",tv1.getText().toString());
        outState.putString("key2",tv2.getText().toString());
    }
}