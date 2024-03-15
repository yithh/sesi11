package com.example.session10;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStateAdapter {

    public ArrayList<Fragment> fragList = new ArrayList<>();
    public ArrayList<String> fragTitleList = new ArrayList<>();

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public void addFragment(Fragment frag, String title){
        fragList.add(frag);
        fragTitleList.add(title);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragList.size();
    }

    public String getPageTitle(int position){
        return fragTitleList.get(position);
    }
}
