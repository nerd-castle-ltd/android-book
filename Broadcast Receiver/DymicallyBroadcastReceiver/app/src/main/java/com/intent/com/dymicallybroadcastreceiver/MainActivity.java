package com.intent.com.dymicallybroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count=1;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textViewID);
    }
    public void registerd(View view) {

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(broadcast,intentFilter);

    }

    public void unregistered(View view) {
        unregisterReceiver(broadcast);

    }
    private BroadcastReceiver broadcast = new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {

            int min = count;
            textView.setText(min+ " min over");
            count++;

        }
    };


}
