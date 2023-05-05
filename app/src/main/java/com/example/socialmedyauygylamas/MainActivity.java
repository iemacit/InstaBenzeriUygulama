package com.example.socialmedyauygylamas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button giris,kayit;
    EditText ad,sifre,email;
    SQLiteDatabase db;
    SharedPreferences preferences;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        giris=findViewById(R.id.gir);
        kayit=findViewById(R.id.kaydol);
        ad=findViewById(R.id.name);
        sifre=findViewById(R.id.sifre);
        email=findViewById(R.id.email);
        try {
            db=this.openOrCreateDatabase("Login",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS kullanici(ıd INTEGER PRIMARY KEY,ad VARCHAR,soyad VARCHAR)");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             Intent intent=new Intent(MainActivity.this,KayitActivity.class);
             startActivity(intent);            }
        });

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username =ad.getText().toString();
                String password =sifre.getText().toString();

                String query = "SELECT * FROM kullanici WHERE ad=? AND soyad=?";
                Cursor cursor=db.rawQuery(query,new String[]{username,password});

                if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)){
                    if(cursor.getCount()==1){
                        Toast.makeText(MainActivity.this,"HOŞGELDİNİZ",Toast.LENGTH_SHORT).show();


                        Intent intentt = new Intent(MainActivity.this, MainActivity2.class);
                        intentt.putExtra("kullanici",username);
                        finish();
                        startActivity(intentt);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"BİLGİLERE AİT KULLANİCİ BULUNAMADİ",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this,"ŞİFRE VE AD BOŞ OLAMAZ",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}