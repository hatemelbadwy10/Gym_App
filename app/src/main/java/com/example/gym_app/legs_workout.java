package com.example.gym_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class legs_workout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs_workout);
        ViewPager pager4=findViewById(R.id.pager4);
        pager4.setAdapter(new pageradapter4(getSupportFragmentManager()));

    }
    private class pageradapter4 extends FragmentPagerAdapter{


        public pageradapter4(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position==0){return new legs_exercise1();}
           else if (position==1){return new legs_exercise2();}
            else if (position==2){return new legs_exercise3();}
            else{
                return new legs_exercise4();}
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}