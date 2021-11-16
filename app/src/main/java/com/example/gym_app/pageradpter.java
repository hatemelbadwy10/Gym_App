package com.example.gym_app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pageradpter extends FragmentPagerAdapter {
    public pageradpter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new c_exercise1();}
        else  if(position==1){
            return new c_exercise2();}
        else  if(position==2){
            return new c_exercise3();}
        else {

            return new c_exercise4();}
    }

    @Override
    public int getCount() {
        return 4;
    }
}

