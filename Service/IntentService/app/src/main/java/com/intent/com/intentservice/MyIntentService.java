package com.intent.com.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("Worker Thread");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int sleepTime = intent.getIntExtra("sleep",0);

        int count =1;
        while (count<= sleepTime){
            Log.d("IntentService", "onHandleIntent: "+ count);

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }

    }
}
