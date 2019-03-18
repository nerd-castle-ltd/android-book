package com.intent.com.orderedbroadcastreceiver;

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

    public void orderedBroadcast(View view) {
        Intent intent = new Intent("com.test.com");
        Bundle bundle = new Bundle();
        bundle.putString("title","smartDeveloper");
        sendOrderedBroadcast(intent,null,new MySecondReceiver(),null,-1,"Android",bundle);
    }
}
