package com.example.furkan.myapplication;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Activity_Result extends ListActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Bildirim çubuğunu gizleme
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* setContentView'i üstteki kodlardan sonra tanımlayın
        yoksa program kırılacaktır. */
        setContentView(R.layout.activity_main3);






        //Kullanıcı adı ekleme


        //Veri Listeleme


        Button btnTekrarOyna=findViewById(R.id.btnTekrarOyna);

        btnTekrarOyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Activity_Main.class);
                startActivity(i);
            }
        });
    }

    protected void onResume() {

        super.onResume();

    }

    protected void onPause() {

        super.onPause();

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //geri tuşuna basılma durumunu yakalıyoruz
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Çıkmak İstediğinizden Eminmisiniz ?");
            alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    android.os.Process.killProcess(android.os.Process.myPid());
                    finish();
                }
            });
            alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    //hayır seçildiginde yapılacak işlemler
                }
            });

            alert.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}

