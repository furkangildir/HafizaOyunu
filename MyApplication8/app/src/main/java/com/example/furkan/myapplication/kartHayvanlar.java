package com.example.furkan.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Dimension;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatDrawableManager;
import com.example.furkan.myapplication.R;

import android.view.Gravity;
import android.view.animation.Animation;
import android.widget.Button;
import android.view.View;
/**
 * Created by FURKAN on 03/01/2018.
 */

public class kartHayvanlar extends android.support.v7.widget.AppCompatImageView {
    boolean acikMi = false;
    boolean cevrilebilirmi = true;
    int arkaPlanID;
    int onPlanID = 0;
    Drawable arka;
    Drawable on;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("RestrictedApi")
    public kartHayvanlar(Context context, int id) {
        super(context);
        setId(id);

        if (id % 15 == 1)
            onPlanID = R.drawable.kart_hayvan1;
        if (id % 15 == 2)
            onPlanID = R.drawable.kart_hayvan2;
        if (id % 15 == 3)
            onPlanID = R.drawable.kart_hayvan3;
        if (id % 15 == 4)
            onPlanID = R.drawable.kart_hayvan4;
        if (id % 15 == 5)
            onPlanID = R.drawable.kart_hayvan5;
        if (id % 15== 6)
            onPlanID = R.drawable.kart_hayvan6;
        if (id % 15 == 7)
            onPlanID = R.drawable.kart_hayvan7;
        if (id % 15 == 8)
            onPlanID = R.drawable.kart_hayvan8;
        if (id % 15 == 9)
            onPlanID = R.drawable.kart_hayvan9;
        if (id % 15 == 10)
            onPlanID = R.drawable.kart_hayvan10;
        if (id % 15== 11)
            onPlanID = R.drawable.kart_hayvan11;
        if (id % 15== 12)
            onPlanID = R.drawable.kart_hayvan12;
        if (id % 15 == 13)
            onPlanID = R.drawable.kart_hayvan13;
        if (id % 15== 14)
            onPlanID = R.drawable.kart_hayvan14;
        if (id % 15 == 0)
            onPlanID = R.drawable.kart_hayvan15;
      /*  if (id % 18== 16)
            onPlanID = R.drawable.kart_hayvan16;
        if (id % 18== 17)
            onPlanID = R.drawable.kart_hayvan17;
        if (id % 18== 0)
            onPlanID = R.drawable.kart_hayvan18;*/
        arkaPlanID = (R.drawable.backhayvan);
        arka = AppCompatDrawableManager.get().getDrawable(context, arkaPlanID);
        on = AppCompatDrawableManager.get().getDrawable(context, onPlanID);


        setBackground(arka);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void cevir() {

        if (cevrilebilirmi) {
            if (!acikMi) {
                setBackground(on);
                acikMi = true;
            } else {
                setBackground(arka);
                acikMi = false;
            }

        } else ;
    }



}
