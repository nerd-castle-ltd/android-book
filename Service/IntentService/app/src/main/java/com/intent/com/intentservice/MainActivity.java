package com.intent.com.intentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void intentServiceMethod(View view) {
        Intent intent = new Intent(MainActivity.this,MyIntentService.class);
        intent.putExtra("sleep",10);
        startService(intent);
    }
}
