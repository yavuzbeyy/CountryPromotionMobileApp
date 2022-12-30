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

public class cografyaBilgileri extends AppCompatActivity {

    Button button;
    TextView cografyaBilgileri;
    SQLiteDatabase veritabani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cografya_bilgileri);

        button = findViewById(R.id.anasayfayadonus2);
        cografyaBilgileri = findViewById(R.id.cografyaBilgileri);

    try {
        veritabani = this.openOrCreateDatabase("AngolaBilgileri",MODE_PRIVATE,null);

        Cursor cursor = veritabani.rawQuery("SELECT cografya FROM Bilgiler",null);

        int cografya = cursor.getColumnIndex("cografya");

        while (cursor.moveToNext())
        {
            cografyaBilgileri.setText(cursor.getString(cografya));
        }cursor.close();

    } catch (Exception e){
        e.printStackTrace();
    }

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(com.huns.mobileodev2.cografyaBilgileri.this,SecondPage.class);
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
            Intent intent = new Intent(cografyaBilgileri.this,nufusBilgileri.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.cografya_menu){
            Intent intent2 = new Intent(cografyaBilgileri.this,cografyaBilgileri.class);
            startActivity(intent2);
        }
        else if (item.getItemId() == R.id.iklim_menu){
            Intent intent3 = new Intent(cografyaBilgileri.this,iklimBilgileri.class);
            startActivity(intent3);
        }
        else if (item.getItemId() == R.id.ana_menu){
            Intent intent3 = new Intent(cografyaBilgileri.this,MainActivity.class);
            startActivity(intent3);
        }

        return super.onOptionsItemSelected(item);
    }

}