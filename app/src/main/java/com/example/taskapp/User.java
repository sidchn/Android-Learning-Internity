package com.example.taskapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    public User(String fname, String lname, String email) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="first_name")
    private String fname;

    @ColumnInfo(name="last_name")
    private String lname;

    @ColumnInfo(name="email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
