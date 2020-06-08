package com.example.taskapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapp.R;
import com.example.taskapp.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.fname.setText(users.get(position).getFname());
        holder.lname.setText(users.get(position).getLname());
        holder.email.setText(users.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView fname;
        public TextView lname;
        public TextView email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fname = itemView.findViewById(R.id.fname);
            lname = itemView.findViewById(R.id.lname);
            email = itemView.findViewById(R.id.email);
        }
    }
}
