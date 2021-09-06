package com.example.furkan.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Activity_Main extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//Bildirim çubuğunu gizleme
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
/* setContentView'i üstteki kodlardan sonra tanımlayın
  yoksa program kırılacaktır. */
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F7941D")));
        this.getSupportActionBar().setSubtitle("Oyuna Başlama Ekranı");







        ((Button) findViewById(R.id.ib4x4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Activity_Fruits.class);

                startActivity(i);
            }
        });
        ((Button) findViewById(R.id.ib5x5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Main.this, Activity_Vehicles.class);

                startActivity(i);
            }
        });
        ((Button) findViewById(R.id.ib6x6)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Main.this, Activity_Animals.class);

                startActivity(i);
            }
        });


    }

}
