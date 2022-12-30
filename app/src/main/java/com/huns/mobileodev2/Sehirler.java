package com.huns.mobileodev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Sehirler extends AppCompatActivity {

    SQLiteDatabase veritabani;
    Button buton3;

    ListView listeleme;

    ArrayList<String> sehirListesi;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sehirler);

        sehirListesi = new ArrayList<>();

        listeleme = findViewById(R.id.listView);
        buton3 = findViewById(R.id.button3);

        try {
            veritabani = this.openOrCreateDatabase("AngolaBilgileri",MODE_PRIVATE,null);

            veritabani.execSQL("CREATE TABLE IF NOT EXISTS AngolaSehirleri(id INTEGER PRIMARY KEY ,sehirAdi VARCHAR)");

           // veritabani.execSQL("INSERT INTO AngolaSehirleri (sehirAdi) VALUES ('Labito')");

            Cursor cursor = veritabani.rawQuery("SELECT sehirAdi FROM AngolaSehirleri",null);

            int sehirAdi = cursor.getColumnIndex("sehirAdi");

            while (cursor.moveToNext())
            {
               sehirListesi.add(cursor.getString(sehirAdi));
               //Toast.makeText(Sehirler.this,cursor.getString(sehirAdi),Toast.LENGTH_SHORT).show();
            }cursor.close();

            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,sehirListesi);
            listeleme.setAdapter(adapter);

        /*    listeleme.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String text = listeleme.getItemAtPosition(i).toString();
                    Toast.makeText(Sehirler.this,""+text,Toast.LENGTH_SHORT).show();
                }
            }); */


        } catch (Exception e){
            e.printStackTrace();
        }

        buton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sehirler.this,SecondPage.class);
                startActivity(intent);
            }
        });

    }

}