package com.huns.mobileodev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class kayitolma extends AppCompatActivity {
    private EditText editEmail,editSifre;
    private String txtEmail, txtSifre;
    SQLiteDatabase veritabani;
    Button menuyedon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayitolma);
        editEmail= (EditText)findViewById(R.id.kayit_ol_editEmail);
        editSifre=(EditText)findViewById(R.id.kayit_ol_editSifre);
        menuyedon = findViewById(R.id.button4);

        menuyedon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(kayitolma.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void kayitOl(View v){
        txtEmail= editEmail.getText().toString();
        txtSifre= editSifre.getText().toString();

        if (!TextUtils.isEmpty(txtEmail)&& !TextUtils.isEmpty(txtSifre)){

            try {
                veritabani = this.openOrCreateDatabase("AngolaBilgileri",MODE_PRIVATE,null);

                veritabani.execSQL("CREATE TABLE IF NOT EXISTS Users(id INTEGER PRIMARY KEY ,kullaniciAdi VARCHAR,parola VARCHAR)");

              //   veritabani.execSQL("INSERT INTO Users (kullaniciAdi,parola) VALUES ('test','test')");

                String sqlString = "Insert Into Users(kullaniciAdi,parola) VALUES(?,?)";
                SQLiteStatement sqLiteStatement = veritabani.compileStatement(sqlString);
                sqLiteStatement.bindString(1,txtEmail);
                sqLiteStatement.bindString(2,txtSifre);
                sqLiteStatement.execute();

                Toast.makeText(this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();

            } catch (Exception e){
                e.printStackTrace();
            }


        }else
            Toast.makeText(this, "Email ve şifre boş geçilemez", Toast.LENGTH_SHORT).show();


    }

}