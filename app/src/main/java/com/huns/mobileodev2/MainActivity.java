package com.huns.mobileodev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buton;
    Button kayitOl,girisYap;
    SQLiteDatabase veritabani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       try {
            veritabani = this.openOrCreateDatabase("AngolaBilgileri",MODE_PRIVATE,null);

            veritabani.execSQL("CREATE TABLE IF NOT EXISTS Bilgiler(id INTEGER PRIMARY KEY ,nufus VARCHAR,iklim VARCHAR,cografya VARCHAR,image BLOB)");

           // veritabani.execSQL("INSERT INTO Bilgiler (nufus,iklim,cografya) VALUES ('Angola nüfusu ile ilgili kesin bir bilgi bulunmamakta olup, Birleşmiş Milletlerin 2012 tahmini verilerine göre 20,6 milyon kişinin yaşadığı tahmin edilmektedir.Birleşmiş Milletler 2009 verilerine göre nüfusun 18 milyon olduğunu tahmin etmiştir.','Ülke üç farklı iklim bölgesine ayrılmış durumdadır. Buna göre ülkenin sahil kesiminde ve kuzey bölgelerinde tropikal iklim etkisini göstermektedir. Bu iklimde yıl boyu yüksek sıcaklıklar ölçülmekte olup, gündüz 25 °C ila 30 °C arasında sıcaklıklar ölçülmektedir.Ülkenin orta kısmında yer alan yüksek kesimlerinde ve güneyinde ise ılımlı bir tropikal iklim gözlemlenmektedir. Özellikle kış aylarında gündüz ile gece sıcaklıklarında yüksek farklılıklar yaşanabilmektedir. ','Ülkenin batısında Atlas Okyanusu kıyısında başlayan dar vadiler, doğu yönünde ülke topraklarının içerisine ilerlendiğinde yükseltinin de artması ile birlikte dağlık arazi olarak gözlemlenebilmektedirÜlkenin güney bölgesi ise daha alçak bir konumdadır. Angolanın doğu kısımlarında ise Zambezi nehrinin kolları yer almaktadır.')");

         //  String sqlString = "INSERT INTO Bilgiler (nufus,iklim,cografya) VALUES ('Angola nüfusu ile ilgili kesin bir bilgi bulunmamakta olup, Birleşmiş Milletlerin 2012 tahmini verilerine göre 20,6 milyon kişinin yaşadığı tahmin edilmektedir.','Ülke üç farklı iklim bölgesine ayrılmış durumdadır. Buna göre ülkenin sahil kesiminde ve kuzey bölgelerinde tropikal iklim etkisini göstermektedir. Bu iklimde yıl boyu yüksek sıcaklıklar ölçülmekte olup, gündüz 25 °C ila 30 °C arasında sıcaklıklar ölçülmektedir.','Ülkenin batısında Atlas Okyanusu kıyısında başlayan dar vadiler, doğu yönünde ülke topraklarının içerisine ilerlendiğinde yükseltinin de artması ile birlikte dağlık arazi olarak gözlemlenebilmektedir')";

         /*   SQLiteStatement sqLiteStatement = veritabani.compileStatement(sqlString);
           sqLiteStatement.bindString(1,"Angola nüfusu ile ilgili kesin bir bilgi bulunmamakta olup, Birleşmiş Milletler'in 2012 tahmini verilerine göre 20,6 milyon kişinin yaşadığı tahmin edilmektedir.");
           sqLiteStatement.bindString(2,"Ülke üç farklı iklim bölgesine ayrılmış durumdadır. Buna göre ülkenin sahil kesiminde ve kuzey bölgelerinde tropikal iklim etkisini göstermektedir. Bu iklimde yıl boyu yüksek sıcaklıklar ölçülmekte olup, gündüz 25 °C ila 30 °C arasında sıcaklıklar ölçülmektedir.");
           sqLiteStatement.bindString(3,"Ülkenin batısında Atlas Okyanusu kıyısında başlayan dar vadiler, doğu yönünde ülke topraklarının içerisine ilerlendiğinde yükseltinin de artması ile birlikte dağlık arazi olarak gözlemlenebilmektedir");
           sqLiteStatement.execute(); */


        } catch (Exception e){
            e.printStackTrace();
        }

        buton = findViewById(R.id.button);

       girisYap = findViewById(R.id.girisYap);
       kayitOl = findViewById(R.id.kayitOl);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anasayfa = new Intent(MainActivity.this,SecondPage.class);
                startActivity(anasayfa);
            }
        });

        girisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GirisActivity.class);
                startActivity(intent);
            }
        });

        kayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,kayitolma.class);
                startActivity(intent2);
            }
        });
    }


}
