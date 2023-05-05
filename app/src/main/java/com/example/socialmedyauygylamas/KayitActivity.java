package com.example.socialmedyauygylamas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class KayitActivity extends AppCompatActivity {
    Button kayitEt;
    EditText ad,sifre,email;
    String adi,sifresi,emaili;
    SQLiteDatabase db;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
        kayitEt=findViewById(R.id.kaydet);
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

        kayitEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("INSERT INTO kullanici(ad,soyad) VALUES ('"+ad.getText().toString()+"','"+sifre.getText().toString()+"')");
                Intent intentt = new Intent(KayitActivity.this, MainActivity.class);
                finish();
                startActivity(intentt);
                Toast.makeText(KayitActivity.this,"Kayıt Olma İşlemi Başarılı",Toast.LENGTH_SHORT).show();

            }
        });
    }
}