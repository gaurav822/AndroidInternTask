package com.example.countapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    int a=0;
    TextView tv;
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView) findViewById(R.id.textCount);
        b1= (Button) findViewById(R.id.subButton);
        b2= (Button) findViewById(R.id.toastButton);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Action
                a--;
                tv.setText(""+a);
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText()=="0"){
                    a=0;
                    Toast.makeText(MainActivity.this,"Your Count is: "+a+"",Toast.LENGTH_SHORT).show();
                }

                else{
                Toast.makeText(MainActivity.this,"Your Count is: "+a+"",Toast.LENGTH_SHORT).show();
                }

            }
        });

        if(savedInstanceState!=null){

            String s=savedInstanceState.getString(("mykey"));
            a=Integer.parseInt(s);
            tv.setText(""+a);

        }
    }

    public void countInc(View view) {

        a++;
        tv.setText(""+a);

    }

    public void resetToZero(View view) {
        a=0;
        tv.setText(""+a);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("mykey",tv.getText().toString());
    }
}