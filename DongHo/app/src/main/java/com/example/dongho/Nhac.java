package com.example.dongho;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class Nhac extends Service {
    MediaPlayer mediaPlayer;
    int id;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("toi owr Nhac","xin chao");
        String keynhac=intent.getExtras().getString("hellow");

        if(keynhac.equals("on")){
            id=1;
        }
        else if(keynhac.equals("off")){
            id=0;
        }

        if(id==1){
            mediaPlayer=MediaPlayer.create(this,R.raw.hero_tonight);
            mediaPlayer.start();
            id=0;
        }
        else{
            mediaPlayer.stop();
            mediaPlayer.reset();
        }

        return START_NOT_STICKY;
    }
}
