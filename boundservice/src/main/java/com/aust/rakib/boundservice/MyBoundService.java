package com.aust.rakib.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBoundService extends Service {

    private MyBinder myBinder = new MyBinder();

    private static final String TAG = "BOUND";
    public MyBoundService() {
    }

    public class MyBinder extends Binder {
        public MyBoundService getService(){
            return MyBoundService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public void addNumbers(int x, int y){
        Log.e(TAG, "SUM: "+(x + y));
    }
}
