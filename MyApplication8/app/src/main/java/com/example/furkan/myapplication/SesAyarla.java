package com.example.furkan.myapplication;

import android.media.AudioManager;

/**
 * Created by FURKAN on 21/02/2018.
 */

public class SesAyarla {
    public void setSeekbar(android.widget.SeekBar bar, final int stream, final AudioManager manager) {
        bar.setMax(manager.getStreamMaxVolume(stream));
        bar.setProgress(manager.getStreamVolume(stream));
        bar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
                //manager.setStreamVolume(stream, progress, R.raw.ndng);
            }

            @Override
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {

            }
        });

    }}
