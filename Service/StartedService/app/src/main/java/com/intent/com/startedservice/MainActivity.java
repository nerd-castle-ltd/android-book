package com.intent.com.startedservice;

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

    public void startServiceMethod(View view) {
        Intent intent = new Intent(MainActivity.this,StartedService.class);
        intent.putExtra("sleep",100000);
        startService(intent);

    }

    public void stopServiceMethod(View view) {
         Intent intent = new Intent(MainActivity.this,StartedService.class);
         stopService(intent);
    }
}
