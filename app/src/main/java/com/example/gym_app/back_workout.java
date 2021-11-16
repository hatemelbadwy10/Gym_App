package com.example.gym_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class back_workout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_workout);
        ViewPager viewPager=findViewById(R.id.pager2);
        viewPager.setAdapter(new pageradpter2(getSupportFragmentManager()));

    }
    private class pageradpter2 extends FragmentPagerAdapter{


        public pageradpter2(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if(position==0){

                return  new a_exercise1();
            }
           else if (position==1){

                return new a_exercise2();
            }
           else if (position==2){
                return new a_exercise3();

            }
            else{
            return new a_exercise4();}
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}