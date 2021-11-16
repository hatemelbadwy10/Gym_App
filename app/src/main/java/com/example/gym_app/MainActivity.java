package com.example.gym_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
        }
        String[]catogry={"chest","arms","abs","legs",};
        ListView listView=findViewById(R.id.lv1);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,catogry);
        listView.setAdapter(arrayAdapter);
        AdapterView.OnItemClickListener listener= new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent =new Intent(MainActivity.this,exercises.class);
                  //  intent.putExtra("exercise_id",(int)id);
                    startActivity(intent);

                }
                else if(position==1){
                    Intent intent =new Intent(MainActivity.this,back_workout.class);
                    //intent.putExtra("exercise_id",(int)id);
                    startActivity(intent);

                }
                else if (position==2){
                    Intent intent =new Intent(MainActivity.this,abs_workout.class);
                   // intent.putExtra("exercise_id",(int)id);
                    startActivity(intent);
                }
                else if(position==3) {
                    Intent intent =new Intent(MainActivity.this,legs_workout.class);
                   // intent.putExtras(MainActivity.this);
                    startActivity(intent); }

            }
        };
        listView.setOnItemClickListener(listener);

        NavigationView.OnNavigationItemSelectedListener listener1=new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int item1= item.getItemId();
                
                if (item1==R.id.contact)
                {

                   Intent intent1=new Intent(Intent.ACTION_CALL);
                   intent1.setData(Uri.parse("tel:1234567890"));

                    startActivity(intent1);
                }
                else if(item1 ==R.id.branches) {
                 Intent intent1 = new Intent(Intent.ACTION_VIEW);
                    intent1.setData(Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway%2C+CA"));
                    startActivity(intent1);
                }
                else {

                    Intent intent1=new Intent(MainActivity.this,BMI.class);
                    startActivity(intent1);
                }

                DrawerLayout drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }

        };
        NavigationView navigationView=findViewById(R.id.navigation1);
        navigationView.setNavigationItemSelectedListener(listener1);
       // navigationView.setNavigationViewListener();
    }
}