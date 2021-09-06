package com.example.furkan.myapplication;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class Activity_Fruits extends AppCompatActivity {
    int sonKart = 0;
    int skor = 0;
    int denemeSayisi = 0;
    Boolean duraklatilmis = false;
    MediaPlayer ArkaPlanMuzik;
    MediaPlayer mp;
    SeekBar change;
    AudioManager manager;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

//Bildirim çubuğunu gizleme
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

/* setContentView'i üstteki kodlardan sonra tanımlayın
  yoksa program kırılacaktır. */


        setContentView(R.layout.activity_main2);

        this.getSupportActionBar().setSubtitle("Meyveleri Eşleştir");
        Intent i = getIntent();
        final String s = i.getStringExtra("mesaj");
        GridLayout gl = findViewById(R.id.kartlar);
        final Boolean sesDurumu = false;
        final Button btnSes = findViewById(R.id.btnSes);
        final kartMeyveler kartlar[] = new kartMeyveler[16];


        final SoundPool sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        final int ses = sp.load(this, R.raw.buttonsound, 1);
        //ArkaPlanMuzik = MediaPlayer.create(this, R.raw.ndng);
        //ArkaPlanMuzik.setLooping(true);
        //ArkaPlanMuzik.setVolume(0.09f, 0.09f);
        final MediaPlayer kartEslesmesSesi = MediaPlayer.create(this, R.raw.karteslesmesesi);


        final TextView tv = findViewById(R.id.puan);
        final TextView tv2 = findViewById(R.id.denemeSayisi);
        tv.setText("Puan\n0");
        tv2.setText("Deneme Sayısı\n0");
        btnSes.setBackgroundResource(R.drawable.sesac);//ses butonu iconu
        for (int j = 1; j <= 16; j++) {
            kartlar[j - 1] = new kartMeyveler(this, j);
            kartlar[j - 1].setPadding(10, 10, 10, 10);
            kartlar[j - 1].setOnClickListener(new View.OnClickListener() {

                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View view) {
                    sp.play(ses, 1, 1, 0, 0, 1);
                    final kartMeyveler k = (kartMeyveler) view;
                    k.cevir();
                    if (sonKart > 0) {
                        final kartMeyveler k2 = (kartMeyveler) findViewById(sonKart);
                        if (k2.onPlanID == k.onPlanID && k2.getId() != k.getId()) {
                            //eslestiler
                            k2.cevrilebilirmi = false;
                            k.cevrilebilirmi = false;
                            skor++;
                            kartEslesmesSesi.start();

                            tv.setText("Puan\n" + skor);
                            if (skor == 8) {
                                //oyun bitti


                                Intent i = new Intent(Activity_Fruits.this, Activity_Main.class);
                                i.putExtra("deneme", denemeSayisi);
                                startActivity(i);
                                finish();
                            }
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k.setVisibility(View.INVISIBLE);
                                    k2.setVisibility(View.INVISIBLE);
                                }
                            }, 500);

                            sonKart = 0;
                        } else {
                            //eslesmediler geri cevir 2 karti
                            for (int j = 1; j <= 16; j++)
                                kartlar[j - 1].setEnabled(false);

                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k.cevir();
                                    k2.cevir();
                                    for (int j = 1; j <= 16; j++)
                                        kartlar[j - 1].setEnabled(true);
                                }
                            }, 500);

                            denemeSayisi++;

                            tv2.setText(String.valueOf("Deneme Sayısı\n" + denemeSayisi));

                            sonKart = 0;
                        }
                    } else {
                        sonKart = k.getId();
                    }
                }
            });
        }
        //Kartları Karıştır
        for (int j = 0; j < 16; j++) {
            int rg = (int) (Math.random() * 16);
            kartMeyveler k = kartlar[rg];
            kartlar[rg] = kartlar[j];
            kartlar[j] = k;
        }
        //Karıştırılan kartları gridlayouta ekle
        for (int j = 0; j < 16; j++)
            gl.addView(kartlar[j]);


//Ses butonuna tıklanınca neler yapılacağı
        btnSes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ArkaPlanMuzik.isPlaying()) {
                    btnSes.setBackgroundResource(R.drawable.seskapat);
                  //  ArkaPlanMuzik.pause();
                    duraklatilmis = true;
                } else {
                    btnSes.setBackgroundResource(R.drawable.sesac);
                   // ArkaPlanMuzik.start();
                    duraklatilmis = false;
                }

            }
        });


        change = (SeekBar) findViewById(R.id.seekBar);
        manager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        SesAyarla seekbarAyarla = new SesAyarla();
        seekbarAyarla.setSeekbar(change, AudioManager.STREAM_MUSIC, manager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (duraklatilmis == false) {
//            ArkaPlanMuzik.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
      //  ArkaPlanMuzik.pause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // ArkaPlanMuzik.release();

    }


}


