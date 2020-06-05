package com.example.taskapp.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.example.taskapp.childfragments.CallsFragment;
import com.example.taskapp.childfragments.ChatsFragment;
import com.example.taskapp.childfragments.StatusFragment;

public class TabAdapter extends FragmentPagerAdapter {
    private int tabscount;
    public TabAdapter(@NonNull FragmentManager fm, int behavior, int tabscount) {
        super(fm, behavior);
        this.tabscount=tabscount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new ChatsFragment();
            case 1:
                return new StatusFragment();
            case 2:
                return new CallsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabscount;
    }
}
