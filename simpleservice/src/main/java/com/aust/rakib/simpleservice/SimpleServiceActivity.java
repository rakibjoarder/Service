package com.aust.rakib.simpleservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SimpleServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_service);
    }

    public void startService(View view) {
        Intent intent = new Intent(SimpleServiceActivity.this,MySimpleService.class);
        startService(intent);
    }
    public void stopService(View view) {
        stopService(new Intent(SimpleServiceActivity.this,MySimpleService.class));
    }
}
