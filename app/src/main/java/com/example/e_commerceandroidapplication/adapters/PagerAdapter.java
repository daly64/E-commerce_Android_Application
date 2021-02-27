package com.example.e_commerceandroidapplication.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.e_commerceandroidapplication.fragments.CategoryFragment;
import com.example.e_commerceandroidapplication.fragments.HelpFragment;
import com.example.e_commerceandroidapplication.fragments.ProfileFragment;
import com.example.e_commerceandroidapplication.fragments.RecentFragment;

import java.util.ArrayList;

public class PagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;


    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.fragments = new ArrayList<>();
        fragments.add(new RecentFragment());
        fragments.add(new CategoryFragment());
        fragments.add(new HelpFragment());
        fragments.add(new ProfileFragment());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(Fragment fragment) {
        fragments.add(fragment);
    }
}
