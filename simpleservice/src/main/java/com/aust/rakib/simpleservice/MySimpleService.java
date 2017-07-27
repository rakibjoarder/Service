package com.aust.rakib.simpleservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MySimpleService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        Log.e("TAG","CREATE");
        super.onCreate();
        mediaPlayer=MediaPlayer.create(this,R.raw.aaa);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG","START");
        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("TAG","DESTROY");
        super.onDestroy();
        mediaPlayer.stop();
    }
}
