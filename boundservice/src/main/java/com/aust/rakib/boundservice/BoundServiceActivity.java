package com.aust.rakib.boundservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BoundServiceActivity extends AppCompatActivity {

    private MyBoundService myBoundService = null;
    private boolean isBound = false;

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBoundService = ((MyBoundService.MyBinder)service).getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myBoundService = null;
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service_activty);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!isBound){
            Intent intent = new Intent(BoundServiceActivity.this,MyBoundService.class);
            bindService(intent,connection,BIND_AUTO_CREATE);
        }
    }

    public void addNumber(View view) {
        if(isBound){
            myBoundService.addNumbers(5,19);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isBound){
            unbindService(connection);
        }
    }
}
