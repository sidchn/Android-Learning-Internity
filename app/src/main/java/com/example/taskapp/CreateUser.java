package com.example.taskapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.taskapp.childfragments.ChatsFragment;

import java.util.regex.Pattern;


public class CreateUser extends AppCompatActivity {
    private static final String TAG = "CreateUser";
    EditText etFirstName;
    EditText etLastName;
    EditText etEmail;
    Button btnSaveUser;
    Button btnCancel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);
        this.setFinishOnTouchOutside(false);
        etFirstName=findViewById(R.id.etFirstName);
        etLastName=findViewById(R.id.etLastName);
        etEmail=findViewById(R.id.etEmail);
        btnSaveUser=findViewById(R.id.btnSaveUser);
        btnCancel=findViewById(R.id.btnCancel);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,
                "production")
                .allowMainThreadQueries()
                .build();

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        btnSaveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 6/8/20 Save to Database
//                Log.d(TAG, "onClick: firstname " + etFirstName.getText().toString());

                String sFname=etFirstName.getText().toString();
                String sLname=etLastName.getText().toString();
                String sEmail=etEmail.getText().toString();
                if(sFname.isEmpty()==false && sLname.isEmpty()==false && sEmail.isEmpty()==false) {


                    if (isValid(sEmail)) {


                        db.userDao().insertAll(new User(sFname, sLname, sEmail));

                        startActivity(new Intent(CreateUser.this, DashboardActivity.class));
                    } else {
                        Toast.makeText(CreateUser.this, "Invalid Email address", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(CreateUser.this, "Please fill all the fields", Toast.LENGTH_LONG).show();
                }
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
