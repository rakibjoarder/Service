package com.aust.rakib.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aust.rakib.boundservice.BoundServiceActivity;
import com.aust.rakib.intentservice.IntentServiceActivity;
import com.aust.rakib.simpleservice.SimpleServiceActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SimpleService(View view) {
        startActivity(new Intent(MainActivity.this, SimpleServiceActivity.class));
    }

    public void IntentService(View view) {
        startActivity(new Intent(MainActivity.this, IntentServiceActivity.class));
    }

    public void BoundService(View view) {
        startActivity(new Intent(MainActivity.this, BoundServiceActivity.class));
    }
}
