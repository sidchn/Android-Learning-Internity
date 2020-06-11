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

import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {
    Button mSignupbtn;
    Button btnlog;

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        final EditText mEmail=(EditText)findViewById(R.id.Second);

        final EditText mPassword=(EditText)findViewById(R.id.Third);
        mSignupbtn=(Button)findViewById(R.id.button2);
        btnlog=findViewById(R.id.btnlog);

        preferences=getSharedPreferences("MYSHAREDPREF",0);

        final EditText mPhone=(EditText)findViewById(R.id.editText8);
        mSignupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nemail = mEmail.getText().toString();
                String npassword = mPassword.getText().toString();
                String nphone = mPhone.getText().toString();

                if (isValid(nemail)==false) {
                    Toast.makeText(Signup.this, "Invalid Email address", Toast.LENGTH_LONG).show();
                }
                else {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("email", nemail);
                    editor.putString("password", npassword);
                    editor.putString("phone", nphone);
                    editor.apply();
                    Toast.makeText(Signup.this, "User Registered", Toast.LENGTH_SHORT).show();
                    editor.commit();
                    finish();
                    startActivity(new Intent(Signup.this, Login.class));
                }
            }
        });

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(Signup.this,Login.class));
            }
        });

    }

    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }


}
