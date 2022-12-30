package com.huns.mobileodev2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminPanel extends AppCompatActivity {

    Button menuyeDon,sehirEkle,nufusEkle;
    SQLiteDatabase veritabani;
    private String txtSehir,txtNufus;
    EditText sehirAl,nufusAl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        menuyeDon = findViewById(R.id.button11);
        sehirEkle = findViewById(R.id.sehirEkle);
        nufusEkle = findViewById(R.id.nufusEkle);

        sehirAl = (EditText)findViewById(R.id.editTextTextPersonName);
        nufusAl = (EditText)findViewById(R.id.editTextNumber);

        menuyeDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(adminPanel.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void sehirEkle(View v){

        txtSehir= sehirAl.getText().toString();

        try {
            veritabani = this.openOrCreateDatabase("AngolaBilgileri",MODE_PRIVATE,null);

            veritabani.execSQL("CREATE TABLE IF NOT EXISTS AngolaSehirleri(id INTEGER PRIMARY KEY ,sehirAdi VARCHAR)");

            //   veritabani.execSQL("INSERT INTO Users (kullaniciAdi,parola) VALUES ('test','test')");

            String sqlString = "Insert Into AngolaSehirleri(sehirAdi) VALUES(?)";
            SQLiteStatement sqLiteStatement = veritabani.compileStatement(sqlString);
            sqLiteStatement.bindString(1,txtSehir);
            sqLiteStatement.execute();

            Toast.makeText(this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void sehirSil(View v){
        txtSehir= sehirAl.getText().toString();

        try {
            veritabani = this.openOrCreateDatabase("AngolaBilgileri",MODE_PRIVATE,null);

            veritabani.execSQL("CREATE TABLE IF NOT EXISTS AngolaSehirleri(id INTEGER PRIMARY KEY ,sehirAdi VARCHAR)");

            String sqlString = "DELETE FROM AngolaSehirleri WHERE sehirAdi=(?)";
            SQLiteStatement sqLiteStatement = veritabani.compileStatement(sqlString);
            sqLiteStatement.bindString(1,txtSehir);
            sqLiteStatement.execute();

            Toast.makeText(this, "Şehir Silindi", Toast.LENGTH_SHORT).show();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void nufusEkle(View v){

        txtNufus= nufusAl.getText().toString();

        try {
            veritabani = this.openOrCreateDatabase("AngolaBilgileri",MODE_PRIVATE,null);

            veritabani.execSQL("CREATE TABLE IF NOT EXISTS AngolaNufus(id INTEGER PRIMARY KEY ,nufusSayisi VARCHAR)");

            String sqlString = "Insert Into AngolaNufus(nufusSayisi) VALUES(?)";
            SQLiteStatement sqLiteStatement = veritabani.compileStatement(sqlString);
            sqLiteStatement.bindString(1,txtNufus);
            sqLiteStatement.execute();

            Toast.makeText(this, "Nüfus Eklendi", Toast.LENGTH_SHORT).show();

        } catch (Exception e){
            e.printStackTrace();
    }
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
            Intent intent = new Intent(adminPanel.this,nufusBilgileri.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.cografya_menu){
            Intent intent2 = new Intent(adminPanel.this,cografyaBilgileri.class);
            startActivity(intent2);
        }
        else if (item.getItemId() == R.id.iklim_menu){
            Intent intent3 = new Intent(adminPanel.this,iklimBilgileri.class);
            startActivity(intent3);
        }
        else if (item.getItemId() == R.id.ana_menu){
            Intent intent3 = new Intent(adminPanel.this,MainActivity.class);
            startActivity(intent3);
        }

        return super.onOptionsItemSelected(item);
    }

}