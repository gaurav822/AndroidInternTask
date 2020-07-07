package com.example.task_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView tv_roll,tv_name,tv_phone,tv_email,tv_password,tv_gender,tv_branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tv_roll=(TextView) findViewById(R.id.tvrollno);
        tv_name=(TextView) findViewById(R.id.tvname);
        tv_phone=(TextView) findViewById(R.id.tvphone);
        tv_email=(TextView) findViewById(R.id.tvemail);
        tv_password=(TextView) findViewById(R.id.tvpassword);
        tv_gender=(TextView) findViewById(R.id.tvgender);
        tv_branch=(TextView) findViewById(R.id.tvbranch);

        String roll = getIntent().getStringExtra("roll");
        tv_roll.setText("Rollno: "+roll);
        String name = getIntent().getStringExtra("name");
        tv_name.setText("Name: "+name);
        String phone = getIntent().getStringExtra("phone");
        tv_phone.setText("Phone: "+phone);
        String email = getIntent().getStringExtra("email");
        tv_email.setText("EmailID: "+email);
        String password = getIntent().getStringExtra("pass");
        tv_password.setText("Password: "+password);
        String gender = getIntent().getStringExtra("gender");
        tv_gender.setText("Gender: "+gender);
        String branch = getIntent().getStringExtra("branch");
        tv_branch.setText("Branch: "+branch);
    }
}