package com.intent.com.passdatafromactivitytoreceiver;

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

    public void sendMessage(View view) {
        Intent intent = new Intent(MainActivity.this,MyFirstReceiver.class);
        intent.putExtra("name","Anik Roy");
        sendBroadcast(intent);
    }
}
