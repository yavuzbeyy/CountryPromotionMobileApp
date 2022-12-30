package com.huns.mobileodev2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class GirisActivity extends AppCompatActivity {
    private EditText editEmail,editSifre;
    private String txtEmail, txtSifre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        editEmail= (EditText)findViewById(R.id.giris_yap_editEmail);
        editSifre=(EditText)findViewById(R.id.giris_yap_editSifre);


    }
    public void GirisYap(View view){
        txtEmail= editEmail.getText().toString();
        txtSifre= editSifre.getText().toString();

        if (!TextUtils.isEmpty(txtEmail)&& !TextUtils.isEmpty(txtSifre)){

            if ((txtEmail.equals("admin")) && (txtSifre.equals("admin"))){
                Intent intent = new Intent(GirisActivity.this,adminPanel.class);
                startActivity(intent);
            }else   Toast.makeText(this, "Giremedim", Toast.LENGTH_SHORT).show();

        }else
            Toast.makeText(this, "Kullanici adı ve şifre boş geçilemez", Toast.LENGTH_SHORT).show();

    }
}