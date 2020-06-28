package com.example.loginregisterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et= (EditText) findViewById(R.id.userName);
        et2 =(EditText) findViewById(R.id.passWord);

    }

    public void RegistrationFunction(View view) {
        Intent i=new Intent(this,Registration.class);
        startActivity(i);
    }

    public void LoginFunction(View view) {
        String data = et.getText().toString();
        String pass = et2.getText().toString();

        if(data.isEmpty()){
            Toast.makeText(this,"Please Enter Username",Toast.LENGTH_SHORT).show();
        }

        else if(pass.isEmpty()){

            Toast.makeText(this,"Please Enter Password",Toast.LENGTH_SHORT).show();
        }
        else {

                Intent i = new Intent(this, Homepage.class);
                i.putExtra("username", data);
                startActivity(i);

        }
    }
}