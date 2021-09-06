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

public class kartAraclar extends android.support.v7.widget.AppCompatImageView {
    boolean acikMi = false;
    boolean cevrilebilirmi = true;
    int arkaPlanID;
    int onPlanID = 0;
    Drawable arka;
    Drawable on;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("RestrictedApi")
    public kartAraclar(Context context, int id) {
        super(context);
        setId(id);
setScaleType(ScaleType.CENTER);
        if (id % 10 == 1)
            onPlanID = R.drawable.kart_arac1;
        if (id % 10 == 2)
            onPlanID = R.drawable.kart_arac2;
        if (id % 10 == 3)
            onPlanID = R.drawable.kart_arac3;
        if (id % 10 == 4)
            onPlanID = R.drawable.kart_arac4;
        if (id % 10 == 5)
            onPlanID = R.drawable.kart_arac5;
        if (id % 10== 6)
            onPlanID = R.drawable.kart_arac6;
        if (id % 10 == 7)
            onPlanID = R.drawable.kart_arac7;
        if (id % 10 == 8)
            onPlanID = R.drawable.kart_arac8;
        if (id % 10 == 9)
            onPlanID = R.drawable.kart_arac9;
        if (id % 10 == 0)
            onPlanID = R.drawable.kart_arac10;
      /* if (id % 15== 11)
            onPlanID = R.drawable.kart_nesne11;
        if (id % 15== 12)
            onPlanID = R.drawable.kart_nesne12;
        if (id % 15 == 13)
            onPlanID = R.drawable.kart_nesne13;
        if (id % 15== 14)
            onPlanID = R.drawable.kart_nesne14;
        if (id % 15 == 0)
            onPlanID = R.drawable.kart_nesne15;
  */
        arkaPlanID = (R.drawable.backarac);
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
