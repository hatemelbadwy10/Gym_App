package com.example.gym_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class abs_workout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_workout);
        ViewPager pager3=findViewById(R.id.pager3);
        pager3.setAdapter(new pageradabter3(getSupportFragmentManager()));
    }
    private class pageradabter3 extends FragmentPagerAdapter{


        public pageradabter3(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position==0){

                return new abs_exercise1();
            }
         else   if (position==1){
                return new abs_exercise2();
            }
           else if (position==2){return new abs_exercise3();}
           else{
            return new abs_exercise4();}
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}