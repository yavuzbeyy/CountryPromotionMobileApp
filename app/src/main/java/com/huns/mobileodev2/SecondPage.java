package com.huns.mobileodev2;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.smarteist.autoimageslider.SliderView;
import java.util.ArrayList;

public class SecondPage extends AppCompatActivity {
    // Urls of our images.
    String url1 = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Flag_of_Angola.svg/1200px-Flag_of_Angola.svg.png";
    String url2 = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/09/df/aa/eb/fortaleza-de-sao-miguel.jpg?w=500&h=-1&s=1";
    String url3 = "https://cdn.yeniakit.com.tr/images/news/625/angola-nerede-ve-hangi-bolgede-h1627405526-5e52d3.jpg";

    Button nufusButton;
    Button cografyaButton;
    Button iklimButton;
    Button sehirButton;
    Button tarihButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        nufusButton = findViewById(R.id.button5);

        tarihButton=findViewById(R.id.tarih);

        nufusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondPage.this,nufusBilgileri.class);
                startActivity(intent);
            }
        });

        cografyaButton = findViewById(R.id.button6);

        cografyaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(SecondPage.this,cografyaBilgileri.class);
                startActivity(intent2);
            }
        });

        iklimButton = findViewById(R.id.button7);

        iklimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(SecondPage.this,iklimBilgileri.class);
                startActivity(intent3);
            }
        });

        sehirButton = findViewById(R.id.button8);

        sehirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(SecondPage.this,Sehirler.class);
                startActivity(intent4);
            }
        });

        tarihButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(SecondPage.this,tarihBilgileri.class);
                startActivity(intent5);
            }
        });

        // we are creating array list for storing our image urls.
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.slider);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();
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
            Intent intent = new Intent(SecondPage.this,nufusBilgileri.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.cografya_menu){
            Intent intent2 = new Intent(SecondPage.this,cografyaBilgileri.class);
            startActivity(intent2);
        }
        else if (item.getItemId() == R.id.iklim_menu){
            Intent intent3 = new Intent(SecondPage.this,iklimBilgileri.class);
            startActivity(intent3);
        }
        else if (item.getItemId() == R.id.ana_menu){
            Intent intent3 = new Intent(SecondPage.this,MainActivity.class);
            startActivity(intent3);
        }

        return super.onOptionsItemSelected(item);
    }
}
