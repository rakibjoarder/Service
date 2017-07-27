package com.aust.rakib.intentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IntentServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);
    }

    public void StartIntentService(View view) {
        startService(new Intent(IntentServiceActivity.this, MyIntentService.class).putExtra("msg","Intent Service."));
    }
}
