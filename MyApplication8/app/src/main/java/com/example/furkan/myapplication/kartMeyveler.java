package com.example.furkan.myapplication;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.effect.Effect;
import android.os.Build;
import android.support.annotation.Dimension;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatDrawableManager;
import com.example.furkan.myapplication.R;
import android.support.v7.widget.AppCompatImageView;

/**
 * Created by FURKAN on 03/01/2018.
 */

public class kartMeyveler extends AppCompatImageView {
    boolean acikMi = false;
    boolean cevrilebilirmi = true;
    int arkaPlanID;
    int onPlanID = 0;
    Drawable arka;
    Drawable on;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("RestrictedApi")
    public kartMeyveler(Context context, int id) {
        super(context);
        setId(id);
        if (id % 8 == 1)
            onPlanID = R.drawable.kart1;
        if (id % 8 == 2)
            onPlanID = R.drawable.kart2;
        if (id % 8 == 3)
            onPlanID = R.drawable.kart3;
        if (id % 8 == 4)
            onPlanID = R.drawable.kart4;
        if (id % 8 == 5)
            onPlanID = R.drawable.kart5;
        if (id % 8 == 6)
            onPlanID = R.drawable.kart6;
        if (id % 8 == 7)
            onPlanID = R.drawable.kart7;
        if (id % 8 == 0)
            onPlanID = R.drawable.kart8;

        arkaPlanID = (R.drawable.back);
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
