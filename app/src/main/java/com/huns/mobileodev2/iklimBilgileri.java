package com.huns.mobileodev2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class iklimBilgileri extends AppCompatActivity {

    Button button;
    TextView iklimBilgileri;

    SQLiteDatabase veritabani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iklim_bilgileri);

        button = findViewById(R.id.anasayfayaDonus3);
        iklimBilgileri = findViewById(R.id.iklimBilgileri);

        try {
            veritabani = this.openOrCreateDatabase("AngolaBilgileri",MODE_PRIVATE,null);

            Cursor cursor = veritabani.rawQuery("SELECT iklim FROM Bilgiler",null);

            int iklim = cursor.getColumnIndex("iklim");

            while (cursor.moveToNext())
            {
                iklimBilgileri.setText(cursor.getString(iklim));
            }cursor.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.huns.mobileodev2.iklimBilgileri.this,SecondPage.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.nufus_menu){
            Intent intent = new Intent(iklimBilgileri.this,nufusBilgileri.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.cografya_menu){
            Intent intent2 = new Intent(iklimBilgileri.this,cografyaBilgileri.class);
            startActivity(intent2);
        }
        else if (item.getItemId() == R.id.iklim_menu){
            Intent intent3 = new Intent(iklimBilgileri.this,iklimBilgileri.class);
            startActivity(intent3);
        }
        else if (item.getItemId() == R.id.ana_menu){
            Intent intent3 = new Intent(iklimBilgileri.this,MainActivity.class);
            startActivity(intent3);
        }

        return super.onOptionsItemSelected(item);
    }
}