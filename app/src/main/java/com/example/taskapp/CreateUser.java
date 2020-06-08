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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.taskapp.childfragments.ChatsFragment;


public class CreateUser extends AppCompatActivity {
    private static final String TAG = "CreateUser";
    EditText etFirstName;
    EditText etLastName;
    EditText etEmail;
    Button btnSaveUser;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);
        etFirstName=findViewById(R.id.etFirstName);
        etLastName=findViewById(R.id.etLastName);
        etEmail=findViewById(R.id.etEmail);
        btnSaveUser=findViewById(R.id.btnSaveUser);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,
                "production")
                .allowMainThreadQueries()
                .build();

        btnSaveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 6/8/20 Save to Database 
//                Log.d(TAG, "onClick: firstname " + etFirstName.getText().toString());

                String sFname=etFirstName.getText().toString();
                String sLname=etLastName.getText().toString();
                String sEmail=etEmail.getText().toString();
                db.userDao().insertAll(new User(sFname, sLname, sEmail));

                startActivity(new Intent(CreateUser.this, DashboardActivity.class));
                
            }
        });
    }
}
