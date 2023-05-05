package com.example.socialmedyauygylamas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {
    BottomNavigationView navigation;
    public static String kullaniciAdi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        navigation=findViewById(R.id.navi);

        kullaniciAdi=getIntent().getStringExtra("kullanici");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new HomeFragment()).commit();

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new HomeFragment()).commit();
                        break;
                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new SearchFragment()).commit();
                        break;
                    case R.id.ekle:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new EkleFragment()).commit();
                        break;
                    case R.id.person:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new KisiselFragment()).commit();
                        break;
                    default:


                }

                return false;
            }
        });

        
    }
    public void onBackPressed(){
        Intent geriye=new Intent(MainActivity2.this,MainActivity.class);
        finish();
        startActivity(geriye);

    }
}