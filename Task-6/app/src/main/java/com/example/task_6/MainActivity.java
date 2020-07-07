package com.example.task_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_roll,et_name,et_email,et_phone,et_password;
    RadioButton r_male,r_female;
    Spinner sp_branch;
    String gender;
    String branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp_branch=(Spinner) findViewById(R.id.branch);
        et_roll=(EditText) findViewById(R.id.rollno);
        et_name=(EditText) findViewById(R.id.name);
        et_email=(EditText) findViewById(R.id.email);
        et_phone=(EditText) findViewById(R.id.phone);
        et_password=(EditText) findViewById(R.id.password);
        r_male=(RadioButton) findViewById(R.id.male);
        r_female=(RadioButton) findViewById(R.id.female);

        ArrayAdapter<CharSequence> branchAdapter= ArrayAdapter.createFromResource(this,R.array.branch,android.R.layout.simple_spinner_item);
        sp_branch.setAdapter(branchAdapter);

        sp_branch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    branch=sp_branch.getItemAtPosition(position).toString();
                }
                else{
                    branch="";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    public void submit(View view) {

        String str_roll=et_roll.getText().toString();
        String str_name=et_name.getText().toString();
        String str_email=et_email.getText().toString();
        String str_phone=et_phone.getText().toString();
        String str_pass=et_password.getText().toString();

        if(str_roll.isEmpty()){
            Toast.makeText(this,"Please Enter Roll Number",Toast.LENGTH_SHORT).show();
        }

        else if(str_name.isEmpty()){
            Toast.makeText(this,"Please Enter Name",Toast.LENGTH_SHORT).show();
        }

        else if(str_phone.isEmpty()){
            Toast.makeText(this,"Please Enter Phone Number",Toast.LENGTH_SHORT).show();
        }

        else if(str_email.isEmpty()){
            Toast.makeText(this,"Please Enter Email Address",Toast.LENGTH_SHORT).show();
        }

        else if(str_pass.isEmpty()){
            Toast.makeText(this,"Please Enter Password",Toast.LENGTH_SHORT).show();
        }

        else if(!r_male.isChecked() && !r_female.isChecked()){
            Toast.makeText(this,"Please choose Gender",Toast.LENGTH_SHORT).show();
        }

        else if(branch.isEmpty()){

            Toast.makeText(this,"Please Select Branch",Toast.LENGTH_SHORT).show();
        }



        else{

            if(r_male.isChecked()){

                gender=r_male.getText().toString();

            }

            else {

                gender=r_female.getText().toString();
            }
            Intent i = new Intent(this, DetailsActivity.class);
            i.putExtra("roll", str_roll);
            i.putExtra("name",str_name);
            i.putExtra("phone",str_phone);
            i.putExtra("email",str_email);
            i.putExtra("pass",str_pass);
            i.putExtra("gender",gender);
            i.putExtra("branch",branch);
            startActivity(i);
        }
    }
}