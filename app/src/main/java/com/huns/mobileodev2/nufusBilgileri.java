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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class nufusBilgileri extends AppCompatActivity {

    SQLiteDatabase veritabani;

    Button anasayfaDonus;
    TextView nufusAciklama,nufusSayisi;
    ListView listView2;

    ArrayList<String> nufusListesi;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nufus_bilgileri);

        nufusAciklama = findViewById(R.id.nufusAciklamasi);
        anasayfaDonus = findViewById(R.id.button2);
      //  nufusSayisi = findViewById(R.id.nufusSayisi);

        listView2 = findViewById(R.id.listView2);

        nufusListesi = new ArrayList<>();


        try {
            veritabani = this.openOrCreateDatabase("AngolaBilgileri",MODE_PRIVATE,null);

            Cursor cursor = veritabani.rawQuery("SELECT nufus FROM Bilgiler",null);

            int nufus = cursor.getColumnIndex("nufus");

            while (cursor.moveToNext())
            {
                nufusAciklama.setText(cursor.getString(nufus));
            }cursor.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            veritabani = this.openOrCreateDatabase("AngolaBilgileri",MODE_PRIVATE,null);

            Cursor cursor = veritabani.rawQuery("SELECT nufusSayisi FROM AngolaNufus",null);

            int nufusSayi = cursor.getColumnIndex("nufusSayisi");

            while (cursor.moveToNext())
            {
                nufusListesi.add(cursor.getString(nufusSayi));
                //nufusSayisi.setText(cursor.getString(nufusSayi));
            }cursor.close();

            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,nufusListesi);
            listView2.setAdapter(adapter);

        } catch (Exception e){
            e.printStackTrace();
        }


        anasayfaDonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(nufusBilgileri.this,SecondPage.class);
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
            Intent intent = new Intent(nufusBilgileri.this,nufusBilgileri.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.cografya_menu){
            Intent intent2 = new Intent(nufusBilgileri.this,cografyaBilgileri.class);
            startActivity(intent2);
        }
        else if (item.getItemId() == R.id.iklim_menu){
            Intent intent3 = new Intent(nufusBilgileri.this,iklimBilgileri.class);
            startActivity(intent3);
        }
        else if (item.getItemId() == R.id.ana_menu){
            Intent intent3 = new Intent(nufusBilgileri.this,MainActivity.class);
            startActivity(intent3);
        }

        return super.onOptionsItemSelected(item);
    }

}