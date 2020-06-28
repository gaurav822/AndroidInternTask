package com.example.loginregisterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Registration extends AppCompatActivity {

    EditText et,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        et= (EditText) findViewById(R.id.userName);
        et2 =(EditText) findViewById(R.id.passWord);
    }

    public void Registration(View view) {

    }
}