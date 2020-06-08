package com.example.taskapp.childfragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.UserHandle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskapp.AppDatabase;
import com.example.taskapp.CreateUser;
import com.example.taskapp.R;
import com.example.taskapp.User;
import com.example.taskapp.adapters.UserAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatsFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    FloatingActionButton fab;
//    ArrayList<User> users;

    public ChatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_chats, container, false);

        recyclerView=v.findViewById(R.id.recyclerView);

//        users = new ArrayList<>();
//        for (int i = 0; i <15; ++i){
//            User user = new User("Sid " + i, "Chouhan", "sidchn@gmail.com");
//            users.add(user);
//        }

            //wrap this in a background thread
        AppDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class,
                "production")
                .allowMainThreadQueries()
                .build();

        List<User>users = db.userDao().getAllUsers();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        adapter = new UserAdapter(users);
        recyclerView.setAdapter(adapter);



        fab = v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), CreateUser.class);
                startActivity(intent);
            }
        });


        return v;
    }
}
