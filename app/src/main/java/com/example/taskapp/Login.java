package com.example.taskapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    Button mloginbtn;
    TextView mcreatebtn;

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText mEmail=(EditText)findViewById(R.id.editText);
        final EditText mPassword=(EditText)findViewById(R.id.editText3);
        mloginbtn=(Button)findViewById(R.id.button);
        mcreatebtn=(TextView)findViewById(R.id.textView5);

        preferences=getSharedPreferences("MYSHAREDPREF",0);
        mloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=mEmail.getText().toString();
                String password=mPassword.getText().toString();
                String uemail=preferences.getString("email","");
                String upass=preferences.getString("password","");


                if(email.equals(uemail)&& password.equals(upass))
                {
                    Intent intent=new Intent(Login.this,DashboardActivity.class);
                    finish();
                    startActivity(intent);
                }else
                {
                    Toast.makeText(Login.this,"Wrong Email/Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
        mcreatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(Login.this,Signup.class));
            }
        });

    }
    }

